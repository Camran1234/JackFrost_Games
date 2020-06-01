/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box_GUI;

import Box.Box;
import BoxTools.Card;
import BoxTools.CardCustomizable;
import Map_Initializer.Template;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author camran
 */
public class Card_GUI implements Serializable{
    
    public Card_GUI(Box box, Template[][] template){
        initComponents(box, template);
    }
    
    public Card_GUI(Card box, Template[][] template){
        initComponents(box, template);
    }
    
    
    
    private void initComponents(Box box, Template[][] template){
        GridLayout grid = new GridLayout(1,2);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        String[] palabras = {"Caminar","Premio","Multa","Pago a Jugadores","Mover a Casilla","Perder Turno","Salga de la Carcel","Vaya a la carcel","Personalizada"};
        JComboBox comboBox = new JComboBox(palabras);
        comboBox.setSelectedIndex(8);
        JButton button = new JButton("Crear");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                switch(comboBox.getSelectedItem().toString()){
                    case "Caminar":
                        Walk_Gui walk = new Walk_Gui(box);
                        break;
                    case "Premio":
                        Prize_GUi prize = new Prize_GUi(box);
                        break;
                    case "Multa":
                        Fee_Gui fee = new Fee_Gui(box);
                        break;
                    case "Pago a Jugadores":
                        PayPlayers_GUI payP = new PayPlayers_GUI(box);
                        break;
                    case "Mover a Casilla":
                        MoveTemplate_GUI moveT = new MoveTemplate_GUI(box,template);
                        break;
                    case "Perder Turno":
                        TurnLost_GUI turnLost = new TurnLost_GUI(box);
                        break;
                    case "Salga de la Carcel":
                        GoOutJail_GUI goOut = new GoOutJail_GUI(box);
                        break;
                    case "Vaya a la carcel":
                        GoJail_GUI goJail = new GoJail_GUI(box);
                        break;
                    case "Personalizada":
                        CardCustomizable card1 = new CardCustomizable();

                        Card_GUI cards1 = new Card_GUI(card1,template);
                        Card_GUI cards2 = new Card_GUI(card1, template);
                        
                        box.add(card1);
                        break;


  
                }
                
                
                
                frame.setVisible(false);
                frame.dispose();
                
            }
        });
        
        panel.add(comboBox);
        panel.add(button);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        
        
    }
    
    private void initComponents(Card box, Template[][] template){
        GridLayout grid = new GridLayout(1,2);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        String[] palabras = {"Caminar","Premio","Multa","Pago a Jugadores","Mover a Casilla","Perder Turno","Vaya a la carcel"};
        JComboBox comboBox = new JComboBox(palabras);
        comboBox.setSelectedIndex(6);
        JButton button = new JButton("Crear");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                switch(comboBox.getSelectedItem().toString()){
                    case "Caminar":
                        Walk_Gui walk = new Walk_Gui(box);
                        break;
                    case "Premio":
                        Prize_GUi prize = new Prize_GUi(box);
                        break;
                    case "Multa":
                        Fee_Gui fee = new Fee_Gui(box);
                        break;
                    case "Pago a Jugadores":
                        PayPlayers_GUI payP = new PayPlayers_GUI(box);
                        break;
                    case "Mover a Casilla":
                        MoveTemplate_GUI moveT = new MoveTemplate_GUI(box, template);
                        break;
                    case "Perder Turno":
                        TurnLost_GUI turnLost = new TurnLost_GUI(box);
                        break;
                    case "Vaya a la carcel":
                        GoJail_GUI goJail = new GoJail_GUI(box);
                        break;
                }
                frame.setVisible(false);
                frame.dispose();
                
            }
        });
        
        panel.add(comboBox);
        panel.add(button);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);     
    }
}
