/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
import vista.VentanaInicio;

/**
 *
 * @author asmal
 */
public class Laberinto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
        /*
        
        Query q1 = new Query( "consult", new Term[] {new Atom("C:\\Users\\asmal\\eclipse-workspace\\Prueba2\\src\\prueba.pl")} );
	System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
        Query q2 = new Query( "child_of", new Term[] {new Atom("joe"),new Atom("ralf")} );
	System.out.println( "child_of(joe,ralf) is " + ( q2.hasSolution() ? "provable" : "not provable" ) );
	System.out.println(q2.hasSolution());
		
	Variable X = new Variable("X");
	Query q4 = new Query( "descendent_of", new Term[] {X,new Atom("ralf")} );

	java.util.Map<String,Term> solution;

	solution = q4.oneSolution();

	System.out.println( "first solution of descendent_of(X, ralf)"); 
	System.out.println( "X = " + solution.get("X"));*/
    }
    
}
