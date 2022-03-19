package controller.telaAdm;

import catalogos.CatalogoCliente;
import clientes.ClienteEmpresarial;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastrarClienteEmpresarial implements MenuAdmPrincipal {

    public Main main;
    public TextField nomeTf;
    public TextField emailTf;
    public TextArea msgAdmTa;
    public TextField senhaEmpTf;
    public TextField cnpjTf;
    public TextField razaoSocialTf;

    @FXML
    public void limpar(ActionEvent actionEvent)
    {
        limparDados();
        msgAdmTa.clear();
    }

    private void limparDados()
    {
        nomeTf.clear();
        emailTf.clear();
        senhaEmpTf.clear();
        cnpjTf.clear();
        razaoSocialTf.clear();
    }

    @FXML
    public void cadastrar(ActionEvent actionEvent)
    {
        // Valida se o usuario preencheu todos os campos
        if (validaClienteEmpresarial())
        {
            ClienteEmpresarial cliEmp = new ClienteEmpresarial
                    (
                            emailTf.getText().trim(),
                            senhaEmpTf.getText().trim(),
                            nomeTf.getText().trim(),
                            cnpjTf.getText().trim(),
                            razaoSocialTf.getText()
                    );
            // adiciona o jogo no array, se nao houver um jogo com o mesmo id
            if(CatalogoCliente.getInstance().adicionarCliente(cliEmp))
            {
                limparDados();
                msgAdmTa.appendText( cliEmp + "\n");
            }
            else
                msgAdmTa.appendText("Erro" + '\n');
        }
        else
            msgAdmTa.appendText("Erro, preencha todos os campos de dados!" + '\n');
        limparDados();
    }


    public boolean validaClienteEmpresarial()
    {
        return emailTf.getText() != "" && senhaEmpTf.getText() != "" &&
                nomeTf.getText() != "" && cnpjTf.getText() != "" && razaoSocialTf.getText() != "";
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
