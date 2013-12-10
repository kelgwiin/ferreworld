package core5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class B {

	public B() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> l = new ArrayList<String>();
		
		l.add("     Hola como estas.  ");
		l.add("Vivimos en Venezuela  estado Carabobo.   ");
		l.add("Actualmente nos encontramos en la academia de Sistemas   ");
		
		
		triml(l);
		
	}
	
	public static void triml(List<String> l){
		Iterator<String> it = l.iterator();
		String cad;
		while(it.hasNext()){
			cad = it.next();
			System.out.println("::" + cad +"::");
			System.out.println("::"+cad.trim()+"::");
		}
	}

}
