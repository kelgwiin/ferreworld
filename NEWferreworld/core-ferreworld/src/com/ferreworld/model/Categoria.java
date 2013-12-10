package com.ferreworld.model;

public class Categoria {
	
	private Integer id;
	private String nombre;
	private Boolean activo;
	
	
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(Integer id) {
		super();
		this.id = id;
	}
	public Categoria(Integer id, String nombre, Boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		
		return "ID: "+id+ " - Nombre: "+ nombre +", Activa: "+ activo;
	}
	
	
	
	

}
