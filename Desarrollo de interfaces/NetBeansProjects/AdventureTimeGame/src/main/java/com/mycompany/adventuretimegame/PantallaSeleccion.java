package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PantallaSeleccion {

        private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
        @FXML
    private AnchorPane pane2;
        
    @FXML
    private ImageView finnCasilla;

    @FXML
    private ImageView jakeCasilla;

    @FXML
    private ImageView gunterCasilla;

    @FXML
    private ImageView LlamaCasilla;

    @FXML
    private ImageView marcelineCasilla;

    @FXML
    private ImageView reyHieloCasilla;

    @FXML
    private ImageView limoncioCasilla;

    @FXML
    private ImageView cakeCasilla;

    @FXML
    private ImageView mentaCasilla;
    
     @FXML
    private ImageView espacioMuñecoIzq;

    @FXML
    private ImageView espacioMuñecoDer;
    
    @FXML
    private ImageView botonJugador;
    
    @FXML
    private ImageView rejilla;
    
    @FXML
    private ImageView botonPlay;
    
    @FXML
    private ImageView botonExit;
    
    private ImageView botonSeleccionado = null;
    
    private boolean jugador1= true;
    
@FXML
void cambiarJugador(MouseEvent event) {
    Image rejillaAzul = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/rejillaAzul.png");
    Image rejillaRoja = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/rejillaRoja.png");
    Image botonAzul = new Image("/resources/img/interfaces/PantallaSeleccion/BotonJugador1.png");
    Image botonRojo = new Image("/resources/img/interfaces/PantallaSeleccion/BotonJugador2.png");

    
    String nombreSin = botonSeleccionado.getId().substring(0, botonSeleccionado.getId().length() - 7) + "Sin.png";
    Image imagenSin = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/" + nombreSin);

    botonSeleccionado.setImage(imagenSin);

    if (jugador1) {
        botonJugador.setImage(botonRojo);
        rejilla.setImage(rejillaRoja);
        jugador1 = false;

    } else {
        botonJugador.setImage(botonAzul);
        rejilla.setImage(rejillaAzul);
        jugador1 = true;
    }
}
     
    @FXML
    void animarBoton(MouseEvent event) {
        
        ImageView boton = (ImageView) event.getSource();
        String idDelBoton = boton.getId();
        
        
        if (botonSeleccionado != null) {
            // Cambia la imagen y restaura la escala del botón previamente seleccionado
            String nombreSin = botonSeleccionado.getId().substring(0, botonSeleccionado.getId().length() - 7) + "Sin.png";
         
            Image imagenSin = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/" + nombreSin);

            botonSeleccionado.setImage(imagenSin);
            botonSeleccionado.setScaleX(1.0);
            botonSeleccionado.setScaleY(1.0);
        }

      
        botonSeleccionado = boton;
        

        String nombreCon = boton.getId().substring(0, boton.getId().length() - 7) + "Con.png";
                    if(jugador1){
            String nombreMun = botonSeleccionado.getId().substring(0, botonSeleccionado.getId().length() - 7) + "D.png";
            Image imagenMun = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/Munecos/" + nombreMun);
            espacioMuñecoIzq.setImage(imagenMun);  
            }else{
            String nombreMun = botonSeleccionado.getId().substring(0, botonSeleccionado.getId().length() - 7) + "I.png";
            Image imagenMun = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/Munecos/" + nombreMun);
            espacioMuñecoDer.setImage(imagenMun);
            }
            
        
        Image nuevaImagen = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/" + nombreCon);
        boton.setImage(nuevaImagen);
        
      if (espacioMuñecoDer.getImage() != null && espacioMuñecoIzq.getImage() != null) {
            Image imagen=new Image ("/resources/img/interfaces/PantallaSeleccion/PLAY.png");
            botonPlay.setImage(imagen);
        }

    }
    
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
        cambiarAVistaMenuSeleccion();
    });

    expandirAnimacion.play();
    pause.play();
}
    
    @FXML
void cambiarAVistaMenuSeleccion() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mapa.fxml"));
        Parent root = loader.load();
        
        PantallaSeleccion controlador= loader.getController();
        pane2.getChildren().setAll(root);
        
    } catch (IOException e) {
        e.printStackTrace(); 
    }
}
    
}