package com.guillermo.feedback.clasesAbstract;

import java.util.ArrayList;
import java.util.List;

import com.guillermo.feedback.DAO.CiudadDAO;
import com.guillermo.feedback.DAO.ParqueDAO;
import com.guillermo.feedback.model.Ciudad;
import com.guillermo.feedback.model.Parque;
import com.guillermo.feedback.utiles.Herramientas;
/**
 * 
 * @author Guillermo Suarez
 * Esta clase abstracta reúne todas las variables comunes que se van a usar para las distintas funciones.
 * Protegemos las variables para que solo las subclases puedan tener acceso.
 */
public abstract class BaseFunciones {

	  protected ParqueDAO tablaParque = new ParqueDAO();
	  protected CiudadDAO tablaCiudad = new CiudadDAO();
	  protected Herramientas tool = new Herramientas();
	  protected List<Parque> listaParques = new ArrayList<Parque>();
	  protected List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	  protected String userOption=null;
	  protected int userOption2=0;
	  protected Parque p = new Parque();
	  protected int idCiudad=0;
	  protected int filas=0;
	  protected String categoria;
	
}
