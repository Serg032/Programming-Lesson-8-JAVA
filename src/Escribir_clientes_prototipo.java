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

public class Escribir_clientes_prototipo {
    private Scanner teclado = new Scanner(System.in);
    public void crear(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "concesionario", null);
            document.setXmlVersion("1.0");

            Element empresa = document.createElement("empresa");
            Element cliente = document.createElement("cliente");

            System.out.println("Recuerda que si quieres añadir algun campo con espacios, esto tendra que ser hecho mediante una _ o -.");

            System.out.println("Introduzca el nif del cliente:");
            Element nif = document.createElement("nif");
            Text textNif = document.createTextNode(this.teclado.next());
            nif.appendChild(textNif);
            cliente.appendChild(nif);

            System.out.println("Introduzca el nombre del cliente:");
            Element nombre = document.createElement("nombre");
            Text textNombre = document.createTextNode(this.teclado.next());
            nombre.appendChild(textNombre);
            cliente.appendChild(nombre);

            System.out.println("Introduzca el telefono del cliente:");
            Element telefono = document.createElement("telefono");
            Text textTelefono = document.createTextNode(this.teclado.next());
            telefono.appendChild(textTelefono);
            cliente.appendChild(telefono);

            System.out.println("Introduzca la direccion del clente:");
            Element direccion = document.createElement("direccion");
            Text textDireccion = document.createTextNode(this.teclado.next());
            direccion.appendChild(textDireccion);
            cliente.appendChild(direccion);

            System.out.println("Introduzca la deuda del cliente");
            Element deuda = document.createElement("deuda");
            Text textDeuda = document.createTextNode(this.teclado.next());
            deuda.appendChild(textDeuda);
            cliente.appendChild(deuda);

            StringBuilder continuar = new StringBuilder();
            do {
                System.out.println("Quiere continuar añadiendo clientes?");
                System.out.println("Pulse Enter para continuar o escriba 'no' para terminar:");
                continuar.append(this.teclado.next());

                Element cliente1 = document.createElement("cliente");

                System.out.println("Introduzca el nif del cliente:");
                Element nif1 = document.createElement("nif");
                Text textNif1 = document.createTextNode(this.teclado.next());
                nif1.appendChild(textNif1);
                cliente1.appendChild(nif1);

                System.out.println("Introduzca el nombre del cliente:");
                Element nombre1 = document.createElement("nombre");
                Text textNombre1 = document.createTextNode(this.teclado.next());
                nombre1.appendChild(textNombre1);
                cliente1.appendChild(nombre1);

                System.out.println("Introduzca el telefono del cliente:");
                Element telefono1 = document.createElement("telefono");
                Text textTelefono1 = document.createTextNode(this.teclado.next());
                telefono1.appendChild(textTelefono1);
                cliente1.appendChild(telefono1);

                System.out.println("Introduzca la direccion del clente:");
                Element direccion1 = document.createElement("direccion");
                Text textDireccion1 = document.createTextNode(this.teclado.next());
                direccion1.appendChild(textDireccion1);
                cliente1.appendChild(direccion1);

                System.out.println("Introduzca la deuda del cliente");
                Element deuda1 = document.createElement("deuda");
                Text textDeuda1 = document.createTextNode(this.teclado.next());
                deuda1.appendChild(textDeuda1);
                cliente1.appendChild(deuda1);

                empresa.appendChild(cliente1);

                System.out.println("Quiere continuar añadiendo clientes?");
                System.out.println("Pulse Enter para continuar o escriba 'no' para terminar:");
                continuar.delete(0, continuar.length() + 1);
                continuar.append(this.teclado.next());
                System.out.println(continuar);
                System.out.println(continuar.equals(new StringBuilder().append("no")));

            } while (!continuar.equals(new StringBuilder().append("no")));

            empresa.appendChild(cliente);

            document.getDocumentElement().appendChild(empresa);
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("clientes.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
