package com.guillermo.funciones;

import com.guillermo.feedback.clasesAbstract.BaseFunciones;
import com.guillermo.feedback.interfaces.IFunciones;
/**
 * 
 * @author Guillermo Suarez
 *
 */
public class Funcion8 extends BaseFunciones implements IFunciones{
/**
 * Método que ejecuta la función: Listar el nombre de todas las ciudades que contengan parques cuya suma total de su extensión, sea mayor que la que quiera el usuario.
 */
	@Override
	public void ejecutar() {
		//pedimos la extensión
		System.out.println("Inserta la extension");
		userOption2=tool.opcionInt();
		//recuperamos las ciudades
		listaCiudades=tablaCiudad.ciudadesPorExtension(userOption2);
		//mostramos lista de ciudades
		tool.mostrarCiudadesNombre(listaCiudades);
		
	}

}
