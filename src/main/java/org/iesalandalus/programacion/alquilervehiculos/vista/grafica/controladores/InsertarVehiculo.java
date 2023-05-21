package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controles;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InsertarVehiculo extends Controlador{

	private static final String TURISMO = "turismo";
	private static final String AUTOBUS = "autobus";
	private static final String FURGONETA = "furgoneta";
	
	ObservableList<String> cbListaTipoVehiculo = FXCollections.observableArrayList(TURISMO, AUTOBUS, FURGONETA);

    @FXML
    private Button btAceptar;

    @FXML
    private ChoiceBox<String> cbTipoVehiculo;

    @FXML
    private TextField tfCilindrada;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfMatricula;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfPlazas;

    @FXML
    private TextField tfPma;
    
    private String matriculaBuscada;
    private String marca;
    private String modelo;
    private String tipo;

    @FXML
	private void initialize() {
		cbTipoVehiculo.setValue(TURISMO);
		cbTipoVehiculo.setItems(cbListaTipoVehiculo);
		Controles.habilitarCamposTexto(tfMarca,tfModelo, tfMatricula);
		Controles.deshabilitarCamposTexto(tfCilindrada,tfPlazas,tfPma);
		tfMarca.textProperty().addListener((observable, oldValue, newValue) -> controlaTamanoTextoMarca(newValue));
		tfMatricula.textProperty().addListener((observable, oldValue, newValue) -> controlaTamanoTextoMatricula(newValue));
	}
    
    @FXML
    void enviarDatosComunes(MouseEvent event) {
    	matriculaBuscada = tfMatricula.getText();
    	modelo= tfModelo.getText();
    	marca= tfMarca.getText();
    	tipo = cbTipoVehiculo.getSelectionModel().getSelectedItem();
    	if(cbTipoVehiculo.getSelectionModel().getSelectedItem().equals(TURISMO)) {
			Controles.deshabilitarCamposTexto(tfMarca,tfMatricula,tfModelo,tfPma,tfPlazas);
			Controles.habilitarCamposTexto(tfCilindrada);
    	} else if (cbTipoVehiculo.getSelectionModel().getSelectedItem().equals(AUTOBUS)) {
			Controles.deshabilitarCamposTexto(tfMarca,tfMatricula,tfModelo, tfCilindrada, tfPma);
			Controles.habilitarCamposTexto(tfPlazas);
    	} else if(cbTipoVehiculo.getSelectionModel().getSelectedItem().equals(FURGONETA)) {
			Controles.deshabilitarCamposTexto(tfMarca,tfMatricula,tfModelo, tfCilindrada);
			Controles.habilitarCamposTexto(tfPlazas, tfPma);
    	}
    	tfMarca.setText(marca);
		tfModelo.setText(modelo);
		tfMatricula.setText(matriculaBuscada);
    }
   
    @FXML
    void añadirVehiculo(MouseEvent event) {
    	try {
    		if (matriculaBuscada.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
				Dialogos.mostrarDialogoAdvertencia("Faltan datos...",
						"Debe introducir la marca, la matricula y el modelo.", null);
			} else {
				if(tipo.equals(TURISMO)) {
					VistaGrafica.getInstancia().getControlador().insertar(new Turismo(marca, modelo, Integer.parseInt(tfCilindrada.getText()), matriculaBuscada));
				}else if(tipo.equals(AUTOBUS)) {
					VistaGrafica.getInstancia().getControlador().insertar(new Autobus(marca, modelo,Integer.parseInt(tfPlazas.getText()), matriculaBuscada));
				}else if(tipo.equals(FURGONETA)) {
					VistaGrafica.getInstancia().getControlador().insertar(new Furgoneta(marca, modelo,Integer.parseInt(tfPma.getText()),Integer.parseInt(tfPlazas.getText()), matriculaBuscada));
				}
				Dialogos.mostrarDialogoInformacion("Datos Introducidos ",
						"Los datos del nuevo Vehículo se han introducido correctamente", null);
			}
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("ERROR: Ha ocurrido una Exceptión", e.getMessage(), null);
		}
    	 getEscenario().close();
    }

    @FXML
    void limpiar(MouseEvent event) {
    	Controles.limpiarCamposTexto(tfMarca, tfMatricula, tfModelo, tfCilindrada, tfPlazas, tfPma);
    	Controles.habilitarCamposTexto(tfMarca,tfModelo, tfMatricula);
		Controles.deshabilitarCamposTexto(tfCilindrada,tfPlazas,tfPma);
    }
    
    private void controlaTamanoTextoMarca(String textoNuevo) {
		if ((textoNuevo.matches("[A-Z][a-z]+([ -]?[A-Z][a-z]+)*|[A-Z]+"))) {
			tfMarca.setStyle("-fx-border-color: green; -fx-border-radius: 3; -fx-border-width: 2;");
		} else {
			tfMarca.setStyle("-fx-border-color: red; -fx-border-radius: 3; -fx-border-width: 2;");
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
