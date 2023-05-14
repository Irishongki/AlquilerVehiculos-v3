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

public class VentanaVehiculos extends Controlador {

	private static final String TITULO = "Insertar un Vehículo";
	private static final String TITULO2 = "Buscar un Vehículo";
	private static final String TITULO3 = "Borrar un Vehículo";
	private static final String TITULO4 = "Listar los Vehículos";

	private static final String INSERTAR = "Insertar";
	private static final String BUSCAR = "Buscar";
	private static final String BORRAR = "Borrar";
	private static final String LISTAR = "Listar";

	ObservableList<String> cbListaVehiculos = FXCollections.observableArrayList(INSERTAR, BUSCAR, BORRAR, LISTAR);

	@FXML
	private Button btOpcion;

	@FXML
	private ChoiceBox<String> cbVehiculos;

	@FXML
	private void initialize() {
		cbVehiculos.setValue(INSERTAR);
		cbVehiculos.setItems(cbListaVehiculos);
	}

	@FXML
	private void escogerOpcion(MouseEvent event) {
		String opcion = cbVehiculos.getSelectionModel().getSelectedItem();
		switch (opcion) {

		case INSERTAR:
			Controlador ventanaInsertar = Controladores.get("vistas/InsertarVehiculo.fxml", TITULO, null);
			ventanaInsertar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaInsertar.getEscenario(), e));
			Image iconoInsertar = new Image(
					LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoInsertarVehiculo.png"));
			ventanaInsertar.getEscenario().getIcons().add(iconoInsertar);
			ventanaInsertar.getEscenario().showAndWait();
			break;

		case BUSCAR:
			Controlador ventanaBuscar = Controladores.get("vistas/BuscarVehiculo.fxml", TITULO2, null);
			ventanaBuscar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaBuscar.getEscenario(), e));
			Image iconoBuscar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoBuscar.png"));
			ventanaBuscar.getEscenario().getIcons().add(iconoBuscar);
			ventanaBuscar.getEscenario().showAndWait();
			break;

		case BORRAR:
			Controlador ventanaBorrar = Controladores.get("vistas/BorrarVehiculo.fxml", TITULO3, null);
			ventanaBorrar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaBorrar.getEscenario(), e));
			Image iconoBorrar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoBorrar.png"));
			ventanaBorrar.getEscenario().getIcons().add(iconoBorrar);
			ventanaBorrar.getEscenario().showAndWait();
			break;

		case LISTAR:
			Controlador ventanaListar = Controladores.get("vistas/ListarVehiculo.fxml", TITULO4, null);
			ventanaListar.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaListar.getEscenario(), e));
			Image iconoListar = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoListar.png"));
			ventanaListar.getEscenario().getIcons().add(iconoListar);
			ventanaListar.getEscenario().showAndWait();
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
