module com.arthur.mapproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arthur.mapproject to javafx.fxml;
    exports com.arthur.mapproject;
}