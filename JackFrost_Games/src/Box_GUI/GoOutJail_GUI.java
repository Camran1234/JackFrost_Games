/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box_GUI;

import Box.BonusBox;
import Box.Box;
import BoxTools.Card;
import BoxTools.CardJail;
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
public class GoOutJail_GUI {
    
    
    public GoOutJail_GUI(Box box){
        initComponents(box);
    }
    
   
    
    private void initComponents(Box box){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel (new GridLayout(3,1));
        JLabel labelInformativo = new JLabel("Precio Venta");
        JTextField textField = new JTextField ();
        JButton button = new JButton("Crear");
        button.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent a){
               
               try{
               CardJail card = new CardJail(Integer.parseInt(textField.getText().toString()));
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
    
   
}
