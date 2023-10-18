package com.mycompany.maquinacafe;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {
    
    @FXML
    private ComboBox<String> cbx;
    
        @FXML
    private RadioButton cortado;

    @FXML
    private RadioButton latte;

    @FXML
    private RadioButton capuccino;

    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList("Pequeño", "Mediano", "Grande");
        cbx.setItems(options);
        
        ToggleGroup toggleGroup = new ToggleGroup();
        cortado.setToggleGroup(toggleGroup);
        latte.setToggleGroup(toggleGroup);
        capuccino.setToggleGroup(toggleGroup);
        
    }
    
    public void pedirCafe (ActionEvent event){
  
        
    }
}