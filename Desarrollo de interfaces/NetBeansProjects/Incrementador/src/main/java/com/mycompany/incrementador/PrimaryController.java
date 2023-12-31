package com.mycompany.incrementador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController implements Initializable{

    @FXML
    private TextField txtResult;
     @FXML
    private Button btDec;
     @FXML
    private Button btInc;
     @FXML
     private ImageView imgPerri;

    
    public void increase(ActionEvent event) {
        int resultado= Integer.parseInt(txtResult.getText());
        resultado=resultado+1;
        txtResult.setText(Integer.toString(resultado));
        
}
    
        public void decrease(ActionEvent event) {
        int resultado= Integer.parseInt(txtResult.getText());
        resultado=resultado-1;
        txtResult.setText(Integer.toString(resultado));
        
}

    @Override
    public void initialize(URL location, ResourceBundle resources) { 
    this.txtResult.setText("0");
    Image imagen1 = new Image(getClass().getResourceAsStream("/resources/perrito.jpg"));
    imgPerri.setImage(imagen1);
    }
}
