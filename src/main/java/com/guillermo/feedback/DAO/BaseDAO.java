package com.guillermo.feedback.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.guillermo.feedback.clasesAbstract.MotorOracle;

public class BaseDAO extends MotorOracle {
	private String usuario = "feedback";// usuario BBDD
	private String contra = "oracle";// contraseña BBDD
	private String link = "jdbc:oracle:thin:@localhost:1521:XE";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Connection conexion = null;
	PreparedStatement sp = null;
	ResultSet resultado= null;
	Statement st= null;

	/*
	 * metodo para conectar a la BBDD
	 */

	@Override
	public void connect() {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(link, usuario, contra);
			st=conexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e);

		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public int executeUpdate(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet executeQuery(String sql) {
		try {
			this.resultado=st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return resultado;
	}
	
	@Override
	public ResultSet executeQuery() {
		try {
			this.resultado=sp.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return resultado;
	}

	@Override
	public PreparedStatement preparedStatement(String sql) {
		try {
			sp = conexion.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return sp;
	}

	@Override
	public void disconnect() {
		try {
			if (sp != null) {
				sp.close();
			}
			if (conexion != null) {
				conexion.close();
			}
			if (st !=null) {
				st.close();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}


}
