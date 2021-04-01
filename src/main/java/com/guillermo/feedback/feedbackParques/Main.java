package com.guillermo.feedback.feedbackParques;

import com.guillermo.feedback.utiles.*;
import com.guillermo.funciones.Funcion1;
import com.guillermo.funciones.Funcion2;
import com.guillermo.funciones.Funcion3;
import com.guillermo.funciones.Funcion4;
import com.guillermo.funciones.Funcion5;
import com.guillermo.funciones.Funcion6;
import com.guillermo.funciones.Funcion7;
import com.guillermo.funciones.Funcion8;

/**
 * @author Guillermo Jose Suarez
 *
 */

public class Main {
	private static Menu menu = new Menu();
	private static int opcion = 0;
	private static Herramientas tool = new Herramientas();
	private static Funcion1 funcion1= new Funcion1();
	private static Funcion2 funcion2= new Funcion2();
	private static Funcion3 funcion3= new Funcion3();
	private static Funcion4 funcion4= new Funcion4();
	private static Funcion5 funcion5= new Funcion5();
	private static Funcion6 funcion6= new Funcion6();
	private static Funcion7 funcion7= new Funcion7();
	private static Funcion8 funcion8= new Funcion8();
	public static void main(String[] args) {
		do {
			menu.visualizarMenu();
			opcion = tool.opcionInt();
			tool.opcionString();// limpiamos el buffer para poder escribir un String
			switch (opcion) {
			case 1:
				funcion1.ejecutar();
				break;
			case 2:
				funcion2.ejecutar();
				break;
			case 3:
				funcion3.ejecutar();				
				break;
			case 4:
				funcion4.ejecutar();
				break;
			case 5:
				funcion5.ejecutar();
				break;
			case 6:
				funcion6.ejecutar();
				break;
			case 7:
				funcion7.ejecutar();
				break;
			case 8:
				funcion8.ejecutar();
				break;
			case 9:
				menu.mensajeCerrarPrograma();
				break;
			default:
				menu.mensajeReinicioMenu();
			}

		} while (opcion != 9);
	}
}
