/*
 * Desarrollado por: Camilo Andres Bravo Muñoz.
 */
package ModeloDAO;

import Modelo.Conceptos;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class ConceptosDAO {

    public void crearConcepto(Conceptos concepto) {
        File file = new File("datos/Conceptos.xml");
        try {            //System.out.println("XML:"+file.canRead());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            //Para obtener el nodo raiz
            Node nRaiz = doc.getDocumentElement();
            Element nuevoConcepto = doc.createElement("Concepto");
            nuevoConcepto.setAttribute("id", String.valueOf(concepto.getId()));
            Element nuevoNombre = doc.createElement("Nombre");
            nuevoNombre.setTextContent(concepto.getNombre());
            Element nuevoEfecto = doc.createElement("Efecto");
            nuevoEfecto.setTextContent(concepto.getEfecto());
            nuevoConcepto.appendChild(nuevoNombre);
            nuevoConcepto.appendChild(nuevoEfecto);
            nRaiz.appendChild(nuevoConcepto);
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
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

    public void borrarConcepto(int id) {
        //Eliminar un registro del el archivo XML
        //que coincida con el id
        //ArrayList <Element> nodos = new ArrayList();
        File file = new File("datos/Conceptos.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node nRaiz = doc.getDocumentElement();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Concepto");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (id == Integer.parseInt(eElement.getAttribute("id"))) {
                        nRaiz.removeChild(eElement);
                    }
                }
            }
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            System.out.println(e.getMessage());
        }

    }

    public void actualizarConcepto(Conceptos concepto) {
        File file = new File("datos/Conceptos.xml");
        try {            //System.out.println("XML:"+file.canRead());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node nRaiz = doc.getDocumentElement();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Concepto");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (concepto.getId() == Integer.parseInt(eElement.getAttribute("id"))) {
                        Element actConcepto = doc.createElement("Concepto");
                        actConcepto.setAttribute("id", String.valueOf(concepto.getId()));
                        Element actNombre = doc.createElement("Nombre");
                        actNombre.setTextContent(concepto.getNombre());
                        Element actEfecto = doc.createElement("Efecto");
                        actEfecto.setTextContent(concepto.getEfecto());
                        actEfecto.appendChild(actNombre);
                        actEfecto.appendChild(actEfecto);
                        nRaiz.replaceChild(actConcepto, eElement);
                    }
                }
            }
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        }catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            System.out.println(e.getMessage());
        }
        //return list;
        //return list;
        
        //return list;
        
        //return list;

    }

    public Conceptos buscarConcepto(int id) {
        Conceptos concepto = new Conceptos();
        File file = new File("datos/Conceptos.xml");
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
                        concepto.setId(Integer.parseInt(eElement.getAttribute("id")));
                        concepto.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                        concepto.setEfecto(eElement.getElementsByTagName("tipoid").item(0).getTextContent());

                    } else {
                        concepto = null;
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
        return concepto;

    }

    public List listarConcepto() {
        ArrayList<Conceptos> list = new ArrayList();
        int id;
        File file = new File("datos/Conceptos.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Concepto");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Conceptos concepto = new Conceptos();
                    concepto.setId(Integer.parseInt(eElement.getAttribute("id")));
                    concepto.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    concepto.setEfecto(eElement.getElementsByTagName("Efecto").item(0).getTextContent());

                    list.add(concepto);
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
        return list;
    }

}