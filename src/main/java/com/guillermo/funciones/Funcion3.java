package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;
import com.guillermo.feedback.model.Ciudad;
/**
 * 
 * @author Guillermo Suarez
 *
 */
public class Funcion3 extends BaseFunciones implements IFunciones{
/**
 * M�todo que ejecuta la funci�n: A�adir un parque a una determinada ciudad (por nombre de ciudad), si la ciudad no existe no se a�ade y se informa de ello.
 */
	@Override
	public void ejecutar() {
		System.out.println("Por favor introduzca la ciudad a la que desea agregar el nuevo parque ");
		userOption = tool.opcionString();
		boolean ciudadOk = false;
		// llamamos a todas las ciudades
		listaCiudades = tablaCiudad.findAll();
		for (Ciudad c : listaCiudades) {
			if (c.getNombre().equals(userOption)) {
				ciudadOk = true;
			}
		}
		if (ciudadOk) {
			p = tool.ParquePorCiudad(userOption);
			filas = tablaParque.add(p);
			System.out.println("Numero de filas insertadas en la BBDD: " + filas);
		} else {
			System.out.println("ERROR: ciudad no encontrada");
		}
		
	}

}
