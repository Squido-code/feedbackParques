package com.guillermo.feedback.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.guillermo.feedback.interfaces.InterfazDAO;
import com.guillermo.feedback.model.Ciudad;

public class CiudadDAO extends BaseDAO implements InterfazDAO<Ciudad>{
private final String allCiudades="SELECT * from ciudades";
private final String id_por_nombre="SELECT id_ciudad from ciudades where nombre=?";
private final String nombre_por_id="SELECT nombre from ciudades where id_ciudad=?";
private final String lista_Ciudades_por_extension="SELECT c.nombre FROM ciudades c INNER JOIN parques p ON p.id_ciudad = c.id_ciudad GROUP BY c.nombre HAVING SUM(p.extension) > ?";

@Override
public int add(Ciudad bean) {

	return 0;
}



/**
 * método que crea una lista con todas las ciudades almacenadas en la BBDD
 * @return List de ciudades
 */
@Override
public List<Ciudad> findAll() {
	List<Ciudad> listaCiudades= new ArrayList<Ciudad>();
	this.connect();
	resultado=this.executeQuery(allCiudades);
	try {
		while(resultado.next()) {
			Ciudad c=new Ciudad();
			c.setId_ciudad(resultado.getInt(1));
			c.setNombre(resultado.getString(2));
			c.setCcaa(resultado.getString(3));
			listaCiudades.add(c);
		}
	return listaCiudades;
	} catch (SQLException e) {

		System.out.println(e.getMessage());
	}finally {
		this.disconnect();
	}
	return null;
}

@Override
public int update(Ciudad bean) {
	// TODO Auto-generated method stub
	return 0;
}

/**
 * Método que devuelve la id de la ciudad a partir de su nombre
 * @param s String con el nombre de la ciudad
 * @return Entero con la id de la ciudad
 */

public int idCiudadPorNombre(String s) {
	this.connect();
	int id=0;
	try {
		this.sp=conexion.prepareStatement(id_por_nombre);
		sp.setString(1, s);
		resultado = this.executeQuery();
		while(resultado.next()) {
			id=resultado.getInt(1);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	} finally {
		this.disconnect();
	}
	
	return id;
}
/**
* método que devuelve el nombre de la ciudad a partir de su id
 * @param id Entero con la id de la ciudad
 * @return String con el nombre de la ciudad
 */
public String nombreCiudadPorId(int id) {
	this.connect();
	String nombre=null;
	try {
		this.sp=conexion.prepareStatement(nombre_por_id);
		sp.setInt(1, id);
		resultado = this.executeQuery();
		while(resultado.next()) {
			nombre=resultado.getString("nombre");
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	} finally {
		this.disconnect();
	}
	return nombre;
}
/**
 *método que busca todas las ciudades cuya extensión total supere un mínimo
 * @param extension Integer extensión
 * @return list de ciudades
 */
public List<Ciudad> ciudadesPorExtension(int extension){
	List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	this.connect();
	try {
		sp=conexion.prepareStatement(lista_Ciudades_por_extension);
		sp.setInt(1, extension);
		resultado = this.executeQuery();
		while(resultado.next()) {
			Ciudad c = new Ciudad();
			c.setNombre(resultado.getString(1));
			listaCiudades.add(c);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}finally {
		this.disconnect();
	}
	return listaCiudades;
}
}

