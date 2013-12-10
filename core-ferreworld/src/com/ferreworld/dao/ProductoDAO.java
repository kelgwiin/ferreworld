package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferreworld.model.Categoria;
import com.ferreworld.model.Producto;



public class ProductoDAO extends BaseDAO{

	public ProductoDAO() {
		super();
		
	}

	public ProductoDAO(Connection con) {
		super(con);
		
	}
	
	public Producto insertar(String nombre, String marca,Double ultimoCosto,
								Integer existencia, Boolean activo, 
								Integer categoriaID) throws FerreDAOException{
		Producto p= null;
		String sql="INSERT INTO Producto (nombre, marca, ultimo_costo," +
				" existencia, activo, categoria_id) VALUES (?,?,?,?,?,?) ";
		PreparedStatement st= null;
		ResultSet rs= null;
		
		try {
			st= con.prepareStatement(sql);
			st.setString(1, nombre); 
			st.setString(2, marca);
			st.setDouble(3, ultimoCosto);
			st.setInt(4, existencia);
			String myActivo= (activo) ? "A" : "*";
			st.setString(5,myActivo);
			st.setInt(6, categoriaID);
			
			int rows= st.executeUpdate();
			if(rows >= 1){
				p= new Producto();
				p.setNombre(nombre);
				p.setMarca(marca);
				p.setActivo(activo);
				p.setUltimoCosto(ultimoCosto);
				p.setExistencia(existencia);
				p.setCategoria(new CategoriaDAO(con).buscar(categoriaID));
				//recuperar el ID del objeto que insertamos
				String idsql="SELECT max(ID) FROM producto";
				rs=st.executeQuery(idsql);
				if(rs.next()){
					p.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FerreDAOException("Ha ocurrido un error", e);
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return p;
	}

	
	public Producto actualizar(Integer id, String nombre, String marca,
							Double ultimoCosto, Integer existencia,
							Boolean activo, Integer categoriaID){
		Producto p=null;
		String sql="UPDATE Producto SET nombre = ?, marca = ?," +
						" ultimo_costo = ?, existencia = ?, " +
						"activo = ?, categoria_id = ? WHERE id = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nombre);
			st.setString(2, marca);
			st.setDouble(3, ultimoCosto);
			st.setInt(4, existencia);
			st.setString(5, (activo)?"A":"*" );
			st.setInt(6, categoriaID);
			st.setInt(7, id);
			if(st.executeUpdate()>=1){
				p= new Producto();
				p.setId(id);
				p.setNombre(nombre);
				p.setMarca(marca);
				p.setActivo(activo);
				p.setUltimoCosto(ultimoCosto);
				p.setExistencia(existencia);
				p.setCategoria(new CategoriaDAO(con).buscar(categoriaID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public List<Producto> listar(String sql, Object[] params){
		List<Producto> lista= new ArrayList<Producto>();
		ResultSet rs=null;
		
			try {
				PreparedStatement st= con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					st.setObject(i+1, params[i]);
				}
				rs= st.executeQuery();
				while(rs.next()){
					Producto p= new Producto();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setMarca(rs.getString("marca"));
					p.setUltimoCosto(rs.getDouble("ultimo_costo"));
					p.setExistencia(rs.getInt("existencia"));
					p.setActivo((rs.getString("activo").equals("*")?false:true));
					p.setCategoria(new CategoriaDAO(con).buscar(rs.getInt("categoria_id")));
					lista.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return lista;
	}
	
	public Producto buscar(String sql, Object[] params){
		ResultSet rs=null;
		Producto p=null;
			try {
				PreparedStatement st= con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					st.setObject(i+1, params[i]);
				}
				rs= st.executeQuery();
				if(rs.next()){
					p= new Producto();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setMarca(rs.getString("marca"));
					p.setUltimoCosto(rs.getDouble("ultimo_costo"));
					p.setExistencia(rs.getInt("existencia"));
					p.setActivo((rs.getString("activo").equals("*")?false:true));
					p.setCategoria(new CategoriaDAO(con).buscar(rs.getInt("categoria_id")));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return p;
	}
	
	public Producto buscar(Integer id){
		String sql="SELECT * FROM producto WHERE id= ?";
		Object[] param={id};
		return  buscar(sql, param);
	}
	
	public Producto eliminar(Integer id){
		Producto p = buscar(id);
		return actualizar(id, p.getNombre(), p.getMarca(), 
				p.getUltimoCosto(), p.getExistencia(), false, 
				p.getCategoria().getId());
		
	}
	
	

}
