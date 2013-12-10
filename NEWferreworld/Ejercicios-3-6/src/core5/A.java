package core5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class A {

	public A() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		for (int i = 0; i < args.length; i++) {
			l.add(i);
		}
		
		Collections.shuffle(l);
		
		Iterator<Integer> it = l.iterator();
		
		while(it.hasNext()){
			 System.out.println(args[it.next()]);
		}
		
		
	}

}
