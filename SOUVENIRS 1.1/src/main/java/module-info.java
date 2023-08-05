module souvenirs {
    requires javafx.controls;
    requires javafx.fxml;


    opens souvenirs to javafx.fxml;
    exports souvenirs;
}