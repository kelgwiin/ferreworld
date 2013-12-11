package core3;

public class D {

	public D() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) { 
	      int i, j=1;
	      i = (j>1)?2:1;
	      switch(i) {
	        case 0: System.out.println(0); break;
	        case 1: System.out.println(1);
	        case 2: System.out.println(2); break;
	        case 3: System.out.println(3); break;
	      }
	      
	      /** Aquí en el case de uno (1) falto el break por ende se ejecuta 
	       * pero no sale porque se ha encontrado uno, entonces se ejecuta
	       * el siguiente case de 2 y como sí tiene break sale del switch
	       * 
	       * He aquí la importancia de no obviar ningún break en los switch
	       * 
	       */
	}
}
