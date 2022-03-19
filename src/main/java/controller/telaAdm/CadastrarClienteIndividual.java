package controller.telaAdm;

import catalogos.CatalogoCliente;
import clientes.ClienteIndividual;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CadastrarClienteIndividual implements MenuAdmPrincipal
{

    public RadioButton naoRb;
    private Main main;
    public TextField nomeTf;
    public TextField emailTf;
    public TextArea msgAdmTa;
    public TextField senhaIndTf;
    public TextField cpfTf;
    public RadioButton simRb;
    public ToggleGroup cliente;
    public TextField emailEmpresaTf;

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
        senhaIndTf.clear();
        cpfTf.clear();
        emailEmpresaTf.clear();
    }

    @FXML
    public void cadastrar(ActionEvent actionEvent)
    {
        // Valida se o usuario preencheu todos os campos
        if (emailEmpresaTf.getText() == "")
            emailEmpresaTf.setText(null);



        if (validaClienteIndividual())
        {
            ClienteIndividual cliInd = new ClienteIndividual
                    (
                            emailTf.getText().trim(),
                            senhaIndTf.getText().trim(),
                            nomeTf.getText().trim(),
                            cpfTf.getText().trim(),
                            emailEmpresaTf.getText()
                    );
            if(CatalogoCliente.getInstance().adicionarCliente(cliInd))
            {
                limparDados();
                msgAdmTa.appendText( cliInd + "\n");
            }
            else
                msgAdmTa.appendText("Erro" + '\n');
        }
        else
            msgAdmTa.appendText("Erro, preencha todos os campos de dados!" + '\n');
        limparDados();
    }


    private boolean validaClienteIndividual()
    {
        return emailTf.getText() != "" && senhaIndTf.getText() != "" &&
                nomeTf.getText() != "" && cpfTf.getText() != "" && (emailEmpresaTf.getText() != null && simRb.isSelected())
                || (emailEmpresaTf.getText() == null && naoRb.isSelected());
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


    public void naoRb(ActionEvent actionEvent)
    {
        emailEmpresaTf.setDisable(true);
        emailEmpresaTf.clear();
    }

    public void simRb(ActionEvent actionEvent)
    {
        emailEmpresaTf.setDisable(false);
    }

    public void mudarParaSimularCargaImdb(ActionEvent actionEvent)
    {
        main.mudar(17);
    }
}
