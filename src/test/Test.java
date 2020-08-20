
import Modelo.CuentaAhorro;
import Modelo.CuentaCorriente;
import Modelo.Persona;
import ModeloDAO.CuentasDAO;
import ModeloDAO.PersonaDAO;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Test {
    public static void main(String[] args) {

      
        /*PersonaDAO perDAO = new PersonaDAO();
        CuentasDAO cuentaDAO = new CuentasDAO();
        Persona p=new Persona(7,"TI","Luis Sánchez","luis@gmail.com");
        CuentaAhorro cAhorro = new CuentaAhorro(0.015,1000,1,p);
        CuentaCorriente cCorriente = new CuentaCorriente(2,p);
        cuentaDAO.crearCenta(cAhorro);
        cuentaDAO.crearCenta(cCorriente);*/
        
        CuentasDAO cuentaDAO = new CuentasDAO();
        
        Object cuenta=cuentaDAO.buscarCuenta(3);
        System.out.println(cuenta.getClass());
        //PersonaDAO perDAO=new PersonaDAO();
        //Persona p2=perDAO.buscarPersona(1);
        //System.out.println("Busqueda: "+p2);
        
        
        /*List<Persona> list = perDAO.listarPersonas();
        Iterator<Persona> iter = list.iterator();
        Persona per = null;
        while (iter.hasNext()) {
            per = iter.next();
            //System.out.println(per.getNombre());
            System.out.println(per.toString());
        }
        //Persona p2=new Persona(7,"TI","Luis Sánchez","luis@gmail.com");
        //perDAO.crearPersona(p2);
        Persona p2=perDAO.buscarPersona(7);
        System.out.println("Busqueda: "+p2);*/
        //perDAO.eliminarPersona(7);
        //Persona pact=new Persona(1,"TI","Carlos P","carlosp@gmail.com");
        //perDAO.actualizarPersona(pact);
        
        
        
    }
}
