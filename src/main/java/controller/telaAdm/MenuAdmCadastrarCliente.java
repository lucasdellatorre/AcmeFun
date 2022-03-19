package controller.telaAdm;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuAdmCadastrarCliente implements MenuAdmPrincipal
{
    private Main main;

    // Menu de opcoes para cadastro de Clientes
    @FXML
    public void mudarParaClienteEmpresarial(ActionEvent actionEvent)
    {
        main.mudar(10);
    }

    @FXML
    public void mudarParaClienteIndividual(ActionEvent actionEvent)
    {
        main.mudar(9);
    }

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
        main.mudar(0);
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
