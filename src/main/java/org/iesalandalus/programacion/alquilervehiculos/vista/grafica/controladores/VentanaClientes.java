package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.recursos.LocalizadorRecursos;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VentanaClientes extends Controlador {
	private static final String TITULO = "Insertar un Cliente";
	private static final String TITULO2 = "Buscar un Cliente";
	private static final String TITULO3 = "Modificar un Cliente";
	private static final String TITULO4 = "Borrar un Cliente";
	private static final String TITULO5 = "Listar los Clientes";
	private static final String TITULO6 = "Devolver el Alquiler de un Cliente";

	private static final String INSERTAR = "Insertar";
	private static final String BUSCAR = "Buscar";
	private static final String MODIFICAR = "Modificar";
	private static final String BORRAR = "Borrar";
	private static final String LISTAR = "Listar";
	private static final String DEVOLVER_ALQUILER_CLIENTE = "Devolver el Alquiler de un Cliente";

	ObservableList<String> cbListaClientes = FXCollections.observableArrayList(INSERTAR, BUSCAR, MODIFICAR, BORRAR,
			LISTAR, DEVOLVER_ALQUILER_CLIENTE);

	@FXML
	private Button btOpcion;

	@FXML
	private ChoiceBox<String> cbClientes;

	@FXML
	private void initialize() {
		cbClientes.setValue(INSERTAR);
		cbClientes.setItems(cbListaClientes);
	}

	@FXML
	private void escogerOpcion(MouseEvent event) {
		String opcion = cbClientes.getSelectionModel().getSelectedItem();
		switch (opcion) {

		case INSERTAR:
			Controlador ventanaInsertar = Controladores.get("vistas/InsertarCliente.fxml", TITULO, null);
			ventanaInsertar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaInsertar.getEscenario(), e));
			Image iconoInsertar = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoInsertarCliente.png"));
			ventanaInsertar.getEscenario().getIcons().add(iconoInsertar);
			ventanaInsertar.getEscenario().showAndWait();
			break;

		case BUSCAR:
			Controlador ventanaBuscar = Controladores.get("vistas/BuscarCliente.fxml", TITULO2, null);
			ventanaBuscar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaBuscar.getEscenario(), e));
			Image iconoBuscar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoBuscar.png"));
			ventanaBuscar.getEscenario().getIcons().add(iconoBuscar);
			ventanaBuscar.getEscenario().showAndWait();
			break;

		case MODIFICAR:
			Controlador ventanaModificar = Controladores.get("vistas/ModificarCliente.fxml", TITULO3, null);
			ventanaModificar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaModificar.getEscenario(), e));
			Image iconoModificar = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoModificar.png"));
			ventanaModificar.getEscenario().getIcons().add(iconoModificar);
			ventanaModificar.getEscenario().showAndWait();
			break;

		case BORRAR:
			Controlador ventanaBorrar = Controladores.get("vistas/BorrarCliente.fxml", TITULO4, null);
			ventanaBorrar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaBorrar.getEscenario(), e));
			Image iconoBorrar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoBorrar.png"));
			ventanaBorrar.getEscenario().getIcons().add(iconoBorrar);
			ventanaBorrar.getEscenario().showAndWait();
			break;

		case LISTAR:
			ListarCliente ventanaListar = (ListarCliente)Controladores.get("vistas/ListarCliente.fxml", TITULO5, null);
			ventanaListar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaListar.getEscenario(), e));
			Image iconoListar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListar.getEscenario().getIcons().add(iconoListar);
			ventanaListar.refrescar();
			ventanaListar.getEscenario().showAndWait(); 
			break;
			
		case DEVOLVER_ALQUILER_CLIENTE:
			Controlador ventanaDevolverAlquilerCliente = Controladores.get("vistas/DevolverAlquilerCliente.fxml",
					TITULO6, null);
			ventanaDevolverAlquilerCliente.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaDevolverAlquilerCliente.getEscenario(), e));
			Image iconoDevolverAlquilerCliente = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoDevolverAlquiler.png"));
			ventanaDevolverAlquilerCliente.getEscenario().getIcons().add(iconoDevolverAlquilerCliente);
			ventanaDevolverAlquilerCliente.getEscenario().showAndWait();
			break;
		}
	}

	private void confirmarSalida(Stage escenario, WindowEvent e) {
		if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Seguro que quieres salir de la aplicación?", escenario)) {
			escenario.close();
		} else {
			e.consume();
		}
	}
}
