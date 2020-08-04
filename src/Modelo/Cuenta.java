/*
Define una clase abstracta Cuenta con los siguientes atributos:
numerocuenta : entero largo
saldo : double
cliente : atributo de la clase Persona (que tiene nombre y apellidos, y Número de documento de id)
y con los siguientes métodos:
Constructor parametrizado que recibe un cliente y un número de cuenta
Setters y getters para los tres atributos
ingresar(double): permitirá ingresar una cantidad en la cuenta.
abstract retirar(double): permitirá sacar una cantidad de la cuenta (si hay saldo). No se implementa, depende del tipo de cuenta
actualizarSaldo(): actualizará el saldo de la cuenta, pero cada cuenta lo hace de una forma diferente
 */
package Modelo;

public abstract class Cuenta {
    private int numerocuenta;
    private double saldo;
    private Persona cliente;

    public Cuenta(int numerocuenta, Persona cliente) {
        this.numerocuenta = numerocuenta;
        this.cliente = cliente;
    }

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
    public void ingresar(double cantidad){
        
    }
    
    public abstract void retirar(double cantidad);
    
    public void actualizarSaldo(){
    }
    
    
}   

