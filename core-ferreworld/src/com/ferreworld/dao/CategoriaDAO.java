package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ferreworld.model.Categoria;

public class CategoriaDAO {
	//Contiene los metodos de persistencia para las Categorias
		
		private Connection con;
		
				
		public CategoriaDAO() {
			super();
			this.openConnection();//cuando instanciamos el objeto tenemos la conexion creada
		}
		//metodo para abrir la conexion
		public void openConnection(){
			try {
				con=DriverManager.
				getConnection("jdbc:mysql://localhost:3306/academiabd","admin", "admin");
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	
	public Categoria insertar(String nombre, Boolean activo){		//insertar un objeto en la BD
		
		Categoria cat=null;
		String sql="INSERT INTO CATEGORIA (nombre, activo) VALUES (?,?) ";
		PreparedStatement st=null;
		try {
			st=con.prepareStatement(sql);
			st.setString(1, nombre);//se setean los valores en el preparedStatement segun
											// el tipo definido en la BD
			String myActivo=(activo) ? "A" : "*";//Si activo es true se asigna A sino *		
			st.setString(2, myActivo);
			int rows = st.executeUpdate();
			if(rows >= 1 ){
				cat=new Categoria();
				cat.setNombre(nombre);
				cat.setActivo(activo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    return cat;	
	}
	
	public void eliminar(Integer id){
		String sql="UPDATE CATEGORIA SET activo = '*' WHERE CATEGORIA.id = ?";
		PreparedStatement st=null;
		
			try {
				st=con.prepareStatement(sql);
				st.setInt(1, id);
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
	
}
