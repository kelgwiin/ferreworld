package com.ferreworld.model;

public class Categoria {
	private Integer id;
	private String nombre;
	private boolean activo;
	
	public Categoria(Integer id, String nombre, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}
	
	public Categoria(){
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	} 
	

}
