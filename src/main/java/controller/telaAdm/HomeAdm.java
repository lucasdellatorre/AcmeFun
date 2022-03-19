package controller.telaAdm;

import com.jfoenix.controls.JFXButton;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeAdm implements MenuAdmPrincipal
{
    public JFXButton cadastrarEntretenimentoBtn;
    public JFXButton inicioBtn;
    public JFXButton cadastrarClientesBtn;
    public JFXButton consultarAcessosMensaisBtn;
    public JFXButton simularCargaDadosBtn;
    private Main main;

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
