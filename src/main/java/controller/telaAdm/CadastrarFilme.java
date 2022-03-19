
package controller.telaAdm;

import catalogos.CatalogoEntretenimento;
import controller.Main;
import entretenimento.Filme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Locale;

public class CadastrarFilme implements MenuAdmPrincipal
{
    public TextField idTf;
    public TextField tituloTf;
    public TextField anoDp;
    public TextField tempoDuracaoTf;
    public TextArea msgAdmTa;
    private Main main;


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
        anoDp.clear();
        tempoDuracaoTf.clear();
    }

    @FXML
    public void cadastrar(ActionEvent actionEvent)
    {
        // Valida se o usuario preencheu todos os campos
        if (validaFilme())
        {
            Filme filme = new Filme
                    (
                            idTf.getText().toUpperCase(Locale.ROOT).trim(),
                            tituloTf.getText().toUpperCase(Locale.ROOT).trim(),
                            anoDp.getText(),
                            tempoDuracaoTf.getText().toUpperCase(Locale.ROOT).trim()
                    );
            // adiciona o jogo no array, se nao houver um jogo com o mesmo id
            if((CatalogoEntretenimento.getInstance().adicionarEntretenimento(filme)))
            {
                limparDados();
                msgAdmTa.appendText(filme + "\n");
            }
            else
                msgAdmTa.appendText("Erro, Id deve ser único!" + '\n');
        }
        else
            msgAdmTa.appendText("Erro, preencha todos os campos de dados!" + '\n');
        limparDados();
    }

    private boolean validaFilme()
    {
        return idTf.getText() != "" && tituloTf.getText() != "" &&
                anoDp.getText() != "" && tempoDuracaoTf.getText() != "";
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


