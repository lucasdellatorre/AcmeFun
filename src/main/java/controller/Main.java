package controller;

import clientes.Cliente;
import clientes.ClienteIndividual;
import controller.telaAdm.*;
import controller.telaCliente.AcessarEntretenimento;
import controller.telaCliente.ConsultarCatalogo;
import controller.telaCliente.ConsultarCobranca;
import controller.telaCliente.HomeCliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
    Acrescentar a comboBox
 */

public class Main extends Application
{
    private Parent loginInterface;
    private Parent homeAdmInterface;
    private Parent menuCadastrarEntretenimentoInterface;
    private Parent cadastrarJogoInterface;
    private Parent cadastrarFilmeInterface;
    private Parent cadastrarSerieInterface;
    private Parent cadastrarEpSerieInterface;
    private Parent menuCadastrarClienteInterface;
    private Parent cadastrarClienteIndividualInterface;
    private Parent cadastrarClienteEmpresarialInterface;
    private Parent homeClienteInterface;
    private Parent consultarCatalogoInterface;
    private Parent acessarEntretenimentoInterface;
    private Parent consultarCobrancaInterface;
    private Parent consultarAcessoInterface;
    private Parent simularCargaDadosInterface;
    private Parent simularCargaImdbInterface;

    private Login loginControlador;
    private HomeAdm homeAdmControlador;
    private MenuAdmCadastrarEntretenimento menuCadastrarEntretenimentoControlador;
    private CadastrarJogo cadastrarJogoControlador;
    private CadastrarFilme cadastrarFilmeControlador;
    private CadastrarSerie cadastrarSerieControlador;
    private CadastrarEpisodioSerie cadastrarEpSerieControlador;
    private MenuAdmCadastrarCliente menuCadastrarClienteControlador;
    private CadastrarClienteIndividual cadastrarClienteIndividualControlador;
    private CadastrarClienteEmpresarial cadastrarClienteEmpresarialControlador;
    private HomeCliente homeClienteControlador;
    private ConsultarCatalogo consultarCatalogoControlador;
    private AcessarEntretenimento acessarEntretenimentoControlador;
    private ConsultarCobranca consultarCobrancaControlador;
    private ConsultarAcesso consultarAcessoControlador;
    private SimularCargaDados simularCargaDadosControlador;
    private SimularCargaImdb simularCargaImdbControlador;

    private Scene cena;



