package trabajofinal;

public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;
    
    public Persona(){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCedula() {
        return cedula;
    }
    public void setNombre(String nombre) {
       this.nombre=nombre;
    }
    public void setApellido(String apellido) {
        this.apellido=apellido;
    }
    public void setCedula(String cedula) {
        this.cedula=cedula;
    }
    
    
    
}



