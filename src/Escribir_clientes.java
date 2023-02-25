import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class Escribir_clientes {
    private Scanner teclado = new Scanner(System.in);
    public void crear(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "empresa", null);
            document.setXmlVersion("1.0");

            Element cliente = document.createElement("cliente");

            System.out.println("Recuerda que si quieres añadir algun campo con espacios, esto tendra que ser hecho mediante una _ o -.");

            this.pedirNif(document, cliente);
            this.pedirNombre(document, cliente);
            this.pedirTelefono(document, cliente);
            this.pedirDireccion(document, cliente);
            this.pedirDeuda(document, cliente);

            document.getDocumentElement().appendChild(cliente);
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("clientes.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void pedirNif(Document document, Element cliente){
        System.out.println("Introduzca el nif del cliente:");
        Element nif = document.createElement("nif");
        Text textNif = document.createTextNode(this.teclado.next());
        nif.appendChild(textNif);
        cliente.appendChild(nif);
    }
    private void pedirNombre(Document document, Element cliente){
        System.out.println("Introduzca el nombre del cliente:");
        Element nombre = document.createElement("nombre");
        Text textNombre = document.createTextNode(this.teclado.next());
        nombre.appendChild(textNombre);
        cliente.appendChild(nombre);
    }
    private void pedirTelefono(Document document, Element cliente){
        System.out.println("Introduzca el telefono del cliente:");
        Element telefono = document.createElement("telefono");
        Text textTelefono = document.createTextNode(this.teclado.next());
        telefono.appendChild(textTelefono);
        cliente.appendChild(telefono);
    }
    private void pedirDireccion(Document document, Element cliente){
        System.out.println("Introduzca la direccion del clente:");
        Element direccion = document.createElement("direccion");
        Text textDireccion = document.createTextNode(this.teclado.next());
        direccion.appendChild(textDireccion);
        cliente.appendChild(direccion);
    }
    private void pedirDeuda(Document document, Element cliente){
        System.out.println("Introduzca la deuda del cliente");
        Element deuda = document.createElement("deuda");
        Text textDeuda = document.createTextNode(this.teclado.next());
        deuda.appendChild(textDeuda);
        cliente.appendChild(deuda);
    }
}
