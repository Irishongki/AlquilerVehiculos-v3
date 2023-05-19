package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
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

public class BuscarVehiculo extends Controlador {

	@FXML
	private ListView<String> lvVehiculo;

	@FXML
	private TextField tfMatricula;

	@FXML
	void buscarVehiculo(MouseEvent event) {
		try {
			String matricula = tfMatricula.getText();
			System.out.println("Matricula: [" + matricula + "]");

			if (matricula.isEmpty()) {
				Dialogos.mostrarDialogoAdvertencia("Faltan datos...", "Debe introducir la Matricula", null);
			} else {
				Vehiculo vehiculo = VistaGrafica.getInstancia().getControlador()
						.buscar(Vehiculo.getVehiculoConMatricula(matricula));
				ObservableList<String> listaVehiculo = FXCollections.observableArrayList(vehiculo.toString());
				lvVehiculo.setItems(listaVehiculo);
			}
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
	}

	@FXML
	void limpiar(ActionEvent event) {
		tfMatricula.clear();
		lvVehiculo.setItems(null);
	}

}
