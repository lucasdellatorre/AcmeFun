package controller.telaCliente;

import catalogos.CatalogoAcesso;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConsultarCobranca implements MenuClientePrincipal
{
    public Main main;
    public TextField anoTf;
    public TextField mesTf;
    public TextArea dadosAcessoTa = new TextArea();
    public TextArea valorTotalTa;

    @FXML
    public void pesquisar(ActionEvent actionEvent)
    {
        dadosAcessoTa.clear();
        valorTotalTa.clear();
        if (anoTf.getText() != null && mesTf.getText() != null)
        {
            StringBuilder dadosAcesso = CatalogoAcesso.getInstance().mostraInformacoesAcessoCliente(anoTf.getText(), mesTf.getText());
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

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void mudarParaInicio(ActionEvent event) {
        main.mudar(11);
    }

    @Override
    public void mudarParaConsultarCatalogo(ActionEvent event) {
        main.mudar(12);
    }

    @Override
    public void mudarParaAcessarEntretenimento(ActionEvent event)
    {
        main.mudar(13);
    }

    @Override
    public void mudarParaConsultarCobranca(ActionEvent event) {
        main.mudar(14);
    }

    @Override
    public void terminar(ActionEvent event) {
        System.exit(0);
    }

}
