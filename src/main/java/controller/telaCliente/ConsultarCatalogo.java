package controller.telaCliente;

import catalogos.CatalogoEntretenimento;
import comparable.EntretenimentoComparatorData;
import comparable.EntretenimentoComparatorTitulo;
import controller.Main;
import entretenimento.Entretenimento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ConsultarCatalogo implements MenuClientePrincipal, Initializable
{
    public Main main;
    public TextField pesquisarTf;
    public static LinkedList<Entretenimento> ultimaConsultaLista;
    public static Entretenimento ultimaConsulta;
    public ComboBox<String> filtroCb = new ComboBox<>();
    public RadioButton crescenteRb;
    public ToggleGroup ordem;
    public RadioButton decrescenteRb;
    public TextArea mostraEntretenimentoTa;


    public void pesquisar(ActionEvent actionEvent)
    {
        mostraEntretenimentoTa.clear();
        try
        {
            Entretenimento e = null;
            LinkedList<Entretenimento> lista = new LinkedList<>();
            String msgErro = "";
            String itemSelecionado = filtroCb.getSelectionModel().getSelectedItem();
            if (itemSelecionado == null)
            {
                mostraEntretenimentoTa.appendText("Selecione algum filtro!" + '\n');
            }
            else
            {
                switch (itemSelecionado)
                {
                    case "Código" -> {
                        e = CatalogoEntretenimento.getInstance().procurarEntretenimentoCodigo(pesquisarTf.getText());
                        msgErro = "Código";
                    }
                    case "Título Completo" -> {
                        e = CatalogoEntretenimento.getInstance().procuraEntretenimentoTituloCompleto(pesquisarTf.getText());
                        msgErro = "Título Completo";
                    }
                    case "Título Incompleto" -> {
                        lista = CatalogoEntretenimento.getInstance().procuraEntretenimentoTituloIncompleto(pesquisarTf.getText());
                        if (lista.isEmpty())
                            msgErro = "Título Incompleto";
                    }
                    case "Ano de Lançamento" -> {
                        lista = CatalogoEntretenimento.getInstance().procuraEntretenimentoDataLancamento(pesquisarTf.getText().trim());
                        if (lista.isEmpty())
                            msgErro = "Ano de Lançamento";
                    }
                    default -> mostraEntretenimentoTa.appendText("Selecione algum filtro" + '\n');
                }
                printResultados(e, lista, msgErro);
            }
        }
        catch (Exception exception)
        {
            System.err.println(exception);
        }
    }

    private void printResultados(Entretenimento e, LinkedList<Entretenimento> lista, String msgErro)
    {
        // Esvazia ultima consulta
        ultimaConsultaLista = null;
        ultimaConsulta = null;
        if (e != null)
        {
            mostraEntretenimentoTa.appendText(e.toString() + '\n');
            ultimaConsulta = e;
        }
        else if (!lista.isEmpty())
        {
            // Ordena a lista
            if (crescenteRb.isSelected())
                lista.sort(new EntretenimentoComparatorTitulo());
            else
                lista.sort(new EntretenimentoComparatorData());
            for(Entretenimento l : lista)
            {
                mostraEntretenimentoTa.appendText(l.toString() + '\n');
            }
            ultimaConsultaLista = lista;
        }
        else
        {
            mostraEntretenimentoTa.appendText(msgErro + " nao encontrado!" + '\n');
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("Código");
        lista.add("Título Completo");
        lista.add("Título Incompleto");
        lista.add("Ano de Lançamento");
        ObservableList<String> list = FXCollections.observableList(lista);
        filtroCb.setItems(list);

    }

    public static LinkedList<Entretenimento> getUltimaConsultaLista() {
        return ultimaConsultaLista;
    }

    public static Entretenimento getUltimaConsulta() {
        return ultimaConsulta;
    }
}
