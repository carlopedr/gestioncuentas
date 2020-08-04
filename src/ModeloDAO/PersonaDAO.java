/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Persona;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Usuario
 */
public class PersonaDAO {
    public void crearPersona(Persona persona){
       //Registar un objeto persona en el archivo XML 
    }
    public void eliminarPersona(int id){
        //Eliminar un registro del el archivo XML
        //que coincida con el id
    }
    public void actualizarPersona (Persona persona){
        
    }
    public Persona buscarPersona(int id){
        Persona persona=null;
        
        //return persona;
        return null;
    }
    public List listarPersonas(){
        ArrayList<Persona> list = new ArrayList();
        int id;
        File file = new File("datos/Personas.xml");
        //System.out.println("XML:"+file.canRead());
        try {
            //System.out.println("XML:"+file.canRead());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Persona");
            //System.out.println("Número de personas: " + nList.getLength());
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Persona persona = new Persona();
                    System.out.println("Registro No. "+temp+" "+eElement.toString());
                    //System.out.println(eElement.getAttributeNode("nombre"));
                    persona.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                    persona.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    persona.setTipoid(eElement.getElementsByTagName("tipoid").item(0).getTextContent());
                    persona.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
                    list.add(persona);
                                      
                } 
            }


        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ParserConfigurationException e) {
            System.out.println(e.toString());
        } catch (SAXException e) {
            System.out.println(e.toString());
        }
         
        
        return list;
        
    }
    
}
