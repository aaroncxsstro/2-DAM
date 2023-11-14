/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;



public class PantallaMapa {
            private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    private String P1;
    private String P2;
    private String Escenario;
    private boolean unjugador;

    public void setUnjugador(boolean unjugador) {
        this.unjugador = unjugador;
    }
    
    public String getP1() {
        return P1;
    }

    public void setP1(String P1) {
        this.P1 = P1;
    }

    public String getP2() {
        return P2;
    }

    public void setP2(String P2) {
        this.P2 = P2;
    }
    
    @FXML
    private AnchorPane pane3;

    @FXML
    private ImageView Arbol;

    @FXML
    private ImageView Hielo;

    @FXML
    private ImageView play;
    
   
        @FXML
void animarAmpliacionBoton(MouseEvent event) {
    ImageView boton = (ImageView) event.getSource();

    ScaleTransition expandirAnimacion = new ScaleTransition(Duration.seconds(0.1), boton);
    expandirAnimacion.setFromX(1.0);
    expandirAnimacion.setToX(1.1);
    expandirAnimacion.setFromY(1.0);
    expandirAnimacion.setToY(1.1);
    expandirAnimacion.play();
}
    
        @FXML
    void animarReinicioBoton(MouseEvent event) {
         ImageView boton = (ImageView) event.getSource();
         
    ScaleTransition expandirAnimacion = new ScaleTransition(Duration.seconds(0.1), boton);
    expandirAnimacion.setFromX(1.1);
    expandirAnimacion.setToX(1.0);
    expandirAnimacion.setFromY(1.1);
    expandirAnimacion.setToY(1.0);
      expandirAnimacion.play();
    }
   
        @FXML
void animarPulsarBoton(MouseEvent event) {
    ImageView boton = (ImageView) event.getSource();
    String idDelBoton = boton.getId();

    
    ScaleTransition expandirAnimacion = new ScaleTransition(Duration.seconds(0.3), boton);
    expandirAnimacion.setFromX(1.0);
    expandirAnimacion.setToX(0.9);
    expandirAnimacion.setFromY(1.0);
    expandirAnimacion.setToY(0.9);
    expandirAnimacion.setFromX(0.9);
    expandirAnimacion.setToX(1.0);
    expandirAnimacion.setFromY(0.9);
    expandirAnimacion.setToY(1.0);
    expandirAnimacion.play();
    
   PauseTransition pause = new PauseTransition(Duration.seconds(2));

   
    expandirAnimacion.setOnFinished(eventFinished -> {
        //cambiarAVistaMenuSeleccion();
        


    });

    expandirAnimacion.play();
    pause.play();
    
            if(idDelBoton.equals("Hielo")){
        Image Imagen = new Image("/resources/img/interfaces/PantallaSeleccionMapa/MapaArbolBn.png");
        Arbol.setImage(Imagen);
       Image H = new Image("/resources/img/interfaces/PantallaSeleccionMapa/MapaHielo.png");
       Hielo.setImage(H);
        
       Escenario="Hielo";
        }else if(idDelBoton.equals("Arbol")){
            
       
        Image Imagen = new Image("/resources/img/interfaces/PantallaSeleccionMapa/MapaHieloBn.png");
        Hielo.setImage(Imagen);
        Image A = new Image("/resources/img/interfaces/PantallaSeleccionMapa/MapaArbol.png");
        Arbol.setImage(A);
        
        Escenario="Arbol";
        }else{
             cambiarAVistaJuego(boton);
        }
            Image P = new Image("/resources/img/interfaces/PantallaSeleccion/PLAY.png");
            play.setImage(P);
        }

       @FXML
void cambiarAVistaJuego(ImageView idDelBoton) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("juego.fxml"));
        Parent root = loader.load();
        
        Juego controlador= loader.getController();
        controlador.setEscenario(Escenario);
        controlador.setP1(P1);
        controlador.setP2(P2);
        controlador.setunjugador(unjugador);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), pane3);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);

            fadeIn.setOnFinished(e -> {
                pane3.getChildren().setAll(root);
            });

            fadeIn.play();
            
        pane3.getChildren().setAll(root);
        
    } catch (IOException e) {
        e.printStackTrace(); 
    }
}
           }

  
