package com.mycompany.adventuretimegame;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class PantallaSeleccion {

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
    
     private ImageView botonSeleccionado = null;
     
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
        
        // Cambia la imagen y ejecuta la animación del botón actual
        String nombreCon = boton.getId().substring(0, boton.getId().length() - 7) + "Con.png";
              String nombreMun = botonSeleccionado.getId().substring(0, botonSeleccionado.getId().length() - 7) + "D.png";
            Image imagenMun = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/Munecos/" + nombreMun);
            espacioMuñecoIzq.setImage(imagenMun);
        
        Image nuevaImagen = new Image("/resources/img/interfaces/PantallaSeleccion/Botones/" + nombreCon);
        boton.setImage(nuevaImagen);
        

        


    }
}