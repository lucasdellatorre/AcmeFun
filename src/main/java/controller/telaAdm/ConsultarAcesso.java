package controller.telaAdm;

import catalogos.CatalogoAcesso;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConsultarAcesso implements MenuAdmPrincipal
{
    public Main main;
    public TextField anoTf;
    public TextField mesTf;
    public TextArea dadosAcessoTa;
    public TextArea valorTotalTa;

    public void pesquisar(ActionEvent actionEvent)
    {
        dadosAcessoTa.clear();
        valorTotalTa.clear();
        if (anoTf.getText() != null && mesTf.getText() != null)
        {
            StringBuilder dadosAcesso = CatalogoAcesso.getInstance().mostraInformacoesAcessoAdm(anoTf.getText(), mesTf.getText());
            if (dadosAcesso == null)
                dadosAcessoTa.appendText("Data de acesso não existe" + '\n');
            else
                dadosAcessoTa.appendText(dadosAcesso.toString() + '\n');

            String valorTotal = CatalogoAcesso.getInstance().mostraValorTotalAcesso(anoTf.getText(), mesTf.getText());
            if (valorTotal != null)
                valorTotalTa.appendText("R$" + valorTotal);
        }
        else
            dadosAcessoTa.appendText("Data de acesso não existe"); // adicionar um Label

        anoTf.clear();
        mesTf.clear();
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

    public void mudarParaSimularCargaImdb(ActionEvent actionEvent)
    {
        main.mudar(17);
    }
}
