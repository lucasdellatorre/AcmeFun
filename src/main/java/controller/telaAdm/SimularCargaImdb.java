package controller.telaAdm;

import catalogos.CatalogoEntretenimento;
import controller.Main;
import entretenimento.Entretenimento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimularCargaImdb implements MenuAdmPrincipal
{
    public Main main;

    public void simular(ActionEvent actionEvent)
    {
        CatalogoEntretenimento.getInstance().adicionarEntretenimentoImdb();
    }


    public void setMain(Main main)
    {
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


    public void mudarParaSimularCargaImdb(ActionEvent actionEvent) {
    }
}
