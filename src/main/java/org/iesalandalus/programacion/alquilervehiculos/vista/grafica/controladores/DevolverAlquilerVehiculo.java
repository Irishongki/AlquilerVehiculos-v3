package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.time.LocalDate;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DevolverAlquilerVehiculo extends Controlador {

	@FXML
	private DatePicker dpFechaDevolucion;

	@FXML
	private TextField tfMatricula;

	@FXML
	void devolverAlquilerVehiculo(MouseEvent event) {
		try {
			String matricula = tfMatricula.getText();
			LocalDate fechaDevolucion = dpFechaDevolucion.getValue();
			Vehiculo vehiculo = VistaGrafica.getInstancia().getControlador()
					.buscar(Vehiculo.getVehiculoConMatricula(matricula));
			VistaGrafica.getInstancia().getControlador().devolver(vehiculo, fechaDevolucion);
			Dialogos.mostrarDialogoInformacion("Datos Modificados",
					"El Alquiler del vehiculo se ha devuelto correctamente", null);
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
	}

	@FXML
	void limpiar(MouseEvent event) {
		tfMatricula.clear();
		dpFechaDevolucion.setValue(null);
	}

}
