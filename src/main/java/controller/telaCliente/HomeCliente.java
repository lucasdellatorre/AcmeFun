package controller.telaCliente;

import com.jfoenix.controls.JFXButton;
import controller.Main;
import controller.telaCliente.MenuClientePrincipal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HomeCliente implements MenuClientePrincipal
{
    public Main main;



    @FXML
    public void mudarParaInicio(ActionEvent event)
    {

    }

    @FXML
    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void mudarParaConsultarCatalogo(ActionEvent event) {
        main.mudar(12);
    }

    @FXML
    public void mudarParaAcessarEntretenimento(ActionEvent event) {
        main.mudar(13);
    }

    @FXML
    public void mudarParaConsultarCobranca(ActionEvent event)
    {
        main.mudar(14);
    }

    @FXML
    public void terminar(ActionEvent event) {
        System.exit(0);
    }


}
