package com.mycompany.adventuretimegame;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PantallaTabla {

    @FXML
    private ImageView fondo;

    @FXML
    private TableView<JuegoResult> tabla;

    public void setGanadorYMapa(Personaje ganador, String mapa) {
        Image image;
        if ("Arbol".equals(mapa)) {
            image = new Image("/resources/img/Escenarios/FondoArbol.png");
        } else {
            image = new Image("/resources/img/Escenarios/FondoHielo.png");
        }

        fondo.setImage(image);

        // Limpiar la tabla antes de agregar nuevos datos
        tabla.getItems().clear();
        tabla.getColumns().clear();

        // Crear columnas para la tabla
        TableColumn<JuegoResult, String> columnaEscenario = new TableColumn<>("Escenario");
        TableColumn<JuegoResult, String> columnaGanador = new TableColumn<>("Ganador");
        TableColumn<JuegoResult, String> columnaControlador = new TableColumn<>("Controlador");

        // Configurar cómo se obtienen los valores de las celdas
        columnaEscenario.setCellValueFactory(cellData -> new SimpleStringProperty(mapa));
        columnaGanador.setCellValueFactory(cellData -> new SimpleStringProperty(ganador.getNombre()));
        columnaControlador.setCellValueFactory(cellData -> new SimpleStringProperty(ganador.isJ1() ? "Jugador 1" : "Jugador 2"));

        // Agregar las columnas a la tabla
        tabla.getColumns().addAll(columnaEscenario, columnaGanador, columnaControlador);

        // Agregar los datos a la tabla (un nuevo objeto JuegoResult)
        tabla.getItems().add(new JuegoResult(mapa, ganador.getNombre(), ganador.isJ1() ? "Jugador 1" : "Jugador 2"));
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
}