package com.ferreworld.dao;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Cliente;
import com.ferreworld.model.Producto;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		CategoriaDAO dao = new CategoriaDAO();
//		Categoria myObj=dao.insertar("Teclados",true);
//		System.out.println(myObj);
//		
		
		
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
