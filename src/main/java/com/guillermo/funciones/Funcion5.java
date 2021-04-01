package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;
/**
 * 
 * @author Guillermo Suarez
 *
 */
public class Funcion5 extends BaseFunciones implements IFunciones{
/**
 * Método que ejecuta la función: Seleccionar todos los parques cuyo nombre contenga una determinada cadena.
 */
	@Override
	public void ejecutar() {
		System.out.println("Introduce los criterios de busqueda");
		userOption = tool.opcionString();
		// obtenemos una lista con los parques que coinciden con la busqueda
		listaParques = tablaParque.busquedaParque(userOption);
		// informamos si no ha encontrado parques
		if (listaParques.isEmpty()) {
			System.out.println("No se ha encontrado ningun parque");
		} else {
			// imprimimos por pantalla la lista de parques
			tool.mostrarListaParques(listaParques);
		}
		
	}

}
