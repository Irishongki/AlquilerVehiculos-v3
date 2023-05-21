package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListarAlquilerCliente extends Controlador {

	@FXML
	private TextField tfdni;

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

	private ObservableList<Alquiler> listaAlquileresCliente;
	
	private String dni;


    @FXML
    void listarAlquileresCliente(MouseEvent event) {
    	dni = tfdni.getText();
    	clienteItem.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
		vehiculoItem.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
		fechaAlquilerItem.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
		fechaDevolucionItem.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");

		clienteItem.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		vehiculoItem.setCellValueFactory(new PropertyValueFactory<>("vehiculo"));
		fechaAlquilerItem.setCellValueFactory(new PropertyValueFactory<>("fechaAlquiler"));
		fechaDevolucionItem.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
		

		listaAlquileresCliente = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres(Cliente.getClienteConDni(dni)));
		tvAlquiler.setItems(listaAlquileresCliente);
    }

	   @FXML
	    void limpiar(MouseEvent event) {
		   tfdni.clear();
		   tvAlquiler.getItems().clear();
	    }

	public void refrescar() {
		if (!tvAlquiler.getItems().isEmpty()) {
			tvAlquiler.getItems().clear();
			listaAlquileresCliente = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres(Cliente.getClienteConDni(dni)));
			tvAlquiler.setItems(listaAlquileresCliente);
		}
	}
}
