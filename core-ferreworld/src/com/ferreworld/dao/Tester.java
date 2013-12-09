package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Cliente;
import com.ferreworld.model.Producto;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnector dbcon = new DBConnector();
		Connection con = null;
		try {
			con = dbcon.openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CategoriaDAO dao = new CategoriaDAO(con);
		Categoria myObj=dao.insertar("Plomeria",true);
		System.out.println(myObj);
		
		dbcon.closeConnection();
		
		
//		ProductoDAO daoo = new ProductoDAO();
//		Categoria cate = new Categoria(2,"Teclados",true);
//		Producto myPro=daoo.insertar("Teclado escritorio", "Lenovo", 6.30, 105, true, cate);		
//		System.out.println(myPro);
		
//		
		ClienteDAO daooo = new ClienteDAO();
		Cliente myClie=daooo.insertar("V-19594416-1", "Elier", "04127628002", true);
		System.out.println(myClie);
//		
//		
		//Eliminar Categoria
//		CategoriaDAO dao_cat = new CategoriaDAO();
//		dao_cat.eliminar(2);
//		
//		Eliminar Cliente
//		ClienteDAO daooooo = new ClienteDAO();
//		daooooo.eliminar(1);
		System.out.println("FIN");
	}

}
