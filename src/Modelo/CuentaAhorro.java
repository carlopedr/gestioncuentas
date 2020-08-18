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
public class CuentaAhorro extends Cuenta{
    private double interes;
    private double saldomin;

    public CuentaAhorro(double interes, double saldomin, int numerocuenta, Persona cliente) {
        super(numerocuenta, cliente);
        this.interes = interes;
        this.saldomin = saldomin;
    }

    public CuentaAhorro() {
    }

    public double getInteres() {
        return interes;
    }

    public double getSaldomin() {
        return saldomin;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public void setSaldomin(double saldomin) {
        this.saldomin = saldomin;
    }

    

    

    @Override
    public void retirar(double cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" + "interes=" + interes + ", saldomin=" + saldomin + '}';
    }
    
    
}
