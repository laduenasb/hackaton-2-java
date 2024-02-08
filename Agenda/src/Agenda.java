import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Agenda {
  // ATRIBUTOS
  // Lista de los contactos
  private Map<String,Long> Contactos = new LinkedHashMap<>();
  // Si el usuario no indica el tamaño de la agenda, por defecto en 10
  private int tamanio=10;

  // CONSTRUCTORES

  public Agenda(int tamanio){
    this.tamanio=tamanio;
  }
  public Agenda(){
  }

  // GETTERS y SETTERS
  public Map<String, Long> getContactos() {
    return Contactos;
  }

  public int getTamanio() {
    return tamanio;
  }
  // Método añadir contacto
  public void anadirContacto(Contacto c){
    if(Contactos.size()<tamanio && !Contactos.containsKey(c.getNombre())){
      Contactos.put(c.getNombre(),c.getNumero());
      System.out.println("Se añadio el contacto exitosamente.");
    } else if(Contactos.containsKey(c.getNombre())) {
      System.out.println("El contacto ya existe.");
    } else {
      agendaLlena();
    }
  }

  // Mostrar contactos

  public void listarContactos(){
    for(int i=0; i<Contactos.size(); i++) {
      System.out.println("Contacto "+(i+1));
      System.out.println("Nombre: " + Contactos.keySet().toArray()[i]);
      System.out.println("Número: " + Contactos.values().toArray()[i]);
      System.out.println();
    }
  }

  // metodo existe contacto

  public boolean existeContacto(Contacto c){
    boolean existe=false;
    if(Contactos.containsKey(c.getNombre())) {
      existe = true;
      System.out.println("El contacto existe.");
    }
    return existe;
  }

  // metodo agenda llena

  public boolean agendaLlena(){
    boolean estaLlena=false;
    if(Contactos.size()==tamanio){
      System.out.println("La agenda esta llena.");
      estaLlena=true;
    }
    return estaLlena;
  }

  // metodo buscar contacto

  public Contacto buscaContacto(String nombre){
    // Se construye el objeto contacto a buscar, sino existe el nombre y el numero estan vacios
    Contacto contacto=new Contacto();
    if(Contactos.containsKey(nombre)){
      contacto.setNombre(nombre);
      contacto.setNumero(Contactos.get(nombre));
      System.out.println("Nombre: "+nombre);
      System.out.println("Número: "+Contactos.get(nombre));
    } else {
      System.out.println("No existe ese nombre en la agenda.");
    }
    return contacto;
  }

  // metodo eliminar el contacto de la agenda
  public void eliminarContacto(Contacto c){
    boolean existe=existeContacto(c);
    if(existe){
      Contactos.remove(c.getNombre());
      System.out.println("Se ha eliminado el contacto de la lista.");
    } else {
      System.out.println("Verifica bien los datos.");
    }
  }
  // Metodo que indica la cantidad de contactos disponibles

  public void espaciosLibres(){
    System.out.println("Espacios libres: " + (tamanio - Contactos.size()));
  }
}
