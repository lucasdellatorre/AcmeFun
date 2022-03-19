package controller.telaAdm;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuAdmCadastrarEntretenimento implements MenuAdmPrincipal
{
    private Main main;

    // Menu de opcoes para cadastro de entretenimento

    @FXML
    public void mudarParaEpSerie(ActionEvent actionEvent) {main.mudar(7);}

    @FXML
    public void mudarParaJogo(ActionEvent actionEvent)
    {
        main.mudar(4);
    }

    @FXML
    public void mudarParaFilme(ActionEvent actionEvent) { main.mudar(5); }

    @FXML
    public void mudarParaSerie(ActionEvent actionEvent) { main.mudar(6); }


    // Metodos da interface

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


    public void mudarParaSimularCargaImdb(ActionEvent actionEvent)
    {
        main.mudar(17);
    }
}
