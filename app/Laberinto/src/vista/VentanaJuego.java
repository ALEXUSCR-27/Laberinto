/*
 */
package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import modelo.Modelo;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author asmal
 */
public class VentanaJuego extends javax.swing.JFrame implements KeyListener{
    private Term[][] matrizMadre;
    Modelo pModelo;
    int x;
    int y;
    Atom[] listaValores = {new Atom("i"), new Atom("x"), new Atom("f"), new Atom("ad"), new Atom("at"), new Atom("ab"), new Atom("ar"), new Atom("inter")};
    ArrayList<JLabel> labelArray = new ArrayList<>();
    JLabel[][] matrizLabels;
    int posX;
    int posY;
    
    private final ImageIcon bloque = new ImageIcon(getClass().getResource("/assets/bolck4.png"));
    private final ImageIcon suelo = new ImageIcon(getClass().getResource("/assets/piso.png"));
    private final ImageIcon meta = new ImageIcon(getClass().getResource("/assets/final.png"));
    private final ImageIcon inicio = new ImageIcon(getClass().getResource("/assets/playerInicio.png"));
    private final ImageIcon abajo = new ImageIcon(getClass().getResource("/assets/playerDown.png"));
    private final ImageIcon arriba = new ImageIcon(getClass().getResource("/assets/playerUp.png"));
    private final ImageIcon izquierda = new ImageIcon(getClass().getResource("/assets/playerIz.png"));
    private final ImageIcon derecha = new ImageIcon(getClass().getResource("/assets/playerDe.png"));
    private final ImageIcon ganarMsg = new ImageIcon(getClass().getResource("/assets/ganaste.png"));
    
    
    
    
    
    /**
     * Creates new form VentanaJuego
     * @param modelo
     */
    public VentanaJuego(Modelo modelo) {
        pModelo = modelo;
        initComponents();
        addKeyListener(this);
        this.setExtendedState(VentanaJuego.MAXIMIZED_BOTH);
        Dibujar();
        Jugar();
    }
    
    public final void Dibujar() {
        matrizMadre = pModelo.GetMatrizMadre();
        x = pModelo.GetX();
        y = pModelo.GetY();
        matrizLabels = new JLabel[x][y];
        panelJuego.setLayout(new GridLayout(x, y));
        for (int i = 0;i!=x;i++) {
            for (int j = 0;j!=y;j++) {
                JLabel label = new JLabel();
                if(matrizMadre[i][j].equals(listaValores[1])){
                    label.setIcon(bloque);
                }
                else if (matrizMadre[i][j].equals(listaValores[0])) {
                    label.setIcon(inicio);
                }
                else if (matrizMadre[i][j].equals(listaValores[2])) {
                    label.setIcon(meta);
                }
                else {
                    label.setIcon(suelo);
                }
                matrizLabels[i][j] = label;
                panelJuego.add(label);
            }
        }
    }
    
