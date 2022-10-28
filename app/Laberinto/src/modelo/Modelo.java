/*
 */
package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JDialog;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/**
 *
 * @author asmal
 */
public class Modelo {
    JDialog Aviso = new JDialog();
    Term[][] matrizMadre;
    Atom[] listaValores = {new Atom("i"), new Atom("x"), new Atom("f"), new Atom("ad"), new Atom("at"), new Atom("ab"), new Atom("ar"), new Atom("inter")};
    int x;
    int y;
    int posActualX;
    int posActualY;
    
    
    public void ConectarPL() {
        Query conectar = new Query( "consult", new Term[] {new Atom("T:\\2022\\S2\\LENGUAJES DE PROGRAMACION\\PRY3\\Laberinto\\app\\main.pl")});
        System.out.println(conectar.hasSolution());
        Query limpieza = new Query("limpieza");
        System.out.println(limpieza.hasSolution());
    }
    public void BuscarArchivo(String direccion) {
        
        Query leerArchivo = new Query("leerArchivo", new Term[]{new Atom(direccion)});
        System.out.println(leerArchivo.hasSolution());
        
        Variable X = new Variable("X");
       
        Query obtenerMatriz = new Query("devolverMatriz", new Term[] {X});
        Map<String,Term> matriz;
        matriz = obtenerMatriz.oneSolution();
        ObtenerMatriz(matriz);
    }
    
    public void ObtenerMatriz(Map<String, Term> matriz) {
        Term[][] resultado;
        x = matriz.get("X").listLength()-1;
        y = matriz.get("X").listToTermArray()[0].listLength();
        System.out.println(x);
        resultado = new Term [x][y];
        for (int i = 0;i!=x;i++) {
            for (int j = 0;j!=y;j++) {
                resultado[i][j] = matriz.get("X").listToTermArray()[i].listToTermArray()[j];
            }
        }
        matrizMadre = resultado;
    }
    
    public void Dibujar() {
        System.out.println(GetX());System.out.println(y);
        for (int i = 0;i!=x;i++) {
            for (int j = 0;j!=y;j++) {
                if(matrizMadre[i][j].equals(listaValores[1])) {
                    System.out.print("#");
                }
                else {System.out.print(" ");}
            }
            System.out.print("\n");
        }
    }
    
    
    public int GetX() {return x;}
    public int GetY() {return y;}
    public Term[][] GetMatrizMadre() {return matrizMadre;}
    
    public void CrearXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            Document documento = implementation.createDocument(null,"DatosJugador",null);
            documento.setXmlVersion("1.0");
            
            //Element usuarios= documento.createElement("Datos");
            //documento.getDocumentElement().appendChild(usuarios);
            
            Source source= new DOMSource(documento);
            Result result= new StreamResult(new File("Data.xml"));
            
            try
            {
                Transformer transformer= TransformerFactory.newInstance().newTransformer();
                try
                {
                    transformer.transform(source,result);
                }
                catch (javax.xml.transform.TransformerException te)
                {
                    te.printStackTrace();
                }
                
            }
            catch (javax.xml.transform.TransformerConfigurationException tce)
            {
                tce.printStackTrace();
            }
            
        }
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
    }
    
}
