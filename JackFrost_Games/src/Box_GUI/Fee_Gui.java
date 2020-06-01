/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box_GUI;

import Box.Box;
import BoxTools.Card;
import BoxTools.CardCustomizable;
import BoxTools.CardFee;
import Map_Initializer.MapEditor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author camran
 */
public class Fee_Gui {
    
    
    public Fee_Gui(Box box){
        initComponents(box);
    }
    
    public Fee_Gui(Card card){
       initComponents(card);
    }
    
    private void initComponents(Box box){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel (new GridLayout(3,1));
        JLabel labelInformativo = new JLabel("Multa");
        JTextField textField = new JTextField();
        JButton button = new JButton("Crear");
        button.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent a){
               try{
               CardFee card = new CardFee(Integer.parseInt(textField.getText().toString()));
               box.add(card);
               frame.setVisible(false);
               frame.dispose();
               }catch(Exception e){
                   MapEditor map = new MapEditor();
                   map.errorMessage(e.getMessage());
               }
               
           } 
        });
        
        
        panel.add(labelInformativo);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void initComponents(Card cardC){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel (new GridLayout(3,1));
        JLabel labelInformativo = new JLabel("Multa");
        JTextField textField = new JTextField();
        JButton button = new JButton("Crear");
        button.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent a){
               try{
               CardFee card = new CardFee(Integer.parseInt(textField.getText().toString()));
               cardC.add(card);
               frame.setVisible(false);
               frame.dispose();
               }catch(Exception e){
                   MapEditor map = new MapEditor();
                   map.errorMessage(e.getMessage());
               }
               
           } 
        });
        
        
        panel.add(labelInformativo);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }   
}
