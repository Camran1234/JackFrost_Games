/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box_GUI;

import Box.BonusBox;
import Box.Box;
import BoxTools.Card;
import BoxTools.CardMoveTemplate;
import Map_Initializer.MapEditor;
import Map_Initializer.Template;
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
public class MoveTemplate_GUI {
    public MoveTemplate_GUI(Box box, Template[][] template){
        initComponents(box,template);
    }
    
    public MoveTemplate_GUI(Card card,Template[][] template){
        initComponents(card,template);
    }
    
    private void initComponents(Box box, Template[][] template){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel (new GridLayout(3,1));
        JLabel labelInformativo = new JLabel("Casilla a Moverse");
        JTextField textField = new JTextField ();
        JButton button = new JButton("Crear");
        button.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent a){
               
               try{
               for(int i=0;i<template.length;i++){
                   for(int j=0;j<template[0].length;j++){
                       if(((i*template.length)+j+1) == Integer.parseInt(textField.getText().toString())){
                           if(template[i][j].getPrimitiv()==false){
                                CardMoveTemplate card = new CardMoveTemplate(Integer.parseInt(textField.getText().toString()));
                                box.add(card);
                                frame.setVisible(false);
                                frame.dispose();
                           }else{
                               MapEditor map = new MapEditor();
                                map.errorMessage("Casilla Vacia");
                           }
                       }
                   }
               }
               
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
    
    private void initComponents(Card cardC,Template[][] template){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel (new GridLayout(3,1));
        JLabel labelInformativo = new JLabel("Casilla a Moverse");
        JTextField textField = new JTextField ();
        JButton button = new JButton("Crear");
        button.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent a){
               
               try{
               for(int i=0;i<template.length;i++){
                   for(int j=0;j<template[0].length;j++){
                       if(((i*template.length)+j+1)== Integer.parseInt(textField.getText().toString())){
                            if(template[i][j].getPrimitiv()==false){
                                CardMoveTemplate card = new CardMoveTemplate(Integer.parseInt(textField.getText().toString()));
                                cardC.add(card);
                                frame.setVisible(false);
                                frame.dispose();
                           }else{
                               MapEditor map = new MapEditor();
                                map.errorMessage("Casilla Vacia");
                           }
                       }
                       
                   }
               }
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
