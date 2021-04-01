package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;

/**
 * 
 * @author Guillermo
 * @version 1.0
 *
 */
public class Funcion1 extends BaseFunciones implements IFunciones{
	/**
	 * Método que ejecuta la función: Listar todos los parques de una determinada ciudad por nombre.
	 */
	@Override
	public void ejecutar() {
		System.out.println("Por favor ingresa la ciudad deseada");
		userOption = tool.opcionString();
		String categoria="c.nombre";
		listaParques = tablaParque.listarPorFiltro(categoria, userOption);
		System.out.println("Listado de parques encontrados en " + userOption + ":");
		tool.mostrarListaParques(listaParques);
	}
}
