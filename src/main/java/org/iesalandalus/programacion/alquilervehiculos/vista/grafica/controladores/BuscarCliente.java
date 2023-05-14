package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BuscarCliente extends Controlador {

	@FXML
	private TextField tfDni;

	@FXML
	private ListView<String> lvCliente;

	@FXML
	void buscarCliente(MouseEvent event) {
		try {
			String dni = tfDni.getText();
			System.out.println("DNI: [" + dni + "]");

			if (dni.isEmpty()) {
				Dialogos.mostrarDialogoAdvertencia("Faltan datos...", "Debe introducir el dni", null);
			} else {
				Cliente cliente = VistaGrafica.getInstancia().getControlador().buscar(Cliente.getClienteConDni(dni));
				ObservableList<String> listaCliente = FXCollections.observableArrayList(cliente.toString());
				lvCliente.setItems(listaCliente);
			}
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
	}

	@FXML
	void limpiar(ActionEvent event) {
		tfDni.clear();
		lvCliente.setItems(null);
	}

}
