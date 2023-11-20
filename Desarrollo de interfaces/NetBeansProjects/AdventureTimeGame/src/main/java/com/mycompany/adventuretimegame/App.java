package com.mycompany.adventuretimegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("menuinicio.fxml"));
        Parent root = loader.load();

        MenuInicio controller = loader.getController();
        controller.setStage(primaryStage);
        
        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
         
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);

        primaryStage.setTitle("Adventure Time Fight");
        primaryStage.getIcons().add(new Image("/resources/img/interfaces/Logo.png"));        
        primaryStage.setWidth(1024); // Establece el ancho deseado
        primaryStage.setHeight(576); // Establece el alto deseado
        primaryStage.centerOnScreen(); // Centra la ventana en la pantalla

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
