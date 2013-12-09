package com.ferreworld.logic;

import java.sql.SQLException;
import java.util.List;

import com.ferreworld.dao.CategoriaDAO;
import com.ferreworld.dao.DBConnector;
import com.ferreworld.dao.ProductoDAO;
import com.ferreworld.model.Producto;

public class ProductoServer {
	ProductoDAO dao;
	public ProductoServer() {
		super();
		try {
			dao = new ProductoDAO(new DBConnector().openConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Producto insertarProducto (String nombre, String marca,
									  Double ultimoCosto, Integer existencia,
									  Boolean activo, Integer categoriaId){
		return dao.insertar(nombre, marca, ultimoCosto, existencia,
				activo, categoriaId);
	}
	
	public void eliminarProducto(Producto p){
		dao.eliminar(p.getId());
	}
	
	public List<Producto> findProductoLikeNombre(String nomb){
		String sql = "SELECT * FROM PRODUCTO WHERE NOMBRE LIKE ?";
		Object[] par = {nomb};
//		return dao.listar(sql, par);
		return null;
	}
	
//	public List<Producto> findProductoByActivoAndCategoria(Boolean activo){
//	
//	}
	
	public void bloquearCategoria(Integer id){
		String sql = "SELECT ID FROM PRODUCTO WHERE CATEGORIA_ID = ? ";
		Object[] par = {id};
		ArrayList listProducto;
		
		listProducto = dao.listar(sql,par);
		
		for() 
		
		
		
	}
	
	

}
