package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.recursos.LocalizadorRecursos;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VentanaPrincipal extends Controlador {

	private static final String TITULO = "Información sobre el Autor de la Aplicación";

	@FXML
	private Button btPulsame;

	@FXML
	private void initialize() {
		System.out.println("Método initialize de VentanaPrincipal");
	}
	
    @FXML
    void salir(ActionEvent event) {
    	System.out.println("Has salido correctamente");
    	System.exit(0);
    }

    @FXML
    void abrirAlquileres(MouseEvent event) {
    	System.out.println("Ventana de los Alquileres");
    }

    @FXML
    void abrirClientes(MouseEvent event) {
    	System.out.println("Ventana de los Clientes");
    }

    @FXML
    void abrirVehiculos(MouseEvent event) {
    	System.out.println("Ventana de los Vehiculos");
    }

	@FXML
	void verAutor(ActionEvent event) {
		System.out.println("Ventana de información del Autor");
		Controlador ventanaAutor = Controladores.get("vistas/Autoria.fxml", TITULO, null);
		ventanaAutor.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaAutor.getEscenario(), e));
		Image iconoAutor = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/autor.png"));
		ventanaAutor.getEscenario().getIcons().add(iconoAutor);
		ventanaAutor.getEscenario().showAndWait();
	}

	private void confirmarSalida(Stage escenario, WindowEvent e) {
		if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Seguro que quieres salir de la aplicación?", escenario)) {
			escenario.close();
		} else {
			e.consume();
		}
	}

}
