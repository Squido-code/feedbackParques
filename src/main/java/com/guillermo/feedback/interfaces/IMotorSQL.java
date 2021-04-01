package com.guillermo.feedback.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IMotorSQL {
	public void connect();

	public int executeUpdate(String sql);

	public ResultSet executeQuery(String sql);

	public PreparedStatement preparedStatement(String sql);

	public void disconnect();

	ResultSet executeQuery();
}
