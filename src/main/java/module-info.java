module t.t4_lucasdellatorre {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens controller to javafx.fxml;
    exports controller;
    exports controller.telaAdm;
    opens controller.telaAdm to javafx.fxml;
    exports controller.telaCliente;
    opens controller.telaCliente to javafx.fxml;
}