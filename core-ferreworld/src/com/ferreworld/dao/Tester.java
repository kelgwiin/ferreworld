package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Cliente;
import com.ferreworld.model.Producto;

@SuppressWarnings("unused")
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		DBConnector dbcon = new DBConnector();
		Connection con = null;
		try {
			con = dbcon.openConnection();
			//INI
			ProductoDAO prod = new ProductoDAO(con);
			String sql="INSERT INTO PRODUCTO (nombre, marca, ultimo_costo, existencia,"
					+ " activo, categoria_id) VALUES (?,?,?,?,?,?) ";
			
			
			prod.insertar("Lavadora ", "Gplus", 35000.45,
					23, true, 10);
			//FIN
			
			dbcon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FIN");
	}
	
	
	public static void testCategoriaDAO(){
//		//BUSCAR
//		DBConnector dbcon = new DBConnector();
//		Connection con = null;
//		try {
//			String sql = "SELECT id, nombre, activo FROM CATEGORIA WHERE ID = ? ";
//			con = dbcon.openConnection();
//			CategoriaDAO dao = new CategoriaDAO(con);
//			Object[] lparams = {1};
//			
//			Categoria cat = dao.buscar(sql, lparams);
//			System.out.println(cat);
//			
//			dbcon.closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		LISTAR GENERICO
//		DBConnector dbcon = new DBConnector();
//		Connection con = null;
//		try {
//			String sql = "SELECT id, nombre, activo FROM CATEGORIA WHERE ID = ? ";
//			con = dbcon.openConnection();
//			CategoriaDAO dao = new CategoriaDAO(con);
//			Object[] lparams = {2};
//			
//			ArrayList<Categoria> l = (ArrayList<Categoria>)dao.
//					listar(sql, lparams);
//			
//			for (Categoria itemCat : l) {
//				System.out.println(itemCat);
//			}
//			
//			dbcon.closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//LISTAR
//		DBConnector dbcon = new DBConnector();
//		Connection con = null;
//		try {
//			con = dbcon.openConnection();
//			CategoriaDAO dao = new CategoriaDAO(con);
//			ArrayList<Categoria> l = (ArrayList<Categoria>)dao.listar(true);
//			
//			for (Categoria itemCat : l) {
//				System.out.println(itemCat);
//			}
//			
//			dbcon.closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		
		
		
//		DBConnector dbcon = new DBConnector();
//		Connection con = null;
//		try {
//			con = dbcon.openConnection();
//			CategoriaDAO dao = new CategoriaDAO(con);
//			Categoria myObj=dao.insertar("Linea Gris",true);
//			System.out.println(myObj);
//			
//			dbcon.closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
//		Actualizar Categoria 
//		DBConnector dbcon = new DBConnector();
//		Connection con = null;
//		try {
//			con = dbcon.openConnection();
//			CategoriaDAO dao = new CategoriaDAO(con);
//			Categoria myObj= new Categoria (3, "Oficina Premiun", true);
//			myObj = dao.actualizar(myObj);
//			
//			System.out.println(myObj);
//			dbcon.closeConnection();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		
//		
		
//		ProductoDAO daoo = new ProductoDAO();
//		Categoria cate = new Categoria(2,"Teclados",true);
//		Producto myPro=daoo.insertar("Teclado escritorio", "Lenovo", 6.30, 105, true, cate);		
//		System.out.println(myPro);
		
//		
//		ClienteDAO daooo = new ClienteDAO();
//		Cliente myClie=daooo.insertar("V-19594416-1", "Elier", "04127628002", true);
//		System.out.println(myClie);
//		
//		
		//Eliminar Categoria
//		CategoriaDAO dao_cat = new CategoriaDAO();
//		dao_cat.eliminar(2);
//		
//		Eliminar Cliente
//		ClienteDAO daooooo = new ClienteDAO();
//		daooooo.eliminar(1);
	}

}



