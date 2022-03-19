package controller.telaCliente;

import acessos.Acesso;
import catalogos.CatalogoEntretenimento;
import com.jfoenix.controls.JFXButton;
import controller.Main;
import entretenimento.Entretenimento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.ResourceBundle;

public class AcessarEntretenimento implements MenuClientePrincipal
{
    public TextField selecionarTf;
    public Label erroLabel;
    public TextArea ultimosEntretenimentos;
    private Main main;
    public JFXButton acessarBtn;


    @FXML
    public void carregar(ActionEvent a)
    {
        ultimosEntretenimentos.clear();
        if(ConsultarCatalogo.ultimaConsulta != null)
        {
            ultimosEntretenimentos.appendText(ConsultarCatalogo.ultimaConsulta.toString());
        }
        else if (ConsultarCatalogo.ultimaConsultaLista != null)
        {
            for(Entretenimento e : ConsultarCatalogo.ultimaConsultaLista)
            {
                ultimosEntretenimentos.appendText(e.toString() + '\n');
            }
        }
    }

    public void mudarParaInicio(ActionEvent event)
    {
        main.mudar(11);
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

    }

    @FXML
    public void mudarParaConsultarCobranca(ActionEvent event) {
        main.mudar(14);
    }

    @FXML
    public void terminar(ActionEvent event) {
        System.exit(0);
    }

    public void acessar(ActionEvent actionEvent)
    {
        erroLabel.setVisible(false);
        Entretenimento ent = CatalogoEntretenimento.getInstance().procuraEntretenimentoTituloCompleto(selecionarTf.getText());
        if (ent != null)
        {
            boolean encontrado = false;
            if (ConsultarCatalogo.ultimaConsulta != null)
            {
                if(selecionarTf.getText().equals(ConsultarCatalogo.ultimaConsulta.getTitulo()))
                {
                    encontrado = true;
                    //ultimosEntretenimentos.appendText(ConsultarCatalogo.ultimaConsulta.getTitulo() + '\n');
                }
            }
            else
            {
                LinkedList<Entretenimento> lista = ConsultarCatalogo.ultimaConsultaLista;
                for(Entretenimento e : lista)
                {
                    if(e.getTitulo().equals(selecionarTf.getText()))
                    {
                        encontrado = true;
                        //ultimosEntretenimentos.appendText(ConsultarCatalogo.ultimaConsulta.getTitulo() + '\n');
                        break;
                    }
                }
            }
            MenuConfirmacaoCliente m;
            if(encontrado)
                m = new MenuConfirmacaoCliente(ent);
            else
                erroLabel.setVisible(true);
        }
        else
            erroLabel.setVisible(true);

    }
}
