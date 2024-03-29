/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

/**
 *
 * @author Andre
 */
public class XML {
    
    public static void leeXml(String path){
        try {
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Raiz :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("Staff path : " + eElement.getAttribute("path"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public static void AddUser(String path,String id,String username,String password,String name,String lastName,
            String rootId, String rootName, String rootPath, String rootSize,
            String folderId, String folderName, String folderPath,String folderSize) 
        throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{

        File fXmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        Element root = doc.getDocumentElement();

        //Creamos un nuevo elemento en la casa
        Element user = doc.createElement("user");
        user.setAttribute("id", id);
        user.setAttribute("name", name);
        user.setAttribute("lastename", lastName);
        user.setAttribute("username", username);
        user.setAttribute("password", password);

        Element rootUser = doc.createElement("root");
        rootUser.setAttribute("id", rootId);
        rootUser.setAttribute("name", rootName);
        rootUser.setAttribute("path", rootPath);
        rootUser.setAttribute("size", rootSize);
        user.appendChild(rootUser);

        Element folder = doc.createElement("folder");
        folder.setAttribute("id", folderId);
        folder.setAttribute("name", folderName);
        folder.setAttribute("path", folderPath);
        folder.setAttribute("size", folderSize);    
        rootUser.appendChild(folder);

        root.appendChild(user);

        DOMSource source = new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(path);
        transformer.transform(source, result);

        //Añadimos la información a la casa ya existente
       // NodeList nodoRaiz = doc.getDocumentElement().getElementsByTagName("company");
        //nodoRaiz.item(0).appendChild(staff);
        /*staff.appendChild(firstname);
        staff.appendChild(lastname);
        staff.appendChild(nickname);
        staff.appendChild(salary);*/

        //Guardamos la nueva estructura la fichero XML
    }
    
    
    public static boolean encuentraUser(String path,String username,String pass) throws ParserConfigurationException, SAXException, IOException{
        boolean flag = false;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(path));
        doc.getDocumentElement().normalize();
        NodeList listaNodos = doc.getDocumentElement().getElementsByTagName("user");
        for (int temp = 0; temp < listaNodos.getLength(); temp++) {
            Node nodo = listaNodos.item(temp);		
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodo;
                if(eElement.getAttribute("username").equals(username) &&
                        eElement.getAttribute("password").equals(pass))
                    flag = true;
            }
        }
        return flag;
    }

    public static void eliminaNodo(String path, String name) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(path));
        doc.getDocumentElement().normalize();
        
        NodeList listaNodos = doc.getDocumentElement().getElementsByTagName("staff");
        for (int temp = 0; temp < listaNodos.getLength(); temp++) {
            Node nodo = listaNodos.item(temp);		
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodo;
                if (eElement.getElementsByTagName("firstname").item(0).getTextContent().equals((name))) {
                    nodo.getParentNode().removeChild(nodo);
                }
            }
        }
            
        DOMSource source = new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(path);
        transformer.transform(source, result);
    }
    
}
