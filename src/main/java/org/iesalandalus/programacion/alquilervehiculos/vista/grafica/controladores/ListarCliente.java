package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarCliente extends Controlador {

	@FXML
	private TableView<Cliente> tablaClientes;

	@FXML
	private TableColumn<Cliente, String> dniItem;

	@FXML
	private TableColumn<Cliente, String> nombreItem;

	@FXML
	private TableColumn<Cliente, String> telefonoItem;

	private ObservableList<Cliente> listaClientes;

	@FXML
	private void initialize() {
		nombreItem.setStyle("-fx-text-fill: rgb(1, 0, 1); -fx-font-weight: bold;");
		dniItem.setStyle("-fx-text-fill: rgb(1, 0, 1); -fx-font-weight: bold;");
	    telefonoItem.setStyle("-fx-text-fill: rgb(1, 0, 1); -fx-font-weight: bold;");
		
		nombreItem.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		dniItem.setCellValueFactory(new PropertyValueFactory<>("dni"));
		telefonoItem.setCellValueFactory(new PropertyValueFactory<>("telefono"));

		//Incializamos la lista Clientes y configuramos la TableView
		listaClientes = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getClientes());
		tablaClientes.setItems(listaClientes);
		
		
	}
	
	public void refrescar() {
		tablaClientes.getItems().clear();
		listaClientes = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getClientes());
		tablaClientes.setItems(listaClientes);
	}
	

}

