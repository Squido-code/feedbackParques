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
	 * Método que ejecuta la función: 4. Actualizar la información de un parque
	 * (primero se pedirá al usuario el nombre del parque que quiere actualizar, se
	 * buscará en la base de datos y se mostrarán los datos del parque (nombre,
	 * nombre ciudad, extensión) y a continuación se pedirán los 3 nuevos datos
	 * (nombre, nombre ciudad y extensión) y se hará la actualización.
	 */
	@Override
	public void ejecutar() {
		System.out.println("Por favor introduce el nombre del parque que deseas actualizar");
		userOption = tool.opcionString();
		// obtenemos el parque elegído
		p = tablaParque.parquePorNombre(userOption);
		// imprimimos la información del parque
		tool.mostrarInfoParque(p);
		// actualizamos los datos del parque elegído
		tool.actualizarDatosParque(p);
		// hacemos el update
		filas = tablaParque.update(p);
		// confirmamos con la BBDD
		System.out.println("Numero de filas actualizadas en la BBDD: " + filas);
	}

}
