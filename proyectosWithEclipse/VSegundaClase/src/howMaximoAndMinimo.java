
public class howMaximoAndMinimo {
	
	public static void main(String args[]) {
		System.out.println("With this App you can determinate how is the Mayor and menor of Array");
		
		int[] enteros= {4, 9, -9, 0, 76, -2};
		
		int otroEntero[] = {5, 8,-2,0 };
		
		int maximo=0, minimo = enteros[0];
		
		for(int i=0; i<enteros.length-1; i++) {
			if(enteros[i]>maximo) maximo=enteros[i];
			if(enteros[i]<minimo) minimo=enteros[i];
		}
		System.out.println("The maximo value of array = "+maximo);
		System.out.println("The minimo value of array = "+minimo);
	}

}
