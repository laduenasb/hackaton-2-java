import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Menu
    Scanner sc = new Scanner(System.in);
    System.out.println("Tienes 10 espacios en la agenda telefonica, deseas cambiar el tamaño: 1(Si), 2(No): ");
    int opcion = sc.nextInt();
    int tamanio=10;
    if(opcion==1){
      System.out.println("Indica el tamaño de la agenda: ");
      tamanio = sc.nextInt();
    } else {
      System.out.println("Tamaño por defecto 10.");
    }
    Agenda agenda = new Agenda(tamanio);
    do {
      System.out.println("Agenda Telefonica");
      System.out.println("1. Añadir contacto");
      System.out.println("2. Buscar contacto");
      System.out.println("3. Lista de contactos");
      System.out.println("4. Eliminar contacto");
      System.out.println("5. Espacios disponibles");
      System.out.println("6. Salir");
      System.out.println();
      System.out.print("Ingresa la opción: ");
      System.out.println();
      opcion=sc.nextInt();
      String nombre;
      Long numero;
      switch (opcion) {
        case 1:
          if(agenda.agendaLlena()){
            System.out.println();
          } else {
            System.out.print("Ingrese el nombre: ");
            sc.nextLine();
            nombre = sc.nextLine();
            System.out.print("Ingrese el número: ");
            numero = sc.nextLong();
            Contacto c = new Contacto(nombre,numero);
            agenda.anadirContacto(c);
            System.out.println();
          }
          break;
        case 2:
          System.out.print("Ingresa el nombre a consultar: ");
          sc.nextLine();
          nombre= sc.nextLine();
          agenda.buscaContacto(nombre);
          System.out.println();
          break;
        case 3:
          agenda.listarContactos();
          System.out.println();
          break;
        case 4:
          System.out.println("Ingresa el nombre del contacto que desea eliminar: ");
          sc.nextLine();
          nombre = sc.nextLine();
          Contacto contactoBuscar = agenda.buscaContacto(nombre);
          agenda.eliminarContacto(contactoBuscar);
          System.out.println();
          break;
        case 5:
          agenda.espaciosLibres();
          System.out.println();
          break;
        case 6:
          System.out.println("Has salido del menu.");
          System.out.println();
          break;
        default:
          System.out.println("Ingresa una opción valida");
          System.out.println();
      }
    } while(opcion!=6);

  }
}