package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Juego {

            private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    private String Escenario;

    private String p1;

    private String p2;

    public String getEscenario() {
        return Escenario;
    }

    public void setEscenario(String setEscenario) {
        this.Escenario = setEscenario;
         Image image;

        if ("Arbol".equals(this.Escenario)) {
            image = new Image("/resources/img/Escenarios/FondoArbol.png");
        } else {
            image = new Image("/resources/img/Escenarios/FondoHielo.png");
        }

        fondo.setImage(image);
    
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
        Image imagen = new Image ("/resources/img/Personajes/"+p1+"/Quieto/"+p1+".gif");
        personaje1.setImage(imagen);
        
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
        Image imagen = new Image ("/resources/img/Personajes/"+p2+"/Quieto/"+p2+".gif");
        personaje2.setImage(imagen);
    }

    
    @FXML
    private ImageView fondo;
    
     @FXML
    private ImageView personaje1;

    @FXML
    private ImageView personaje2;

}
