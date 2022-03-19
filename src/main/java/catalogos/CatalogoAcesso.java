package catalogos;

import acessos.Acesso;
import clientes.Cliente;
import clientes.ClienteIndividual;
import controller.Login;
import entretenimento.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedList;

public class CatalogoAcesso
{
    public static CatalogoAcesso ca = new CatalogoAcesso();

    public void registrarAcesso(Entretenimento ent)
    {
        // Registrar acesso data ; horario ; email pessoal ; codigo do entretenimento
        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);   // Janeiro = 0
        mes++;
        int ano = calendario.get(Calendar.YEAR);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);

        String data = dia + "/" + mes + "/" + ano;
        String horaMinuto = hora + ":" + minuto;
        String dataHora = data + ";" + horaMinuto;

        // Registrar ACESSO AO CLIENTE
        try(FileWriter fw = new FileWriter("dados_acessos.csv", true);
            PrintWriter out = new PrintWriter(new BufferedWriter(fw)))
        {
            out.println(dataHora + ";" + Login.getUsuarioAtual().getEmail() + ";" + ent.getCodigo());
        }
        catch(Exception io)
        {
            System.err.println(io);
        }
    }

    public LinkedList<Acesso> lerAcessoAnoMes(String ano, String mes)
    {
        final String dadosAcessos = "dados_acessos.csv";
        Path arq = Paths.get(dadosAcessos);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String[] aux;
            String line;
            LinkedList<Acesso> listaAcessosUsuario = new LinkedList<>();
            while ((line = br.readLine()) != null)
            {
                aux = line.split(";");
                String[] dataArmazenada = aux[0].split("/");
                String mesArmazenado = dataArmazenada[1];
                String anoArmazenado = dataArmazenada[2];
                if (anoArmazenado.equals(ano) && mesArmazenado.equals(mes))
                {
                    Cliente cli =  CatalogoCliente.getInstance().pesquisarClienteEmail(aux[2]);
                    Entretenimento e = CatalogoEntretenimento.getInstance().procurarEntretenimentoCodigo(aux[3]);
                    if (cli != null && e != null)
                    {
                        Acesso a = new Acesso(aux[0], aux[1], cli, e);
                        listaAcessosUsuario.add(a);
                    }

                }
            }
            return listaAcessosUsuario;
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        return null;
    }

    public LinkedList<Acesso> lerAcessoAnoMesCliente(String ano, String mes)
    {
        final String dadosAcessos = "dados_acessos.csv";
        Path arq = Paths.get(dadosAcessos);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String[] aux;
            String line;
            LinkedList<Acesso> listaAcessosUsuario = new LinkedList<>();
            while ((line = br.readLine()) != null)
            {
                aux = line.split(";");
                String[] dataArmazenada = aux[0].split("/");
                String mesArmazenado = dataArmazenada[1];
                String anoArmazenado = dataArmazenada[2];
                if (anoArmazenado.equals(ano) && mesArmazenado.equals(mes))
                {
                    Cliente cli =  CatalogoCliente.getInstance().pesquisarClienteEmail(aux[2]);
                    Entretenimento e = CatalogoEntretenimento.getInstance().procurarEntretenimentoCodigo(aux[3]);
                    if (cli.getEmail().equals(Login.usuarioAtual.getEmail()) && e != null)
                    {
                        Acesso a = new Acesso(aux[0], aux[1], cli, e);
                        listaAcessosUsuario.add(a);
                    }
                }
            }
            return listaAcessosUsuario;
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        return null;
    }

    public StringBuilder mostraInformacoesAcessoAdm(String ano, String mes)
    {
        LinkedList<Acesso> lista = lerAcessoAnoMes(ano, mes);
        if (lista == null)
            return null;

        StringBuilder msg = new StringBuilder();
        double valorEntretenimento = 0;
        for(Acesso a : lista)
        {
            Entretenimento e = a.getEntretenimento();
            if (e instanceof Filme)
            {
                valorEntretenimento = 6;
            }
            else if (e instanceof Jogo)
            {
                valorEntretenimento = 8;
            }
            else if (e instanceof EpisodioSerie)
            {
                valorEntretenimento = 4;
            }
            Cliente cli = a.getCliente();
            if (cli instanceof ClienteIndividual)
            {
                if (((ClienteIndividual) cli).getEmailEmpresaVinculada() != null)
                    valorEntretenimento = valorEntretenimento / 2;
            }
            else
                valorEntretenimento = valorEntretenimento / 2;

            msg.append("Cliente: ").append(cli.toString()).append(" | Data: ").append(a.getData()).append(" | Hora: ").append(a.getHora())
                    .append(" | Entretenimento: ").append(e.toString())
                    .append(" | Valor do acesso: R$").append(valorEntretenimento)
                    .append('\n');
        }
        return msg;


    }

    public StringBuilder mostraInformacoesAcessoCliente(String ano, String mes)
    {
        LinkedList<Acesso> lista = lerAcessoAnoMesCliente(ano, mes);
        if (lista.isEmpty())
            return null;
        StringBuilder msg = new StringBuilder();
        double valorEntretenimento = 0;
        for(Acesso a : lista)
        {
            Entretenimento e = a.getEntretenimento();
            if (e instanceof Filme)
            {
                valorEntretenimento = 6;
            }
            else if (e instanceof Jogo)
            {
                valorEntretenimento = 8;
            }
            else if (e instanceof EpisodioSerie)
            {
                valorEntretenimento = 4;
            }
            Cliente cli = a.getCliente();
            if (cli instanceof ClienteIndividual)
            {
                if (((ClienteIndividual) cli).getEmailEmpresaVinculada() != null)
                    valorEntretenimento = valorEntretenimento / 2;
            }
            else
                valorEntretenimento = valorEntretenimento / 2;

            msg.append("Data: ").append(a.getData()).append(" | Hora: ").append(a.getHora())
                    .append(" | Entretenimento: ").append(e.toString())
                    .append(" | Valor do acesso: R$").append(valorEntretenimento)
                    .append('\n');
        }
        return msg;
    }

    public String mostraValorTotalAcesso(String ano, String mes)
    {
        LinkedList<Acesso> lista = lerAcessoAnoMes(ano, mes);
        StringBuilder msg = new StringBuilder();
        double valorEntretenimento = 0;
        double valorTotal = 0;
        for(Acesso a : lista)
        {
            Entretenimento e = a.getEntretenimento();
            if (e instanceof Filme)
            {
                valorEntretenimento = 6;
            }
            else if (e instanceof Jogo)
            {
                valorEntretenimento = 8;
            }
            else if (e instanceof EpisodioSerie)
            {
                valorEntretenimento = 4;
            }
            Cliente cli = a.getCliente();
            if (cli instanceof ClienteIndividual)
            {
                if (((ClienteIndividual) cli).getEmailEmpresaVinculada() != null)
                    valorEntretenimento = valorEntretenimento / 2;
            }
            else valorEntretenimento = valorEntretenimento / 2;
            valorTotal += valorEntretenimento;
        }
        return String.valueOf(valorTotal);
    }

    public static CatalogoAcesso getInstance()
    {
        return(ca);
    }

}
