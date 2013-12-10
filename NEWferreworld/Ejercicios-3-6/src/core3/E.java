package core3;

public class E {

	public E() {
		// TODO Auto-generated constructor stub
	}
	
	  public static void main(String args[]) {
	      for(int i = 0; i < 2; i++) {
	         for(int j = 2; j>= 0; j--) { 
	        	if(i == j) {
	        		System.out.println(i  + "--- " +j);
	        		break;
	        	}
	            System.out.println("i=" + i + " j="+j);
	         }
	      }
	      
	      /**
	       * En este caso la asignación de los i y j se hace a llegar al fin de cada 
	       * ciclo a diferencia que el ejercico anterior que a la siguiente instruccion
	       * ya se asignada el valor que había quedado pendiente
	       */
	   }

}
