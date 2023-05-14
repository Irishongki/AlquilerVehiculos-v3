package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controles;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InsertarCliente extends Controlador {

	@FXML
	private TextField tfNombre;

	@FXML
	private TextField tfDni;

	@FXML
	private TextField tfTelefono;

	@FXML
	private Button btEnviar;

	@FXML
	private Button btLimpiar;

	@FXML
	private void initialize() {
		tfNombre.textProperty().addListener((observable, oldValue, newValue) -> controlaTamanoTextoNombre(newValue));
		tfDni.textProperty().addListener((observable, oldValue, newValue) -> controlaTamanoTextoDni(newValue));
		tfTelefono.textProperty().addListener((observable, oldValue, newValue) -> controlaTamanoTextoTelefono(newValue));
	}

	@FXML
	void añadirCliente(MouseEvent event) {
		try {

			String nombre = tfNombre.getText();
			String dni = tfDni.getText();
			String telefono = tfTelefono.getText();

			System.out.println("Nombre: [" + nombre + "]");
			System.out.println("DNI: [" + dni + "]");
			System.out.println("Telefono: [" + telefono + "]");

			if (nombre.isEmpty() || dni.isEmpty() || telefono.isEmpty()) {
				Dialogos.mostrarDialogoAdvertencia("Faltan datos...",
						"Debe introducir el nombre, el dni y el telefono.", null);
			} else {
				VistaGrafica.getInstancia().getControlador().insertar(new Cliente(nombre, dni, telefono));
				Dialogos.mostrarDialogoInformacion("Datos Introducidos ",
						"Los datos del nuevo Cliente se han introducido correctamente", null);
			}
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
	}

	@FXML
	void borrarDatos(MouseEvent event) {
		Controles.limpiarCamposTexto(tfNombre, tfDni, tfTelefono);
	}

	private void controlaTamanoTextoNombre(String textoNuevo) {
		if ((textoNuevo.matches("[A-ZÁÉÍÓÚÜÑ][a-záéíóúÜñ]+([ ][A-ZÁÉÍÓÚÜÑ][a-záéíóúÜñ]+)*"))) {
			tfNombre.setStyle("-fx-border-color: green; -fx-border-radius: 3; -fx-border-width: 2;");
		} else {
			tfNombre.setStyle("-fx-border-color: red; -fx-border-radius: 3; -fx-border-width: 2;");
		}
	}

	private void controlaTamanoTextoDni(String textoNuevo) {
		if ((textoNuevo.matches("(\\d{8})([A-Za-z])"))) {
			tfDni.setStyle("-fx-border-color: green; -fx-border-radius: 3; -fx-border-width: 2;");
		} else {
			tfDni.setStyle("-fx-border-color: red; -fx-border-radius: 3; -fx-border-width: 2;");
		}
	}

	private void controlaTamanoTextoTelefono(String textoNuevo) {
		if ((textoNuevo.matches("[96]\\d{8}"))) {
			tfTelefono.setStyle("-fx-border-color: green; -fx-border-radius: 3; -fx-border-width: 2;");
		} else {
			tfTelefono.setStyle("-fx-border-color: red; -fx-border-radius: 3; -fx-border-width: 2;");
		}
	}
}