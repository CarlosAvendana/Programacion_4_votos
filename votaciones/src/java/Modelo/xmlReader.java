
package Modelo;


import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class xmlReader implements Serializable{

    private List<Usuario> cargarDatos() {
        List<Usuario> lista = new ArrayList<>();
        try {
            File inputFile = new File("C:\\Users\\demil\\Desktop\\votos");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("usuario");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Usuario user = new Usuario(
                            eElement.getElementsByTagName("cedula").item(0).getTextContent(),
                            eElement.getElementsByTagName("nombre").item(0).getTextContent(),
                            eElement.getElementsByTagName("apellido1").item(0).getTextContent(),
                            eElement.getElementsByTagName("apellido2").item(0).getTextContent(),
                            eElement.getElementsByTagName("clave").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("activo").item(0).getTextContent()) 
                    );
                    lista.add(user);
                }
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
//    public void guardarBD(){
//        List<Usuario> list = cargarDatos();
//        GestorBD ges = GestorBD.obtenerInstancia();
//        for(int i = 0; i < list.size(); i++){
//            ges.anadirUsuario(list.get(i));
//        }        
//    }
}
