package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

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

public class BorrarAlquiler extends Controlador{
	 @FXML
	    private DatePicker dpFechaAlquiler;

	    @FXML
	    private TextField tfDni;

	    @FXML
	    private TextField tfMatricula;

	    @FXML
	    void borrarAlquiler(MouseEvent event) {
	    	try {
				VistaGrafica.getInstancia().getControlador().borrar(new Alquiler(Cliente.getClienteConDni(tfDni.getText()), Vehiculo.getVehiculoConMatricula(tfMatricula.getText()), dpFechaAlquiler.getValue()));
				Dialogos.mostrarDialogoInformacion("Datos Borrados", "Los datos se han borrado correctamente.", null);
			} catch (Exception e) {
				Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
			}
	    }

	    @FXML
	    void limpiar(MouseEvent event) {
	    	Controles.limpiarCamposTexto(tfDni, tfMatricula);
	    	dpFechaAlquiler.setValue(null);
	    }
}
