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
    JDialog Aviso = new JDialog();
    Term[][] matrizMadre;
    Atom[] listaValores = {new Atom("i"), new Atom("x"), new Atom("f"), new Atom("ad"), new Atom("at"), new Atom("ab"), new Atom("ar"), new Atom("inter")};
    int x;
    int y;
    
    
    public void ConectarPL() {
        Query conectar = new Query( "consult", new Term[] {new Atom("T:\\2022\\S2\\LENGUAJES DE PROGRAMACION\\PRY3\\Laberinto\\app\\main.pl")});
        System.out.println(conectar.hasSolution());
    }
    public void BuscarArchivo(String direccion) {
        
        Query leerArchivo = new Query("leerArchivo", new Term[]{new Atom(direccion)});
        System.out.println(leerArchivo.hasSolution());
        
        Variable X = new Variable("X");
       
        Query obtenerMatriz = new Query("devolverMatriz", new Term[] {X});
        java.util.Map<String,Term> matriz;
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
    
}
