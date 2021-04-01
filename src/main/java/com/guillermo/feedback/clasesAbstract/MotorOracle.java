package com.guillermo.feedback.clasesAbstract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.guillermo.feedback.interfaces.IMotorSQL;

public abstract class MotorOracle implements IMotorSQL{
 
	public abstract void connect();

	public abstract int executeUpdate(String sql);

	public abstract ResultSet executeQuery(String sql);

	public abstract PreparedStatement preparedStatement(String sql);

	public abstract void disconnect();
}
