package catalogos;

import clientes.Cliente;
import clientes.ClienteEmpresarial;
import clientes.ClienteIndividual;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CatalogoCliente
{
    public static CatalogoCliente cc = new CatalogoCliente();

    public static CatalogoCliente getInstance()
    {
        return(cc);
    }

    public boolean adicionarCliente(Cliente cli)
    {
        if (!validaEmail(cli))
            return false;
        if (cli instanceof ClienteIndividual)
        {
            if (!validaCpf(cli) )
                return false;
        }
        else
        {
            if(!validaCnpj(cli))
                return false;
        }
        try(FileWriter fw = new FileWriter("dados_clientes.csv", true);
            PrintWriter out = new PrintWriter(new BufferedWriter(fw)))
        {
            int cod = 0;
            if (cli instanceof ClienteIndividual)
            {
                if ( ((ClienteIndividual) cli).getEmailEmpresaVinculada() == null)
                    cod = 1;
                else
                    cod = 3;
            }
            else
                cod = 2;

            out.println(cod + ";" + cli.toStringCsv());
            return true;
        }
        catch(IOException io)
        {
            System.err.println(io);
        }
        return false;
    }

    public Cliente pesquisarClienteEmail(String email)
    {
        if (email.isEmpty())
            return null;
        final String dadosClientes = "dados_clientes.csv";
        Path arq = Paths.get(dadosClientes);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String aux[];
            String line;
            while((line = br.readLine()) != null)
            {
                aux = line.split(";");
                if (aux[2].equals(email))
                {
                    return switch (aux[0]) {
                        case "1" ->
                                new ClienteIndividual(aux[1], aux[2], aux[3], aux[4], null);
                        case "2" ->
                                new ClienteEmpresarial(aux[1], aux[2], aux[3], aux[4], aux[5]);
                        case "3" ->
                                new ClienteIndividual(aux[1], aux[2], aux[3], aux[4], aux[5]);
                        default -> null;
                    };
                }
            }
        }
        catch (IOException io)
        {
            System.out.println(io);
        }
        return null;
    }


    private boolean validaEmail(Cliente cli)
    {
        if (cli.getEmail() == null)
            return false;
        final String dadosClientes = "dados_clientes.csv";
        Path arq = Paths.get(dadosClientes);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String aux[];
            String line;
            while((line = br.readLine()) != null)
            {
                aux = line.split(";");
                if (aux[3].equals(cli.getEmail()))
                {
                   return false;
                }
            }
            return true;
        }
        catch (IOException io)
        {
            System.out.println(io);
        }
        return false;
    }

    private boolean validaCpf(Cliente cli)
    {
        final String dadosClientes = "dados_clientes.csv";
        Path arq = Paths.get(dadosClientes);
        if (cli instanceof ClienteIndividual)
        {
            try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
            {
                String aux[];
                String line;
                while((line = br.readLine()) != null)
                {
                    aux = line.split(";");
                    if (aux[4].equals(((ClienteIndividual) cli).getCpf()))
                    {
                        return false;
                    }
                }
                return true;
            }
            catch (IOException io)
            {
                System.out.println(io);
            }
            return false;
        }
        return false;
    }

    private boolean validaCnpj(Cliente cli)
    {
        final String dadosClientes = "dados_clientes.csv";
        Path arq = Paths.get(dadosClientes);
        if (cli instanceof ClienteEmpresarial)
        {
            try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
            {
                String aux[];
                String line;
                while((line = br.readLine()) != null)
                {
                    aux = line.split(";");
                    if (aux[4].equals(((ClienteEmpresarial) cli).getCnpj()))
                    {
                        return false;
                    }
                }
                return true;
            }
            catch (IOException io)
            {
                System.out.println(io);
            }
        }
        return false;
    }
}
