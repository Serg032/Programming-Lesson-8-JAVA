import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeerCLientes {
    public void leer(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(new File("clientes.xml"));

            NodeList listaClientes = documento.getElementsByTagName("cliente");

            for (int i = 0; i < listaClientes.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaClientes.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("Propiedad: " + hijo.getNodeName() + ", Valor: " + hijo.getTextContent());
                        }
                    }
                    System.out.println("");
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
