package com.guillermo.feedback.model;

public class Ciudad {
	private int id_ciudad;
	private String nombre;
	private String ccaa;

	/**
	 * Constructor vacío para que sea más fácil crear nuevos parques al recuperarlos
	 * de la base de datos
	 */
	public Ciudad() {

	}

	/*
	 * getters y setters
	 */
	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCcaa() {
		return ccaa;
	}

	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}
	@Override
	public String toString() {
		String mensaje="Id de la ciudad: "+this.id_ciudad+", nombre de la ciudad: "+this.nombre+", comunidad autonoma: "+this.ccaa;
		return mensaje;
	}

}
