package core6;

public class Cuenta {
	private long saldo;
	private String clave;
	private String nombre;

	public Cuenta(long saldo, String clave, String nombre) {
		// TODO Auto-generated constructor stub
		this.saldo = saldo;
		this.clave = clave;
		this.nombre = nombre;
	}
	
	public long getSaldo() {
		return saldo;
	}


	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
