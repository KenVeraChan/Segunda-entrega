package loteria;
import java.lang.Math;
import java.util.Scanner;   //se hace la importación de la clase SCANNER para leer por teclado

public class Arrays_Loteria {

	public static void main(String[] args) {
		int vector_boleto[]= new int[50];
		int i=0;
		int j=0;
		// Primero se guardan los elementos en el vector de enteros
		for (i=0;i<9;i++)
		{
			// El generador de números aleatorios es de tipo DOUBLE, se pone (int) para convertir a tipo entero
			//Si ponía el numero 99 en donde generaba los números aleatorios, generaba números por encima de 100
			vector_boleto[i] = (int) (Math.floor(Math.random()*90+10));
		}
		// Segundo se muestra por pantalla los números introducidos
			System.out.println("Bienvenido a participar a la lotería online");
			System.out.println("-- A continuación se le dará el boleto --");
		    System.out.println("-- El boleto generado es el siguiente  --");
		    System.out.println("");
		for(i=0;i<9;i++)
		{
			System.out.print(" "+vector_boleto[i]+" ");
		}
		//Tercero Pedimos al ususario que vaya introduciendo los datos para adivinar el boleto
		Scanner resultado = new Scanner(System.in);  //preparación para leer por teclado
		int vector_comprobacion[]= new int[15];   //Para guardar el número acertado
		int comprobacion=0;   //Numero que irá comprobando si se ha acertado o no y en el caso que sí, será guardado en los vectores anteriores
		int contador_intentos=0;
		int pivote=0;		//Pivote que recorrerá los vectores de indices y de numeros acertados
		int parada=0;
		String boleto=" ";
		
		// Inicializamos el vector: vector_comprobacion[]
		for(i=0;i<15;i++)
		{
			vector_comprobacion[i]=-1; 
		}
		
		//Primer numero buscado //
		
		do {
		System.out.println("");
		System.out.println("Introduzca un número para comprobar si ha acertado:");
		System.out.println("");
		comprobacion= resultado.nextInt();
	
		for(i=0;i<9;i++)
		{
			boolean encontrado=false;    //Booleano que dice si se ha encontado el numero o no
			if(vector_boleto[i]==comprobacion)
			{
					System.out.println("Ha acertado el número " + comprobacion + " del boleto!!!");
					vector_comprobacion[pivote]=comprobacion;
					pivote=pivote+1;  //Pasa a la siguiente celda para guardar el siguiente numero
	
					boleto="";
					for(i=0;i<9;i++)
					{
					//	for(j=0;j<15;j++)
					//	{
							if(vector_boleto[i]==comprobacion && parada==0)
							{
								boleto=boleto+"  XX";
								//parada=1;
								i=i+1;
								j=15;
							}

					//	}	
						boleto= boleto+"  "+vector_boleto[i];
						//parada=0;  //Para encontrar el siguiente valor
					}
					
					
					
					
					
					
				System.out.println("");
				System.out.println("El boleto queda actualizado de la siguiente manera:");
				System.out.print(boleto);
				System.out.println("");
				encontrado=true;
			}
			if(i==8 && encontrado==false)
			{
				System.out.println("El número: " +comprobacion+" no existe.");
				for(i=0;i<9;i++)
				{
					System.out.print(" "+vector_boleto[i]+" ");
				}
			}
		 }
		contador_intentos=contador_intentos+1;  //Se contabiliza el intento actual
	    }while(contador_intentos<15);
	
		
		System.out.println("");
		for(i=0;i<15;i++)
		{
			boleto=boleto+" "+vector_comprobacion[i];
			System.out.print(boleto);
		}
		System.out.println("");
		
		
		
		
		System.out.println("");
		System.out.println("");
		for(i=0;i<10;i++)
		{
			System.out.println("Acertado: "+vector_comprobacion[i]);
		}
	}
}
