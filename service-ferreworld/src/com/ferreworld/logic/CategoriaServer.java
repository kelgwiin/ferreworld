package com.ferreworld.logic;

import java.sql.SQLException;
import java.util.List;

import com.ferreworld.dao.CategoriaDAO;
import com.ferreworld.dao.DBConnector;
import com.ferreworld.model.Categoria;

public class CategoriaServer {
	
	CategoriaDAO dao;

	public CategoriaServer() {
		super();
		try {
			dao= new CategoriaDAO(new DBConnector().openConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Categoria insertarCategoria(Categoria cat){
		return dao.insertar(cat.getNombre(), cat.getActivo());
	}
	
	public Categoria insertarCategoria(String nombre, Boolean activo){
		return insertarCategoria(new Categoria(null, nombre, activo));
	}
	
	public Categoria actualizarCategoria(Categoria cat){
		return dao.actualizar(cat);
	}
	
    public Categoria eliminarCategoria(Categoria cat){
    	return dao.eliminar(cat);
    }
    
    public Categoria getCategoriaByID(Integer id){
    	return dao.buscar(id);
    }
    
    public List<Categoria> findCategoriaByActivo(Boolean activo){
    	return dao.listar(activo);
    }   
    
    public List<Categoria> findCategoriaLikeNombre(String nomb){
    	String sql="SELECT * FROM Categoria WHERE nombre like ? ";
    	Object[] par= {nomb};
    	return dao.listar(sql, par);
    }

}
