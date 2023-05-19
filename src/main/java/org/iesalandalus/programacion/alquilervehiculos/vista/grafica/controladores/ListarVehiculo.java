package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class ListarVehiculo extends Controlador {

	@FXML
	private TableColumn<Vehiculo, String> cilindradaItem;

	@FXML
	private TableColumn<Vehiculo, String> marcaItem;

	@FXML
	private TableColumn<Vehiculo, String> matriculaItem;

	@FXML
	private TableColumn<Vehiculo, String> modeloItem;

	@FXML
	private TableColumn<Vehiculo, String> plazasItem;

	@FXML
	private TableColumn<Vehiculo, String> pmaItem;

	@FXML
	private TableView<Vehiculo> tablaVehiculos;

	@FXML
	private TableColumn<Vehiculo, String> tipoItem;

	private ObservableList<Vehiculo> listaVehiculos;

	@FXML
	private void initialize() {
		String valorNulo = "X";
		marcaItem.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
		matriculaItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");
		modeloItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");
		tipoItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");
		pmaItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");
		cilindradaItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");
		plazasItem.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");

		marcaItem.setCellValueFactory(new PropertyValueFactory<>("marca"));
		matriculaItem.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		modeloItem.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tipoItem.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Vehiculo, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Vehiculo, String> param) {
						return new SimpleStringProperty(param.getValue().getClass().getSimpleName());
					}
				});
		cilindradaItem.setCellValueFactory(cellData -> {
			if (cellData.getValue() instanceof Turismo) {
				return new SimpleIntegerProperty(((Turismo) cellData.getValue()).getCilindrada()).asObject().asString();
			}
			return new SimpleStringProperty(valorNulo);
		});

		pmaItem.setCellValueFactory(cellData -> {
			if (cellData.getValue() instanceof Furgoneta) {
				return new SimpleIntegerProperty(((Furgoneta) cellData.getValue()).getPma()).asObject().asString();
			}
			return new SimpleStringProperty(valorNulo);
		});

		plazasItem.setCellValueFactory(cellData -> {
			if (cellData.getValue() instanceof Autobus) {
				return new SimpleIntegerProperty(((Autobus) cellData.getValue()).getPlazas()).asObject().asString();
			} else if (cellData.getValue() instanceof Furgoneta) {
				return new SimpleIntegerProperty(((Furgoneta) cellData.getValue()).getPlazas()).asObject().asString();
			}
			return new SimpleStringProperty(valorNulo);
		});

		listaVehiculos = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getVehiculos());
		tablaVehiculos.setItems(listaVehiculos);
	}

	public void refrescar() {
		tablaVehiculos.getItems().clear();
		listaVehiculos = FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getVehiculos());
		tablaVehiculos.setItems(listaVehiculos);
	}
}
