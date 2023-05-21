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
	private static final String TITULO3 = "Borrar Alquiler";
	private static final String TITULO4 = "Listar los Alquileres";
	private static final String TITULO5 = "Listar los Alquileres de un Cliente";
	private static final String TITULO6 = "Listar los Alquileres de un Vehículo";
	private static final String TITULO7 = "Mostrar Estadísticas";

	private static final String INSERTAR = "Insertar";
	private static final String BUSCAR = "Buscar";
	private static final String BORRAR = "Borrar";
	private static final String LISTAR = "Listar";
	private static final String LISTAR_ALQUILER_CLIENTE = "Listar los Alquileres de un Cliente";
	private static final String LISTAR_ALQUILER_VEHICULO = "Listar los Alquileres de un Vehículo";
	private static final String MOSTRAR_ESTADISTICAS = "Mostrar Estadísticas";

	ObservableList<String> cbListaAlquileres = FXCollections.observableArrayList(INSERTAR, BUSCAR,
		    BORRAR, LISTAR, LISTAR_ALQUILER_CLIENTE,
			LISTAR_ALQUILER_VEHICULO, MOSTRAR_ESTADISTICAS);

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

		case BORRAR:
			Controlador ventanaBorrar = Controladores.get("vistas/BorrarAlquiler.fxml", TITULO3, null);
			ventanaBorrar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaBorrar.getEscenario(), e));
			Image iconoBorrar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoBorrar.png"));
			ventanaBorrar.getEscenario().getIcons().add(iconoBorrar);
			ventanaBorrar.getEscenario().showAndWait();
			break;

		case LISTAR:
			ListarAlquiler ventanaListar = (ListarAlquiler) Controladores.get("vistas/ListarAlquiler.fxml", TITULO4, null);
			ventanaListar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaListar.getEscenario(), e));
			Image iconoListar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListar.getEscenario().getIcons().add(iconoListar);
			ventanaListar.refrescar();
			ventanaListar.getEscenario().showAndWait();
			break;
			
		case LISTAR_ALQUILER_CLIENTE:
			ListarAlquilerCliente ventanaListarAlquilerCliente = (ListarAlquilerCliente) Controladores.get("vistas/ListarAlquilerCliente.fxml", TITULO5,
					null);
			ventanaListarAlquilerCliente.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaListarAlquilerCliente.getEscenario(), e));
			Image iconoListarAlquilerCliente = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListarAlquilerCliente.getEscenario().getIcons().add(iconoListarAlquilerCliente);
			ventanaListarAlquilerCliente.refrescar();
			ventanaListarAlquilerCliente.getEscenario().showAndWait();
			break;
			
		case LISTAR_ALQUILER_VEHICULO:
			ListarAlquilerVehiculo ventanaListarAlquilerVehiculo = (ListarAlquilerVehiculo) Controladores.get("vistas/ListarAlquilerVehiculo.fxml", TITULO6,
					null);
			ventanaListarAlquilerVehiculo.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaListarAlquilerVehiculo.getEscenario(), e));
			Image iconoListarAlquilerVehiculo = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListarAlquilerVehiculo.getEscenario().getIcons().add(iconoListarAlquilerVehiculo);
			ventanaListarAlquilerVehiculo.getEscenario().showAndWait();
			break;
			
		case MOSTRAR_ESTADISTICAS:
			MostrarEstadisticas ventanaMostrarEstadisticas = (MostrarEstadisticas) Controladores.get("vistas/MostrarEstadisticas.fxml", TITULO7,
					null);
			ventanaMostrarEstadisticas.getEscenario()
					.setOnCloseRequest(e -> confirmarSalida(ventanaMostrarEstadisticas.getEscenario(), e));
			Image iconoMostrarEstadisticas = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaMostrarEstadisticas.getEscenario().getIcons().add(iconoMostrarEstadisticas);
			ventanaMostrarEstadisticas.getEscenario().showAndWait();
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
