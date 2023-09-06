module com.cellimage.malariacellproject {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires com.almasb.fxgl.all;
    requires java.desktop;
    requires javafx.swing;

    opens com.cellimage.malariacellproject to javafx.fxml;
    exports com.cellimage.malariacellproject;
}