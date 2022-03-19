package controller.telaAdm;

import catalogos.CatalogoEntretenimento;
import controller.Main;
import entretenimento.Serie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Locale;

public class CadastrarSerie implements MenuAdmPrincipal
{
    public TextField anoConclusaoDp;
    private Main main;
    public TextField idTf;
    public TextField tituloTf;
    public TextField anoDp;
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
        anoConclusaoDp.clear();
        anoDp.clear();
    }

    @FXML
    public void cadastrar(ActionEvent actionEvent)
    {
        // Valida se o usuario preencheu todos os campos
        if (validaSerie())
        {
            Serie serie = new Serie
                    (
                            idTf.getText().toUpperCase(Locale.ROOT).trim(),
                            tituloTf.getText().toUpperCase(Locale.ROOT).trim(),
                            anoDp.getText(),
                            anoConclusaoDp.getText()
                    );
            // adiciona o jogo no array, se nao houver um jogo com o mesmo id
            if(CatalogoEntretenimento.getInstance().adicionarEntretenimento(serie))
            {
                limparDados();
                msgAdmTa.appendText(serie + "\n");

            }
            else
                msgAdmTa.appendText("Erro, Id deve ser único!" + '\n');
        }
        else
            msgAdmTa.appendText("Erro, preencha todos os campos de dados!" + '\n');
        limparDados();
    }

    private boolean validaSerie()
    {
        return idTf.getText() != "" && tituloTf.getText() != "" &&
                anoDp.getText() != "" && anoConclusaoDp.getText() != "";
    }

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void mudarParaInicio(ActionEvent actionEvent) {
        main.mudar(2);
    }

    @Override
    public void mudarParaCadastrarEntretenimento(ActionEvent actionEvent)
    {
        main.mudar(3);
    }

    @Override
    public void mudarParaCadastrarClientes(ActionEvent actionEvent) {
        main.mudar(8);
    }

    @Override
    public void mudarParaConsultarAcessosMensais(ActionEvent actionEvent) {
        main.mudar(15);
    }

    @Override
    public void mudarParaSimularCargaDados(ActionEvent actionEvent) {
        main.mudar(16);
    }

    @Override
    public void terminar(ActionEvent actionEvent)
    {
        System.exit(0);
    }


    public void mudarParaSimularCargaImdb(ActionEvent actionEvent)
    {
        main.mudar(17);
    }
}
