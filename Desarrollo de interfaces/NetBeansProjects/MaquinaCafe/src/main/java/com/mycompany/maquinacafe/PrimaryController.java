package com.mycompany.maquinacafe;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {
    
    @FXML
    private ChoiceBox<String> choiceBox;
    
        @FXML
    private RadioButton radioButton1;

    @FXML
    private RadioButton radioButton2;

    @FXML
    private RadioButton radioButton3;

    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList("Pequeño", "Mediano", "Grande");
        choiceBox.setItems(options);
        
         ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        
    }
}