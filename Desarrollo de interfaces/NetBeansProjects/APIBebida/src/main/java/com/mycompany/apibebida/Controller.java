package com.mycompany.apibebida;

import org.openjfx.jokes.Categoria;
import org.openjfx.jokes.Chiste;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView imageView;
    @FXML
    private ListView listViewChistes;
    @FXML
    private ChoiceBox<Categoria> choiceCategoria;
    @FXML
    private Button btAleatorio, btCategoria;

    private ObservableList<Categoria> listaCategorias;
    private ObservableList<Chiste> listaChistes;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaCategorias = FXCollections.observableArrayList();
        listaChistes = FXCollections.observableArrayList();
       String urlImagen = "https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png";
        imageView.setImage(new Image(urlImagen));
        try {
            jsonCategorias();
        } catch (IOException e) {
            e.printStackTrace();
        }
        asociarElementos();
       

    }

    
        
            public void generarChisteCategoria(ActionEvent actionEvent) {
                if (choiceCategoria.getSelectionModel().getSelectedIndex()>-1){
                    String url = "https://api.chucknorris.io/jokes/random?category=" + choiceCategoria.getSelectionModel().getSelectedItem().getNombre();
                    InputStream inputStream = null;
                    try {
                        inputStream = new URL(url).openStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String response = null;
                    try {
                       response  = bufferedReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JSONObject jsonObject = new JSONObject(response);
                    String chiste = (String) jsonObject.get("value");
                    listaChistes.add(new Chiste(chiste));
                } else {
                    System.out.println("No hay categoria seleccionada");
                }
            }
       public void generarChisteAleatorio(ActionEvent actionEvent){
        
            
                String url="https://api.chucknorris.io/jokes/random";
                InputStream inputStream = null;
                try {
                    inputStream = new URL(url).openStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String response = null;
                try {
                    response  = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONObject jsonObject = new JSONObject(response);
                String chiste = (String) jsonObject.get("value");
                listaChistes.add(new Chiste(chiste));
            
        
    }

    private void asociarElementos() {
        choiceCategoria.setItems(listaCategorias);
        listViewChistes.setItems(listaChistes);
    }



    private void jsonCategorias() throws IOException {
        String url = "https://api.chucknorris.io/jokes/categories";
        InputStream inputStream;
        inputStream = new URL(url).openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String response = bufferedReader.readLine();
        JSONArray jsonArray = new JSONArray(response);
        String categoria;
        for (int i = 0; i < jsonArray.length(); i++) {
            categoria = (String) jsonArray.get(i);
            listaCategorias.add(new Categoria(categoria));
        }
    }
    
}
