package controller.telaCliente;

import catalogos.CatalogoAcesso;
import entretenimento.Entretenimento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuConfirmacaoCliente {

    public MenuConfirmacaoCliente(Entretenimento ent)
    {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);    // Muda para modal

        GridPane painel2 = new GridPane();

        painel2.setAlignment(Pos.CENTER);
        painel2.setHgap(10);
        painel2.setVgap(10);
        painel2.setPadding(new Insets(25, 25, 25, 25));
        painel2.setGridLinesVisible(false);

        Text scenetitle = new Text("Confirmar Acesso");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel2.add(scenetitle, 0, 0, 3, 1);



        Button btnFinal = new Button("Terminar");

        Button btnConfirmar = new Button("Confirmar");

        painel2.add(btnFinal, 1, 3);
        painel2.add(btnConfirmar, 2, 3);


        btnFinal.setOnAction(e -> {
            newStage.close();
        });

        btnConfirmar.setOnAction(e ->
        {

            CatalogoAcesso.getInstance().registrarAcesso(ent);


            // email da empresa
            newStage.close();
        });

        Scene cena2 = new Scene(painel2, 300, 200);

        //newStage.setTitle("");
        newStage.setScene(cena2);
        newStage.show();
    }

}
