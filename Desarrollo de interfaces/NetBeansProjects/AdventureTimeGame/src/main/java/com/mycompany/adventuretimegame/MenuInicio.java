package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuInicio {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private ImageView btn1j;

    @FXML
    private ImageView btn2j;

    @FXML
    private ImageView btncls;
    
    
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
    String idDelBoton = boton.getId();//Para saber que ventana cambiar
    
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
        cambiarAVistaMenuSeleccion();
    });

    // Reproduce la animación de escala y luego la pausa
    expandirAnimacion.play();
    pause.play();
}

    @FXML
void cambiarAVistaMenuSeleccion() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaseleccion.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);


    } catch (IOException e) {
        e.printStackTrace(); 
    }
}
  
    
}


   
