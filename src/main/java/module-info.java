module com.example.skipsnakebit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.skipsnakebit to javafx.fxml;
    exports com.example.skipsnakebit;
}