    @Override
    public void start(Stage stage) {
        try
        {
            // Login
            FXMLLoader loader1 = new FXMLLoader();
            loginInterface = (Parent) loader1.
                    load(getClass().getResource("login.fxml").openStream());
            loginControlador = (Login) loader1.getController();

            loginControlador.setMain(this);

            // HomeADM
            FXMLLoader loader2 = new FXMLLoader();
            homeAdmInterface= (Parent) loader2.
                    load(getClass().getResource("homeAdm.fxml").openStream());
            homeAdmControlador = (HomeAdm) loader2.getController();
            homeAdmControlador.setMain(this);

            // Menu de selecao de cadastro de entretenimento

            FXMLLoader loader3 = new FXMLLoader();
            menuCadastrarEntretenimentoInterface = (Parent) loader3.
                    load(getClass().getResource("menuCadastrarEntretenimento.fxml").openStream());
            menuCadastrarEntretenimentoControlador = (MenuAdmCadastrarEntretenimento) loader3.getController();
            menuCadastrarEntretenimentoControlador.setMain(this);

            // Cadastrar Jogo
            FXMLLoader loader4 = new FXMLLoader();
            cadastrarJogoInterface = (Parent) loader4
                    .load(getClass().getResource("cadastrarJogo.fxml").openStream());
            cadastrarJogoControlador = (CadastrarJogo) loader4.getController();
            cadastrarJogoControlador.setMain(this);

            // Cadastrar Filme
            FXMLLoader loader5 = new FXMLLoader();
            cadastrarFilmeInterface = (Parent) loader5
                    .load(getClass().getResource("cadastrarFilme.fxml").openStream());
            cadastrarFilmeControlador = (CadastrarFilme) loader5.getController();
            cadastrarFilmeControlador.setMain(this);

            // Cadastrar Serie
            FXMLLoader loader6 = new FXMLLoader();
            cadastrarSerieInterface = (Parent) loader6
                    .load(getClass().getResource("cadastrarSerie.fxml").openStream());
            cadastrarSerieControlador = (CadastrarSerie) loader6.getController();
            cadastrarSerieControlador.setMain(this);

            // Cadastrar Episodio de Serie
            FXMLLoader loader7 = new FXMLLoader();
            cadastrarEpSerieInterface = (Parent) loader7
                    .load(getClass().getResource("cadastrarEpisodioSerie.fxml").openStream());
            cadastrarEpSerieControlador = (CadastrarEpisodioSerie) loader7.getController();
            cadastrarEpSerieControlador.setMain(this);

            // Menu cadastrar cliente

            FXMLLoader loader8 = new FXMLLoader();
            menuCadastrarClienteInterface = (Parent) loader8
                    .load(getClass().getResource("menuCadastrarCliente.fxml").openStream());
            menuCadastrarClienteControlador = (MenuAdmCadastrarCliente) loader8.getController();
            menuCadastrarClienteControlador.setMain(this);

            // Cadastrar cliente Individual

            FXMLLoader loader9 = new FXMLLoader();
            cadastrarClienteIndividualInterface = (Parent) loader9
                    .load(getClass().getResource("cadastrarClienteIndividual.fxml").openStream());
            cadastrarClienteIndividualControlador = (CadastrarClienteIndividual) loader9.getController();
            cadastrarClienteIndividualControlador.setMain(this);

            // Cadastrar cliente Empresarial

            FXMLLoader loader10 = new FXMLLoader();
            cadastrarClienteEmpresarialInterface = (Parent) loader10
                    .load(getClass().getResource("cadastrarClienteEmpresarial.fxml").openStream());
            cadastrarClienteEmpresarialControlador = (CadastrarClienteEmpresarial) loader10.getController();
            cadastrarClienteEmpresarialControlador.setMain(this);

            // Menu Cliente

            FXMLLoader loader11 = new FXMLLoader();
            homeClienteInterface = (Parent) loader11
                    .load(getClass().getResource("homeCliente.fxml").openStream());
            homeClienteControlador  = (HomeCliente) loader11.getController();
            homeClienteControlador.setMain(this);

            // Consultar Catalogo

            FXMLLoader loader12 = new FXMLLoader();
            consultarCatalogoInterface = (Parent) loader12
                    .load(getClass().getResource("consultarCatalogo.fxml").openStream());
            consultarCatalogoControlador  = (ConsultarCatalogo) loader12.getController();
            consultarCatalogoControlador.setMain(this);

            // Acessar Entretenimento

            FXMLLoader loader13 = new FXMLLoader();
            acessarEntretenimentoInterface = (Parent) loader13
                    .load(getClass().getResource("acessarEntretenimento.fxml").openStream());
            acessarEntretenimentoControlador  = (AcessarEntretenimento) loader13.getController();
            acessarEntretenimentoControlador.setMain(this);

            // Consultar Cobranca mensal

            FXMLLoader loader14 = new FXMLLoader();
            consultarCobrancaInterface = (Parent) loader14
                    .load(getClass().getResource("consultarCobrancaMensal.fxml").openStream());
            consultarCobrancaControlador  = (ConsultarCobranca) loader14.getController();
            consultarCobrancaControlador.setMain(this);

            // Consultar Acesso mensal

            FXMLLoader loader15 = new FXMLLoader();
            consultarAcessoInterface = (Parent) loader15
                    .load(getClass().getResource("consultarAcesso.fxml").openStream());
            consultarAcessoControlador  = (ConsultarAcesso) loader15.getController();
            consultarAcessoControlador.setMain(this);

            // Simular Carga de dados

            FXMLLoader loader16 =  new FXMLLoader();
            simularCargaDadosInterface = (Parent) loader16
                    .load(getClass().getResource("simularCargaDados.fxml").openStream());
            simularCargaDadosControlador  = (SimularCargaDados) loader16.getController();
            simularCargaDadosControlador.setMain(this);

            // Simular Imdb

            FXMLLoader loader17 =  new FXMLLoader();
            simularCargaImdbInterface = (Parent) loader17
                    .load(getClass().getResource("simularImdb.fxml").openStream());
            simularCargaImdbControlador  = (SimularCargaImdb) loader17.getController();
            simularCargaImdbControlador.setMain(this);




            cena = new Scene(loginInterface);
            stage.setTitle("ACMEFUN");
            stage.setScene(cena);
            stage.show();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Mudanca de painel
    public void mudar(int painel)
    {
        switch (painel)
        {
            case 1 -> cena.setRoot(loginInterface);
            case 2 -> cena.setRoot(homeAdmInterface);
            case 3 -> cena.setRoot(menuCadastrarEntretenimentoInterface);
            case 4 -> cena.setRoot(cadastrarJogoInterface);
            case 5 -> cena.setRoot(cadastrarFilmeInterface);
            case 6 -> cena.setRoot(cadastrarSerieInterface);
            case 7 -> cena.setRoot(cadastrarEpSerieInterface);
            case 8 -> cena.setRoot(menuCadastrarClienteInterface);
            case 9 -> cena.setRoot(cadastrarClienteIndividualInterface);
            case 10 -> cena.setRoot(cadastrarClienteEmpresarialInterface);
            case 11 -> cena.setRoot(homeClienteInterface);
            case 12 -> cena.setRoot(consultarCatalogoInterface);
            case 13 -> cena.setRoot(acessarEntretenimentoInterface);
            case 14 -> cena.setRoot(consultarCobrancaInterface);
            case 15 -> cena.setRoot(consultarAcessoInterface);
            case 16 -> cena.setRoot(simularCargaDadosInterface);
            case 17 -> cena.setRoot(simularCargaImdbInterface);
        }
    }

}