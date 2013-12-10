package com.ferreworld.logic;

import java.sql.SQLException;
import java.util.List;

import com.ferreworld.dao.DBConnector;
import com.ferreworld.dao.ProductoDAO;
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
    	String sql="SELECT * FROM Producto WHERE activo = ?";
    	Object[] params={(activo)?"A":"*"};
    	return dao.listar(sql,params);
    }   
    
    public List<Producto> findProductoLikeNombre(String nomb){
    	String sql="SELECT * FROM Producto WHERE nombre like ? ";
    	Object[] par= {nomb};
    	return dao.listar(sql, par);
    }
    
    public List<Producto> findProductoByActivoAndCategoria(Boolean activo, Integer idCat){
    	String sql="SELECT * FROM Producto WHERE activo = ? AND categoria_id = ? ";
    	Object[] par= {(activo)?"A":"*", idCat};
    	return dao.listar(sql, par);
    }
	
	

}
