package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.time.LocalDate;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controles;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InsertarAlquiler extends Controlador{
	
	@FXML
	private TextField tfDni;

	@FXML
	private DatePicker dpFechaAlquiler;

    @FXML
    private TextField tfMatricula;
    
    @FXML
	private void initialize() {
		tfDni.textProperty().addListener((observable, oldValue, newValue) -> controlaTamanoTextoDni(newValue));
		tfMatricula.textProperty().addListener((observable, oldValue, newValue) -> controlaTamanoTextoMatricula(newValue));
		dpFechaAlquiler.setStyle("-fx-background-color:rgba(212, 73, 73, 0.522);");
    }
    
    @FXML
    void añadirAlquiler(MouseEvent event) {
    try {
    	String dni = tfDni.getText();
		String matricula = tfMatricula.getText();
		LocalDate fechaAlquiler = dpFechaAlquiler.getValue();


		System.out.println("DNI: [" + dni + "]");
		System.out.println("Matricula: [" + matricula + "]");
		System.out.println("Fecha de Alquiler: [" + fechaAlquiler + "]");

		if (dni.isEmpty() || matricula.isEmpty()) {
			Dialogos.mostrarDialogoAdvertencia("Faltan datos...",
					"Debe introducir el dni y la matricula.", null);
		} else {
			VistaGrafica.getInstancia().getControlador().insertar(new Alquiler(Cliente.getClienteConDni(dni), Vehiculo.getVehiculoConMatricula(matricula), fechaAlquiler));
			Dialogos.mostrarDialogoInformacion("Datos Introducidos ",
					"Los datos del nuevo Alquiler se han introducido correctamente", null);
		}
	} catch (Exception e) {
		Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
	}
}
    

    @FXML
    void limpiar(MouseEvent event) {
    	Controles.limpiarCamposTexto(tfMatricula, tfDni);
    	dpFechaAlquiler.setValue(null);
    }
    
    private void controlaTamanoTextoDni(String textoNuevo) {
		if ((textoNuevo.matches("(\\d{8})([A-Za-z])"))) {
			tfDni.setStyle("-fx-border-color: green; -fx-border-radius: 3; -fx-border-width: 2;");
		} else {
			tfDni.setStyle("-fx-border-color: red; -fx-border-radius: 3; -fx-border-width: 2;");
		}
	}
    
    private void controlaTamanoTextoMatricula(String textoNuevo) {
		if ((textoNuevo.matches("\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}"))) {
			tfMatricula.setStyle("-fx-border-color: green; -fx-border-radius: 3; -fx-border-width: 2;");
		} else {
			tfMatricula.setStyle("-fx-border-color: red; -fx-border-radius: 3; -fx-border-width: 2;");
		}
	}
    
}
