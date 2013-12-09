package com.ferreworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ferreworld.model.Categoria;
import java.util.List;
import java.util.ArrayList;

public class CategoriaDAO {
	//Contiene los metodos de persistencia para las Categorias
		
		private Connection con;
		
				
		public CategoriaDAO() {
			super();
		}
		
		public CategoriaDAO(Connection con){
			this.con = con;
		}
	
	public Connection getConnection() {
			return con;
		}

		public void setConnection(Connection con) {
			this.con = con;
		}
	
	/**
	 * Actualiza la data de la tabla Categoria
	 * @param categoria
	 */
	public Categoria actualizar(Categoria upCat){
		return actualizar(upCat.getId(), upCat.getNombre(),upCat.isActivo());
	}
	/**
	 * Actualiza y retorna el objeto actualizado encapsulado en la clase
	 * categoria
	 * 
	 * @param id
	 * @param nombre
	 * @param activo
	 * @return el objeto actualizado
	 */
	public Categoria actualizar(Integer id, String nombre, Boolean activo){
		Categoria cat = null;
		String sql = "UPDATE categoria SET NOMBRE = ?, ACTIVO = ? WHERE ID = ?  ";
		 
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nombre);
			st.setString(2, (activo)?"A":"*" );
			st.setInt(3, id);
			
			if(st.executeUpdate() >= 1){
				cat = new Categoria();
				cat.setId(id);
				cat.setNombre(nombre);
				cat.setActivo(activo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}

	public Categoria insertar(String nombre, Boolean activo){		//insertar un objeto en la BD
		
		Categoria cat=null;
		String sql="INSERT INTO CATEGORIA (nombre, activo) VALUES (?,?) ";
		PreparedStatement st=null;
		try {
			st=con.prepareStatement(sql);
			st.setString(1, nombre);//se setean los valores en el preparedStatement segun
											// el tipo definido en la BD
			String myActivo=(activo) ? "A" : "*";//Si activo es true se asigna A sino *		
			st.setString(2, myActivo);
			int rows = st.executeUpdate();
			if(rows >= 1 ){
				cat=new Categoria();
				cat.setNombre(nombre);
				cat.setActivo(activo);
				
				//Recuperar el ID del Objeto que insertamos
				String idsql = "SELECT max(ID) FROM CATEGORIA ";
				ResultSet rs = st.executeQuery(idsql);
				if(rs.next()){
					cat.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    return cat;	
	}
	
	public Categoria eliminar(Categoria cat){
		return actualizar(cat.getId(), cat.getNombre(), false);
	}
	
	/**
	 * Dato un SQL y sus parámetro retorna la lista de los objetos 
	 * contenidos allí
	 * @param sql
	 * @param parms
	 * @return
	 */
	public List<Categoria> listar(String sql, Object[] params){
		List<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = null;
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			rs = st.executeQuery();
			
			while(rs.next()){
				Categoria cat = new Categoria();
				cat.setId(rs.getInt(1));
				cat.setNombre(rs.getString(2));
				cat.setActivo((rs.getString(3)).equals("*")?false:true);
				lista.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public List<Categoria> listar(Boolean activa){
		String sql = "SELECT ID, NOMBRE, ACTIVO" +
				" FROM CATEGORIA " +
				"WHERE ACTIVO = ? "; 
		Object[] objs = {(activa) ? "A" : "*"};
		return listar(sql, objs );
	}
	
	public Categoria buscar(String sql, Object[] params)
			throws FerreDAOException{
		Categoria cat=null;
		ResultSet  rs = null;
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			for (int i = 0; i < params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			
			rs = st.executeQuery();
			
			if(rs.next()){
				cat = new Categoria();
				cat.setId(rs.getInt(1));
				cat.setNombre(rs.getString(2));
				cat.setActivo((rs.getString(3)).equals("*")?false:true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FerreDAOException("Error en buscar ");
			
		}
		return cat;
	}
	
	public Categoria buscar(Integer id){
		Object[] obj = {id};
		return buscar("SELECT id, nombre, activo FROM CATEGORIA WHERE ID = ? ",
				obj);
	}
	 
}
