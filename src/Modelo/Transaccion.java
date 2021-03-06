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
public class Transaccion {
    private int id;
    private Cuenta cuenta;
    private Conceptos concepto;
    private double valor;

    public Transaccion(int id, Cuenta cuenta, Conceptos concepto, double valor) {
        this.id = id;
        this.cuenta = cuenta;
        this.concepto = concepto;
        this.valor = valor;
    }

    public Transaccion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Conceptos getConcepto() {
        return concepto;
    }

    public void setConcepto(Conceptos concepto) {
        this.concepto = concepto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", cuenta=" + cuenta + ", concepto=" + concepto + ", valor=" + valor + '}';
    }
    
    
}
