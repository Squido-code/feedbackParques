package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;
/**
 * 
 * @author Guillermo Suarez
 *
 */
public class Funcion7 extends BaseFunciones implements IFunciones{
/**
 * Método que ejecuta la función: Borrar todos los parques de una determinada ciudad por nombre.
 */
	@Override
	public void ejecutar() {
		// pedimos la ciudad a la que se quieren borrar todos los parques
		System.out.println("Por favor introduce la ciudad");
		userOption = tool.opcionString();
		// confirmamos que quiere realizar la operación
		System.out.println("Esta operacion borrara todos los parques de manera permanente");
		System.out.println("Â¿Estas seguro de que quieres borrar todos los parques de " + userOption + "?");
		System.out.println("1. Si \n2.No");
		userOption2 = tool.opcionInt();
		// ejecutamos segun la opcion escogida
		switch (userOption2) {
		case 1:
			// converimos el nombre de ciudad en ciudad id
			idCiudad = tablaCiudad.idCiudadPorNombre(userOption);
			//eliminamos parques
			filas=tablaParque.borradoParquesPorCiudad(idCiudad);
			//confirmamos las filas eliminadas
			System.out.println("numero de filas eliminadas: "+filas);
			break;
		case 2:
			System.out.println("La operacion ha sido cancelada");
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
		
	}

}
