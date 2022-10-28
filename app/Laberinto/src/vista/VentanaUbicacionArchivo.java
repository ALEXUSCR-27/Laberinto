
package vista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.Modelo;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

/**
 *
 * @author Alex Sanchez Cespedes
 */
public class VentanaUbicacionArchivo extends javax.swing.JFrame {
    Modelo pModelo;
    /**
     * Constructor de la clase VentasnaUbicacionArchivo
     * @param modelo
     */
    public JFrame ventanaAnterior;
    public VentanaUbicacionArchivo(Modelo modelo) {
        pModelo = modelo;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputArchivo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        nombreJug = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setIconImages(null);
        setLocation(new java.awt.Point(600, 200));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputArchivo.setBackground(new java.awt.Color(46, 60, 60));
        inputArchivo.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N
        inputArchivo.setForeground(new java.awt.Color(255, 255, 255));
        inputArchivo.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));
        inputArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(inputArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 650, 480, 50));
        inputArchivo.getAccessibleContext().setAccessibleName("inputArchivo");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buscar2.png"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 255, 255), new java.awt.Color(0, 153, 153)));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, -1, -1));

        nombreJug.setBackground(new java.awt.Color(46, 60, 60));
        nombreJug.setFont(new java.awt.Font("Calisto MT", 1, 24)); // NOI18N
        nombreJug.setForeground(new java.awt.Color(255, 255, 255));
        nombreJug.setAutoscrolls(false);
        nombreJug.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));
        jPanel1.add(nombreJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 520, 480, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bichito.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 890, 100, 120));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/meta$.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 900, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/titulo2.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/nombreJug.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/volver.png"))); // NOI18N
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 255, 255), new java.awt.Color(0, 153, 153)));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 920, 180, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo5.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputArchivoActionPerformed
       inputArchivo.setText("");
    }//GEN-LAST:event_inputArchivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarArchivo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void BuscarArchivo() {
        String direccion = inputArchivo.getText();
        pModelo.BuscarArchivo(direccion);
        String nombre = nombreJug.getText();
        
        
        VentanaJuego juego = new VentanaJuego(pModelo);
        juego.setVisible(true);
        this.dispose();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputArchivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreJug;
    // End of variables declaration//GEN-END:variables
}
