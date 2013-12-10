package com.ferreworld.model;

public class Cliente {
	
	private Integer id;
	private String rifCi;
	private String nombreRazon;
	private String telefono;
	private Boolean activo;
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRifCi() {
		return rifCi;
	}
	public void setRifCi(String rifCi) {
		this.rifCi = rifCi;
	}
	public String getNombreRazon() {
		return nombreRazon;
	}
	public void setNombreRazon(String nombreRazon) {
		this.nombreRazon = nombreRazon;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return "ID: "+id + " : " +rifCi+ " : "+nombreRazon+ 
		" : "+telefono + " : "+activo;
	}
	

}
