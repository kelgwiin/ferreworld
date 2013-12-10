package core3;

public class B {

	public B() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayOfInts = {8,5,6,1,3};
		boolean es;
		for (int i = 0; i < arrayOfInts.length-1; i++) {
			/**
			 * Posee el operador de comparaci�n de mayor, el cual permite
			 * comparar el elemento del array en la posici�n i con el de la 
			 * posici�n i+1, y en caso de que el de la i sea mayor retorna 
			 * verdadero en caso contrario falso
			 */
			es = arrayOfInts[i] > arrayOfInts[i+1];
			Util.println(arrayOfInts[i] + " > "+ arrayOfInts[i+1] + " = " + es);
			
		}
		
		//----------
		int i = 10 ;
		int n = ++i%5;
		
		System.out.printf("n %d i %d %d ", n,i, (11%5));
		/*n da como residuo cero cuando uno pensar�a que deber�a ser uno 
		 * ello se debe a que el incremento i++  incrementa y luego en una
		 * estapa posterior asigna, y miestras no hab�a asignado se hizo la
		 * operaci�n de obtener el residuo. 
		 * 
		 * Caso contrario cuando se encuentra precedido de la variable, all�
		 * incrementa y asigna de una vez
		 */
		
		//Para invertir el valor booleano.
		boolean valorBooleano = false;
		Util.print("Boolean " + valorBooleano + " Invertido " + (!valorBooleano) + " \n");
		
		//Condicional ternario de una linea
		int dd = 2, ee = 3;
		ee = dd > ee ? 30:32;
		Util.println("Resultado de la comparacion ternario " + ee);
		
		/* En este caso se eval�a la condici�n que se encuentra antes del
		 * signo de interrogaci�n si es verdad a ee se le asigna 30 (el valor
		 * de la izquierda) sino 32 (lado derecho despu�s de los dos puntos)
		 * 
		 */
	}

}
