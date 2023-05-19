package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controles;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModificarCliente extends Controlador {

	@FXML
	private TextField tfNombre;

	@FXML
	private TextField tfDni;

	@FXML
	private TextField tfTelefono;

	private String dniBuscado;
	
	@FXML
	private void initialize() {
		Controles.deshabilitarCamposTexto(tfNombre,tfTelefono);
	}

	@FXML
	void limpiar(MouseEvent event) {
		Controles.limpiarCamposTexto(tfNombre, tfDni, tfTelefono);
		Controles.deshabilitarCamposTexto(tfNombre,tfTelefono);
		Controles.habilitarCamposTexto(tfDni);
	}

    @FXML
    void introducirDni(MouseEvent event) {
    	try {
    	dniBuscado = tfDni.getText();
    	Controles.habilitarCamposTexto(tfNombre,tfTelefono);
    	Controles.deshabilitarCamposTexto(tfDni);
    	tfDni.setText(dniBuscado);
    	}catch (Exception e) {
    		Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
    }

	@FXML
	void modificar(MouseEvent event) {
		try {
			String nombre = tfNombre.getText();
			String telefono = tfTelefono.getText();
			Cliente cliente = VistaGrafica.getInstancia().getControlador().buscar(Cliente.getClienteConDni(dniBuscado));
			VistaGrafica.getInstancia().getControlador().modificar(cliente, nombre, telefono);
			Dialogos.mostrarDialogoInformacion("Datos Modificados", "Los datos se han modificado correctamente.", null);
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
	}

}
