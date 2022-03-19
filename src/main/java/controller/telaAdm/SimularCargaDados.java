package controller.telaAdm;


import controller.Login;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimularCargaDados implements MenuAdmPrincipal
{
    public Main main;
    public TextArea traceTa;
    public TextField nomeArq;
    public TextArea todosDadosTa;

    public void simular(ActionEvent actionEvent)
    {

        traceTa.clear();
        todosDadosTa.clear();

        // Mostra o trace

        if(!mergeArquivoEntretenimento(nomeArq.getText()))
        {
            traceTa.appendText("Erro, digite o nome de um arquivo válido" + '\n' );
            return;
        }
        if(!mergeArquivoCliente(nomeArq.getText()))
        {
            traceTa.appendText("Erro, digite o nome de um arquivo válido" + '\n' );
            return;
        }
        if(!mergeArquivoAcesso(nomeArq.getText()))
        {
            traceTa.appendText("Erro, digite o nome de um arquivo válido" + '\n' );
            return;
        }

        // Mostra uma lista com todos os dados

        mostraAcessos();
        mostraListaClientes();
        mostraListaEntretenimento();

        // Apaga os campos de dados
        nomeArq.clear();
    }

    private boolean mergeArquivoEntretenimento(String nomeArq)
    {
        Path arqEntretenimento = Paths.get(nomeArq + "-entretenimento.dat");
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(arqEntretenimento));
                FileWriter fw = new FileWriter("dados_entretenimento.csv", true);
                PrintWriter out = new PrintWriter(new BufferedWriter(fw))
        )
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                out.println(line);
                traceTa.appendText(line + '\n');
            }
            return true;
        }
        catch (IOException io)
        {
            System.err.println(io);
            return false;
        }

    }

    private boolean mergeArquivoCliente(String nomeArq)
    {
        Path arqClientes= Paths.get(nomeArq + "-clientes.dat");
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(arqClientes));
                FileWriter fw = new FileWriter("dados_clientes.csv", true);
                PrintWriter out = new PrintWriter(new BufferedWriter(fw))
        )
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                out.println(line);
                traceTa.appendText(line + '\n');
            }
            return true;
        }
        catch (IOException io)
        {
            System.err.println(io);
            return false;
        }
    }

    private boolean mergeArquivoAcesso(String nomeArq)
    {
        Path arqAcesso = Paths.get(nomeArq + "-acessos.dat");
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(arqAcesso));
                FileWriter fw = new FileWriter("dados_acessos.csv", true);
                PrintWriter out = new PrintWriter(new BufferedWriter(fw))
        )
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                out.println(line);
                traceTa.appendText(line + '\n');
            }
            return true;
        }
        catch (IOException io)
        {
            System.err.println(io);
            return false;
        }
    }

    private void mostraListaEntretenimento()
    {
        Path arqEntretenimento = Paths.get("dados_entretenimento.csv");
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(arqEntretenimento));
        )
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                todosDadosTa.appendText(line + '\n');
            }
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    private void mostraListaClientes()
    {
        Path arqClientes = Paths.get("dados_clientes.csv");
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(arqClientes));
        )
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                todosDadosTa.appendText(line + '\n');
            }
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    private void mostraAcessos()
    {
        Path arqAcessos = Paths.get("dados_acessos.csv");
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(arqAcessos));
        )
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                todosDadosTa.appendText(line + '\n');
            }
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void mudarParaInicio(ActionEvent actionEvent)
    {
        main.mudar(2);
    }

    @FXML
    public void mudarParaCadastrarEntretenimento(ActionEvent actionEvent)
    {
        main.mudar(3);
    }

    @FXML
    public void mudarParaCadastrarClientes(ActionEvent actionEvent)
    {
        main.mudar(8);
    }

    @FXML
    public void mudarParaConsultarAcessosMensais(ActionEvent actionEvent)
    {
        main.mudar(15);
    }

    @FXML
    public void mudarParaSimularCargaDados(ActionEvent actionEvent)
    {
        main.mudar(16);
    }

    @FXML
    public void terminar(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void mudarParaSimularCargaImdb(ActionEvent actionEvent)
    {
        main.mudar(17);
    }
}
