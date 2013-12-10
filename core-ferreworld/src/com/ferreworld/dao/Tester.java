package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Producto;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			DBConnector dbcon= new DBConnector();
			Connection con= dbcon.openConnection();
			CategoriaDAO dao= new CategoriaDAO(con);
			//Categoria myObj= new Categoria(3,"Plomeria",true);
			//myObj= dao.eliminar(myObj);
			
			/*String sql="SELECT id, nombre, activo FROM categoria WHERE nombre like ? AND id > ?";
			Object[] params= {"%as%", 3};
			List<Categoria> listado= dao.listar(sql, params);
			for (Categoria categoria : listado) {
				System.out.println(categoria);
			}*/
			
			ProductoDAO dao2 = new ProductoDAO(con);
			Producto p=dao2.actualizar(1,"Candado persina 120 mm", "Cisa", 200.0, 25, true, 5);
			
			System.out.println(p);
			dbcon.closeConnection();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
