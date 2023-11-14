package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuInicio {
    private Stage stage;

    private boolean unJugador;
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private AnchorPane pane;

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

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), pane);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeOut.setOnFinished(eventFinished -> {
            if(idDelBoton.equals("btn1j")){
                unJugador=true;
            }
            cambiarAVistaMenuSeleccion();
        });

        // Reproduce la animación de escala y luego la pausa
        expandirAnimacion.play();
        fadeOut.play();
    }

    @FXML
    void cambiarAVistaMenuSeleccion() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaseleccion.fxml"));
            Parent root = loader.load();

            PantallaSeleccion controlador = loader.getController();
            controlador.setStage(stage);
            pane.getChildren().setAll(root);

            controlador.setunjugador(unJugador);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), pane);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);

            fadeIn.setOnFinished(e -> {
                pane.getChildren().setAll(root);
            });

            fadeIn.play();
            
        pane.getChildren().setAll(root);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
void cerrarPrograma(MouseEvent event) {
    System.exit(0);
}
}
