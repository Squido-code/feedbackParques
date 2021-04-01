package com.guillermo.feedback.utiles;

import java.util.List;
import java.util.Scanner;

import com.guillermo.feedback.DAO.CiudadDAO;
import com.guillermo.feedback.model.Ciudad;
import com.guillermo.feedback.model.Parque;

public class Herramientas {
	private Scanner sc = new Scanner(System.in);// objeto Scanner
	private CiudadDAO tablaCiudad = new CiudadDAO();
	private boolean salir = false;

	/**
	 * Método para pintar por pantalla un ArrayList de parques
	 *@param lista lista de parques que se desean imprimir
	 */
	public void mostrarListaParques(List<Parque> lista) {
		for (Parque p : lista) {
			System.out.println(p);
		}
	}

	/**
	 * método para pedir por teclado info al usuario
	 * 
	 * @return un entero
	 */
	public int opcionInt() {
		int usuario;
		return usuario = sc.nextInt();
	}

	/**
	 * método para pedir por teclado info al usuario
	 * 
	 * @return un String
	 */
	public String opcionString() {
		String usuario;
		return usuario = sc.nextLine();
	}
/**
 *Este método busca un parque de una determinada ciudad, y actualiza sus datos, devolviendo asi un parque nuevo.
 * @param nombreCiudad Nombre de la ciudad de la que se desea actualizar un parque
 * @return parque actualizado
 */
	public Parque ParquePorCiudad(String nombreCiudad) {
		String usuString;
		Parque p = new Parque();
		//introducimos id del parque. Controlamos que se introduzca un número, si no se
		// repite la ejecución 
		while (!salir) {
			System.out.println("Por favor introduzca la id del nuevo parque (debe ser un numero)");
			usuString = this.opcionString();
			if (this.isNumeric(usuString)) {
				p.setId_parque(Integer.parseInt(usuString));
				salir = true;
			} else {
				System.out.println("Por favor introduzca un numero valido");
				salir = false;
			}
		}
		salir = false;
		// introducimos el nombre del parque
		System.out.println("Por favor introduzca un nombre:");
		usuString = this.opcionString();
		p.setNombre(usuString);
		// introducimos la extensión, controlamos que se introduzca un numero, si no se
		// repite la ejecución
		while (!salir) {
			System.out.println("Por favor introduzca la extension del parque (debe ser un numero)");
			usuString = this.opcionString();
			if (this.isNumeric(usuString)) {
				p.setExtension(Integer.parseInt(usuString));
				salir = true;
			} else {
				System.out.println("Por favor introduzca un numero valido");
				salir = false;
			}
		}
		salir = false;
		// introducimos el nombre de la ciudad y obtenemos id
		p.setId_ciudad(tablaCiudad.idCiudadPorNombre(nombreCiudad));
		// confirmamos la creación del parque
		System.out.println("El parque se ha creado correctamente");
		// devolvemos el parque
		return p;

	}
/**
 * Este método comprueba si se ha introducido un Integer o un String
 * @param cadena Pasamos la cadena que se quiera comprobar
 * @return devolvemos true o false dependiendo de sí es una cadena o un Integer
 */
	private boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Este método imprime por pantalla la informacion relevante de un parque. Se
	 * oculta el parque id y se sustituye el id de la ciudad por su nombre.
	 * 
	 * @param p objeto tipo parque para obtener su información
	 */
	public void mostrarInfoParque(Parque p) {
		// obtenemos nombre del parque
		String nombre = p.getNombre();
		// obtenemos la extension del parque
		int extension = p.getExtension();
		// obtenemos la id de la ciudad y buscamos su nombre
		int idCiudad = p.getId_ciudad();
		String nombreCiudad = tablaCiudad.nombreCiudadPorId(idCiudad);
		// imprimimos por pantalla
		System.out.println("informacion del parque " + nombre + ":");
		System.out.println("Nombre: " + nombre);
		System.out.println("Ciudad: " + nombreCiudad);
		System.out.println("Extension: " + extension);
		System.out.println();
	}
	/**
	 * Este método imprime por pantalla una lista de ciudades, solo por el nombre
	 * @param lc List ciudades
	 */
	public void mostrarCiudadesNombre(List<Ciudad> lc) {
		System.out.println("Lista de ciudades:");
		for(Ciudad c:lc) {
			String nombre=c.getNombre();
			System.out.println("-"+nombre);
		}
		System.out.println("Fin de la lista");
	}
	/**
	 * Método que obtiene la id de un parque existente pero rellena el parque con
	 * nueva información
	 * 
	 * @param p parque que se desea actualizar
	 * 
	 * @return parque actualizado
	 */
	public Parque actualizarDatosParque(Parque p) {
		// pedimos datos del nuevo parque
		//nombre
		System.out.println("Por favor introduce el nuevo nombre");
		String nombreNuevo = this.opcionString();
		//pedimos nombre la nueva ciudad
		System.out.println("Por favor introduce la nueva ciudad");
		String nombreCiudadNuevo = this.opcionString();
		//convertimos nombre de la ciudad en id de ciudad
		int idCiudadNuevo=tablaCiudad.idCiudadPorNombre(nombreCiudadNuevo);
		// pedimos extension y controlamos que se meta un numero
		int extensionNueva=0;
		while (!salir) {
			System.out.println("Por favor introduce la nueva extension");
			String usuString = this.opcionString();
			if (this.isNumeric(usuString)) {
				extensionNueva = (Integer.parseInt(usuString));
				salir = true;
			} else {
				System.out.println("Por favor introduzca un numero valido");
				salir = false;
			}
		}
		//actualizamos el parque con los nuevos parametros
		p.setNombre(nombreNuevo);
		p.setExtension(extensionNueva);
		p.setId_ciudad(idCiudadNuevo);
		return p;
	}
/**
 * método que limpia todas las variables de las funciones usadas
 */
	/*public void limpieza(){
		  listaParques.clear();
		  listaCiudades.clear();
		  userOption=null;
		  userOption2=0;
		  idCiudad=0;
		  filas=0;
	}*/
}
