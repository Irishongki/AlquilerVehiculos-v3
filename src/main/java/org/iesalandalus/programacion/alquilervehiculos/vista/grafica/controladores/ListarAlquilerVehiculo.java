package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
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

public class ListarAlquilerVehiculo extends Controlador{

	@FXML
	private TextField tfmatricula;

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

	private ObservableList<Alquiler> listaAlquileresVehiculo;
	
	private String matricula;


    @FXML
    void listarAlquileresVehiculo(MouseEvent event) {
    	matricula = tfmatricula.getText();
    	clienteItem.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
		vehiculoItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");
		fechaAlquilerItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");
		fechaDevolucionItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");

		clienteItem.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		vehiculoItem.setCellValueFactory(new PropertyValueFactory<>("vehiculo"));
		fechaAlquilerItem.setCellValueFactory(new PropertyValueFactory<>("fechaAlquiler"));
		fechaDevolucionItem.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
		

		listaAlquileresVehiculo = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres(Vehiculo.getVehiculoConMatricula(matricula)));
		tvAlquiler.setItems(listaAlquileresVehiculo);
    }

	   @FXML
	    void limpiar(MouseEvent event) {
		   tfmatricula.clear();
		   tvAlquiler.getItems().clear();
	    }

	public void refrescar() {
		if (!tvAlquiler.getItems().isEmpty()) {
			tvAlquiler.getItems().clear();
			listaAlquileresVehiculo = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres(Vehiculo.getVehiculoConMatricula(matricula)));
			tvAlquiler.setItems(listaAlquileresVehiculo);
		}
	}
}
