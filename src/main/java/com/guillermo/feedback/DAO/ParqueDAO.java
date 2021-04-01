package com.guillermo.feedback.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.guillermo.feedback.interfaces.InterfazDAO;
import com.guillermo.feedback.model.Parque;

public class ParqueDAO extends BaseDAO implements InterfazDAO<Parque> {
	private final String allParqueFiltro = "SELECT * from parques p inner join ciudades c on p.id_ciudad=c.id_ciudad where <id_column> = ? ";
	private final String addParque = "INSERT INTO parques (id_parque,nombre,extension,id_ciudad) VALUES (?,?,?,?)";
	private final String allParques = "SELECT * from parques";
	private final String parque_por_nombre = "SELECT * from parques where nombre = ?";
	private final String actualizar_parque = "UPDATE parques p SET p.nombre = ?, p.extension = ?, p.id_ciudad = ? WHERE p.id_parque = ?";
	private final String busqueda_nombre_parque = "SELECT * FROM parques p WHERE  p.nombre LIKE ?";
	private final String numero_parque_extension = "SELECT COUNT(*) FROM parques p INNER JOIN ciudades c ON p.id_ciudad = c.id_ciudad WHERE  c.id_ciudad = ?  AND p.extension > ?";
	private final String borrar_parques_por_ciudad = "DELETE FROM parques WHERE id_ciudad = ?";

	/**
	 * metodo para listar parques con un filtro especifico.
	 * 
	 * @param categoria String con la categoría que se va a buscar
	 * @param filtro String del nombre a filtrar dentro de esa categoria
	 * 
	 * @return Lista de todos los parque encontrados.
	 */
	public List<Parque> listarPorFiltro(String categoria,String filtro) {
		this.connect();
		List<Parque> lista = new ArrayList<Parque>();
		String nuevaQuery = allParqueFiltro.replace("<id_column>", categoria);
		this.preparedStatement(nuevaQuery);
		try {
			sp.setString(1,filtro);
			resultado = this.executeQuery();
				while (resultado.next()) {
					Parque p = new Parque();
					p.setId_parque(resultado.getInt("id_parque"));
					p.setNombre(resultado.getString("nombre"));
					p.setExtension(resultado.getInt("extension"));
					p.setId_ciudad(resultado.getInt("id_ciudad"));
					lista.add(p);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				this.disconnect();
			}

		return lista;
			
	}

	/**
	 * metodo para buscar en la base de datos un parque con filtro por nombre
	 * 
	 * @param nombre String con el sombre del parque que se desea buscar
	 * 
	 * @return El parque buscado
	 */
	public Parque parquePorNombre(String nombre) {
		this.connect();
		Parque p = new Parque();
		try {
			this.sp = conexion.prepareStatement(parque_por_nombre);
			sp.setString(1, nombre);
			resultado = this.executeQuery();
			while (resultado.next()) {
				p.setId_parque(resultado.getInt(1));
				p.setNombre(resultado.getString(2));
				p.setExtension(resultado.getInt(3));
				p.setId_ciudad(resultado.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.disconnect();
		}
		return p;
	}

	@Override
	public int add(Parque p) {
		int filasInsertadas = 0;
		try {
			this.connect();
			sp = conexion.prepareStatement(addParque);
			sp.setInt(1, p.getId_parque());
			sp.setString(2, p.getNombre());
			sp.setInt(3, p.getExtension());
			sp.setInt(4, p.getId_ciudad());

			filasInsertadas = sp.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			this.disconnect();
		}
		return filasInsertadas;
	}

	

	@Override
	public List<Parque> findAll() {
		List<Parque> listaParques = new ArrayList<Parque>();
		this.connect();
		resultado = this.executeQuery(allParques);
		try {
			while (resultado.next()) {
				Parque p = new Parque();
				p.setId_parque(resultado.getInt(1));
				p.setNombre(resultado.getString(2));
				p.setExtension(resultado.getInt(3));
				p.setId_ciudad(resultado.getInt(4));
				listaParques.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaParques;
	}

	@Override
	public int update(Parque p) {
		int filasActualizadas = 0;
		try {
			this.connect();
			sp = conexion.prepareStatement(actualizar_parque);
			sp.setString(1, p.getNombre());
			sp.setInt(2, p.getExtension());
			sp.setInt(3, p.getId_ciudad());
			sp.setInt(4, p.getId_parque());
			filasActualizadas = sp.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.disconnect();
		}
		return filasActualizadas;
	}

	/**
	 * metodo para Seleccionar todos los parques cuyo nombre contenga una
	 * determinada cadena.
	 * 
	 * @param busqueda String cadena que se desea buscar
	 * 
	 * @return Lista con los parques encontrados
	 */
	public List<Parque> busquedaParque(String busqueda) {
		List<Parque> listaParques = new ArrayList<Parque>();
		this.connect();
		try {
			sp = conexion.prepareStatement(busqueda_nombre_parque);
			// modificamos la busqueda aÃ±adiendo atributos de los parametros regulares
			String nuevaBusqueda = "%" + busqueda + "%";
			sp.setString(1, nuevaBusqueda);
			resultado = this.executeQuery();
			while (resultado.next()) {
				Parque p = new Parque();
				p.setId_parque(resultado.getInt("id_parque"));
				p.setNombre(resultado.getString("nombre"));
				p.setExtension(resultado.getInt("extension"));
				p.setId_ciudad(resultado.getInt("id_ciudad"));
				listaParques.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.disconnect();
		}

		return listaParques;
	}

	/**
	 * metodo para encontrar el numero de parques superior a una extension
	 * determinada por una determinada ciudad
	 * 
	 * @param ciudad    id de la ciudad seleccionada
	 * @param extension extension seleccionada
	 * @return numero de parques
	 */
	public Integer numeroParquesExtension(int ciudad, int extension) {
		int numeroTotal = 0;
		this.connect();
		try {
			sp = conexion.prepareStatement(numero_parque_extension);
			sp.setInt(1, ciudad);
			sp.setInt(2, extension);
			resultado = this.executeQuery();
			while (resultado.next()) {
				numeroTotal = resultado.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.disconnect();
		}

		return numeroTotal;
	}

	/**
	 * Metodo para eliminar todos los parques de una determinada ciudad
	 * 
	 * @param idCiudad Integer id ciudad
	 * 
	 * @return Integer numero de filas eliminadas
	 */
	public Integer borradoParquesPorCiudad(int idCiudad) {
		int numeroFilas = 0;
		this.connect();
		try {
			sp = conexion.prepareStatement(borrar_parques_por_ciudad);
			sp.setInt(1, idCiudad);
			numeroFilas = sp.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.disconnect();
		}
		return numeroFilas;
	}
}
