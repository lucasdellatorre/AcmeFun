package controller.telaAdm;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface MenuAdmPrincipal
{
    void setMain(Main main);

    @FXML
    void mudarParaInicio(ActionEvent actionEvent);

    @FXML
    void mudarParaCadastrarEntretenimento(ActionEvent actionEvent);

    @FXML
    void mudarParaCadastrarClientes(ActionEvent actionEvent);

    @FXML
    void mudarParaConsultarAcessosMensais(ActionEvent actionEvent);

    @FXML
    void mudarParaSimularCargaDados(ActionEvent actionEvent);

    @FXML
    void mudarParaSimularCargaImdb(ActionEvent actionEvent);

    @FXML
    void terminar(ActionEvent actionEvent);
}
