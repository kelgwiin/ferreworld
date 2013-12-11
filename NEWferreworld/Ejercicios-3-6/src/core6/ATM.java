package core6;

import java.util.HashMap;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM cajero = new ATM();
		Scanner cin = new Scanner(System.in);
		int op;
		
		System.out.println("MENU:");
		System.out.println("1.- Consultar Saldo.");
		System.out.println("2.- Retiro de Dinero.");
		System.out.println("3.- Cambiar Clave.\n");
		System.out.println("4.- Salir.\n");
		
		System.out.println("\nPulse una opcion \n");
		
		op = cin.nextInt();
		String numcuenta, clave;
		long dinero=0, saldo_retirar=0;
		boolean claveCorrecta = true;
		do{
			switch(op){
			case 1:
				
				System.out.println("-----------------");
				System.out.println("Consultar Saldo: ");
				System.out.println("-----------------");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
				System.out.print("Ingrese numero de cuenta: ");
				numcuenta = cin.next();
				
				System.out.print("Ingrese clave: ");
				clave = cin.next();
				
				
				
				try {
					dinero = cajero.consultarSaldo(numcuenta, clave);					
				} catch (ATMexceptions e) {
					claveCorrecta = false;
					System.out.println(e.getMessage());
				}
				
				if(claveCorrecta){
					System.out.printf("Sr.(a) %s usted dispone de: %d \n \n",cajero.
							getOwnerCuenta(numcuenta), dinero);
				}
				
				
				break;
				
			case 2:
				System.out.println("-----------------");
				System.out.println("Retirando: ");
				System.out.println("-----------------");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
				System.out.print("Ingrese numero de cuenta: ");
				numcuenta = cin.next();
				
				System.out.print("Ingrese clave: ");
				clave = cin.next();
				
				System.out.print("Saldo retirar: ");
				saldo_retirar = cin.nextInt();
				
				try {
					cajero.retirar(numcuenta, clave, saldo_retirar);
				} catch (ATMexceptions e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
				
				break;
			case 3:
				String cambioClave;
				System.out.println("-----------------");
				System.out.println("Cambiar Clave: ");
				System.out.println("-----------------");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
				System.out.print("Ingrese numero de cuenta: ");
				numcuenta = cin.next();
				
				System.out.print("Ingrese clave anterior: ");
				clave = cin.next();
				
				System.out.print("Ingrese nueva clave: ");
				cambioClave = cin.next();
				
				try {
					cajero.cambiarClave(numcuenta, clave, cambioClave);
				} catch (ATMexceptions e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			default: System.out.println("Opción Inválida \n");
			}
			
			System.out.println("\n\nMENU:");
			System.out.println("1.- Consultar Saldo.");
			System.out.println("2.- Retiro de Dinero.");
			System.out.println("3.- Cambiar Clave.\n");
			System.out.println("4.- Salir.\n");
			op = cin.nextInt();
		}while(op != 4);
		
		System.out.println("Fin");
		cin.close();
	}
	
	/**
	 * Es un hashmap <br>
	 * key = numero de cuenta <br>
	 * data = es un objeto del tipo cuenta.
	 */
	private HashMap<String,Cuenta> listaCuentas;
	private ATMexceptions errorClave, errorMonto;
	
	public ATM (){
		listaCuentas = new HashMap<String, Cuenta>();
		listaCuentas.put("112233445566", new Cuenta(20000, "1234", "Luis Gonzales"));
		listaCuentas.put("112233445567", new Cuenta(25000, "1235", "Joalbert Restrepo"));
		listaCuentas.put("112233445568", new Cuenta(5000, "1236", "Andrez Betancourt"));
		listaCuentas.put("112233445569", new Cuenta(1500, "1237", "Jesus Perez"));
		listaCuentas.put("112233445510", new Cuenta(2500, "1238", "Juan Carlos Jimenez"));
		listaCuentas.put("112233445511", new Cuenta(614, "1239", "Luis Gonzales"));
		
		
		errorClave = new ATMexceptions("Error: La clave ingresada no coincide");
		errorMonto = new ATMexceptions("Error: Monto insuficiente");
		
	}
	
	public ATM (HashMap<String, Cuenta> lc){
		this.listaCuentas = lc;
	}
	public HashMap<String, Cuenta> getCuenta() {
		return listaCuentas;
	}
	
	public void setCuenta(HashMap<String, Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	
	//metodos principales
	public long consultarSaldo(String numCta, String clave) throws ATMexceptions{
		Cuenta cta = validar(numCta, clave);
		return cta.getSaldo();
	}
	
	public void retirar(String numCta, String clave, long monto)throws ATMexceptions{
		Cuenta cta = validar(numCta, clave);
		long saldoTotal;
		
		saldoTotal = cta.getSaldo();
		
		if(!(saldoTotal > monto)){
			throw errorMonto;
		}else{
			cta.setSaldo(saldoTotal - monto);
			System.out.printf("Sr(a). %s usted ha retirado de su cuenta \n",
					getOwnerCuenta(numCta));
			
			System.out.printf(" Saldo anterior %d \n",saldoTotal);
			System.out.printf(" Saldo actual %d \n\n",saldoTotal-monto);
		}
	}
	
	public void cambiarClave(String numCta, String clave, String nuevaClave) throws ATMexceptions{
		Cuenta cta = validar(numCta, clave);
		cta.setClave(nuevaClave);
		
		System.out.printf("Sr(a). %s usted ha cambiado la clave con éxito \n",
				getOwnerCuenta(numCta));
	}
	
	
	protected Cuenta validar(String numCta, String clave) throws ATMexceptions{
		Cuenta cta;
		
		if(!listaCuentas.containsKey(numCta)){
			throw new ATMexceptions("Error: La cuenta de número: "+numCta+ 
					" no se encuentra registrada en el sistema");
		}
		cta = listaCuentas.get(numCta);
		
		//verificando la que la clave coincida
		if(!(cta.getClave().compareTo(clave) == 0)){
			throw errorClave;
		}
		
		return cta;
	}
	
	
	public String getOwnerCuenta(String numCta){
		return listaCuentas.get(numCta).getNombre();
	}
}
