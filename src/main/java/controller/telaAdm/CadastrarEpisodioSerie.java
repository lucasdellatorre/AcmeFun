package controller.telaAdm;

import catalogos.CatalogoEntretenimento;
import controller.Main;
import entretenimento.EpisodioSerie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Locale;

public class CadastrarEpisodioSerie implements MenuAdmPrincipal
{
    public TextField numEpisodioTf;
    public TextField numTemporadaTf;
    public TextField seriesTf;
    private Main main;
    public TextField idTf;
    public TextField tituloTf;
    public TextField anoDp;
    public TextArea msgAdmTa;
    public static CadastrarEpisodioSerie ces = new CadastrarEpisodioSerie();

    /*
        @todo
        - Dar um jeito de fazer com que o comboBox inicialize a partir de um arquivo + permita que adicionemos objetos
        criados a ele
        - Fazer com que se selecionarmos um titulo, estaremos selecionando um objeto
     */


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
        numEpisodioTf.clear();
        numTemporadaTf.clear();
        seriesTf.clear();
    }

    @FXML
    public void cadastrar(ActionEvent actionEvent)
    {
        // Valida se o usuario preencheu todos os campos
        if (validaSerie())
        {
            EpisodioSerie epSerie = new EpisodioSerie
                    (
                            idTf.getText().toUpperCase(Locale.ROOT).trim(),
                            tituloTf.getText().toUpperCase(Locale.ROOT).trim(),
                            anoDp.getText(),
                            numEpisodioTf.getText(),
                            numTemporadaTf.getText(),
                            seriesTf.getText()
                    );
            // adiciona o jogo no array, se nao houver um jogo com o mesmo id
            if(CatalogoEntretenimento.getInstance().adicionarEntretenimento(epSerie))
            {
                limparDados();
                msgAdmTa.appendText(epSerie.toString() + "\n");
            }
            else
                msgAdmTa.appendText("Erro, Id deve ser único!" + '\n');
        }
        else
            msgAdmTa.appendText("Erro, preencha todos os campos de dados!" + '\n');
        limparDados();
    }

    /*
     @todo
     validar os campos de botoes restantes
     */
    private boolean validaSerie()
    {
        return idTf.getText() != "" && tituloTf.getText() != "" &&
                anoDp.getText() != "" && numEpisodioTf.getText() != ""
                && numTemporadaTf.getText() != "" && seriesTf.getText() != "";
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

    public static CadastrarEpisodioSerie getInstance()
    {
        return(ces);
    }


    public void mudarParaSimularCargaImdb(ActionEvent actionEvent)
    {
        main.mudar(17);
    }
}
