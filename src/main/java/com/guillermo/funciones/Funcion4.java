package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;

/**
 * 
 * @author Guillermo Suarez
 *
 */
public class Funcion4 extends BaseFunciones implements IFunciones {
	/**
	 * M�todo que ejecuta la funci�n: 4. Actualizar la informaci�n de un parque
	 * (primero se pedir� al usuario el nombre del parque que quiere actualizar, se
	 * buscar� en la base de datos y se mostrar�n los datos del parque (nombre,
	 * nombre ciudad, extensi�n) y a continuaci�n se pedir�n los 3 nuevos datos
	 * (nombre, nombre ciudad y extensi�n) y se har� la actualizaci�n.
	 */
	@Override
	public void ejecutar() {
		System.out.println("Por favor introduce el nombre del parque que deseas actualizar");
		userOption = tool.opcionString();
		// obtenemos el parque eleg�do
		p = tablaParque.parquePorNombre(userOption);
		// imprimimos la informaci�n del parque
		tool.mostrarInfoParque(p);
		// actualizamos los datos del parque eleg�do
		tool.actualizarDatosParque(p);
		// hacemos el update
		filas = tablaParque.update(p);
		// confirmamos con la BBDD
		System.out.println("Numero de filas actualizadas en la BBDD: " + filas);
	}

}
