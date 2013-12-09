package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Producto;

public class ProductoDAO {
	
	private Connection con;
		
	public ProductoDAO() {
		super();
		this.openConnection();//cuando instanciamos el objeto tenemos la conexion creada
	}
	//metodo para abrir la conexion
	public void openConnection(){
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/academiabd",
					"admin", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//metodo para cerrar la conexion
	public void closeConnection(){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//metodo insertar de producto
	public Producto insertar(String nombre, String marca, Double ultimoCosto, Integer existencia, Boolean activo, Categoria cat){		//insertar un objeto en la BD
		
		Producto pro=null;
		String sql="INSERT INTO PRODUCTO (nombre, marca, ultimo_costo, existencia, activo, categoria_id) VALUES (?,?,?,?,?,?) ";
		PreparedStatement st=null;
		try {
			st=con.prepareStatement(sql);
			st.setString(1, nombre);//se setean los valores en el preparedStatement segun
											// el tipo definido en la BD
			st.setString(2, marca);
			st.setDouble(3, ultimoCosto);
			st.setInt(4, existencia);
			String myActivo=(activo) ? "A" : "*";//Si activo es true se asigna A sino *		
			st.setString(5, myActivo);
			st.setInt(6, cat.getId());
			int rows =st.executeUpdate();
			if(rows >= 1 ){
				pro=new Producto();
				pro.setNombre(nombre);
				pro.setMarca(marca);
				pro.setExistencia(existencia);
				pro.setActivo(activo);
				pro.setUltimoCosto(ultimoCosto);			
				//aqui esta esperando una categoria
				pro.setCategoria(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pro;		
	}
	
	public void eliminar(Integer id){
		String sql="UPDATE PRODUCTO SET activo = '*' WHERE PRODUCTO.id = ?";
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
