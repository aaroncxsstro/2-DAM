package com.mycompany.adventuretimegame;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Juego {

            private Stage stage;
    private List<PantallaTabla.JuegoResult> resultadosAnteriores;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
        public void setResultadosAnteriores(List<PantallaTabla.JuegoResult> resultadosAnteriores) {
        this.resultadosAnteriores = resultadosAnteriores;
    }
        
        @FXML
    private AnchorPane pane4;
        
    private Personaje jugador1;
    
    private Personaje jugador2;
    
    private String Escenario;

    private String p1;

    private String p2;

    private Image sprite1;

    private Image sprite2;
    
    private boolean unjugador; 

    public void setunjugador(boolean unjugador) {
        this.unjugador = unjugador;
    }
   
    @FXML
    private ProgressBar barraSuperj1;
    
    @FXML
    private ProgressBar barraSuperj2;
    
        @FXML
    private ImageView cartel;
        
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
    private ProgressBar barraj1;
    
    
    @FXML
    private ImageView continuar;
    
      @FXML
    private ProgressBar barraj2;
    
    @FXML
    private ImageView logoj1;
    
    @FXML
    private ImageView logoj2;
    
       @FXML
    private ImageView critical;

    private boolean esAtaqueCritico;
    
 boolean esTurnoJugador1;
         
    @FXML
    public void comenzar(){
        
        botonStart.setVisible(false);
        Image image = new Image ("/resources/img/Interfaces/Juego/BotonAtackJ1"+Escenario+".png");
        attack1.setImage(image);
        attack1.setVisible(true);
        Image image2 = new Image ("/resources/img/Interfaces/Juego/BotonAtackJ2"+Escenario+".png");
        attack2.setImage(image2);
        attack2.setVisible(true);
        Image image3 = new Image ("/resources/img/Interfaces/Juego/BotonSuperJ1"+Escenario+".png");
        Image image4 = new Image ("/resources/img/Interfaces/Juego/BotonSuperJ2"+Escenario+".png");
        Image image5 = new Image ("/resources/img/Interfaces/Juego/Continuar"+Escenario+".png");
        continuar.setImage(image5);
        super1.setImage(image3);
        super2.setImage(image4);
        super1.setVisible(false);
        super2.setVisible(false);
        personaje1.setVisible(true);
        personaje2.setVisible(true);
        barraj1.setVisible(true);
        barraj2.setVisible(true);
        barraSuperj1.setVisible(true);
        barraSuperj2.setVisible(true);
         jugador1 = new Personaje(p1, true, sprite1);
         jugador2 = new Personaje(p2, false, sprite2);
        jugador1.atributos();
        jugador2.atributos();
        Image imagen = new Image ("/resources/img/Interfaces/Juego/"+p1+".png");
        Image imagen2 = new Image ("/resources/img/Interfaces/Juego/"+p2+".png");
        logoj1.setImage(imagen);
        logoj2.setImage(imagen2);
        actualizarBarrasDeVida();
        esTurnoJugador1 = new Random().nextBoolean();
        actualizarBotones(esTurnoJugador1);
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

    expandirAnimacion.play();
}
    
    public void animarAtaqueJ1(){
        
        Image image = new Image("/resources/img/Personajes/"+p1+"/Ataque/"+p1+".gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p1+"/Ataque/dash.gif");
        dash.setImage(dashgif);
        personaje1.setImage(image);
        attack1.setVisible(false);
        attack2.setVisible(false);
        super1.setVisible(false);
        super2.setVisible(false);
        personaje1.setFitWidth(656);
        personaje1.setFitHeight(407);
        personaje1.setLayoutX(-110);
        personaje1.setLayoutY(140);
        double duracion=jugador1.getTiempoAtaque();
       Image image2 = new Image("/resources/img/Personajes/"+p1+"/Quieto/"+p1+".gif");
             double duracionBotones=jugador1.getTiempoDashAtaque();
    Duration botonDuration = Duration.seconds(duracionBotones); 
    Timeline timelineBotones = new Timeline(new KeyFrame(botonDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        jugador2.setVidaTotal(jugador2.getVidaTotal()-calcularDanio(jugador1, jugador2,false));
                actualizarBotones(false);
        actualizarBarrasDeVida();

        actualizarBarraSuper(true);

        if(esAtaqueCritico){
            System.out.println("Critico");
        }
        }
    }));
        Duration gifDuration = Duration.seconds(duracion); 
        Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            personaje1.setImage(image2);
        }
    }));
        
    timeline.play();
    timelineBotones.play();
}
    
        public void animarAtaqueJ2(){
        
        
        Image image = new Image("/resources/img/Personajes/"+p2+"/Ataque/"+p2+"D.gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p2+"/Ataque/dashD.gif");
         attack1.setVisible(false);
        attack2.setVisible(false);
        super1.setVisible(false);
        super2.setVisible(false);
        dash.setImage(dashgif);
        personaje2.setImage(image);
        personaje2.setFitWidth(656);
        personaje2.setFitHeight(407);
        personaje2.setLayoutX(500);
        personaje2.setLayoutY(140);
        double duracion=jugador2.getTiempoAtaque();
                
       Image image2 = new Image("/resources/img/Personajes/"+p2+"/Quieto/"+p2+"D.gif");
      double duracionBotones=jugador2.getTiempoDashAtaque();
      
    Duration botonDuration = Duration.seconds(duracionBotones); 
    Timeline timelineBotones = new Timeline(new KeyFrame(botonDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

         jugador1.setVidaTotal(jugador1.getVidaTotal()-calcularDanio(jugador2, jugador1,false));
         actualizarBotones(true);
        actualizarBarrasDeVida();

        actualizarBarraSuper(false);

        if(esAtaqueCritico){
            System.out.println("Critico");
        }
        }
    }));
    
    Duration gifDuration = Duration.seconds(duracion); 
    Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            personaje2.setImage(image2);
        }
    }));


    timeline.play();
    timelineBotones.play();
}

    private void animarSuperJ1() {
  
        Image image = new Image("/resources/img/Personajes/"+p1+"/Super/"+p1+".gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p1+"/Super/dash.gif");
        attack1.setVisible(false);
        attack2.setVisible(false);
        super1.setVisible(false);
        super2.setVisible(false);
        barraSuperj1.setProgress(0);
        dash.setImage(dashgif);
        personaje1.setImage(image);
        personaje1.setFitWidth(656);
        personaje1.setFitHeight(407);
        personaje1.setLayoutX(-110);
        personaje1.setLayoutY(140);
        double duracion=jugador1.getTiempoSuper();
        
       Image image2 = new Image("/resources/img/Personajes/"+p1+"/Quieto/"+p1+".gif");
        double duracionBotones=jugador1.getTiempoDashSuper();
        Duration botonDuration = Duration.seconds(duracionBotones); 
    Timeline timelineBotones = new Timeline(new KeyFrame(botonDuration, new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent event) {
        jugador2.setVidaTotal(jugador2.getVidaTotal()-calcularDanio(jugador1, jugador2,true));
        actualizarBotones(false);
        actualizarBarrasDeVida();

        if(esAtaqueCritico){
            System.out.println("Critico");
        }
        }
    }));
    Duration gifDuration = Duration.seconds(duracion);
    Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            personaje1.setImage(image2);
        }
    }));

    timeline.play();
    timelineBotones.play();
}

    private void animarSuperJ2() {
  
        Image image = new Image("/resources/img/Personajes/"+p2+"/Super/"+p2+"D.gif");
        Image dashgif = new Image("/resources/img/Personajes/"+p2+"/Super/dashD.gif");
        attack1.setVisible(false);
        attack2.setVisible(false);
        super1.setVisible(false);
        super2.setVisible(false);
        barraSuperj2.setProgress(0);
        dash.setImage(dashgif);
        personaje2.setImage(image);
        personaje2.setFitWidth(656);
        personaje2.setFitHeight(407);
        personaje2.setLayoutX(500);
        personaje2.setLayoutY(140);
        double duracion=jugador2.getTiempoSuper();
       Image image2 = new Image("/resources/img/Personajes/"+p2+"/Quieto/"+p2+"D.gif");
       double duracionBotones=jugador2.getTiempoDashSuper();
        Duration botonDuration = Duration.seconds(duracionBotones); 
    Timeline timelineBotones = new Timeline(new KeyFrame(botonDuration, new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent event) {
         jugador1.setVidaTotal(jugador1.getVidaTotal()-calcularDanio(jugador2, jugador1,true));
        actualizarBotones(true);
        actualizarBarrasDeVida();

        if(esAtaqueCritico){
            System.out.println("Critico");
        }
        }
    }));
    
    Duration gifDuration = Duration.seconds(duracion); 
    Timeline timeline = new Timeline(new KeyFrame(gifDuration, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            personaje2.setImage(image2);
        }
    }));

    timeline.play();
    timelineBotones.play();
}
private double calcularDanio(Personaje atacante, Personaje atacado, boolean isSuper) {
    double ataque = atacante.getAtaque() / 13.0;
    double vida = atacado.getVida() / 13.0;
    double relacionAtaqueVida = ataque / vida;
    double suerte = atacante.getSuerte() / 5.0;

    double probabilidadCritico = isSuper ? 0.25 * suerte : 0.5 * suerte;
    esAtaqueCritico = Math.random() < probabilidadCritico;

    if (esAtaqueCritico) {
        double danio = relacionAtaqueVida * (isSuper ? 0.3 : 0.1); 
        double vidaRestante = atacado.getVidaTotal() - danio;


        if (vidaRestante <= 0) {
            atacado.setVidaTotal(0);
        } else {
            atacado.setVidaTotal(vidaRestante);
        }

        Image image = new Image("/resources/img/Interfaces/Juego/critical.gif");
        critical.setImage(image);
        critical.setVisible(true);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), critical);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.9));
        pauseTransition.setOnFinished(event -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.2), critical);
            fadeOut.setToValue(0.0);

            // Agrega un evento adicional al fadeOut para establecer la visibilidad después del fade-out
            fadeOut.setOnFinished(fadeOutEvent -> {
                critical.setVisible(false);
            });

            fadeOut.play();
        });
        pauseTransition.play();

        return danio;

    } else {
        double danio = relacionAtaqueVida * (isSuper ? 0.15 : 0.05); 
        double vidaRestante = atacado.getVidaTotal() - danio;


        if (vidaRestante <= 0) {
            atacado.setVidaTotal(0);
        } else {
            atacado.setVidaTotal(vidaRestante);
        }

        return danio;
    }
}


