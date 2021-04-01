package com.guillermo.feedback.utiles;

public class Menu {

	private final String listar_P_C = "Listar todos los parques por ciudad";
	private final String listar_P_CCAA = "Listar todos los parques por Comunidad Autonoma";
	private final String insert_P_C = "Añadir nuevo parque a una ciudad";
	private final String update_P = "Actualizar información de un parque";
	private final String select_P = "Buscar parque";
	private final String select_P_E = "Mostrar numero de parques con una extension mínima en una ciudad";
	private final String delete_P_C = "Eliminar todos los parques de una ciudad";
	private final String listar_C_E = "Listar todas las ciudades con una extensión total mínima";
	private final String salida = "Salir";

	/**
	 * Metodo que pinta un menu con las opciones disponibles en el programa
	 */
	public void visualizarMenu() {
		System.out.println("-----------------Menu tus parques-----------------");
		System.out.println();
		System.out.println("Elige una opción:");
		System.out.println();
		System.out.println("1. " + listar_P_C);
		System.out.println("2. " + listar_P_CCAA);
		System.out.println("3. " + insert_P_C);
		System.out.println("4. " + update_P);
		System.out.println("5. " + select_P);
		System.out.println("6. " + select_P_E);
		System.out.println("7. " + delete_P_C);
		System.out.println("8. " + listar_C_E);
		System.out.println("9. " + salida);
		System.out.println("---------------------------------------------------");

	}
/**
 * metodo que imprime por pantalla error de opcion e indica que vuelve al menu
 */
	public void mensajeReinicioMenu() {
		System.out.println("*****************Opción incorrecta*****************");
		System.out.println("*****************volviendo al menu*****************");
		System.out.println();
	}
/**
 * metodo que imprime por pantalla que se el programa se esta cerrando con una pequeÃ±a animacion
 */
	public void mensajeCerrarPrograma() {
		// una pequeÃ±a tontuna para cerrar el programa
		System.out.print("Saliendo del programa");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
