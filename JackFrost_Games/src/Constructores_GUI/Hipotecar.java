/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructores_GUI;

import Box.BoxProperty;
import BoxTools.Card;
import BoxTools.CardJail;
import Player.Player;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class Hipotecar extends javax.swing.JFrame {
    
    private BoxProperty theBox;
    private Card card;
    private Player player;
    //Cuando es verdadero se manejara una propiedad cuando es falso se tratara como una carta
    private boolean decision=false;
    
    /**
     * Creates new form Hipotecar, usar con cualquier casilla tipo propiedad
     * @param boxProperty
     */
    public Hipotecar(BoxProperty boxProperty,Player playerN) {
        decision=true;
        this.theBox = boxProperty;
        this.player = playerN;
        initComponents();
        declararPropiedad();
        jLabel1.setText(theBox.getName());
        setVisible(true);
    }
    
    /**
     *Creates new form Hipotecar, usar para cartas
     * @param player
     */
    public Hipotecar(Player player) {
        decision=false;
        if(player.getCards().length>0)
            card=player.getCards()[0];
        this.player=player;                
        initComponents();
        declararCarta();
        jLabel1.setText("Carta Salir de Carcél");
        setVisible(true);
        
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setOpaque(true);
        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("jLabel1");

        jButton1.setText("Hipotecar");
        jButton1.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Recuperar");
        jButton2.setVisible(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("jLabel1");
        jLabel2.setText("Dinero: "+Integer.toString(player.getDinero()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(36, 36, 36)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(decision){
           theBox.mortage(player);
           jLabel2.setText("Dinero: "+Integer.toString(player.getDinero()));
        }else{
            player.addDinero(((CardJail)card).getPrice());
            player.eliminateCard();
            JOptionPane.showMessageDialog(null, player.getNombre() + " ha vendido una carta");
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        theBox.recoverFromMortage(player);
        jLabel2.setText("Dinero: "+Integer.toString(player.getDinero()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void declararPropiedad(){
        jButton1.setVisible(true);
        jButton2.setVisible(true);
    }

    private void declararCarta(){
        jButton1.setText("Vender");
        jButton1.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}