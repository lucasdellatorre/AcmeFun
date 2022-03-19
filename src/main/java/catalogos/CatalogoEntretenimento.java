package catalogos;

import entretenimento.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CatalogoEntretenimento
{
    public static CatalogoEntretenimento ce = new CatalogoEntretenimento();

    public boolean adicionarEntretenimento(Entretenimento e)
    {
        if (e.getCodigo() == null)
            return false;
        if (procurarEntretenimentoCodigo(e.getCodigo()) != null)
            return false;
        try(FileWriter fw = new FileWriter("dados_entretenimento.csv", true);
            PrintWriter out = new PrintWriter(new BufferedWriter(fw)))
        {
            int cod = 0;
            if (e instanceof Filme)
                cod = 1;
            else if (e instanceof Jogo)
                cod = 2;
            else if (e instanceof Serie)
                cod = 3;
            else if (e instanceof EpisodioSerie)
                cod = 4;

            out.println(cod + ";" + e.toStringCsv());
            return true;
        }
        catch(Exception io)
        {
            return false;
        }
    }

    public boolean adicionarEntretenimentoImdb()
    {
        Path arqEntretenimento = Paths.get("data.tsv");
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(arqEntretenimento));
                FileWriter fw = new FileWriter("dados_entretenimento.csv", true);
                PrintWriter out = new PrintWriter(new BufferedWriter(fw))
        ) {
            String aux[];
            String line;
            while ((line = br.readLine()) != null) {
                                aux = line.split("\t");
                // 0,1,2,3,5 tipos de atributos 6, 7
                String codigo = aux[0];
                String tipoEntretenimento = aux[1];
                String titulo = aux[2];
                String tituloOrignial = aux[3];
                String anoLancamento = aux[5];
                String duracaoMinutos = aux[7];
                String genero = aux[8];
                String formato = "";
                if (tipoEntretenimento.equals("movie"))
                {
                    formato = "1" + ";" + codigo + ";" + titulo + ";" + anoLancamento + ";" + duracaoMinutos;
                    out.println(formato);
                }
                else if (tipoEntretenimento.equals("videoGame"))
                {
                    formato = "2" + ";" + codigo + ";" + titulo + ";" + tituloOrignial + ";" + anoLancamento + ";" + genero;
                    out.println(formato);
                }
            }
            return true;
        } catch (IOException io) {
            System.err.println(io);
            return false;
        }
    }

    public Entretenimento procurarEntretenimentoCodigo(String codigo)
    {
        if (codigo.isEmpty())
            return null;
        final String dadosEntretenimento = "dados_entretenimento.csv";
        Path arq = Paths.get(dadosEntretenimento);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String aux[];
            String line;
            while((line = br.readLine()) != null)
            {
                aux = line.split(";");
                if (aux[1].equalsIgnoreCase(codigo))
                {
                    return switch (aux[0]) {
                        case "1" ->
                                new Filme(aux[1], aux[2], aux[3], aux[4]);
                        case "2" ->
                                new Jogo(aux[1], aux[2], aux[3], aux[4], aux[5]);
                        case "3" ->
                                new Serie(aux[1], aux[2], aux[3], aux[4]);
                        case "4" ->
                                new EpisodioSerie(aux[1], aux[2], aux[3], aux[4], aux[5], aux[6]);
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

    public Entretenimento procuraEntretenimentoTituloCompleto(String tituloComp)
    {
        if (Objects.equals(tituloComp, ""))
            return null;

        final String dadosEntretenimento = "dados_entretenimento.csv";
        Path arq = Paths.get(dadosEntretenimento);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String aux[];
            String line;
            while((line = br.readLine()) != null)
            {
                aux = line.split(";");
                if (aux[2].equalsIgnoreCase(tituloComp))
                {
                    return switch (aux[0]) {
                        case "1" ->
                                //LinkedList<Filme> listaFilmes = new LinkedList<>();
                                new Filme(aux[1], aux[2], aux[3], aux[4]);
                        case "2" ->
                                //LinkedList<Jogo> listaJogos = new LinkedList<>();
                                new Jogo(aux[1], aux[2], aux[3], aux[4], aux[5]);
                        case "3" ->
                                //LinkedList<Serie> listaSeries = new LinkedList<>();
                                new Serie(aux[1], aux[2], aux[3], aux[4]);
                        case "4" ->
                                //LinkedList<EpisodioSerie> listaEp = new LinkedList<>();
                                new EpisodioSerie(aux[1], aux[2], aux[3], aux[4], aux[5], aux[6]);
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

    public LinkedList<Entretenimento> procuraEntretenimentoTituloIncompleto(String tituloIncomp)
    {
        if (tituloIncomp == null)
            return null;
        final String dadosEntretenimento = "dados_entretenimento.csv";
        Path arq = Paths.get(dadosEntretenimento);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String aux[];
            String line;
            LinkedList<Entretenimento> listaEntretenimentos = new LinkedList<>();
            while((line = br.readLine()) != null)
            {
                aux = line.split(";");
                if (aux[2].contains(tituloIncomp))
                {
                    Entretenimento e = switch (aux[0]) {
                        case "1" ->
                                new Filme(aux[1], aux[2], aux[3], aux[4]);
                        case "2" ->
                                new Jogo(aux[1], aux[2], aux[3], aux[4], aux[5]);
                        case "3" ->
                                new Serie(aux[1], aux[2], aux[3], aux[4]);
                        case "4" ->
                                new EpisodioSerie(aux[1], aux[2], aux[3], aux[4], aux[5], aux[6]);
                        default -> null;
                    };
                    listaEntretenimentos.add(e);
                }
            }
            return listaEntretenimentos;
        }
        catch (IOException io)
        {
            System.out.println(io);
        }
        return null;
    }

    public LinkedList<Entretenimento> procuraEntretenimentoDataLancamento(String data)
    {
        if (data == null)
            return null;
        final String dadosEntretenimento = "dados_entretenimento.csv";
        Path arq = Paths.get(dadosEntretenimento);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String aux[];
            String line;
            LinkedList<Entretenimento> listaEntretenimentos = new LinkedList<>();
            while((line = br.readLine()) != null)
            {
                aux = line.split(";");
                if (aux[3].equals(data))
                {
                    Entretenimento e = switch (aux[0]) {
                        case "1" ->
                                new Filme(aux[1], aux[2], aux[3], aux[4]);
                        case "2" ->
                                new Jogo(aux[1], aux[2], aux[3], aux[4], aux[5]);
                        case "3" ->
                                new Serie(aux[1], aux[2], aux[3], aux[4]);
                        case "4" ->
                                new EpisodioSerie(aux[1], aux[2], aux[3], aux[4], aux[5], aux[6]);
                        default -> null;
                    };
                    listaEntretenimentos.add(e);
                }
            }
            return listaEntretenimentos;
        }
        catch (IOException io)
        {
            System.out.println(io);
        }
        return null;
    }

    public static CatalogoEntretenimento getInstance()
    {
        return(ce);
    }



}
