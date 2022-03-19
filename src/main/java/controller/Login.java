package controller;

import clientes.Cliente;
import clientes.ClienteEmpresarial;
import clientes.ClienteIndividual;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Login
{
    private Main main;
    private final String adminUsername = "administracao@mail.com";
    private final String adminSenha = "admin123";
    public static Cliente usuarioAtual;

    @FXML
    public TextField textField;

    @FXML
    public PasswordField passField;

    @FXML
    public Label loginMensagem;

    public void setMain(Main main) {
        this.main = main;
    }

    public static Cliente getUsuarioAtual() {
        return usuarioAtual;
    }

    @FXML
    public void logar(ActionEvent actionEvent) {
        String username = textField.getText();
        String password = passField.getText();
        if (username.equals(adminUsername) && password.equals(adminSenha))
            main.mudar(2);
        else if(verificarUsuarioSenha(username, password))
        {
            main.mudar(11);
        }
        else
        {
            loginMensagem.setVisible(true);
            textField.clear();
            passField.clear();
        }

    }

    public boolean verificarUsuarioSenha(String user, String pw)
    {
        final String dadosClientes = "dados_clientes.csv";
        Path arq = Paths.get(dadosClientes);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(arq)))
        {
            String aux[];
            String line;
            while((line = br.readLine()) != null)
            {
                aux = line.split(";");
                if (aux[2].equals(user) && aux[3].equals(pw))
                {
                    // Registrar usuario atual
                    if(aux[0].equals("1"))
                        usuarioAtual = new ClienteIndividual(aux[1], aux[2], aux[3], aux[4], null);
                    else if (aux[0].equals("2"))
                    {
                        usuarioAtual = new ClienteEmpresarial(aux[1], aux[2], aux[3], aux[4], aux[5]);
                    }
                    else
                        usuarioAtual = new ClienteIndividual(aux[1], aux[2], aux[3], aux[4], aux[5]);
                    return true;
                }
            }
            return false;
        }
        catch (IOException io)
        {
            return false;
        }
    }

}