package com.mycompany.maquinacafe;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class Cafeteria {
   
       @FXML
    private TableView<Cafe> tabla;
       
       @FXML
    private TableColumn<Cafe, String> tipoColumn;

    @FXML
    private TableColumn<Cafe, String> tamañoColumn;

    @FXML
    private TableColumn<Cafe, String> cantidadColumn;

    @FXML
    private TableColumn<Cafe, String> precioColumn;    

    @FXML
    private TextField fieldCantidad;
        
    @FXML
    private Label almacenSaldo;
        
     @FXML
    private RadioButton cortado;

    @FXML
    private RadioButton latte;

    @FXML
    private RadioButton capuccino;

    @FXML
    private Button btnSaldo;

    @FXML
    private TextField fieldSaldo;

    @FXML
    private ComboBox<String> cbx;

    @FXML
private void mostrarAlertaError(String error) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText(error);
    alert.showAndWait();
}

    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList("Pequeño", "Mediano", "Grande");
        cbx.setItems(options);
        
    tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoCafe"));
    tamañoColumn.setCellValueFactory(new PropertyValueFactory<>("tamañoCafe"));
    precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
    cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
}
    
    @FXML
     void añadirSaldo (ActionEvent event) {
        double saldoIntroducido=0;
         String saldoIntroducidoText = fieldSaldo.getText();
         
     try {
        saldoIntroducido = Double.parseDouble(saldoIntroducidoText);
            if(saldoIntroducido<=0){
         mostrarAlertaError("El saldo introducido debe ser mayor que 0");
            }else{
                
    String saldoActualText=almacenSaldo.getText().substring(0,almacenSaldo.getText().length()-1);
    
    double saldoActual = Double.parseDouble(saldoActualText);
    saldoActual = saldoActual + saldoIntroducido;
    
    almacenSaldo.setText(String.valueOf(saldoActual)+"€");
                 fieldSaldo.clear(); 
    
     }
    } catch (NumberFormatException e) {
       mostrarAlertaError("Introduce un caracter válido ");
    } 
 
     }
     
     
     @FXML
    public void pedirCafe (ActionEvent event){
        
        ToggleGroup toggleGroup = new ToggleGroup();
        cortado.setToggleGroup(toggleGroup);
        latte.setToggleGroup(toggleGroup);
        capuccino.setToggleGroup(toggleGroup);
        
       if (toggleGroup.getSelectedToggle() != null) {
           
 ToggleButton selectedToggle = (ToggleButton) toggleGroup.getSelectedToggle();
String tipo = selectedToggle.getText();

if(cbx.getValue()!=null){
    
String tamaño = cbx.getValue();

try{
    
    String cantidadText = fieldCantidad.getText();
    int cantidad = Integer.parseInt(cantidadText);

          if(cantidad<=0){
         mostrarAlertaError("La cantidad introducida debe ser mayor que cero");
            }else{
            
              Cafe c1 = new Cafe (tipo, tamaño, cantidad);
              c1.calcularPrecio();
              String saldoText = almacenSaldo.getText().substring(0,almacenSaldo.getText().length()-1);;

              double saldoNum = Double.parseDouble(saldoText);

              if(saldoNum<c1.getPrecio()){
         mostrarAlertaError("No hay saldo suficiente");
              }else {
              
              tabla.getItems().add(c1);
              
     String saldoActualText=almacenSaldo.getText().substring(0,almacenSaldo.getText().length()-1);
    double saldoActual = Double.parseDouble(saldoActualText);
    saldoActual = saldoActual - c1.getPrecio();

    cbx.getSelectionModel().clearSelection(); 
    cortado.setSelected(false); 
    latte.setSelected(false); 
    capuccino.setSelected(false);
    fieldCantidad.clear(); 
    
    almacenSaldo.setText(String.valueOf(saldoActual)+"€");
              }
              
          }
              
} catch (NumberFormatException e) {
       mostrarAlertaError("Introduce un caracter válido");
} 
            

}else{
mostrarAlertaError("Debes seleccionar el tamaño del café");
}

       } else {
           
mostrarAlertaError("Debes seleccionar el tipo de café");

} 
       
    }
    
    public void eliminarCafeSeleccionado(ActionEvent event) {
    Cafe cafeSeleccionado = tabla.getSelectionModel().getSelectedItem();

    if (cafeSeleccionado != null) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de que deseas eliminar este café?");
        
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            tabla.getItems().remove(cafeSeleccionado);
     double saldoRegresar=cafeSeleccionado.getPrecio();
     String saldoActualText=almacenSaldo.getText().substring(0,almacenSaldo.getText().length()-1);
    double saldoActual = Double.parseDouble(saldoActualText);
    saldoActual = saldoActual + saldoRegresar;
 
    almacenSaldo.setText(String.valueOf(saldoActual)+"€");
        }
    } else {
        mostrarAlertaError("Selecciona un café para eliminar.");
    }
}
    }
