/*
 * cliente : atributo de la clase Persona 
(que tiene nombre y apellidos, y Número de documento de id)
 */
package Modelo;

public class Persona {
    private int id;
    private String tipoid;
    private String nombre;
    private String email;

    public Persona() {
    }

    public Persona(int id, String tipoid, String nombre, String email) {
        this.id = id;
        this.tipoid = tipoid;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getTipoid() {
        return tipoid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", tipoid=" + tipoid + ", nombre=" + nombre + ", email=" + email + '}';
    }
    
    
    
}
