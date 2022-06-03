import java.util.*;
import javax.swing.*;

public class Adivina_Numero {
	
	public static void main(String[] args){
				
		int aleatorio=(int)(Math.random()*100);
		Scanner entrada= new Scanner(System.in);
		
		int numero=0, intentos=3;
		
		while (numero!=aleatorio){

			intentos=intentos-1;
			
			System.out.println("introduce un numero");
			numero = entrada.nextInt();
			
			if(aleatorio<numero){	
				System.out.println("numero mas bajo");						
			}
			
			else if(aleatorio>numero){
				System.out.println("numero mas alto");
			}
			if(intentos>0){
				System.out.println("numero de intentos "+ intentos);				
			}
			
			else{
				System.out.println("perdiste el numero era "+ aleatorio);
				numero=aleatorio;
			}
			
		}
		System.out.println("felicidades");
				
	}

}
