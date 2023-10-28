package com.mycompany.maquinacafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());

       Image icon = new Image(App.class.getResourceAsStream("/img/Logo.png"));

        stage.getIcons().add(icon);

        stage.setScene(scene);

        stage.sizeToScene();
        
        stage.setTitle("Coffee Shop");
        
          stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
