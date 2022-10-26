/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import modelo.Modelo;
import org.jpl7.Atom;
import org.jpl7.Term;

/**
 *
 * @author asmal
 */
public class VentanaJuego extends javax.swing.JFrame {
    private Term[][] matrizMadre;
    Modelo pModelo;
    int x;
    int y;
    Atom[] listaValores = {new Atom("i"), new Atom("x"), new Atom("f"), new Atom("ad"), new Atom("at"), new Atom("ab"), new Atom("ar"), new Atom("inter")};
    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego(Modelo modelo) {
        pModelo = modelo;
        pModelo.Dibujar();
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        matrizMadre = pModelo.GetMatrizMadre();
        x = pModelo.GetX();
        y = pModelo.GetY();
        panelJuego.setLayout(new GridLayout(x, y));
        ArrayList<JLabel> labelArray = new ArrayList<>() ;
        for (int i = 0;i!=x;i++) {
            for (int j = 0;j!=y;j++) {
                JLabel label = new JLabel();
                if(matrizMadre[i][j].equals(listaValores[1])){
                    label.setIcon(new ImageIcon(getClass().getResource("/assets/bolck4.png")));
                }
                else if (matrizMadre[i][j].equals(listaValores[0])) {
                    label.setIcon(new ImageIcon(getClass().getResource("/assets/playerInicio.png")));
                }
                else {
                    label.setIcon(new ImageIcon(getClass().getResource("/assets/piso.png")));
                }
                labelArray.add(label);
                panelJuego.add(label);
            }
            System.out.print("\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelJuego = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1100));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 1100));

        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJuego.setBackground(new java.awt.Color(0, 0, 0));
        panelJuego.setAlignmentX(0.0F);
        panelJuego.setAlignmentY(0.0F);
        panelJuego.setAutoscrolls(true);
        panelJuego.setPreferredSize(new java.awt.Dimension(880, 970));
        panelJuego.setLayout(new java.awt.GridBagLayout());
        jPanel2.add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo5.jpg"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(1980, 1100));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
