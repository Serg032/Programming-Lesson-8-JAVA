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

public class CreaXML {
    public void crear(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "concesionario", null);
            document.setXmlVersion("1.0");
            // creo cocches
            Element coches = document.createElement("coches");
            Element coche = document.createElement("coche");
            // creo matricula
            Element matricula = document.createElement("Matricula");
            Text textMatricula = document.createTextNode("5599 CLL");
            matricula.appendChild(textMatricula);
            coche.appendChild(matricula);
            // creo marca
            Element marca = document.createElement("marca");
            Text textMarca = document.createTextNode("AUDI");
            marca.appendChild(textMarca);
            coche.appendChild(marca);
            // Precio
            Element precio = document.createElement("precio");
            Text textPrecio = document.createTextNode("30000");
            precio.appendChild(textPrecio);
            coche.appendChild(precio);
            // Añado al elemento coches el elemento coche
            coches.appendChild(coche);
            // Añado al root el elemento coches
            document.getDocumentElement().appendChild(coches);
            // Asocio el source con el Document
            Source source = new DOMSource(document);
            // Creo el Result, indicado que fichero se va a crear
            Result result = new StreamResult(new File("concesionario.xml"));
            // Creo un transformer, se crea el fichero XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
