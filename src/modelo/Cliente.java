package modelo;

public class Cliente {

    private int cedula;
    private String nombre;
    private String direccion;
    private byte edad;
    private long telefono;

    public Cliente() {}
    public Cliente(int cedula, String nombre, String direccion, 
    byte edad, long telefono) {
        
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
    }

    public int getCedula() {return cedula;}
    public void setCedula(int cedula) {this.cedula = cedula;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public byte getEdad() {return edad;}
    public void setEdad(byte edad) {this.edad = edad;}

    public long getTelefono() {return telefono;}
    public void setTelefono(long telefono) {this.telefono = telefono;}

    @Override
    public String toString() {
        return "C;" + this.cedula + ";" + this.nombre + ";" + this.direccion + ";" 
                + this.edad + ";" + this.telefono;
    }
}
