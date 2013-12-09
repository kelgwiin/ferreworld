package com.ferreworld.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.ferreworld.model.Cliente;

public class ClienteDAO {
	
	private Connection cone;
	
	
	public ClienteDAO() {
		super();
		this.openConnection();//cuando instanciamos el objeto tenemos la conexion creada
	}
	//metodo para abrir la conexion
	public void openConnection(){
		try {
			cone=DriverManager.getConnection("jdbc:mysql://localhost:3306/academiabd", "admin", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//metodo para cerrar la conexion
	public void closeConnection(){
		if(cone!=null){
			try {
				cone.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public Cliente insertar(String rifCi, String nombreRazon, String telefono, Boolean activo){		//insertar un objeto en la BD
	
	Cliente clie=null;
	String sql="INSERT INTO CLIENTE (rif_Ci, nombre_Razon, telefono, activo) VALUES (?,?,?,?) ";
	PreparedStatement st1=null;
	try {
		st1=cone.prepareStatement(sql);
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
				st=cone.prepareStatement(sql);
				st.setInt(1, id);
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	
	

}
