import java.util.Arrays;
import java.util.Scanner;
/*1) Datos - vector de enteros
2) Crear
3) Llenar
4) Agregar elemento  
5)agregar elemento al inicio
6)mostrar elementos
7)Eliminar elemento del inicio 
8)eliminar elemento del final */

class TDAVectorEspecial{
	Scanner sc = new Scanner (System.in);
	private byte datos[];
	
	
	public void  TDAVectorEspecial (int tam) {
		datos = new byte [tam];
	}
	
	public void llenarDatos() {
		for(int i=0;i< datos.length;i++) {
			System.out.println("Ingrerse un valor"+(i+1)+": ");
			datos[i]= sc.nextByte();
			
		}
	}
	public void agregarElementosAlFinal(byte elemento) {
		  byte[] nuevoVector = new byte [datos.length +1 ];
		for(int i =0; i<datos.length;i++) {
			nuevoVector[i] = datos[i];
		}
		nuevoVector[nuevoVector.length -1] =  elemento;
		datos = nuevoVector;
	}
	public void agregarElementosAlPrincipio(byte elemento) {
		 byte[] nuevoVector = new byte[datos.length + 1];

		    nuevoVector[0] = elemento;

		    for (int i = 0; i < datos.length; i++) {
		        nuevoVector[i + 1] = datos[i];
		    }

		    datos = nuevoVector;
		
		
	}
	public void mostrarElementos() {
		if(datos!= null) {
			System.out.println(Arrays.toString(datos) );
		}else {
			System.out.println("¡DEBES CREAR EL VECTOR!");
		}
		
	}
	public void eliminarElementoDelFinal() {
		 byte nuevoVector[] = new byte[datos.length - 1];

	        for (int i = 0; i < nuevoVector.length; i++) {
	            nuevoVector[i] = datos[i];
	        }

	        datos = nuevoVector;
		
	}
	public void eliminarElementoDelInicio() {
		 byte nuevoVector[] = new byte[datos.length - 1];

	        for (int i = 0; i < nuevoVector.length; i++) {
	            nuevoVector[i] = datos[i + 1];
	        }

	        datos = nuevoVector;
		
	}
	
}


public class EjercicioVectorEspecial {

	public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
		
		int opcion ;
		TDAVectorEspecial tda = new TDAVectorEspecial();
		int tamaño;
		
		do {
			System.out.println("=========MENU DE OPCIONES======");
			System.out.println("Opcion 1: crear");
			System.out.println("Opcion 2: llenar ");
			System.out.println("Opcion 3: Agregar un elemento al final ");
			System.out.println("Opcion 4: Agregar un elemento al inicio ");
			System.out.println("Opcion 5: Mostrar Elementos");
			System.out.println("Opcion 6: Eliminar elementos del inicio");
			System.out.println("Opcion 7: Eliminar elementos del final");
			System.out.println("Opcion 8: Salir");
			System.out.println("Opcion : ");
			opcion = sc.nextInt();
			
			switch(opcion) {
			case 1:
				System.out.println("Ingrese tamaño del arreglo: ");
				tamaño = sc.nextInt();
				tda.TDAVectorEspecial(tamaño);
				break;
			case 2:
				tda.llenarDatos();
				break;
			case 3:
				System.out.println("Ingrese elemento: ");
				byte elementos = sc.nextByte();
				tda.agregarElementosAlFinal(elementos);
				break;
			case 4:
				
				System.out.println("Ingrese elemento: ");
				byte elemento = sc.nextByte();
				tda.agregarElementosAlPrincipio(elemento);
				break;
			case 5:
				System.out.println("Mostrando elementos:-------");
				tda.mostrarElementos();
				break;
			case 6:
				System.out.println("Se elimino el elemento del final ");
				tda.eliminarElementoDelFinal();
				break;
			case 7:
				System.out.println("Se elimino elemento del principio");
				tda.eliminarElementoDelInicio();
				break;
			case 8:
				System.out.println("Saliendo---");
				break;
				default: 
					System.out.println("Opcion incorrecta...");
				
				
			}
		}while(opcion!=8);

	}

}