public void actualizarBarraSuper(boolean turnoj1) {
    if (turnoj1) {
        if (!comprobarSuper1()) {
            barraSuperj1.setProgress(barraSuperj1.getProgress() + 0.33);
        }
    } else {
        if (!comprobarSuper2()) {
            barraSuperj2.setProgress(barraSuperj2.getProgress() + 0.33);
        }
    }
}




    
public boolean comprobarSuper1() {
    return barraSuperj1.getProgress() >= 0.9;
}

public boolean comprobarSuper2() {
    return barraSuperj2.getProgress() >= 0.9;
}

        
    public void actualizarBarrasDeVida() {

    barraj1.setProgress(jugador1.getVidaTotal()); 
    barraj2.setProgress(jugador2.getVidaTotal());

    if (jugador1.getVidaTotal() <= 0) {
        critical.setVisible(false);
        barraj1.setProgress(0);
        Image image = new Image("/resources/img/Personajes/"+p2+"/Victoria/"+"VictoriaD.gif");
        personaje2.setImage(image);
        Image image2 = new Image("/resources/img/Personajes/"+p1+"/Derrota/"+"Derrota.gif");
        personaje1.setImage(image2);
        barraj1.setVisible(false);
        barraj2.setVisible(false);
        attack1.setVisible(false);
        attack2.setVisible(false);
        super1.setVisible(false);
        super2.setVisible(false);
        logoj1.setVisible(false);
        logoj2.setVisible(false);
        barraSuperj1.setVisible(false);
        barraSuperj2.setVisible(false);
        Image image3 = new Image("/resources/img/Interfaces/Juego/cartel2.gif");
        cartel.setImage(image3);
        cartel.setVisible(true);
        continuar.setVisible(true);
    } else {
         barraj1.setStyle(""); 
    }
    if (jugador2.getVidaTotal() <= 0) {
        critical.setVisible(false);
        barraj2.setProgress(0);
         Image image = new Image("/resources/img/Personajes/"+p1+"/Victoria/"+"Victoria.gif");
         Image image2 = new Image("/resources/img/Personajes/"+p2+"/Derrota/"+"DerrotaD.gif");
        personaje2.setImage(image2);
        personaje1.setImage(image);
        barraj1.setVisible(false);
        barraj2.setVisible(false);
        attack1.setVisible(false);
        attack2.setVisible(false);
        super1.setVisible(false);
        super2.setVisible(false);
        logoj1.setVisible(false);
        logoj2.setVisible(false);
        barraSuperj1.setVisible(false);
        barraSuperj2.setVisible(false);
        Image image4 = new Image("/resources/img/Interfaces/Juego/cartel.gif");
        cartel.setImage(image4);
        cartel.setVisible(true);
        continuar.setVisible(true);


    } else {
        barraj2.setStyle(""); 
    }
}
    
    public void actualizarBotones(boolean turnoJugador1) {
    if (turnoJugador1) {
        attack1.setVisible(true);
        attack1.setFocusTraversable(true);
        attack2.setVisible(false);
        attack2.setFocusTraversable(false);
        super1.setVisible(comprobarSuper1());
        super1.setFocusTraversable(comprobarSuper1());
        super2.setVisible(false);
        super2.setFocusTraversable(false);
    } else {
        if(unjugador){
            if(comprobarSuper2()){
                animarSuperJ2();
            }else{
            animarAtaqueJ2();
            }
        }else{
        attack1.setVisible(false);
          attack1.setFocusTraversable(false);
        attack2.setVisible(true);
        attack2.setFocusTraversable(true);
        super1.setVisible(false);
        super1.setFocusTraversable(false);
        super2.setVisible(comprobarSuper2());
        super2.setFocusTraversable(comprobarSuper1());
        }
    }
}
    
    @FXML
