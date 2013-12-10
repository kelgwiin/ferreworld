package com.ferreworld.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ferreworld.model.Cliente;
import com.ferreworld.model.Producto;

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
	
	
	
	public void actualizar(){
		Producto p=null;
		String sql="UPDATE PRODUCTO SET nombre = ?, marca = ?," +
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
	
	

}
