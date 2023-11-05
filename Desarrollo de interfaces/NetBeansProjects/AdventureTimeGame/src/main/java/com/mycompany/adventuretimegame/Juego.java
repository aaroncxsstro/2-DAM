package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Juego {

            private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    private Personaje jugador1;
    
    private Personaje jugador2;
    
    private String Escenario;

    private String p1;

    private String p2;

    private Image sprite1;

    private Image sprite2;
    
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
        sprite1=imagen;
        
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
         Image imagen = new Image ("/resources/img/Personajes/"+p2+"/Quieto/"+p2+"D.gif");
        personaje2.setImage(imagen);
        sprite2=imagen;
    }

    
    @FXML
    private ImageView fondo;
    
     @FXML
    private ImageView personaje1;

    @FXML
    private ImageView personaje2;
    
        @FXML
    private ImageView attack1;

    @FXML
    private ImageView super1;

    @FXML
    private ImageView attack2;

    @FXML
    private ImageView super2;
    
    @FXML
    private ImageView dash;
    
        @FXML
    private ImageView botonStart;
        
        
    @FXML
    private ImageView personaje1dash;

    @FXML
    public void comenzar(){
        
        botonStart.setVisible(false);
        attack1.setVisible(true);
        attack2.setVisible(true);
        super1.setVisible(true);
        super2.setVisible(true);
        personaje1.setVisible(true);
        personaje2.setVisible(true);
         jugador1 = new Personaje(p1, true, sprite1);
         jugador2 = new Personaje(p2, false, sprite2);
        jugador1.atributos();
        jugador2.atributos();
        
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

           switch (idDelBoton){
            case "attack1":
            animarAtaqueJ1();
            
            break;
            case "super1":
            animarSuperJ1();
            break;
            case "attack2":
            animarAtaqueJ2();
            break;
            case "super2":
            animarSuperJ2();
            break;
        }
           
    expandirAnimacion.setOnFinished(eventFinished -> {


    });

    // Reproduce la animación de escala y luego la pausa
    expandirAnimacion.play();
}
    
    public void animarAtaqueJ1(){
        
        Image image = new Image("/resources/img/Personajes/"+p1+"/Ataque/"+p1+".gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p1+"/Ataque/dash.gif");
        dash.setImage(dashgif);
        personaje1.setImage(image);

        personaje1.setFitWidth(656);
        personaje1.setFitHeight(407);
        personaje1.setLayoutX(-110);
        personaje1.setLayoutY(140);
        double duracion=jugador1.getTiempoAtaque();
        
       Image image2 = new Image("/resources/img/Personajes/"+p1+"/Quieto/"+p1+".gif");
       
    Duration gifDuration = Duration.seconds(duracion); // Ajusta la duración según tu animación
    Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            // Cambiar la imagen a image2 después de que termine la animación del GIF
            personaje1.setImage(image2);
        }
    }));

    // Iniciar el Timeline
    timeline.play();
}
    
        public void animarAtaqueJ2(){
        
        
        Image image = new Image("/resources/img/Personajes/"+p2+"/Ataque/"+p2+"D.gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p2+"/Ataque/dashD.gif");
        dash.setImage(dashgif);
        personaje2.setImage(image);
        personaje2.setFitWidth(656);
        personaje2.setFitHeight(407);
        personaje2.setLayoutX(500);
        personaje2.setLayoutY(140);
        double duracion=jugador2.getTiempoAtaque();
                
       Image image2 = new Image("/resources/img/Personajes/"+p2+"/Quieto/"+p2+"D.gif");
        // Crear un Timeline con una duración que coincide con la duración de la animación del GIF
    Duration gifDuration = Duration.seconds(duracion); // Ajusta la duración según tu animación
    Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            // Cambiar la imagen a image2 después de que termine la animación del GIF
            personaje2.setImage(image2);
        }
    }));

    // Iniciar el Timeline
    timeline.play();
}

    private void animarSuperJ1() {
  
        Image image = new Image("/resources/img/Personajes/"+p1+"/Super/"+p1+".gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p1+"/Super/dash.gif");
        dash.setImage(dashgif);
        personaje1.setImage(image);
        personaje1.setFitWidth(656);
        personaje1.setFitHeight(407);
        personaje1.setLayoutX(-110);
        personaje1.setLayoutY(140);
        double duracion=jugador1.getTiempoSuper();
        
       Image image2 = new Image("/resources/img/Personajes/"+p1+"/Quieto/"+p1+".gif");
        // Crear un Timeline con una duración que coincide con la duración de la animación del GIF
    Duration gifDuration = Duration.seconds(duracion); // Ajusta la duración según tu animación
    Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            // Cambiar la imagen a image2 después de que termine la animación del GIF
            personaje1.setImage(image2);
        }
    }));

    // Iniciar el Timeline
    timeline.play();
}

    private void animarSuperJ2() {
  
        Image image = new Image("/resources/img/Personajes/"+p2+"/Super/"+p2+"D.gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p2+"/Super/dashD.gif");
        dash.setImage(dashgif);
        personaje2.setImage(image);
        personaje2.setFitWidth(656);
        personaje2.setFitHeight(407);
        personaje2.setLayoutX(500);
        personaje2.setLayoutY(140);
        double duracion=jugador2.getTiempoSuper();
       Image image2 = new Image("/resources/img/Personajes/"+p2+"/Quieto/"+p2+"D.gif");
        // Crear un Timeline con una duración que coincide con la duración de la animación del GIF
    Duration gifDuration = Duration.seconds(duracion); // Ajusta la duración según tu animación
    Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            // Cambiar la imagen a image2 después de que termine la animación del GIF
            personaje2.setImage(image2);
        }
    }));

    // Iniciar el Timeline
    timeline.play();
}

    
}

