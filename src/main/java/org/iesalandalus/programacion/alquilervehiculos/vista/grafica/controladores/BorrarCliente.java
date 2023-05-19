package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BorrarCliente extends Controlador {

	@FXML
	private TextField tfDni;

	@FXML
	void borrarCliente(MouseEvent event) {
		try {
			VistaGrafica.getInstancia().getControlador().borrar(Cliente.getClienteConDni(tfDni.getText()));
			Dialogos.mostrarDialogoInformacion("Datos Borrados", "Los datos se han borrado correctamente.", null);
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
	}

	@FXML
	void limpiar(ActionEvent event) {
		tfDni.clear();
	}

}

