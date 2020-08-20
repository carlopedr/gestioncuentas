/*
 * Desarrollado por: Camilo Andres Bravo Muñoz.
 */
package ModeloDAO;

import Modelo.Conceptos;
import Modelo.Cuenta;
import Modelo.Transaccion;
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
public class TransaccionesDAO {

    public void crearTransaccion(Transaccion transaccion) {
        File file = new File("datos/Transacciones.xml");
        int idTransaccion=transaccion.getId();
        int idCuenta=transaccion.getCuenta().getNumerocuenta();
        int idConcepto=transaccion.getConcepto().getId();
        double valor=transaccion.getValor();
        try {            //System.out.println("XML:"+file.canRead());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            //Para obtener el nodo raiz
            Node nRaiz = doc.getDocumentElement();
            Element nuevaTransaccion = doc.createElement("Transaccion");
            nuevaTransaccion.setAttribute("id", String.valueOf(idTransaccion));
            Element nuevaCuenta = doc.createElement("cuenta");
            nuevaCuenta.setTextContent(String.valueOf(idCuenta));
            Element nuevoConcepto = doc.createElement("concepto");
            nuevoConcepto.setTextContent(String.valueOf(idConcepto));
            Element nuevoValor = doc.createElement("valor");
            nuevoValor.setTextContent(String.valueOf(valor));
            nuevaTransaccion.appendChild(nuevaCuenta);
            nuevaTransaccion.appendChild(nuevoConcepto);
            nuevaTransaccion.appendChild(nuevoValor);
            nRaiz.appendChild(nuevaTransaccion);
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

    public void borrarTransaccion(int id) {
        //Eliminar un registro del el archivo XML
        //que coincida con el id
        //ArrayList <Element> nodos = new ArrayList();
        File file = new File("datos/Transacciones.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node nRaiz = doc.getDocumentElement();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Transaccion");
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
    public void actualizarTransaccion(Transaccion transaccion) {
        File file = new File("datos/Conceptos.xml");
        try {            //System.out.println("XML:"+file.canRead());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node nRaiz = doc.getDocumentElement();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Transaccion");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (transaccion.getId() == Integer.parseInt(eElement.getAttribute("id"))) {
                        Element actTransaccion = doc.createElement("Transaccion");
                        actTransaccion.setAttribute("id", String.valueOf(transaccion.getId()));
                        Element actCuenta = doc.createElement("Cuenta");
                        actCuenta.setTextContent(String.valueOf(transaccion.getCuenta()));
                        Element actConcepto = doc.createElement("Concepto");
                        actConcepto.setTextContent(String.valueOf(transaccion.getConcepto()));
                        Element actValor = doc.createElement("Valor");
                        actValor.setTextContent(String.valueOf(transaccion.getValor()));
                        actTransaccion.appendChild(actTransaccion);
                        actCuenta.appendChild(actCuenta);
                        actTransaccion.appendChild(actConcepto);
                        actTransaccion.appendChild(actValor);
                        nRaiz.appendChild(actTransaccion);
                    }
                }
            }
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

    public Transaccion buscarTransaccion(int id) {
        Transaccion transaccion = new Transaccion();
        Object cuenta;
        Conceptos concepto;
        int idCuenta;
        int idConcepto;
        File file = new File("datos/Transacciones.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Transaccion");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //Persona persona = new Persona();
                    if (id == Integer.parseInt(eElement.getAttribute("id"))) {
                        transaccion.setId(Integer.parseInt(eElement.getAttribute("id")));
                        idCuenta=Integer.parseInt(eElement.getElementsByTagName("cuenta").item(0).getTextContent());
                        CuentasDAO cuentaDAO=new CuentasDAO();
                        cuenta=cuentaDAO.buscarCuenta(idCuenta);
                        transaccion.setCuenta((Cuenta) cuenta);
                        idConcepto=Integer.parseInt(eElement.getElementsByTagName("concepto").item(0).getTextContent());
                        ConceptosDAO conceptosDAO = new ConceptosDAO();
                        concepto=conceptosDAO.buscarConcepto(idConcepto);
                        transaccion.setConcepto(concepto);
                        transaccion.setValor(Double.parseDouble(eElement.getElementsByTagName("Valor").item(0).getTextContent()));
                        break;
                    } else {
                        transaccion = null;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ParserConfigurationException e) {
            System.out.println(e.toString());
        } catch (SAXException e) {
            System.out.println(e.toString());
        }
        return transaccion;
    }

    public List listarTransacciones() {
        ArrayList<Transaccion> list = new ArrayList();
        Object cuenta;
        Conceptos concepto;
        int idCuenta;
        int idConcepto;
        File file = new File("datos/Transacciones.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Transaccion");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Transaccion transaccion = new Transaccion();
                    //
                    transaccion.setId(Integer.parseInt(eElement.getAttribute("id")));
                    idCuenta = Integer.parseInt(eElement.getElementsByTagName("cuenta").item(0).getTextContent());
                    CuentasDAO cuentaDAO = new CuentasDAO();
                    cuenta = cuentaDAO.buscarCuenta(idCuenta);
                    transaccion.setCuenta((Cuenta) cuenta);
                    idConcepto = Integer.parseInt(eElement.getElementsByTagName("concepto").item(0).getTextContent());
                    ConceptosDAO conceptosDAO = new ConceptosDAO();
                    concepto = conceptosDAO.buscarConcepto(idConcepto);
                    transaccion.setConcepto(concepto);
                    transaccion.setValor(Double.parseDouble(eElement.getElementsByTagName("Valor").item(0).getTextContent()));
                    //
                    list.add(transaccion);
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
        return list;
    }

}
