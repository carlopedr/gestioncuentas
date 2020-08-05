
import Modelo.Persona;
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

      
        PersonaDAO perDAO = new PersonaDAO();
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
        perDAO.eliminarPersona(7);
        
        
    }
}
