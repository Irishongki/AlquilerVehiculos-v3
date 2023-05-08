package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaVista;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		Vista vista = procesarArgumentos(args);
		Modelo modelo = new ModeloCascada(FactoriaFuenteDatos.FICHEROS);

		Controlador controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}

	
	private static Vista procesarArgumentos(String[] argumentos) {
		Vista vista = FactoriaVista.GRAFICA.crear();
		for (String argumento : argumentos) {
			if (argumento.equals("-vTexto")) {
				vista = FactoriaVista.TEXTO.crear();
			}else if(argumento.equals("-vGrafica")) {
				vista = FactoriaVista.GRAFICA.crear();
			}
		}
		return vista;
	}
}
