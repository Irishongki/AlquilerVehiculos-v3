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

public class VentanaAlquileres extends Controlador {

	private static final String TITULO = "Insertar un Alquiler";
	private static final String TITULO2 = "Buscar un Alquiler";
	private static final String TITULO3 = "Devolver el Alquiler de un Cliente";
	private static final String TITULO4 = "Devolver el Alquiler de un Vehiculo";
	private static final String TITULO5 = "Borrar Alquiler";
	private static final String TITULO6 = "Listar los Alquileres";
	private static final String TITULO7 = "Listar los Alquileres de un Cliente";
	private static final String TITULO8 = "Listar los Alquileres de un Vehículo";

	private static final String INSERTAR = "Insertar";
	private static final String BUSCAR = "Buscar";
	private static final String DEVOLVER_ALQUILER_CLIENTE = "Devolver el Alquiler de un Cliente";
	private static final String DEVOLVER_ALQUILER_VEHICULO = "Devolver el Alquiler de un Vehículo";
	private static final String BORRAR = "Borrar";
	private static final String LISTAR = "Listar";
	private static final String LISTAR_ALQUILER_CLIENTE = "Listar los Alquileres de un Cliente";
	private static final String LISTAR_ALQUILER_VEHICULO = "Listar los Alquileres de un Vehículo";

	ObservableList<String> cbListaAlquileres = FXCollections.observableArrayList(INSERTAR, BUSCAR,
			DEVOLVER_ALQUILER_CLIENTE, DEVOLVER_ALQUILER_VEHICULO, BORRAR, LISTAR, LISTAR_ALQUILER_CLIENTE,
			LISTAR_ALQUILER_VEHICULO);

	@FXML
	private Button btOpcion;

	@FXML
	private ChoiceBox<String> cbAlquileres;

	@FXML
	private void initialize() {
		cbAlquileres.setValue(INSERTAR);
		cbAlquileres.setItems(cbListaAlquileres);
	}

	@FXML
	private void escogerOpcion(MouseEvent event) {
		String opcion = cbAlquileres.getSelectionModel().getSelectedItem();
		switch (opcion) {

		case INSERTAR:
			Controlador ventanaInsertar = Controladores.get("vistas/InsertarAlquiler.fxml", TITULO, null);
			ventanaInsertar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaInsertar.getEscenario(), e));
			Image iconoInsertar = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoInsertarAlquiler.png"));
			ventanaInsertar.getEscenario().getIcons().add(iconoInsertar);
			ventanaInsertar.getEscenario().showAndWait();
			break;

		case BUSCAR:
			Controlador ventanaBuscar = Controladores.get("vistas/BuscarAlquiler.fxml", TITULO2, null);
			ventanaBuscar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaBuscar.getEscenario(), e));
			Image iconoBuscar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoBuscar.png"));
			ventanaBuscar.getEscenario().getIcons().add(iconoBuscar);
			ventanaBuscar.getEscenario().showAndWait();
			break;

		case DEVOLVER_ALQUILER_CLIENTE:
			Controlador ventanaDevolverAlquilerCliente = Controladores.get("vistas/DevolverAlquilerCliente.fxml",
					TITULO3, null);
			ventanaDevolverAlquilerCliente.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaDevolverAlquilerCliente.getEscenario(), e));
			Image iconoDevolverAlquilerCliente = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoDevolverAlquiler.png"));
			ventanaDevolverAlquilerCliente.getEscenario().getIcons().add(iconoDevolverAlquilerCliente);
			ventanaDevolverAlquilerCliente.getEscenario().showAndWait();
			break;

		case DEVOLVER_ALQUILER_VEHICULO:
			Controlador ventanaDevolverAlquilerVehiculo = Controladores.get("vistas/DevolverAlquilerVehiculo.fxml",
					TITULO4, null);
			ventanaDevolverAlquilerVehiculo.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaDevolverAlquilerVehiculo.getEscenario(), e));
			Image iconoDevolverAlquilerVehiculo = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoDevolverAlquiler.png"));
			ventanaDevolverAlquilerVehiculo.getEscenario().getIcons().add(iconoDevolverAlquilerVehiculo);
			ventanaDevolverAlquilerVehiculo.getEscenario().showAndWait();
			break;

		case BORRAR:
			Controlador ventanaBorrar = Controladores.get("vistas/BorrarAlquiler.fxml", TITULO5, null);
			ventanaBorrar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaBorrar.getEscenario(), e));
			Image iconoBorrar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoBorrar.png"));
			ventanaBorrar.getEscenario().getIcons().add(iconoBorrar);
			ventanaBorrar.getEscenario().showAndWait();
			break;

		case LISTAR:
			Controlador ventanaListar = Controladores.get("vistas/ListarAlquiler.fxml", TITULO6, null);
			ventanaListar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaListar.getEscenario(), e));
			Image iconoListar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListar.getEscenario().getIcons().add(iconoListar);
			ventanaListar.getEscenario().showAndWait();
			break;

		case LISTAR_ALQUILER_CLIENTE:
			Controlador ventanaListarAlquilerCliente = Controladores.get("vistas/ListarAlquilerCliente.fxml", TITULO7,
					null);
			ventanaListarAlquilerCliente.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaListarAlquilerCliente.getEscenario(), e));
			Image iconoListarAlquilerCliente = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListarAlquilerCliente.getEscenario().getIcons().add(iconoListarAlquilerCliente);
			ventanaListarAlquilerCliente.getEscenario().showAndWait();
			break;

		case LISTAR_ALQUILER_VEHICULO:
			Controlador ventanaListarAlquilerVehiculo = Controladores.get("vistas/ListarAlquilerVehiculo.fxml", TITULO8,
					null);
			ventanaListarAlquilerVehiculo.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaListarAlquilerVehiculo.getEscenario(), e));
			Image iconoListarAlquilerVehiculo = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListarAlquilerVehiculo.getEscenario().getIcons().add(iconoListarAlquilerVehiculo);
			ventanaListarAlquilerVehiculo.getEscenario().showAndWait();
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
