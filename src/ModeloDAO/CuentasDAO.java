/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import Modelo.CuentaAhorro;
import Modelo.CuentaCorriente;
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
public class CuentasDAO {
    public void crearCenta(Object cuenta){
        //Una variable para cada atributo del archivo de salida
        int idcuenta;
        double saldo;
        int idcliente;
        String tipocuenta;
        double interes;
        double saldomin;
        //Se crean dos objetos de cada tipo de cuenta.
        CuentaAhorro cAhorro = new CuentaAhorro();
        CuentaCorriente cCorriente = new CuentaCorriente();
        //Se verifica que objeto se esta recibiendo en el método
        if (cuenta.getClass() == cAhorro.getClass()) {
            System.out.println("Clase de cuenta es Ahorros");
            cAhorro = (CuentaAhorro) cuenta;
            idcuenta = cAhorro.getNumerocuenta();
            saldo = cAhorro.getSaldo();
            idcliente = cAhorro.getCliente().getId();
            tipocuenta = "A";
            interes = cAhorro.getInteres();
            saldomin = cAhorro.getSaldomin();
        } else {
            System.out.println("Clase de cuenta es Corriente");
            cCorriente=(CuentaCorriente) cuenta;
            idcuenta = cCorriente.getNumerocuenta();
            saldo = cCorriente.getSaldo();
            idcliente = cCorriente.getCliente().getId();
            tipocuenta="C";
            interes = cCorriente.getInteres();
            saldomin = cCorriente.getSaldo();
        }
        File file = new File("datos/Cuentas.xml");//para acceder a la ubicacion del archivo en este caso carpeta datos/Cuentas
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            //Nodo raiz
            Node nRaiz = doc.getDocumentElement();
            Element nuevaCuenta = doc.createElement("Cuenta");
            nuevaCuenta.setAttribute("id", String.valueOf(idcuenta));
            Element nuevoSaldo = doc.createElement("saldo");
            nuevoSaldo.setTextContent(String.valueOf(saldo));
            Element nuevoCliente = doc.createElement("cliente");
            nuevoCliente.setTextContent(String.valueOf(idcliente));
            Element nuevoTipoCuenta = doc.createElement("tipocuenta");
            nuevoTipoCuenta.setTextContent(tipocuenta);
            Element nuevoInteres = doc.createElement("interes");
            nuevoInteres.setTextContent(String.valueOf(interes));
            Element nuevoSaldoMin = doc.createElement("saldomin");
            nuevoSaldoMin.setTextContent(String.valueOf(saldomin));
            nuevaCuenta.appendChild(nuevoSaldo);
            nuevaCuenta.appendChild(nuevoCliente);
            nuevaCuenta.appendChild(nuevoTipoCuenta);
            nuevaCuenta.appendChild(nuevoInteres);
            nuevaCuenta.appendChild(nuevoSaldoMin);
            nRaiz.appendChild(nuevaCuenta);
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
   
    public void borrarCuenta(int id){
        File file = new File("datos/Cuentas.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node nRaiz = doc.getDocumentElement();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Cuenta");
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
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
    }
    public void actualizarCuenta(int id){
        int idcuenta;
        double saldo;
        int idcliente;
        String tipocuenta;
        double interes;
        double saldomin;
        //Se crean dos objetos de cada tipo de cuenta.
        CuentaAhorro cAhorro = new CuentaAhorro();
        CuentaCorriente cCorriente = new CuentaCorriente();
        //Se verifica que objeto se esta recibiendo en el método
        if (cuenta.getClass() == cAhorro.getClass()) {
            System.out.println("Clase de cuenta es Ahorros");
            cAhorro = (CuentaAhorro) cuenta;
            idcuenta = cAhorro.getNumerocuenta();
            saldo = cAhorro.getSaldo();
            idcliente = cAhorro.getCliente().getId();
            tipocuenta = "A";
            interes = cAhorro.getInteres();
            saldomin = cAhorro.getSaldomin();
        } else {
            System.out.println("Clase de cuenta es Corriente");
            cCorriente = (CuentaCorriente) cuenta;
            idcuenta = cCorriente.getNumerocuenta();
            saldo = cCorriente.getSaldo();
            idcliente = cCorriente.getCliente().getId();
            tipocuenta = "C";
            interes = cCorriente.getInteres();
            saldomin = cCorriente.getSaldo();
        }
        File file = new File("datos/Cuentas.xml");//para acceder a la ubicacion del archivo en este caso carpeta datos/Cuentas
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
                    if (cuenta.getClass() == Integer.TYPE(eElement.getAttribute("id"))) {
                        //Nodo raiz
                        Element actCuenta = doc.createElement("Cuenta");
                        actCuenta.setAttribute("id", String.valueOf(idcuenta));
                        Element actSaldo = doc.createElement("saldo");
                        actSaldo.setTextContent(String.valueOf(saldo));
                        Element actCliente = doc.createElement("cliente");
                        actCliente.setTextContent(String.valueOf(idcliente));
                        Element actTipoCuenta = doc.createElement("tipocuenta");
                        actTipoCuenta.setTextContent(tipocuenta);
                        Element actInteres = doc.createElement("interes");
                        actInteres.setTextContent(String.valueOf(interes));
                        Element actSaldoMin = doc.createElement("saldomin");
                        actSaldoMin.setTextContent(String.valueOf(saldomin));
                        actCuenta.appendChild(actSaldo);
                        actCuenta.appendChild(actCliente);
                        actCuenta.appendChild(actTipoCuenta);
                        actCuenta.appendChild(actInteres);
                        actCuenta.appendChild(actSaldoMin);
                        nRaiz.replaceChild(actCuenta, eElement);
                    } else {
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
   public List listarCuenta() {
        Object cuenta = null;
        ArrayList<Object> list = new ArrayList();
        File file = new File("datos/Cuentas.xml");
        int idcuenta;
        double saldo;
        int idcliente;
        String tipocuenta;
        double interes;
        double saldomin;
        //Se crean dos objetos de cada tipo de cuenta.
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Cuenta");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    idcuenta = Integer.parseInt(eElement.getAttribute("id"));
                    saldo = Double.parseDouble(eElement.getElementsByTagName("saldo").item(0).getTextContent());
                    idcliente = Integer.parseInt(eElement.getElementsByTagName("cliente").item(0).getTextContent());
                    tipocuenta = eElement.getElementsByTagName("tipocuenta").item(0).getTextContent();
                    interes = Double.parseDouble(eElement.getElementsByTagName("interes").item(0).getTextContent());;
                    saldomin = Double.parseDouble(eElement.getElementsByTagName("saldomin").item(0).getTextContent());;
                    list.add(cuenta);
                }                
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
        }
        return list;
    }
    @SuppressWarnings("empty-statement")
    public Object buscarCuenta(int id){
        //Una variable para cada atributo del archivo XML
        Object cuenta = null;
        int idcuenta;
        double saldo;
        int idcliente;
        String tipocuenta;
        double interes;
        double saldomin;
        File file = new File("datos/Cuentas.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Cuenta");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (id == Integer.parseInt(eElement.getAttribute("id"))) {
                        
                        idcuenta=Integer.parseInt(eElement.getAttribute("id"));
                        saldo=Double.parseDouble(eElement.getElementsByTagName("saldo").item(0).getTextContent());
                        idcliente=Integer.parseInt(eElement.getElementsByTagName("cliente").item(0).getTextContent());
                        tipocuenta=eElement.getElementsByTagName("tipocuenta").item(0).getTextContent();
                        interes=Double.parseDouble(eElement.getElementsByTagName("interes").item(0).getTextContent());;
                        saldomin=Double.parseDouble(eElement.getElementsByTagName("saldomin").item(0).getTextContent());;
                        //Obtener el Cliente
                        PersonaDAO clienteDAO=new PersonaDAO();
                        Persona cliente=new Persona();
                        cliente=clienteDAO.buscarPersona(idcliente);
                        //Determinar el tipo de cuenta y crear el objeto correspondiente
                        if("A".equals(tipocuenta)){
                            cuenta = new CuentaAhorro(interes,saldomin,idcuenta,cliente);
                        }
                        else{
                            cuenta = new CuentaCorriente(idcuenta,cliente);
                        } 
                        break;
                    } else {
                        cuenta = null;
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.toString());
            
        }
        return cuenta;
                
        
    }
}
