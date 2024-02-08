public class Contacto {
  // ATRIBUTOS
  private String nombre;
  private long numero;

  // CONSTRUCTOR

  public Contacto(){

  }
  public Contacto(String nombre, long numero){
    this.nombre = nombre;
    this.numero = numero;
  }

  // GETTERS y SETTERS

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public long getNumero() {
    return numero;
  }

  public void setNumero(long numero) {
    this.numero = numero;
  }


}
