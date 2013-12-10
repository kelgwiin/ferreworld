package core3;

public class A {
	private int var1;
	private double var2;
	
	//Seccion con campos ilegales
	//private int case;
	//protected float default;
	
	//fin de seccion con campos ilegales
	
	public static void main (String ars[]){
		A un = new A();
		un.print();
		un = new A(50,10.5);
		
		System.out.println("Otro Objeto");
		un.print();
		
		//Imprimiendo valores sin inicializar
		//float dd;
		
		//al tratar de imprimir arroja un error porque no se ha inicializado
		//System.out.printf(" Valor vacío %f \n",dd);
	}
	public A(){
		var1 = 1233;
		var2 = 2132.23;
	}
	
	public A(int var1, double var2){
		this.var1 = var1;
		this.var2 = var2;
	}
	public int getVar1() {
		return var1;
	}
	public void setVar1(int var1) {
		this.var1 = var1;
	}
	public double getVar2() {
		return var2;
	}
	public void setVar2(float var2) {
		this.var2 = var2;
	}
	
	public void print(){
		System.out.printf("Datos de las variables %d %f \n",var1, var2);
	}
	
	//Creación de case con nombre ilegal y metodos con nombres no permitidos
	/**
	public class switch{
		private int dato;
		private char 1d;
		
		public switch(){
			dato = 1234;
		}
		
		public void **333(){
			System.out.println("Hola")
		}
	}
	*/
	
}
