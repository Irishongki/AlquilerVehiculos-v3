package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

public class MostrarEstadisticas extends Controlador {

	@FXML
	private DatePicker dpEstadisticas;

	@FXML
	private PieChart grafico;

	 @FXML
		private void initialize() {
		 PieChart.Data turismo = new PieChart.Data("Turismo", 1);
		 PieChart.Data autobus = new PieChart.Data("Autobus", 1);
		 PieChart.Data furgoneta = new PieChart.Data("Furgoneta", 1);
		 
		 ObservableList<Data> listaGrafico = FXCollections.observableArrayList();
		 listaGrafico.addAll(turismo, autobus, furgoneta);
		 grafico.setData(listaGrafico);
	 }
	 
	@FXML
	void muestraEstadisticas(MouseEvent event) {
		ObservableList<Data> listaGraficoAux = grafico.getData();
		
		int contador= 0;
		while(contador < listaGraficoAux.size()) {
			listaGraficoAux.get(contador).setPieValue(0);
			contador++;
		}

		for (Alquiler alquiler : VistaGrafica.getInstancia().getControlador().getAlquileres()) {
			if ((alquiler.getFechaAlquiler().getYear() == dpEstadisticas.getValue().getYear()) && (alquiler.getFechaAlquiler().getMonth().equals(dpEstadisticas.getValue().getMonth()))) {
				if(alquiler.getVehiculo() instanceof Turismo ) {
					listaGraficoAux.get(0).setPieValue(listaGraficoAux.get(0).getPieValue() + 1);
				}else if(alquiler.getVehiculo() instanceof Autobus ){
					listaGraficoAux.get(1).setPieValue(listaGraficoAux.get(1).getPieValue() + 1);
				}else if(alquiler.getVehiculo() instanceof Furgoneta ){
					listaGraficoAux.get(2).setPieValue(listaGraficoAux.get(2).getPieValue() + 1);
				}
			}
		}
	}

}
