/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Concepto {
    private int id;
    private String nombre;
    private String efecto;

    public Concepto(int id, String nombre, String efecto) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    @Override
    public String toString() {
        return "Concepto{" + "id=" + id + ", nombre=" + nombre + ", efecto=" + efecto + '}';
    }
    
}