void animarPulsarTecla(KeyEvent event) {

        if (attack1.isVisible()) {
            manejarEntradasJugador1(event);
        } else {
            manejarEntradasJugador2(event);
        }
}

private void manejarEntradasJugador1(KeyEvent event) {
    switch (event.getCode()) {
        case A:
            if (attack1.isVisible()) {
                animarAtaqueJ1();
            }
            break;
        case D:
            if (super1.isVisible()) {
                animarSuperJ1();
            }
            break;
    }
}

private void manejarEntradasJugador2(KeyEvent event) {
    switch (event.getCode()) {
        case LEFT:
            if (attack2.isVisible()) {
                animarAtaqueJ2();
            }
            break;
        case RIGHT:
            if (super2.isVisible()) {
                animarSuperJ2();
            }
            break;
    }
}

@FXML 
private void continuar(MouseEvent event){
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
            try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallatabla.fxml"));
        Parent root = loader.load();
        
        PantallaTabla controlador = loader.getController();
        
        controlador.setGanadorYMapa(jugador1.getVidaTotal() <= 0 ? jugador2 : jugador1, Escenario);
        controlador.setunjugador(unjugador);
        // controlador.setResultadosAnteriores(resultadosAnteriores);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), pane4);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeOut.setOnFinished(e -> {
            pane4.getChildren().setAll(root);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), pane4);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });

        fadeOut.play();

    } catch (IOException e) {
        e.printStackTrace();
    }
    });

    expandirAnimacion.play();
    pause.play();
}

}



