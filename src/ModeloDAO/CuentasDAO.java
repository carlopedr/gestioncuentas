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
        
    }
    public void actualizarCuenta(int id){
        
    }
    public List listarCuenta(){
        return null;
        
    }
    public Object buscarCuenta(int id){
        return null;
        
    }
}
