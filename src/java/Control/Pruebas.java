/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Andre
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        // TODO code application logic here
        
        String path;
        path = "DB\\prueba.xml";
        
        /*XML.AnadirCaracteristica("C:\\Users\\Andre\\Documents\\TEC\\IX Semestre\\Sistemas Operativos\\Xml\\prueba.xml",
                "4545", "Al", "Godinez", "Gof", "125");*/
        
        //XML.eliminaNodo(path, "low");
        
        XML.leeXml(path);
        //System.out.println(XML.encuentraNodo(path, "4545"));
    }
    
}
