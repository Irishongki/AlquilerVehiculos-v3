package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.time.LocalDate;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DevolverAlquilerCliente extends Controlador {

	@FXML
	private DatePicker dpFechaDevolucion;

	@FXML
	private TextField tfDni;

	@FXML
	void devolverAlquilerCliente(MouseEvent event) {
		try {
			String dni = tfDni.getText();
			LocalDate fechaDevolucion = dpFechaDevolucion.getValue();
			Cliente cliente = VistaGrafica.getInstancia().getControlador().buscar(Cliente.getClienteConDni(dni));
			VistaGrafica.getInstancia().getControlador().devolver(cliente, fechaDevolucion);
			Dialogos.mostrarDialogoInformacion("Datos Modificados",
					"El Alquiler del cliente se ha devuelto correctamente", null);
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
		 getEscenario().close();
	}

	@FXML
	void limpiar(MouseEvent event) {
		tfDni.clear();
		dpFechaDevolucion.setValue(null);
	}
}

