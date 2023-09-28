package com.mycompany.prueba;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML
    private Button btnSaludar;
    
    @FXML
    private TextField txtSaludo;
    
    public void saludar(ActionEvent event){
        
        txtSaludo.setText("Hola Mundo");
    }
}
