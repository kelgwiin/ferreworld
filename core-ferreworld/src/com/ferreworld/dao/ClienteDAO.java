package com.ferreworld.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ferreworld.model.Cliente;

public class ClienteDAO extends BaseDAO{
	
	public ClienteDAO() {
		super();
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
	
	

}
