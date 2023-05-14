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
	private static final String TITULO2 = "Opciones para los Clientes";
	private static final String TITULO3 = "Opciones para los Vehículos";
	private static final String TITULO4 = "Opciones para los Alquileres";

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
	void crearCliente(ActionEvent event) {
		Controlador ventanaInsertar = Controladores.get("vistas/InsertarCliente.fxml", "Insertar un Cliente", null);
		ventanaInsertar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaInsertar.getEscenario(), e));
		Image iconoInsertar = new Image(
				LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoInsertarCliente.png"));
		ventanaInsertar.getEscenario().getIcons().add(iconoInsertar);
		ventanaInsertar.getEscenario().showAndWait();
	}

	@FXML
	void abrirAlquileres(MouseEvent event) {
		System.out.println("Ventana de los Alquileres");
		Controlador ventanaAlquileres = Controladores.get("vistas/VentanaAlquileres.fxml", TITULO4, null);
		ventanaAlquileres.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaAlquileres.getEscenario(), e));
		Image iconoAlquileres = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/alquiler.png"));
		ventanaAlquileres.getEscenario().getIcons().add(iconoAlquileres);
		ventanaAlquileres.getEscenario().showAndWait();
	}

	@FXML
	void abrirClientes(MouseEvent event) {
		System.out.println("Ventana de los Clientes");
		Controlador ventanaClientes = Controladores.get("vistas/VentanaClientes.fxml", TITULO2, null);
		ventanaClientes.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaClientes.getEscenario(), e));
		Image iconoClientes = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/clientes.png"));
		ventanaClientes.getEscenario().getIcons().add(iconoClientes);
		ventanaClientes.getEscenario().showAndWait();
	}

	@FXML
	void abrirVehiculos(MouseEvent event) {
		System.out.println("Ventana de los Vehículos");
		Controlador ventanaVehiculos = Controladores.get("vistas/VentanaVehiculos.fxml", TITULO3, null);
		ventanaVehiculos.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaVehiculos.getEscenario(), e));
		Image iconoVehiculos = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/vehiculos.png"));
		ventanaVehiculos.getEscenario().getIcons().add(iconoVehiculos);
		ventanaVehiculos.getEscenario().showAndWait();
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
