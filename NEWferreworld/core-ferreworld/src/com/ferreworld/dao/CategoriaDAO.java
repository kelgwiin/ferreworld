package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferreworld.model.Categoria;


public class CategoriaDAO extends BaseDAO{
	
	public CategoriaDAO() {
		super();
		
	}
	
	public CategoriaDAO(Connection newConn){
		super(newConn);
	}
	
	//Contiene los metodos de persistencia para las Categorias
	public Categoria insertar(String nombre, Boolean activo){
		String sql="INSERT INTO CATEGORIA (nombre, activo) VALUES (?,?) ";
		PreparedStatement st= null;
		Categoria cat=null;
		
		try {
			st= con.prepareStatement(sql);
			st.setString(1, nombre);    //se settean los valores en el
			                            //preparedStatement seg�n el TIPO 
										//definido en la Base de Datos
			
			String myActivo= (activo) ? "A" : "*";
			st.setString(2,myActivo);
			
			int rows= st.executeUpdate();
			if(rows >= 1){
				cat= new Categoria();
				cat.setNombre(nombre);
				cat.setActivo(activo);
				//recuperar el ID del objeto que insertamos
				String idsql="SELECT max(ID) FROM CATEGORIA";
				ResultSet rs= st.executeQuery(idsql);
				if(rs.next()){
					cat.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat;
		
	}
	
	
	public Categoria actualizar(Integer id, String nombre, Boolean activo){
		Categoria cat=null;
		String sql="UPDATE CATEGORIA SET nombre = ?, activo = ? WHERE id = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nombre);
			st.setString(2, (activo)?"A":"*" );
			st.setInt(3, id);
			if(st.executeUpdate()>=1){
				cat= new Categoria();
				cat.setId(id);
				cat.setNombre(nombre);
				cat.setActivo(activo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}
	
	public List<Categoria> listar(Boolean activa){
		
		String sql="SELECT id, nombre, activo FROM CATEGORIA WHERE activo = ?";
		Object[] pars= {(activa)?"A":"*"};
		return listar(sql, pars);
		
	}
	
	public List<Categoria> listar(String sql, Object[] params){
		List<Categoria> lista= new ArrayList<Categoria>();
		ResultSet rs=null;
		
			try {
				PreparedStatement st= con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					st.setObject(i+1, params[i]);
				}
				rs= st.executeQuery();
				while(rs.next()){
					Categoria cat= new Categoria();
					cat.setId(rs.getInt("id"));
					cat.setNombre(rs.getString("nombre"));
					cat.setActivo((rs.getString("activo").equals("*")?false:true));
					lista.add(cat);
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
	
	public Categoria buscar(String sql, Object[] params){
		Categoria cat= null;
		ResultSet rs=null;
		
		try {
			PreparedStatement st= con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			rs= st.executeQuery();
			if(rs.next()){          //SOLO DEVUELVE 1 VALOR
				cat= new Categoria();
				cat.setId(rs.getInt(1));
				cat.setNombre(rs.getString(2));
				cat.setActivo((rs.getString(3).equals("*")?false:true));
				
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
		
		return cat;
	}
	
	public Categoria buscar(Integer id){
		String sql="SELECT id, nombre, activo FROM CATEGORIA WHERE id= ?";
		Object[] param={id};
		return  buscar(sql, param);
	}
	
	
	
	public Categoria eliminar(Categoria cat){
		return actualizar(cat.getId(), cat.getNombre(), false);
	}
	
	public Categoria actualizar(Categoria upCat){
	     return  	actualizar(upCat.getId(), upCat.getNombre(),
	    		 						upCat.getActivo());
	}
	
	
	

}
