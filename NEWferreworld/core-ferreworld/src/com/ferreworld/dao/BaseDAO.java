package com.ferreworld.dao;

import java.sql.Connection;

public abstract class BaseDAO {

	Connection con;
	
	public BaseDAO() {
		super();
	}
	
	public BaseDAO(Connection con){
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
