package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Crea el elemento raíz de la interfaz de usuario desde el archivo FXML generado por Scene Builder.
        // Por ejemplo, si tienes un archivo FXML llamado "sample.fxml":
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();

        // Establece la raíz del diseño como escena
        Scene scene = new Scene(root);

        // Establece la escena en la ventana principal
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);

        // Establece el título de la ventana
        primaryStage.setTitle("Adventure Time Fight");
        primaryStage.getIcons().add(new Image("/resources/img/Logo.png"));        
        primaryStage.setWidth(1024); // Establece el ancho deseado
        primaryStage.setHeight(576); // Establece el alto deseado
        primaryStage.centerOnScreen(); // Centra la ventana en la pantalla

        // Muestra la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}






