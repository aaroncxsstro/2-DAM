package org.openjfx.cocktelery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable {

    @FXML
    private ListView<String> listViewCocktails;
    @FXML
    private ChoiceBox<String> choiceCategoria;
    @FXML
    private Button btAleatorio, btCategoria;

    private ObservableList<String> listaCategorias;
    private ObservableList<String> listaBebidas;
    private ObservableList<String> listaIngredientes;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaCategorias = FXCollections.observableArrayList();
        listaBebidas = FXCollections.observableArrayList();
        listaIngredientes = FXCollections.observableArrayList();

        try {
            jsonCategorias();
        } catch (IOException e) {
            e.printStackTrace();
        }

        asociarElementos();
    }

    public void generarBebidaCategoria(ActionEvent actionEvent) {
        if (choiceCategoria.getSelectionModel().getSelectedIndex() > -1) {
            // Limpiar listas antes de agregar nuevos elementos
            listaBebidas.clear();

            String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c="
                    + choiceCategoria.getSelectionModel().getSelectedItem();
            try {
                JSONObject jsonObject = obtenerJsonObjectDesdeURL(url);

                JSONArray drinks = jsonObject.getJSONArray("drinks");
                for (int i = 0; i < drinks.length(); i++) {
                    String bebida = drinks.getJSONObject(i).getString("strDrink");
                    String imagenURL = drinks.getJSONObject(i).getString("strDrinkThumb") + "/preview";
                    listaBebidas.add(bebida);

                }
            } catch (IOException e) {
                mostrarError("Error al obtener datos", "Hubo un problema al obtener datos desde la API.");
            }
        } else {
            mostrarError("No category selected", "Please, select a category before keep going.");
        }
    }

    public void generarBebidaAleatoria(ActionEvent actionEvent) {
        // Limpiar listas antes de agregar nuevos elementos
        listaBebidas.clear();


        String url = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
        try {
            JSONObject jsonObject = obtenerJsonObjectDesdeURL(url);
            JSONArray drinks = jsonObject.getJSONArray("drinks");
            for (int i = 0; i < drinks.length(); i++) {
                String bebida = drinks.getJSONObject(i).getString("strDrink");
                String imagenURL = drinks.getJSONObject(i).getString("strDrinkThumb") + "/preview";
                Image imagen = new Image (imagenURL);
                imageView.setImage(imagen);
                listaBebidas.add(bebida);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void asociarElementos() {
        choiceCategoria.setItems(listaCategorias);
        listViewCocktails.setItems(listaBebidas);
    }

    private void jsonCategorias() throws IOException {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list";
        JSONObject jsonObject = obtenerJsonObjectDesdeURL(url);
        JSONArray categories = jsonObject.getJSONArray("drinks");
        for (int i = 0; i < categories.length(); i++) {
            String categoria = categories.getJSONObject(i).getString("strCategory");
            listaCategorias.add(categoria);
        }
    }

    private JSONObject obtenerJsonObjectDesdeURL(String url) throws IOException {
        InputStream inputStream = new URL(url).openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder responseBuilder = new StringBuilder();
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            responseBuilder.append(inputLine);
        }
        bufferedReader.close();
        return new JSONObject(responseBuilder.toString());
    }
}
