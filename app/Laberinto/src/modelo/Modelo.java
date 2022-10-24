/*
 */
package modelo;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.JDialog;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

/**
 *
 * @author asmal
 */
public class Modelo {
    public void ConectarPL() {
        Query conectar = new Query( "consult", new Term[] {new Atom("T:\\2022\\S2\\LENGUAJES DE PROGRAMACION\\PRY3\\Laberinto\\app\\main.pl")});
        System.out.println(conectar.hasSolution());
    }
    public Map<String,Term> BuscarArchivo(String direccion) {
        
        Query leerArchivo = new Query("leerArchivo", new Term[]{new Atom(direccion)});
        System.out.println(leerArchivo.hasSolution());
        
        Variable X = new Variable("X");
       
        Query obtenerMatriz = new Query("devolverMatriz", new Term[] {X});
        java.util.Map<String,Term> matriz;
        matriz = obtenerMatriz.oneSolution();
        return matriz;
    }
}
