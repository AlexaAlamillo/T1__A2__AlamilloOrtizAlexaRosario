import java.util.Scanner;

class Aspirante{
	private String nombre;
	private String primerApellido;
	private int edad;
	private String escuelaDeProcedencia;
	private String direccion;
	private String correo;
	private String telefono;
	private String redesSociales;
	private String Carrera;
	private String bachillerato;
	
	public Aspirante(String nombre, String primerApellido, int edad, String escuelaDeProcedencia, String direccion,
			String correo, String telefono, String redesSociales, String carrera, String bachillerato) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.edad = edad;
		this.escuelaDeProcedencia = escuelaDeProcedencia;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.redesSociales = redesSociales;
		Carrera = carrera;
		this.bachillerato = bachillerato;
	}

	public void numeroDeFicha(int ficha) {
		System.out.println("=======ASPIRANTE======");
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+primerApellido);
		System.out.println("Edad: "+edad);
		System.out.println("Escuela de Procedencia: "+escuelaDeProcedencia);
		System.out.println("Bachillerato: "+bachillerato);
		System.out.println("Direccion: "+direccion);
		System.out.println("Correo: "+correo);
		System.out.println("Telefono: "+ telefono);
		System.out.println("Redes Sociales: "+ redesSociales);
		System.out.println("Carrera de interes: "+Carrera);
	}
	 public String getNombre() {
	        return nombre;
	    }

	    public String getPrimerApellido() {
	        return primerApellido;
	    }
	
}
class RegistroAspirante {
	private Aspirante [] aspirantes;
	private int cantidad;
	
	public RegistroAspirante(int tamaño) {
        aspirantes = new Aspirante[tamaño];
        cantidad = 0;
    }
	
	public boolean AgregarAspirante(Aspirante aspirante) {
		 if (cantidad >= aspirantes.length) {
	            return false;
	        }

	        aspirantes[cantidad] = aspirante;
	        cantidad++;

	        return true;
	}
	
	public boolean eliminarUltimoAspirante() {
		if (cantidad == 0) {
            return false;
        }

        aspirantes[cantidad - 1] = null;
        cantidad--;

        return true;
	}
	 public void buscarPorFicha(int ficha) {

	        if (ficha < 1 || ficha > cantidad) {
	            System.out.println("No existe esa ficha.");
	            return;
	        }

	        aspirantes[ficha - 1].numeroDeFicha(ficha);
	    }
	
	 public void buscarPorNombre(String nombre) {

	        boolean encontrado = false;

	        for (int i = 0; i < cantidad; i++) {

	            if (aspirantes[i].getNombre()
	                    .equalsIgnoreCase(nombre)) {

	                aspirantes[i].numeroDeFicha(i+1);
	                encontrado = true;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("No se encontro ningun aspirante con ese Nombre");
	        }
	    }
	 
	 public void buscarPorPrimerApellido(String apellido) {
		 boolean encontrado = false;

	        for (int i = 0; i < cantidad; i++) {

	            if (aspirantes[i].getPrimerApellido()
	                    .equalsIgnoreCase(apellido)) {

	                aspirantes[i].numeroDeFicha(i+1);
	                encontrado = true;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("No se encontro ningun aspirante con ese Apellido");
	        }
	 }
	 
	 public void mostrarListado() {

	        if (cantidad == 0) {
	            System.out.println("No hay aspirantes registrados");
	            return;
	        }

	        System.out.println("\n===== LISTADO DE ASPIRANTES =====");

	        for (int i = 0; i < cantidad; i++) {
	        	System.out.println(aspirantes[i].getNombre()+ aspirantes[i].getPrimerApellido());
	        }
	 }

	 public int getCantidad() {
		 return cantidad;
	 }

	 public void setCantidad(int cantidad) {
		 this.cantidad = cantidad;
	 }
	 
	 
	
}
public class MemoriaEstatica {

	public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       System.out.print("¿Cuántos ASPIRANTES deseas ingresar? ");
       int tamaño = sc.nextInt();
		byte opcion =0;
		RegistroAspirante ra = new RegistroAspirante(tamaño);
		do {
			
			System.out.println("======MENU======");
			System.out.println("1)Agregar Aspirante");
			System.out.println("2)Eliminar Aspirante");
			System.out.println("3) Buscar aspirante (Numero de ficha, nombre, o primer Apellido)");
			System.out.println("4)Mostrar listado de Aspirantes");
			System.out.println("5)Salir");
			System.out.println("Ingrese opcion: ");
			opcion = sc.nextByte();
			switch (opcion) {
			case 1: 
				System.out.println();
				System.out.print("Nombre: ");
				sc.next();
				String nombre = sc.nextLine();

				System.out.print("Primer Apellido: ");
				String primerApellido = sc.nextLine();

				System.out.print("Edad: ");
				int edad = Integer.parseInt(sc.nextLine());

				System.out.print("Dirección: ");
				String direccion = sc.nextLine();

				System.out.print("Teléfono: ");
				String telefono = sc.nextLine();

				System.out.print("Correo electrónico: ");
				String correo = sc.nextLine();

				System.out.print("Redes Sociales: ");
				String redesSociales = sc.nextLine();

				System.out.print("Carrera(s) de interés: ");
				String carrera = sc.nextLine();

				System.out.print("Escuela de procedencia: ");
				String escuela = sc.nextLine();

				System.out.print("Bachillerato cursado: ");
				String bachillerato = sc.nextLine();
                  Aspirante as = new Aspirante(nombre, primerApellido,edad,direccion,telefono,correo,redesSociales,carrera,escuela,bachillerato);
                  
                  if (ra.AgregarAspirante(as)) {
                      System.out.println("\nAspirante agregado correctamente.");
                      System.out.println("Número de ficha: "
                              + String.format("%03d", ra.getCantidad()));
                  }
				break;
				
			case 2:
				  if (ra.eliminarUltimoAspirante()) {
                      System.out.println("Último aspirante eliminado.");
                  } else {
                      System.out.println("No hay aspirantes para eliminar.");
                  }

				break;
			case 3: 
				int opcionBusqueda;

				System.out.println("\n===== BUSCAR ASPIRANTE =====");
				System.out.println("1) Por número de ficha");
				System.out.println("2) Por nombre");
				System.out.println("3) Por primer apellido");
				System.out.print("Seleccione una opción: ");

				opcionBusqueda = sc.nextInt();

				switch (opcionBusqueda) {

				    case 1:

				        System.out.print("Ingrese el número de ficha: ");
				        int ficha = sc.nextInt();

				        ra.buscarPorFicha(ficha);

				        break;

				    case 2:

				        System.out.print("Ingrese el nombre: ");
				        sc.next();
				        String nombreBuscar = sc.nextLine();

				        ra.buscarPorNombre(nombreBuscar);

				        break;

				    case 3:

				        System.out.print("Ingrese el primer apellido: ");
				        sc.next();
				        String apellidoBuscar = sc.nextLine();

				        ra.buscarPorPrimerApellido(apellidoBuscar);

				        break;

				    default:

				        System.out.println("Opción de búsqueda no válida.");
				}
				break;
			case 4:
				  ra.mostrarListado();
				break;
			case 5: 
				System.out.println("Saliendo del menu....");
				break;
				default:
					System.out.println("Opcion incorrecta");
			}
			
			
			
		}while(opcion != 5);
		

	}

}
