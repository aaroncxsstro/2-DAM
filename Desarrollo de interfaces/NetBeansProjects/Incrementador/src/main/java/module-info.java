/* doesn't work with source level 1.8:
module com.mycompany.incrementador {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.incrementador to javafx.fxml;
    exports com.mycompany.incrementador;
}
*/
