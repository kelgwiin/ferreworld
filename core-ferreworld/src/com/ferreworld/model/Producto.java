package com.ferreworld.model;

public class Producto {
	private Integer id;
	private String nombre;
	private String marca;
	private Double ultimoCosto;
	private Integer existencia;
	private Boolean activo;
	private Categoria categoria;
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(Integer id){
		this.id = id;
	}
	
	public Producto (Integer id, Categoria categoria){
		this.id = id;
		this.categoria = categoria;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getUltimoCosto() {
		return ultimoCosto;
	}

	public void setUltimoCosto(Double ultimoCosto) {
		this.ultimoCosto = ultimoCosto;
	}

	public Integer getExistencia() {
		return existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
