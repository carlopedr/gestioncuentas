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
public class CuentaCorriente extends Cuenta{
    
    private final double interes=0.015;

    public CuentaCorriente(int numerocuenta, Persona cliente) {
        super(numerocuenta, cliente);
    }

    public CuentaCorriente() {
    }

    public double getInteres() {
        return interes;
    }

   

    @Override
    public void retirar(double cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + "interes=" + interes + '}';
    }
    
    
    
}
