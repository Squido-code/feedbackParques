package com.guillermo.feedback.model;

public class Parque {
	private int id_parque;
	private String nombre;
	private int extension;
	private int id_ciudad;

	/**
	 *Constructor vacío para que sea más fácil crear nuevos parques al recuperarlos
	 *de la base de datos
	 */
	public Parque() {

	}

	/*
	 * getters y setters
	 */
	public int getId_parque() {
		return id_parque;
	}

	public void setId_parque(int id_parque) {
		this.id_parque = id_parque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	@Override
	public String toString() {
		String mensaje = "Id del Parque: " + this.id_parque + ", Nombre: " + this.nombre + ", Extension: "
				+ this.extension + ", Id de la ciudad: " + this.id_ciudad;
		return mensaje;
	}
}
