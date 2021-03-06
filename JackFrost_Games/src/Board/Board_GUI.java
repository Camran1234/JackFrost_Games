/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Box.BoxProperty;
import BoxTools.CardGoJail;
import Constructores_GUI.Buscador;
import Map_Initializer.Map;
import Player.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import Constructores_GUI.VerPropiedades;
import File.ErrorException_GUI;
import File.FileMap;
import Map_Initializer.Map_GUI;
import Menu_GUI.Menu_GUI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Board_GUI es una interfaz que nos permite interactuar con las propiedades del mapa
 * tanto como sus jugadores y las animaciones
 * @author camran
 */
public class Board_GUI extends javax.swing.JFrame {
    private Map map;
    private JTextArea[] textAreas = new JTextArea[3];
    private JPanel panelAux;
    private int vecesTiradas=0;
    /**
     * Creates new form Board_GUI
     */
    public Board_GUI(Map map) {
        this.map = map;
        initComponents();
        panelTablero.setLayout(new java.awt.GridLayout(map.getTemplate().length, map.getTemplate()[0].length));
        this.setVisible(true);
        textAreas[0] = jTextArea1;
        textAreas[1] = jTextArea2;
        textAreas[2] = jTextArea3;

        reloj();
        printPlayers();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTablero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        panelInformativo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        labelTurno = new javax.swing.JLabel();
        labelDinero = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTablero.setOpaque(true);
        for(int rows=0; rows<map.getTemplate().length;rows++){
            for(int cols=0;cols<map.getTemplate()[0].length;cols++){
                if(map.getTemplate()[rows][cols].getPrimitiv() ==false)
                panelTablero.add(map.getTemplate()[rows][cols].getPanelGame());
                else{
                    JPanel panel = new JPanel();
                    panel.setOpaque(true);
                    panel.setBackground(Color.CYAN);
                    panelTablero.add(panel);
                }

            }
        }
        panelTablero.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
        panelTablero.setBackground(new java.awt.Color(0, 255, 255));
        panelTablero.setForeground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1765, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        jPanel1.setOpaque(true);
        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 0, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setVerticalAlignment(JLabel.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(659, 659, 659))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 8));
        jPanel2.setOpaque(true);
        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        jButton1.setText("Propiedades");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Bancarrota");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Construir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Tirar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Fin Turno");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Fin Juego");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Hipotecar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        panelInformativo.setLayout(new GridLayout(0,2));
        panelInformativo.setOpaque(true);
        panelInformativo.setBackground(new java.awt.Color(0, 0, 0));
        panelInformativo.setForeground(new java.awt.Color(204, 255, 204));

        jTextArea1.setEditable(false);
        jTextArea1.setOpaque(true);
        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setOpaque(true);
        jTextArea2.setBackground(new java.awt.Color(51, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setEditable(false);
        jTextArea3.setOpaque(true);
        jTextArea3.setBackground(new java.awt.Color(51, 255, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout panelInformativoLayout = new javax.swing.GroupLayout(panelInformativo);
        panelInformativo.setLayout(panelInformativoLayout);
        panelInformativoLayout.setHorizontalGroup(
            panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformativoLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInformativoLayout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(462, Short.MAX_VALUE)))
        );
        panelInformativoLayout.setVerticalGroup(
            panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformativoLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(panelInformativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformativoLayout.createSequentialGroup()
                    .addContainerGap(26, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        labelTurno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelTurno.setForeground(new java.awt.Color(60, 63, 65));
        labelTurno.setText("Turno:");

        labelDinero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelDinero.setForeground(new java.awt.Color(60, 63, 65));
        labelDinero.setText("Dinero:");

        jButton8.setText("Comprar");
        jButton8.setVisible(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(labelDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addGap(65, 65, 65)
                .addComponent(panelInformativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton7)
                    .addComponent(labelTurno)
                    .addComponent(jButton8))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jButton9)
                            .addComponent(jButton6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelDinero)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInformativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getTurnosPerdidos() == 0 &&
                map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getaccestoPlay()==true){
            int []totales = new int[map.getPlayerHandler().getNumberDices()];
            int dadosIguales=1;
             
            
            if(map.getDadosTirados()==false){
                for(int i=0;i<map.getPlayerHandler().getNumberDices();i++){
                    try {
                    map.getPlayerHandler().lanzarDados(textAreas[i]);
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                map.getPlayerHandler().setVisibletheButton(jButton4);
                map.setDadosTirados(true);
                
            }else{
                //Metemos en un vector los resultados de los dados
                //y aplicamos el metodo de mover posicion
                //luego prohibimos al usuario el acceso a este
                //y de ultimo se comprueba de que no se hallan lanzado la misma magnitud en los dados
                //si resulta asi entonces se vuelve a habilitar el boton
                for(int i=0;i<totales.length;i++){
                    totales[i] = Integer.parseInt(textAreas[i].getText().trim());
                    map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].move(totales[i]);
                }
                
                jButton4.setText("Tirar");
                jButton4.setVisible(false);
                printPlayers();
                
                for(int i=0;i<totales.length;i++){
                    if((i+1)<totales.length ){
                        if(totales[i] == totales[i+1]){
                            dadosIguales++;
                        }
                    }
                }
                
                //Aqui comparamos si los numeros obtenidos son iguales y reiniciamos la casilla
                if(dadosIguales==totales.length && map.getPlayerHandler().getNumberDices()>1){
                    map.setDadosTirados(false);
                    jButton4.setVisible(true);
                    vecesTiradas++;
                }
                Player player = map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()];
                if(vecesTiradas<3){
                    //Estas dos lineas nos dice el jugador que le toca este turno y accionamos la casilla
                    //en la que este parado
                    if(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getPosition()!=0)
                        map.getRoute().getRoute()[player.getPosition()].getBox().doBox(player);
                }else{
                    CardGoJail newCard = new CardGoJail();
                    newCard.doCard(player);
                }
                printPlayers();


            }
        }  else{
            JOptionPane.showMessageDialog(null, "Faltan " + map.getPlayerHandler().getPlayers()
                    [map.getPlayerHandler().getTurn()].getTurnosPerdidos() + " Turnos");
        }  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getaccestoPlay()==true){
            jButton8.setVisible(false);
            map.getPlayerHandler().turnPass();
            if(map.getPlayerHandler().getTurn() == 0){
                map.getBank().addInterests();
            }
            jButton4.setVisible(true);
            map.setDadosTirados(false);
            vecesTiradas=0;
            printPlayers();
            map.getBank().aumentarGrupos();
            if(map.checkForWinners()){
                try {
                    map.doResults();
                    setVisible(false);
                    dispose();
                } catch (ErrorException_GUI ex) {
                    Logger.getLogger(Board_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Estas en bancarrota no puedes continuar" , "Acceso Denegado",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getTurnosPerdidos() == 0&&
                map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getaccestoPlay()==true){
            new Buscador(map.getBank(), map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()],true);
        }else{
            JOptionPane.showMessageDialog(null, "Faltan " + map.getPlayerHandler().getPlayers()
                    [map.getPlayerHandler().getTurn()].getTurnosPerdidos() + " Turnos");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getTurnosPerdidos() == 0&&
                map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getaccestoPlay()==true){
           new VerPropiedades(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()],map.getBank()); 
        }else{
            JOptionPane.showMessageDialog(null, "Faltan " + map.getPlayerHandler().getPlayers()
                    [map.getPlayerHandler().getTurn()].getTurnosPerdidos() + " Turnos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getTurnosPerdidos() == 0&&
                map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getaccestoPlay()==true)
            new Buscador(map.getBank(), map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()],false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            //Alteramos la variable de poder seguir jugando del jugador y lo sacamos del juego y de ultimo pasamos turno
            map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].setLooser();
            JOptionPane.showMessageDialog(new JFrame(), map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getNombre()+" se ha declarado en bancarrota");
            map.getBank().resetPropertys(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()]);
            if(map.checkForWinners()){
                try {
                    map.doResults();
                    setVisible(false);
                    dispose();
                    new Menu_GUI();
                } catch (ErrorException_GUI ex) {
                    Logger.getLogger(Board_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            printPlayers();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Player player = map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()];
        BoxProperty box = (BoxProperty)map.getRoute().getRoute()[player.getPosition()].getBox();
        //Se corrobora que el jugador tenga suficiente dinero y luego de ese se coloca el propietario y le quita el dinero adentro de la funcion
        //setOwner
        if(player.getDinero()>=box.getBuyPrice()){
            box.setOwner(player);
            System.out.println(player.getaccestoPlay());
            JOptionPane.showMessageDialog(null, "Propiedad: "+box.getName()+" comprada por "+player.getNombre());
            labelDinero.setText("Dinero: "+player.getDinero());
            jButton8.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null,"Dinero Insuficiente para comprar");
        }
        
        if(box.getOwner().equalsIgnoreCase(player.getNombre())){
            jButton8.setVisible(false);
        }
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        endGame();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         try {
                FileMap file = new FileMap();
                file.saveMap("./Juegos/"+map.getNameMap()+ jLabel1.getText()+".game", map);
                JOptionPane.showMessageDialog(null,"Partida Guardada");
         } catch (ErrorException_GUI ex) {
                Logger.getLogger(Map_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel labelDinero;
    private javax.swing.JLabel labelTurno;
    private javax.swing.JPanel panelInformativo;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para terminar el juego 
    */
    private void endGame(){
        map.checkForWinnersForResults();
        setVisible(false);
        dispose();
        new Menu_GUI();
    }
    private void reloj(){
        //Hilo que hace de reloj y nunca termina, y va modificando el label1
        //solo le añadimos el segundo al mapa que tiene un contador
        //sobre cuantos segundos tiene, minutos y horas, cuando llega a 60 aumenta sus minutos
        //y cuando llega a 60 minutos aumenta en hora, en este proceso se duerme un segundo
        //para imitar lo mayor posible un reloj
        Thread hilo = new Thread() {
            public void run() {
                jLabel1.setFont(new Font("Dina", Font.BOLD, 14));
                jLabel1.setAlignmentX(SwingConstants.CENTER);
                jLabel1.setAlignmentY(SwingConstants.CENTER);
                while(true){
                 jLabel1.setText(map.getHoras()+":"+map.getMinutos()+":"+map.getSegundos());
                 map.addSegundo();
                 jPanel1.revalidate();
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException ex) {
                     System.out.println(ex.getMessage());
                 }
             }
            }
        };
        hilo.start();
    }
    
    private void printPlayers(){
        JLabel label;
        //Hacemos un ciclo para verificar todas las casillas
        for(int index=0;index<map.getRoute().getRoute().length;index++){
            
            //Obtenemos el panel que contiene los label para modificar su color
            panelAux= map.getRoute().getRoute()[index].getPanelGame();
            panelAux = (JPanel) panelAux.getComponent(2);
            
            //Realizamos un ciclo para verificar todos los jugadores y sus colores si la posicion del jugador
            //se encuentra en esa casilla la pintara de lo contrario lo dejara en blanco
            for(int playerPosition =0;playerPosition<map.getPlayerHandler().getPlayersAdded();playerPosition++){
                if(map.getPlayerHandler().getPlayers()[playerPosition].getPosition() == index ){
                label = (JLabel)panelAux.getComponent(playerPosition);
                label.setBackground(map.getPlayerHandler().getPlayers()[playerPosition].getColor());
                }else{
                    label = (JLabel)panelAux.getComponent(playerPosition);
                    label.setBackground(Color.WHITE);
                }
            }
        }
        //Con esto comprobamos si callo en una casilla de tipo propiedad y comparamos que si no tiene dueño
        //puede comprarla, activando el boton comprar
        if(map.getRoute().getRoute()[map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getPosition()].getBox() instanceof BoxProperty){
            BoxProperty theBox = (BoxProperty) map.getRoute().getRoute()[map.getPlayerHandler()
                    .getPlayers()[map.getPlayerHandler().getTurn()].getPosition()].getBox();
            if( theBox.getOwner().equalsIgnoreCase("")){
                jButton8.setVisible(true);
            }
        }else{
            jButton8.setVisible(false);
        }
        
        
        //Con este ciclo comprobamos si el jugador siguiente aun puede jugar o no, y colocamos su nombre y la cantidad de dinero que posee
        while(true){
            if(map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getaccestoPlay()==true){
                labelTurno.setText("Turno: "+map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getNombre());
                labelDinero.setText("Dinero: "+map.getPlayerHandler().getPlayers()[map.getPlayerHandler().getTurn()].getDinero());
                break;
            }
            else{
                map.getPlayerHandler().turnPass();
            }
        }
        
        if(map.getDadosTirados()){
            jButton4.setVisible(false);
        }else
            jButton4.setVisible(true);
        
        
    }

}



