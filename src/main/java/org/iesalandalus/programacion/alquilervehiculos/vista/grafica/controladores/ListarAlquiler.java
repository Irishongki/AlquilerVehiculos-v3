package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarAlquiler extends Controlador{

    @FXML
    private TableColumn<Alquiler, String> clienteItem;

    @FXML
    private TableColumn<Alquiler, String> fechaAlquilerItem;

    @FXML
    private TableColumn<Alquiler, String> fechaDevolucionItem;

    @FXML
    private TableView<Alquiler> tvAlquiler;

    @FXML
    private TableColumn<Alquiler, String> vehiculoItem;
    
    private ObservableList<Alquiler> listaAlquileres;
    
    @FXML
	private void initialize() {
		clienteItem.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
		vehiculoItem.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
		fechaAlquilerItem.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
		fechaDevolucionItem.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");

		clienteItem.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		vehiculoItem.setCellValueFactory(new PropertyValueFactory<>("vehiculo"));
		fechaAlquilerItem.setCellValueFactory(new PropertyValueFactory<>("fechaAlquiler"));
		fechaDevolucionItem.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
		
		listaAlquileres = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres());
		tvAlquiler.setItems(listaAlquileres);
	}

	public void refrescar() {
		tvAlquiler.getItems().clear();
		listaAlquileres = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres());
		tvAlquiler.setItems(listaAlquileres);
	}
}


