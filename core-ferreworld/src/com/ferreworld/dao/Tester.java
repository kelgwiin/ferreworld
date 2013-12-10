package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Producto;

@SuppressWarnings("unused")
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//INSERTAR PRODUCTOS
		try {
			DBConnector dbcon= new DBConnector();
			Connection con= dbcon.openConnection();
			ProductoDAO dao= new ProductoDAO(con);
			Producto myObj;
			
			myObj = dao.insertar("Lavadora ", "Gplus",25000.34, 56, true, 5);
			System.out.println(myObj);
			
			myObj = dao.insertar("Secadora ", "Regina",25000.34, 56, true, 5);
			System.out.println(myObj);
			
			myObj = dao.insertar("Nevera ", "LG",25000.34, 56, true, 5);
			System.out.println(myObj);
			
			dbcon.closeConnection();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

		
		
		//INSERTAR NUEVO CATEGORIA
//		try {
//			DBConnector dbcon= new DBConnector();
//			Connection con= dbcon.openConnection();
//			CategoriaDAO dao= new CategoriaDAO(con);
//			Categoria myObj;
//			
//			myObj = dao.insertar("Linea Blanca",true);
//						
//			System.out.println(myObj);
//			dbcon.closeConnection();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		

}


