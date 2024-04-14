module com.lcaohoanq.loginsignupjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.lcaohoanq.loginsignupjavafx to javafx.fxml;
    exports com.lcaohoanq.loginsignupjavafx;
}