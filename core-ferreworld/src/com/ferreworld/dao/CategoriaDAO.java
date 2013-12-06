package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ferreworld.model.Categoria;

/**
 * Contiene los metodos de persitencia para las Categorias
 * @author Kelwin
 *
 */
public class CategoriaDAO {
	private Connection con;
	
	public CategoriaDAO(){
		super();
		this.openConnection();
	}
	public void openConnection(){
		try {
			con = DriverManager.getConnection("jdbc:mysql:localhost:3306/academiabd",
					"admin","admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Categoria insertar(String nombre, Boolean activo){
		String sql = "INSERT INTO categoria (nombre, activo) VALUES ?,? ";
		PreparedStatement st = null;
		Categoria cat = null;
		
		try {
			st = con.prepareStatement(sql);
			String myActivo = (activo)?"A":"*";
			
			st.setString(1, nombre);
			st.setString(2, myActivo);
			
			int rows = st.executeUpdate(); //ingresando en la BD
			if(rows == 1){
				cat = new Categoria();
				cat.setNombre(nombre);
				cat.setActivo(activo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}								//se settean los valores en el 
										//preparedStatement segun el TIPO
										//definido en la Base de Datos
		return cat;
	}

}
