package core4;

public class A_String implements CharSequence{

	//MAIN
	public static void main (String ars[]){
		A_String cad = new A_String("camioneta");
		
		//Subcadena
		System.out.println(cad.subSequence(2,5).toString());
		System.out.println(((A_String) cad.subSequence(2)).getChain());
		
		//charAt
		System.out.println(cad.charAt(2));
		
		//length
		System.out.println(cad.length());
		
		//backwards
		System.out.println(cad.backwards().getChain());
		
	}
	
	//METODOS DE CLASE
	
	private char[] chain;
	
	public A_String(char[] chain ) {
		this.chain = chain;
	}
	
	public A_String(String chain){
		this.chain = chain.toCharArray();
	}
	
	public char[] getChain(){
		return chain;
	}
	
	@Override
	public char charAt(int arg0) {
		// TODO Auto-generated method stub
		return chain[arg0];
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return chain.length;
	}

	@Override
	public CharSequence subSequence(int begin, int end) {
		// TODO Auto-generated method stub
		char[] newChain = new char[end-begin+1];
		
		for (int i = 0; i < newChain.length; i++, begin++){
			newChain[i] = chain[begin];
		}
		
		return new A_String(newChain);
	}
	
	public CharSequence subSequence(int begin) {
		char[]  newChain = new char[this.chain.length - begin];
		
		for(int i = 0; i < newChain.length; i++, begin++){
			newChain[i] = chain[begin];
		}
		
		return new A_String(newChain);
	}
	
	public A_String backwards(){
		char[] newChain = new char[chain.length];
		int j = 0;
		for (int i = chain.length-1; i >= 0; i--, j++) {
			newChain[i] = chain[j];
		}
		return new A_String(newChain);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String(chain);
	}

}
