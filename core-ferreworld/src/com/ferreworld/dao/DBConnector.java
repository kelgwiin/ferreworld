package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	static final String URL = "jdbc:mysql://localhost:3306/academiabd";
	static final String USER = "admin";
	static final String PASS = "admin";
	
	private String url;
	private String user;
	private String pass;
	
	private Connection con;
	
	public DBConnector() {
		setUrl(URL);
		setUser(USER);
		setPass(PASS);
	}

	//metodo para abrir la conexion
	public Connection openConnection() throws SQLException{
		con = null;
			con=DriverManager.
			getConnection( getUrl(),getUser(), getPass());
		return con;
	}
	
	//metodo para cerrar la conexion
	public void closeConnection(){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
