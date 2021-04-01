package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;

/**
 * 
 * @author Guillermo Suarez
 *
 */
public class Funcion2 extends BaseFunciones implements IFunciones {
	/**
	 * Método que ejecuta la función: 2. Listar todos los parques de una cierta
	 * comunidad autóma por nombre.
	 */
	@Override
	public void ejecutar() {
		System.out.println("Por favor ingresa la comunidad autónoma deseada:");
		userOption = tool.opcionString();
		categoria="ccaa";
		listaParques = tablaParque.listarPorFiltro(categoria, userOption);
		System.out.println("Listado de parques encontrados en " + userOption + ":");
		tool.mostrarListaParques(listaParques);
	}

}
