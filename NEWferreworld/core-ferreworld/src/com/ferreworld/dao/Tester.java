package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Cliente;
import com.ferreworld.model.Producto;

@SuppressWarnings("unused")
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//LISTAR PRODUCTOS
		try {
			DBConnector dbcon= new DBConnector();
			Connection con= dbcon.openConnection();
			ClienteDAO dao= new ClienteDAO(con);
			Cliente cl;
			
			List<Cliente> l = dao.listar();
			for (Cliente cliente : l) {
				System.out.println(cliente);
			}
			
			dbcon.closeConnection();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		//ACTUALIZAR PRODUCTOS
//		try {
//			DBConnector dbcon= new DBConnector();
//			Connection con= dbcon.openConnection();
//			ClienteDAO dao= new ClienteDAO(con);
//			Cliente cl;
//			
//			cl = dao.actualizar(2, "20542093", "Kelwin Roberto Gamez ","042644844824", true);
//			
//			System.out.println(cl);
//			
//			dbcon.closeConnection();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//INSERTAR PRODUCTOS
//		try {
//			DBConnector dbcon= new DBConnector();
//			Connection con= dbcon.openConnection();
//			ProductoDAO dao= new ProductoDAO(con);
//			Producto myObj;
//			
//			myObj = dao.insertar("Lavadora ", "Gplus",25000.34, 56, true, 5);
//			System.out.println(myObj);
//			
//			myObj = dao.insertar("Secadora ", "Regina",25000.34, 56, true, 5);
//			System.out.println(myObj);
//			
//			myObj = dao.insertar("Nevera ", "LG",25000.34, 56, true, 5);
//			System.out.println(myObj);
//			
//			dbcon.closeConnection();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		

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


