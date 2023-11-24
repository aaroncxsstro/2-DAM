package org.openjfx.jokes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("primary.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getBounds(); // Para pillar las dimensiones de la pantalla
        Scene scene = new Scene(fxmlLoader.load(), (screenBounds.getWidth()), (screenBounds.getHeight()-100));
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}