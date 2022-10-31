/*
 * Nombre del paquete: app
 */
package app;

import vista.VentanaInicio;

//Inclusion de librerias y clases
import modelo.Modelo;

/**
 *
 * @author Alex Sánchez Céspedes
 */
public class Laberinto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        modelo.CrearXML();
        
        modelo.ConectarPL();
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
    }
    
}
