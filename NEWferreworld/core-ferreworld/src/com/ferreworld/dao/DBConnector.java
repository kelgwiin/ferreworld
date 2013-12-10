package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	static final String URL="jdbc:mysql://localhost:3306/academiabd";
	static final String USER="admin";
	static final String PASSWD="admin";
	
	private String url;
	private String user;
	private String password;
	
	Connection con;
	
	public DBConnector(){
		setUrl(URL);
		setUser(USER);
		setPassword(PASSWD);
	}
	
	public DBConnector(String url, String password, String user){
		this.url = url;
		this.password = password;
		this.user = user;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Connection openConnection()throws SQLException{
		con= DriverManager.getConnection(getUrl(), 
								getUser(), getPassword());
		return con;
	}
	
	public void closeConnection() throws SQLException{
		if(con!= null){
			con.close();
		}
	}
	
}
