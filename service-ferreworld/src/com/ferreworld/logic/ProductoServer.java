package com.ferreworld.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferreworld.dao.CategoriaDAO;
import com.ferreworld.dao.DBConnector;
import com.ferreworld.dao.ProductoDAO;
import com.ferreworld.model.Categoria;
import com.ferreworld.model.Producto;

public class ProductoServer {
	
	ProductoDAO dao;

	public ProductoServer() {
		super();
		try {
			dao= new ProductoDAO(new DBConnector().openConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Producto insertarProducto(Producto cat){
		return dao.insertar(cat.getNombre(), cat.getMarca(),
				       cat.getUltimoCosto(), cat.getExistencia(),
				       cat.getActivo(), cat.getCategoria().getId());
	}
	
	public Producto insertarProducto(String nombre,String marca,
									Double ultimoCosto, Integer existe,
									Boolean activo, Integer idCat){
		return dao.insertar( nombre,marca,ultimoCosto, existe,
											activo, idCat);
	}
	
	public Producto actualizarProducto(Producto p){
		return dao.actualizar(p.getId(), p.getNombre(), p.getMarca(),
								p.getUltimoCosto(), p.getExistencia(),
								p.getActivo(), p.getCategoria().getId());
	}
	
    public Producto eliminarProducto(Producto p){
    	return dao.eliminar(p.getId());
    }
    
    public Producto getProductoByID(Integer id){
    	return dao.buscar(id);
    }
    
    public List<Producto> findProductoByActivo(Boolean activo){
    	String sql="SELECT * FROM PRODUCTO WHERE activo = ?";
    	Object[] params={(activo)?"A":"*"};
    	return dao.listar(sql,params);
    }   
    
    public List<Producto> findProductoLikeNombre(String nomb){
    	String sql="SELECT * FROM PRODUCTO WHERE nombre like ? ";
    	Object[] par= {nomb};
    	return dao.listar(sql, par);
    }
    
    public List<Producto> findProductoByActivoAndCategoria(Boolean activo, Integer idCat){
    	String sql="SELECT * FROM PRODUCTO WHERE activo = ? AND categoria_id = ? ";
    	Object[] par= {(activo)?"A":"*", idCat};
    	return dao.listar(sql, par);
    }
	/**
	 * Anula 
	 * @param idCategoria
	 * @return Una lista con el objeto categoria actualizado y una lista con 
	 * los productos asociados
	 */
    public  List<Object> anularCategoria(Integer idCategoria){
    	String sql = "UPDATE PRODUCTO SET activo = ? WHERE "
    			+ "categoria_id = ? ";
    	CategoriaDAO daoCat=null;
    	Categoria cat;
    	ArrayList<Object> catProdActualizado = new ArrayList<>(); 
    	
    	//desactivando categoria
		daoCat= new CategoriaDAO(dao.getCon());
		cat = daoCat.buscar(idCategoria);
		cat.setActivo(false);
		catProdActualizado.add(cat);
		daoCat.actualizar(cat);
		
		//desactivar items asociado a la categoria
		Object[] par = {"*",idCategoria};
		
		if(dao.actualizar(sql, par) >= 1){
			String sqlListar = "SELECT * FROM PRODUCTO WHERE categoria_id = ?";
			par = new Object[1];
			par[0] = idCategoria;
			catProdActualizado.add(dao.listar(sqlListar, par));
		}
    	return catProdActualizado;
    }
    /**
	 * Activa
	 * @param idCategoria
	 * @return Una lista con el objeto categoria actualizado y una lista con 
	 * los productos asociados
	 */
    public  List<Object> activarCategoria(Integer idCategoria){
    	String sql = "UPDATE PRODUCTO SET activo = ? WHERE "
    			+ "categoria_id = ? ";
    	CategoriaDAO daoCat=null;
    	Categoria cat;
    	ArrayList<Object> catProdActualizado = new ArrayList<>(); 
    	
    	//activando categoria
		daoCat= new CategoriaDAO(dao.getCon());
		cat = daoCat.buscar(idCategoria);
		cat.setActivo(true);
		catProdActualizado.add(cat);
		daoCat.actualizar(cat);
		
		//activar items asociado a la categoria
		Object[] par = {"A",idCategoria};
		
		if(dao.actualizar(sql, par)>= 1){
			String sqlListar = "SELECT * FROM PRODUCTO WHERE categoria_id = ?";
			par = new Object[1];
			par[0] = idCategoria;
			catProdActualizado.add(dao.listar(sqlListar, par));
		}
    	return catProdActualizado;
    }	

}
