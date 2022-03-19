package controller.telaCliente;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface MenuClientePrincipal
{
    void setMain(Main main);

    @FXML
    void mudarParaInicio(ActionEvent event);

    @FXML
    void mudarParaConsultarCatalogo(ActionEvent event);

    @FXML
    void mudarParaAcessarEntretenimento(ActionEvent event);

    @FXML
    void mudarParaConsultarCobranca(ActionEvent event);

    @FXML
    void terminar(ActionEvent event);

}
