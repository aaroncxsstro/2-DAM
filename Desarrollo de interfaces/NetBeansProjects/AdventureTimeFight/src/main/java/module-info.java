module com.mycompany.adventuretimefight {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.adventuretimefight to javafx.fxml;
    exports com.mycompany.adventuretimefight;
}
