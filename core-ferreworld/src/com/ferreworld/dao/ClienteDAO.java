package com.ferreworld.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferreworld.model.Cliente;
import com.ferreworld.model.Producto;

public class ClienteDAO extends BaseDAO{
	
	public ClienteDAO() {
		super();
	}
	
	public ClienteDAO(Connection con){
		super();
		this.con = con; 
	}

	public Cliente insertar(String rifCi, String nombreRazon, String telefono, Boolean activo){		//insertar un objeto en la BD
	
	Cliente clie=null;
	String sql="INSERT INTO CLIENTE (rif_Ci, nombre_Razon, telefono, activo) VALUES (?,?,?,?) ";
	PreparedStatement st1=null;
	try {
		st1=con.prepareStatement(sql);
		st1.setString(1, rifCi);//se setean los valores en el preparedStatement segun
										// el tipo definido en la BD
		st1.setString(2, nombreRazon);
		st1.setString(3, telefono);		
		String myActivo=(activo) ? "A" : "*";//Si activo es true se asigna A sino *		
		st1.setString(4, myActivo);
		int rows =st1.executeUpdate();
		if(rows >= 1 ){
			clie=new Cliente();
			clie.setRifCi(rifCi);
			clie.setNombreRazon(nombreRazon);
			clie.setTelefono(telefono);
			clie.setActivo(activo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    return clie;	
	}
	
	public void eliminar(Integer id){
		String sql="UPDATE CLIENTE SET activo = '*' WHERE CLIENTE.id = ?";
		PreparedStatement st=null;
		
			try {
				st=con.prepareStatement(sql);
				st.setInt(1, id);
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	
	public Cliente actualizar(Integer id, String rifCi, String nombreRazon,
			String telefono, Boolean activo){
		
		Cliente c=null;
		String sql="UPDATE CLIENTE SET rif_ci = ?, nombre_razon = ?," +
						" telefono = ?, activo = ? "
						+ " WHERE id = ? ";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, rifCi);
			st.setString(2, nombreRazon);
			st.setString(3, telefono);
			st.setString(4, (activo)?"A":"*");
			st.setInt(5, id);
			
			if(st.executeUpdate()>=1){
				c= new Cliente();
				c.setRifCi(rifCi);
				c.setNombreRazon(nombreRazon);
				c.setTelefono(telefono);
				c.setActivo(activo);
				c.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FerreDAOException("Error al actualizar CLiente");
		}
		return c;
	}
	
	public Cliente actualizar(Cliente c){
		return actualizar(c.getId(), c.getRifCi(), c.getNombreRazon(), 
				c.getTelefono(),c.getActivo());
	}
	
	public List<Cliente> Listar(String sql, Object[] params){
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			ResultSet rs=null;
			
			PreparedStatement st= con.prepareStatement(sql);
			for (int i = 0; params!= null && i < params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			rs= st.executeQuery();
			
			while (rs.next()){
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setActivo(rs.getString("activo").equals("A")?true:false);
				c.setNombreRazon(rs.getString("nombre_razon"));
				c.setRifCi(rs.getString("rif_ci"));
				c.setTelefono(rs.getString("telefono"));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Cliente> listar(){
		return Listar("SELECT * FROM CLIENTE ", null);
	}
	
	public Cliente buscar(String sql, Object[] params){
		Cliente c=null;
		ResultSet rs=null;
		try {
			PreparedStatement st= con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			
			rs = st.executeQuery();
			if(rs.next()){
				c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setActivo(rs.getString("activo").equals("A")?true:false);
				c.setNombreRazon(rs.getString("nombre_razon"));
				c.setRifCi(rs.getString("rif_ci"));
				c.setTelefono(rs.getString("telefono"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FerreDAOException("Error buscar");
		}
		
		return c;
	}
	

}
