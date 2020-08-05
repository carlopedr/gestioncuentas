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
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
    public void crearPersona(Persona persona) {
        //Registar un objeto persona en el archivo XML 
        File file = new File("datos/Personas.xml");
        try {            //System.out.println("XML:"+file.canRead());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            //Para obtener el nodo raiz
            Node nRaiz = doc.getDocumentElement();
            Element nuevaPersona = doc.createElement("Persona");
            nuevaPersona.setAttribute("id", String.valueOf(persona.getId()));
            Element nuevoTipoId = doc.createElement("tipoid");
            nuevoTipoId.setTextContent(persona.getTipoid());
            Element nuevoNombre = doc.createElement("nombre");
            nuevoNombre.setTextContent(persona.getNombre());
            Element nuevoEmail = doc.createElement("email");
            nuevoEmail.setTextContent(persona.getEmail());
            nuevaPersona.appendChild(nuevoTipoId);
            nuevaPersona.appendChild(nuevoNombre);
            nuevaPersona.appendChild(nuevoEmail);
            nRaiz.appendChild(nuevaPersona);
            TransformerFactory transFactory= TransformerFactory.newInstance();
            Transformer transformer=transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (TransformerConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
        //return list;
    
}
public void removePersona(int id){
    File file = new File("datos/Personas.xml");
    
    
    
}
public void eliminarPersona(int id){
        //Eliminar un registro del el archivo XML
        //que coincida con el id
        ArrayList <Element> nodos = new ArrayList();
         File file = new File("datos/Personas.xml");
        try {            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node nRaiz = doc.getDocumentElement();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Persona");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (id == Integer.parseInt(eElement.getAttribute("id"))) {
                        nRaiz.removeChild(eElement);
                    }
                }
            }
            TransformerFactory transFactory= TransformerFactory.newInstance();
            Transformer transformer=transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (TransformerConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void actualizarPersona (Persona persona){
        
    }
    public Persona buscarPersona(int id){
        Persona persona = new Persona();
        File file = new File("datos/Personas.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Persona");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //Persona persona = new Persona();
                    if (id == Integer.parseInt(eElement.getAttribute("id"))) {
                        persona.setId(Integer.parseInt(eElement.getAttribute("id")));
                        persona.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                        persona.setTipoid(eElement.getElementsByTagName("tipoid").item(0).getTextContent());
                        persona.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
                    }
                    else
                        persona=null;
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ParserConfigurationException e) {
            System.out.println(e.toString());
        } catch (SAXException e) {
            System.out.println(e.toString());
        }

        return persona;
        //return null;
    }
    public List listarPersonas() {
        ArrayList<Persona> list = new ArrayList();
        int id;
        File file = new File("datos/Personas.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Persona");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Persona persona = new Persona();
                    persona.setId(Integer.parseInt(eElement.getAttribute("id")));
                    persona.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    persona.setTipoid(eElement.getElementsByTagName("tipoid").item(0).getTextContent());
                    persona.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
                    list.add(persona);
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
        return list;
    }
}
