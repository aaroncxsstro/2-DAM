package com.mycompany.apibebida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;


public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaprincipal.fxml"));
        Parent root = loader.load();

        PantallaPrincipal controller = loader.getController();
        controller.setStage(primaryStage);
        
        Scene scene = new Scene(root);
         
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);

        primaryStage.setTitle("Cocktail");
        primaryStage.getIcons().add(new Image("/resources/Logo.jpg"));        
        primaryStage.setWidth(1000); 
        primaryStage.setHeight(700); 
        primaryStage.centerOnScreen();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
