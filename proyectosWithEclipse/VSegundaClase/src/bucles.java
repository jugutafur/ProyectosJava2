import javax.swing.*;

public class bucles {
	
	public static void main(String[] args){
		
		String clave="Juan";
		String pss="";
		
		while(clave.equals(pss)==false){
			
			pss=JOptionPane.showInputDialog("Ingrese password");
			
			if(clave.equals(pss)==false){
				
			System.out.println("Contraseņa incorrecta");	
			}
		}
		System.out.println("Contraseņa correcta bienvenido");
		
	}

}
