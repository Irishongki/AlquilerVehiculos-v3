package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.time.LocalDate;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controles;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BuscarAlquiler extends Controlador{

	  @FXML
	    private DatePicker dpFechaAlquiler;

	    @FXML
	    private ListView<String> lvAlquiler;

	    @FXML
	    private TextField tfDni;

	    @FXML
	    private TextField tfMatricula;

	    @FXML
	    void buscarAlquiler(MouseEvent event) {
	    	try {
	    	String dni = tfDni.getText();
	    	String matricula = tfMatricula.getText();
			LocalDate fechaAlquiler = dpFechaAlquiler.getValue();
			
			System.out.println("DNI: [" + dni + "]");
			System.out.println("Matricula: [" + matricula + "]");
			System.out.println("Fecha de Alquiler: [" + fechaAlquiler + "]");

			if (dni.isEmpty() || matricula.isEmpty()) {
				Dialogos.mostrarDialogoAdvertencia("Faltan datos...", "Debe introducir el dni y la matricula", null);
			} else {
				Alquiler alquiler = VistaGrafica.getInstancia().getControlador().buscar(new Alquiler(Cliente.getClienteConDni(dni), Vehiculo.getVehiculoConMatricula(matricula), fechaAlquiler));
				ObservableList<String> listaAlquiler = FXCollections.observableArrayList(alquiler.toString());
				lvAlquiler.setItems(listaAlquiler);
			}
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
	 }
	    
		@FXML
		void limpiar(MouseEvent event) {
			Controles.limpiarCamposTexto(tfMatricula, tfDni);
			dpFechaAlquiler.setValue(null);
			lvAlquiler.getItems().clear();
		}
	
}
