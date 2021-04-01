package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;
/**
 * 
 * @author Guillermo Suarez
 *
 */
public class Funcion6 extends BaseFunciones implements IFunciones{
/**
 * Método que ejecuta la función: Devolver el número de parques de una determinada ciudad que tengan una extensión individual mayor que la que desee el usuario.
 */
	@Override
	public void ejecutar() {
		// pedimos la ciudad
		System.out.println("Por favor introduce la ciudad seleccionada");
		// guardamos la ciudad
		userOption = tool.opcionString();
		// converimos el nombre de ciudad en ciudad id
		idCiudad = tablaCiudad.idCiudadPorNombre(userOption);
		// pedimos la extensión mínima
		System.out.println("Por favor introduce la extension minima");
		userOption2 = tool.opcionInt();
		// llamamos al metodo y guardamos el numero total de parques
		int numeroParques = tablaParque.numeroParquesExtension(idCiudad, userOption2);
		// imprimimos por pantalla
		System.out.println("El numero total de parques de " + userOption + " con una extension minima de "
				+ userOption2 + " es :" + numeroParques);
		
	}

}
