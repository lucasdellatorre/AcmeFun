package controller.telaAdm;

import catalogos.CatalogoEntretenimento;
import controller.Main;
import entretenimento.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Locale;

public class CadastrarJogo implements MenuAdmPrincipal
{
    private Main main;
    public TextField idTf;
    public TextField tituloTf;
    public TextField tituloOriginalTf;
    public TextField anoDp;
    public TextField generoTf;
    public TextArea msgAdmTa;

    @FXML
    public void limpar(ActionEvent actionEvent)
    {
        limparDados();
        msgAdmTa.clear();
    }

    private void limparDados()
    {
        idTf.clear();
        tituloTf.clear();
        tituloOriginalTf.clear();
        anoDp.clear();
        generoTf.clear();
    }

    @FXML
    public void cadastrar(ActionEvent actionEvent)
    {
        // Valida se o usuario preencheu todos os campos
        if (validaJogo())
        {
            Jogo jogo = new Jogo
                    (
                            idTf.getText().toUpperCase(Locale.ROOT).trim(),
                            tituloTf.getText().toUpperCase(Locale.ROOT).trim(),
                            anoDp.getText(),
                            tituloOriginalTf.getText().toUpperCase(Locale.ROOT).trim(),
                            generoTf.getText().toUpperCase(Locale.ROOT).trim()
                    );
            // adiciona o jogo no array, se nao houver um jogo com o mesmo id
            if(CatalogoEntretenimento.getInstance().adicionarEntretenimento(jogo))
            {
                limparDados();
                msgAdmTa.appendText(jogo + "\n");
            }
            else
                msgAdmTa.appendText("Erro, Id deve ser único!" + '\n');
        }
        else
            msgAdmTa.appendText("Erro, preencha todos os campos de dados!" + '\n');
        limparDados();
    }

    private boolean validaJogo()
    {
        return idTf.getText() != "" && tituloTf.getText() != "" &&
                anoDp.getText() != "" && tituloOriginalTf.getText() != "" &&
                generoTf.getText() != "";
    }


    @Override
    public void setMain(Main main) {
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
