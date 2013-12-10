package core3;

public class C {

	public C() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 3;
        i++;
        System.out.println(i);    // "4"
        ++i;                     
        System.out.println(i);    // "5"
        System.out.println(++i);  // "6"
        System.out.println(i++);  // "6"
        System.out.println(i);    // "7"
        
        /* Se imprime 6 dos veces porque en la linea 18 se hace el incremento
         * que asigna el incremento en una etapa posterior, sigue el patron 
         * INCREMENTO Y LUEGO ASIGNO
         * ejecutandose primero la operación de imprimir y luego se
         * asigna efectivamente
         * 
         */
	}

}
