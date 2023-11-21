package com.mycompany.adventuretimegame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PantallaTabla {

            private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
        @FXML
    private AnchorPane pane6;
        
    @FXML
    private ImageView fondo;

        private boolean unjugador; 

    public void setunjugador(boolean unjugador) {
        this.unjugador = unjugador;
    }
    
    @FXML
    private TableView<JuegoResult> tabla;

     
      
public void setGanadorYMapa(Personaje ganador, String mapa) {
    Image image;
    Image image1;
    Image image2;
    if ("Arbol".equals(mapa)) {
        image = new Image("/resources/img/Escenarios/FondoArbol.png");
        image1 = new Image("/resources/img/Interfaces/Juego/nuevaPArbol.png");
        image2 = new Image("/resources/img/Interfaces/Juego/inicioArbol.png");
    } else {
        image = new Image("/resources/img/Escenarios/FondoHielo.png");
        image1 = new Image("/resources/img/Interfaces/Juego/nuevaPHielo.png");
        image2 = new Image("/resources/img/Interfaces/Juego/inicioHielo.png");
    }

    nuevaPbtn.setImage(image1);
    iniciobtn.setImage(image2);
    fondo.setImage(image);

    tabla.getItems().clear();
    tabla.getColumns().clear();

    TableColumn<JuegoResult, String> columnaEscenario = new TableColumn<>("Escenario");
    TableColumn<JuegoResult, String> columnaGanador = new TableColumn<>("Ganador");
    TableColumn<JuegoResult, String> columnaControlador = new TableColumn<>("Controlador");

    
columnaEscenario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEscenario()));
columnaGanador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGanador()));
columnaControlador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getControlador()));
    
ObservableList<JuegoResult> datosTabla = FXCollections.observableArrayList();
    tabla.getColumns().addAll(columnaEscenario, columnaGanador, columnaControlador);

    MemoriaTabla memoriaTabla = MemoriaTabla.getInstancia();

    memoriaTabla.agregarResultado(new JuegoResult(mapa, ganador.getNombre(), ganador.isJ1() ? "Jugador 1" : "Jugador 2"));

    for (JuegoResult juegoResult : memoriaTabla.getResultadosAnteriores()) {
        String escenario = juegoResult.getEscenario();
        String ganadorr = juegoResult.getGanador();
        String controlador = juegoResult.getControlador();
        
        JuegoResult antiguo = new JuegoResult(escenario, ganadorr, controlador);
        datosTabla.add(antiguo);
      tabla.getItems().add(antiguo);
System.out.println("Añadido a la tabla: " + antiguo.getEscenario() + ", " + antiguo.getGanador() + ", " + antiguo.getControlador());

    }
}


    

    public static class JuegoResult {
        private final SimpleStringProperty escenario;
        private final SimpleStringProperty ganador;
        private final SimpleStringProperty controlador;

        public JuegoResult(String escenario, String ganador, String controlador) {
            this.escenario = new SimpleStringProperty(escenario);
            this.ganador = new SimpleStringProperty(ganador);
            this.controlador = new SimpleStringProperty(controlador);
        }

        public String getEscenario() {
            return escenario.get();
        }

        public String getGanador() {
            return ganador.get();
        }

        public String getControlador() {
            return controlador.get();
        }
    }
    
        @FXML
    private ImageView iniciobtn;

    @FXML
    private ImageView nuevaPbtn;
    
 
    

    @FXML
    void nuevaPartida(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaseleccion.fxml"));
            Parent root = loader.load();

            PantallaSeleccion controlador = loader.getController();
            controlador.setStage(stage);
            pane6.getChildren().setAll(root);

            controlador.setunjugador(unjugador);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), pane6);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);

            fadeIn.setOnFinished(e -> {
                pane6.getChildren().setAll(root);
            });

            fadeIn.play();
            
        pane6.getChildren().setAll(root);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void volverInicio(MouseEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuinicio.fxml"));
            Parent root = loader.load();

            MenuInicio controlador = loader.getController();
            controlador.setStage(stage);
            pane6.getChildren().setAll(root);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), pane6);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);

            fadeIn.setOnFinished(e -> {
                pane6.getChildren().setAll(root);
            });

            fadeIn.play();
            
        pane6.getChildren().setAll(root);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}