    public final void Jugar(){
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

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        Variable X = new Variable("X");
        Variable Y = new Variable("Y");
        Query posicionActual = new Query("obtenerPosicionActual", new Term[] {X, Y});
        Map<String, Term> resultados = posicionActual.oneSolution();
        posX = Integer.parseInt(resultados.get("X").toString());
        posY = Integer.parseInt(resultados.get("Y").toString());
        switch(e.getKeyCode()) {
           case(38):
               Query movimientoUP = new Query("movimiento", new Term[]{listaValores[6]});
               System.out.println(movimientoUP.hasSolution());
               Query verificarUP = new Query("verificarPosicion");
               System.out.print("Solucion> ");System.out.println(verificarUP.hasSolution());
               System.out.println(posX);System.out.println(posY);
      
               if (verificarUP.hasSolution()) {
                   System.out.println("si entra");
                   Query movimientoValido =  new Query("aMovimientoVerificado", new Term[] {listaValores[6]});
                   System.out.println(movimientoValido.hasSolution());
                   matrizLabels[posX][posY].setIcon(suelo); //arriba
                   
                   Variable X2 = new Variable("X");
                   Variable Y2 = new Variable("Y");
                   
                   Query posicionNueva = new Query("obtenerPosicionActual", new Term[] {X2, Y2});
                   Map<String, Term> resultadosUP = posicionNueva.oneSolution();
                   int nuevoX = Integer.parseInt(resultadosUP.get("X").toString());
                   int nuevoY = Integer.parseInt(resultadosUP.get("Y").toString());
                   
                   matrizLabels[nuevoX][nuevoY].setIcon(arriba); //arriba
                   Query ganar = new Query("verificarGane");
                   if (ganar.hasSolution()) {
                       System.out.println("gano");
                       JDialog ventanaGanador =  new JDialog();
                       JLabel ganador = new JLabel();
                       ganador.setIcon(ganarMsg);
                       ventanaGanador.setSize(510, 520);
                       ventanaGanador.setLocationRelativeTo(null);
                       ventanaGanador.add(ganador);
                       ventanaGanador.setVisible(true);
                       ventanaGanador.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                   }
               }
               break;
           case(40):
               Query movimientoDown = new Query("movimiento", new Term[]{listaValores[5]});
               System.out.println(movimientoDown.hasSolution());
               Query verificarDown = new Query("verificarPosicion");
               
               if (verificarDown.hasSolution()) {
                   Query movimientoValido =  new Query("aMovimientoVerificado", new Term[] {listaValores[5]});
                   System.out.println(movimientoValido.hasSolution());
               
                   matrizLabels[posX][posY].setIcon(suelo); //abajo
                   Variable X2 = new Variable("X");
                   Variable Y2 = new Variable("Y");
                   
                   Query posicionNueva = new Query("obtenerPosicionActual", new Term[] {X2, Y2});
                   Map<String, Term> resultadosDown = posicionNueva.oneSolution();
                   int nuevoX = Integer.parseInt(resultadosDown.get("X").toString());
                   int nuevoY = Integer.parseInt(resultadosDown.get("Y").toString());
                   
                   matrizLabels[nuevoX][nuevoY].setIcon(abajo); //abajo
                   Query ganar = new Query("verificarGane");
                   if (ganar.hasSolution()) {
                       System.out.println("gano");
                       JDialog ventanaGanador =  new JDialog(this);
                       JLabel ganador = new JLabel();
                       ganador.setIcon(ganarMsg);
                       ventanaGanador.setSize(510, 520);
                       ventanaGanador.setLocationRelativeTo(null);
                       ventanaGanador.add(ganador);
                       ventanaGanador.setVisible(true);
                       ventanaGanador.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                   }
               }
               break;
            case(39):
               Query movimientoRG = new Query("movimiento", new Term[]{listaValores[3]});
               System.out.println(movimientoRG.hasSolution());
               Query verificarRG = new Query("verificarPosicion");
               
               if (verificarRG.hasSolution()) {
                   Query movimientoValido =  new Query("aMovimientoVerificado", new Term[] {listaValores[3]});
                   System.out.println(movimientoValido.hasSolution());
                   matrizLabels[posX][posY].setIcon(suelo);
                   Variable X2 = new Variable("X");
                   Variable Y2 = new Variable("Y");
                   
                   Query posicionNueva = new Query("obtenerPosicionActual", new Term[] {X2, Y2});
                   Map<String, Term> resultadosRG = posicionNueva.oneSolution();
                   int nuevoX = Integer.parseInt(resultadosRG.get("X").toString());
                   int nuevoY = Integer.parseInt(resultadosRG.get("Y").toString());
                   
                   matrizLabels[nuevoX][nuevoY].setIcon(derecha);
                   Query ganar = new Query("verificarGane");
                   if (ganar.hasSolution()) {
                       System.out.println("gano");
                       JDialog ventanaGanador =  new JDialog();
                       
                       JLabel ganador = new JLabel();
                       ganador.setIcon(ganarMsg);
                       ventanaGanador.setSize(510, 520);
                       ventanaGanador.setLocationRelativeTo(null);
                       ventanaGanador.add(ganador);
                       ventanaGanador.setVisible(true);
                       ventanaGanador.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                   }
               }
                break;
            case(37):
                Query movimientoIZ = new Query("movimiento", new Term[]{listaValores[4]});
                System.out.println(movimientoIZ.hasSolution());
                Query verificarIZ = new Query("verificarPosicion");
               
               if (verificarIZ.hasSolution()) {
                   Query movimientoValido =  new Query("aMovimientoVerificado", new Term[] {listaValores[4]});
                   System.out.println(movimientoValido.hasSolution());
                   matrizLabels[posX][posY].setIcon(suelo);
                   Variable X2 = new Variable("X");
                   Variable Y2 = new Variable("Y");
                   
                   Query posicionNueva = new Query("obtenerPosicionActual", new Term[] {X2, Y2});
                   Map<String, Term> resultadosIZ = posicionNueva.oneSolution();
                   int nuevoX = Integer.parseInt(resultadosIZ.get("X").toString());
                   int nuevoY = Integer.parseInt(resultadosIZ.get("Y").toString());
                   
                   matrizLabels[nuevoX][nuevoY].setIcon(izquierda); 
                   Query ganar = new Query("verificarGane");
                   if (ganar.hasSolution()) {
                       System.out.println("gano");
                       JDialog ventanaGanador =  new JDialog();
                       ventanaGanador.setSize(510, 520);
                       JLabel ganador = new JLabel();
                       ganador.setIcon(ganarMsg);
                       ventanaGanador.setLocationRelativeTo(null);
                       ventanaGanador.add(ganador);
                       ventanaGanador.setVisible(true);
                       ventanaGanador.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                   }
               }
               break;
                
            default:
                break;
        } 
    }
}
