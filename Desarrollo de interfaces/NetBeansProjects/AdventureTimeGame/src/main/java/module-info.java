module com.mycompany.adventuretimegame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.adventuretimegame to javafx.fxml;
    exports com.mycompany.adventuretimegame;
}
