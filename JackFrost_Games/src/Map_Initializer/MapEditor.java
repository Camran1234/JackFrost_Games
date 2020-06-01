/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import Box.BonusBox;
import Box.Box;
import Box.BoxJail;
import Box.BoxNeutral;
import Box.BoxStart;
import Box.BoxTrap;
import BoxTools.BoxPlace;
import BoxTools.BoxService;
import BoxTools.BoxStation;
import Box_GUI.Card_GUI;
import Box_GUI.Fee_Gui;
import Box_GUI.InformativeCardsGUI;
import Box_GUI.MoveTemplate_GUI;
import Box_GUI.TurnLost_GUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author camran
 */
public class MapEditor implements Serializable{
    
    private GridLayout mainGrid;
    private Template[][] template;
    private JFrame mainFrame;
    private JFrame frameChoose;
    private static String decision;
    
    /**
     * Usamos este constructor para modificar un tablero ya existente, donde solo lo imprime y por las funciones
     * del objeto casilla(template) facilita mucho la modificacion
     * 
     * Seleccionar true en el espacio booleano para continuar la edicion de mapas
     * Selecionar false en el espacio booleano para crear un editor de mapa
     * @param template
     */
    public MapEditor(Template[][] template, boolean started,boolean recentlyLoad){
        this.template = template;
        mainFrame = new JFrame();
        mainGrid = new GridLayout(template.length, template[0].length);
        frameChoose = new JFrame();
        frameChoose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(started && recentlyLoad==true){
            System.out.println("Entro"+recentlyLoad);
            for(int i=0;i<template.length;i++){
                for(int j=0;j<template[0].length;j++){
                    template[i][j].getButton().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                         botonPresionado((JButton) e.getSource());
                      }
                    });
                }
            }
            
            print();
        }else if(started && recentlyLoad==false){
            print();
        }
        else{            
            init(template.length,template[0].length);
        }
        
    }

    public MapEditor() {
    }
    
    
    
    
    
    /**
     * Inicia una plantilla de botones para que se pueda empezar a modificar las casillas
     * @param rows
     * @param columns
     */
    public void init(int rows, int columns){
        
        JButton[][] vec = new JButton[rows][columns];  
        
       
        mainFrame.setLayout(mainGrid);
        
        
        for (int i =0; i< vec.length; i++){
            for (int j =0; j< vec[0].length; j++){
                vec[i][j] = new JButton();
                template[i][j] = new Template();
                
                vec[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                         botonPresionado((JButton) e.getSource());
                      }
                });
                vec[i][j].setText("Crear "+((i*rows)+j+1));
                vec[i][j].setVisible(true);
                    
                template[i][j].assignButton(vec[i][j]);
                mainFrame.add(vec[i][j]);
            }
        }
        
         
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(1500,1000);
        mainFrame.setVisible(true);   
    }
    
    /* Genera un form para seleccionar los distintos tipos de casillas que se
       pueden generar, el evento realizado es al seleciconar la casilla
    */
    private void botonPresionado(JButton button ){
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
  
        JLabel labelTipo = new JLabel("Tipo");
        String[] palabras = {"Inicio","Neutro","Trampa", "Propiedad", "Bonus","Cárcel","Eliminar"};
        JComboBox comboBoxTipo = new JComboBox(palabras);
        GridLayout grid = new GridLayout(4,2);       
        
        comboBoxTipo.setSelectedIndex(6);
        JButton configure = new JButton("Configurar");
        
        
        panel.setLayout(grid);
        panel.add(labelTipo);
        panel.add(comboBoxTipo);
        panel.add(configure);
        
        configure.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    try {
                        frame.setVisible(false);
                        frame.dispose();
                        setPlantilla(comboBoxTipo.getSelectedItem().toString(),"", button,false);
                    } catch (Exception ex) {
                        Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
          
            }
            
        
        );
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300,250);
        frame.setVisible(true);
        
        
              
    }
    
    /*
        Creamos un frame que se le pondra un panel diferente dependiendo de la eleccion del usuario
    */
    private void setPlantilla(String decision,String typeProperty,JButton button,boolean actioned) throws Exception{
        
       frameChoose = new JFrame();
        GridLayout grid = new GridLayout(6,2);
        frameChoose.setSize(300, 350);
        switch(decision){
            case "Inicio":
                frameChoose.add(setInicio(decision,grid,button));
                
                break;
                
            case "Neutro":
                setNeutro(decision,button);
                frameChoose.setVisible(false);                
                frameChoose.dispose();
                break;
                
            case "Trampa":
                frameChoose.add(setTrampa(decision,grid,button));    
                    break;
                    
            case "Propiedad":
                frameChoose.add(setPropiedad(decision,grid,typeProperty,button,actioned));
                break; 
                
            case "Bonus":
                frameChoose.add(setBonus(decision,button));
                break;
                
            case "Cárcel":
                frameChoose.add(setJail(decision,button));
                    break;   
            case "Eliminar":
                for(int i=0;i<template.length;i++){
                     for (int j=0;j<template[0].length;j++){
                        if(template[i][j].getButton() == button){ 
                         template[i][j].reset();
                            print();  
                        }
                    }
                }
                break;
            
        }
        
        if(decision!="Neutro" && decision!="Eliminar"){
            frameChoose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameChoose.setVisible(true);
        }
        
    }
    
    
    private JPanel setInicio(String decision,GridLayout grid,JButton button){
        JPanel contenedor = new JPanel(grid);   
        
        JLabel labelDinero = new JLabel("Dinero Inicial");
        JTextField dinero = new JTextField();
        JButton buttonSave = new JButton("Guardar");
        buttonSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    
                if( dinero.getText()!=""){
                    try{
                        GridLayout grid = new GridLayout(0, 1);
                        JPanel inicio = new JPanel(grid);
                        JLabel tipoLabel = new JLabel("Casilla: " + decision);
                        JLabel dineroLabel = new JLabel("Dinero: "+dinero.getText());

                        inicio.add(tipoLabel);
                        inicio.add(dineroLabel);
                        inicio.add(button);
                            
                        BoxStart box = new BoxStart(Integer.parseInt(dinero.getText()));

                        for(int i=0;i<template.length;i++){
                            for (int j=0;j<template[0].length;j++){
                                if(template[i][j].getButton() == button){
                                    template[i][j].createComponent(decision, inicio, box);
                                    print();
                                }
                            }
                        }
                        }catch(Exception a){
                            errorMessage(a.getMessage());
                        }
                    }   
            }
        });
        
        
        contenedor.add(labelDinero);
        contenedor.add(dinero);
        contenedor.add(buttonSave);
        
        return contenedor;
    }
    
    //Creamos un panel con la informacion de que es casilla neutra, y creamos un objeto casilla para atribuirselos al objeto template dado en la matriz
    private void setNeutro(String decision ,JButton button) {
        
        GridLayout grid = new GridLayout(2,1);
        JPanel inicio = new JPanel(grid);
        JLabel tipoLabel = new JLabel("Casilla: " + decision);
        inicio.add(tipoLabel);
        inicio.add(button);
        
        BoxNeutral box = new BoxNeutral();
        
        
        
        for(int i=0;i<template.length;i++){
            for (int j=0;j<template[0].length;j++){
                if(template[i][j].getButton() == button){
                    template[i][j].createComponent(decision, inicio, box);
                    print();
                }
             }
        }
    }
    
    
    
    private JPanel setTrampa(String decision,GridLayout grid, JButton button){
        
        BoxTrap box = new BoxTrap();
        JPanel panel = new JPanel(grid);
        JLabel textoLabel = new JLabel ("Selecciona una propiedad trampa: ");
        String[] palabras = {"Cambiar Casilla","Perder Turno","Pagar Multa"};
        JComboBox comboBox = new JComboBox(palabras);
        comboBox.setSelectedIndex(2);
        JButton add = new JButton ("Añadir");
        JButton save = new JButton("Guardar");
        
        save.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
               
                if(box!=null)
                try{
                GridLayout gridTrampa = new GridLayout(3,1);
                JPanel panelTrampa = new JPanel(gridTrampa);
                JLabel tipoLabel = new JLabel("Casilla: " + decision);
                
                panelTrampa.add(tipoLabel);
                panelTrampa.add(new InformativeCardsGUI(box.getCard()));
                panelTrampa.add(button);
                
                
                for(int i=0;i<template.length;i++){
                    for (int j=0;j<template[0].length;j++){
                        if(template[i][j].getButton() == button){
                            template[i][j].createComponent(decision, panelTrampa, box);
                            print();
                        }
                    }
                }
                
                }catch(Exception a){
                    errorMessage(a.getMessage());
                }
            }
            
        });
        
        add.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                if(comboBox.getSelectedItem().toString()!="")
                switch(comboBox.getSelectedItem().toString()){
                    case "Cambiar Casilla":
                    
                        MoveTemplate_GUI change = new MoveTemplate_GUI(box,template);
                                 
                        break;

                    case "Perder Turno":
                        TurnLost_GUI turnL = new TurnLost_GUI(box);
                        break;
                    case "Pagar Multa":
                        Fee_Gui fee = new Fee_Gui(box);
                        break;
                }
                
            }
            
        });
        
        panel.add(textoLabel);
        panel.add(comboBox);
        panel.add(add);
        panel.add(save);
        
        return panel;
    }
    
    private JPanel setPropiedad(String decision,GridLayout grid,String typeProperty, JButton button, boolean actioned){
         
        GridLayout gridPlace = new GridLayout(14,2);
        JPanel panel = new JPanel(grid);
        if(actioned){
                JLabel labelTipo = new JLabel("Tipo: " + decision);
                JLabel labelNombre = new JLabel("Nombre");
                JLabel labelCompra = new JLabel ("Precio Compra: ");
                JLabel labelHipoteca = new JLabel ("Precio Hipoteca: ");
                JTextField fieldCompra = new JTextField ();
                JTextField fieldHipoteca = new JTextField ();
                JTextField fieldNombre = new JTextField();
                
                panel.add(labelTipo);
                panel.add(new JPanel());
                panel.add(labelNombre);
                panel.add(fieldNombre);
                panel.add(labelCompra);
                panel.add(fieldCompra);
                panel.add(labelHipoteca);
                panel.add(fieldHipoteca);
                
                switch(typeProperty){
                case "Lugar":
                   try{
                    panel = new JPanel(gridPlace);   
                    JLabel labelEstancia = new JLabel ("Precio Estancia: ");
                    JLabel labelHousePrice = new JLabel ("Costo de cada casa: ");
                    JLabel labelHouseBonus = new JLabel ("Aumento por casa: ");
                    JLabel labelHotelPrice = new JLabel ("Costo de cada Hotel: ");
                    JLabel labelHotelBonus = new JLabel ("Aumento por Hotel: ");
                    JLabel labelGrupo = new JLabel ("Grupo: ");
                    
                    
                    JTextField fieldEstancia = new JTextField ();
                    JTextField fieldHousePrice = new JTextField ();
                    JTextField fieldHouseBonus = new JTextField ();
                    JTextField fieldHotelPrice = new JTextField ();
                    JTextField fieldHotelBonus = new JTextField ();
                    JTextField fieldGroup = new JTextField ();
                    

                    JButton save = new JButton("Guardar");
                    save.addActionListener(new ActionListener(){
                       
                        public void actionPerformed(ActionEvent e){
                            JPanel panelLugar = new JPanel(gridPlace);
                            
                            JLabel labelT = new JLabel ("Tipo: "+ decision+ ", "+typeProperty);
                            JLabel labelN = new JLabel ("Nombre: " + fieldNombre.getText());
                            JLabel labelC = new JLabel ("Precio Compra: "+ fieldCompra.getText());
                            JLabel labelH = new JLabel ("Precio Hipoteca: "+ fieldHipoteca.getText());
                            JLabel labelE = new JLabel ("Precio Estancia: "+ fieldEstancia.getText());
                            JLabel labelHP = new JLabel ("Costo de cada casa: " + fieldHousePrice.getText());
                            JLabel labelHB = new JLabel ("Aumento por casa: " + fieldHouseBonus.getText());
                            JLabel labelPH = new JLabel ("Costo de cada Hotel: " + fieldHotelPrice.getText());
                            JLabel labelBH = new JLabel ("Aumento por Hotel: " + fieldHotelBonus.getText());
                            JLabel labelGroup = new JLabel ("Grupo: "+ fieldGroup.getText());
                            
                            
                            
                            panelLugar.add(labelN);
                            panelLugar.add(labelT);
                            panelLugar.add(labelC);
                            panelLugar.add(labelH);
                            panelLugar.add(labelE);
                            panelLugar.add(labelHP);
                            panelLugar.add(labelHB);
                            panelLugar.add(labelPH);
                            panelLugar.add(labelBH);
                            panelLugar.add(labelGroup);
                            panelLugar.add(button);
                      
                            BoxPlace box = new BoxPlace(fieldNombre.getText(), fieldGroup.getText().toUpperCase(), Integer.parseInt(fieldCompra.getText()),
                            Integer.parseInt(fieldHipoteca.getText()), Integer.parseInt(fieldEstancia.getText()), 
                            Integer.parseInt(fieldHouseBonus.getText()), Integer.parseInt(fieldHousePrice.getText()),
                            Integer.parseInt(fieldHotelBonus.getText()), Integer.parseInt(fieldHotelPrice.getText()));
                            
                            for(int i=0;i<template.length;i++){
                                for (int j=0;j<template[0].length;j++){
                                    if(template[i][j].getButton() == button){
                                        template[i][j].createComponent(typeProperty, panelLugar, box);
                                        print();
                                    }       
                                }
                            }
                        }
                    });
                    
                    panel.add(labelTipo);
                    panel.add(new JPanel());
                    panel.add(labelNombre);
                    panel.add(fieldNombre);
                    panel.add(labelCompra);
                    panel.add(fieldCompra);
                    panel.add(labelHipoteca);
                    panel.add(fieldHipoteca);
                    panel.add(labelEstancia);
                    panel.add(fieldEstancia);
                    panel.add(labelHousePrice);
                    panel.add(fieldHousePrice);
                    panel.add(labelHouseBonus);
                    panel.add(fieldHouseBonus);
                    panel.add(labelHotelPrice);
                    panel.add(fieldHotelPrice);
                    panel.add(labelHotelBonus);
                    panel.add(fieldHotelBonus);
                    panel.add(labelGrupo);
                    panel.add(fieldGroup);
                    panel.add(save);
                    }catch(Exception e){
                        errorMessage(e.getMessage());
                    }
                    
                    
                    break;
                case "Servicio":
                    
                    try{
                    JLabel labelServicio = new JLabel ("Precio Servicio: ");
                    JTextField fieldServicio = new JTextField ();
                    JButton save = new JButton("Guardar");
                    save.addActionListener(new ActionListener(){
                       
                        public void actionPerformed(ActionEvent e){
                            JPanel panelLugar = new JPanel(grid);
                            
                            JLabel labelT = new JLabel ("Tipo: "+ decision+ ", "+typeProperty);
                            JLabel labelN = new JLabel ("Nombre: " + fieldNombre.getText());
                            JLabel labelC = new JLabel ("Precio Compra: "+ fieldCompra.getText());
                            JLabel labelH = new JLabel ("Precio Hipoteca: "+ fieldHipoteca.getText());
                            JLabel labelS = new JLabel ("Precio Servicio: "+ fieldServicio.getText());
                            
                            
                            panelLugar.add(labelN);
                            panelLugar.add(labelT);
                            panelLugar.add(labelC);
                            panelLugar.add(labelH);
                            panelLugar.add(labelS);
                            panelLugar.add(button);
                            
                            BoxService box = new BoxService(fieldNombre.getText(),Integer.parseInt(fieldCompra.getText()) ,Integer.parseInt(fieldHipoteca.getText()) , Integer.parseInt(fieldServicio.getText()));
                            
                            for(int i=0;i<template.length;i++){
                                for (int j=0;j<template[0].length;j++){
                                    if(template[i][j].getButton() == button){
                                        template[i][j].createComponent(typeProperty, panelLugar, box);
                                        print();
                                    }       
                                }
                            }
                        }
                    });
                    
                    
                    panel.add(labelServicio);
                    panel.add(fieldServicio);
                    panel.add(save);
                    }catch(Exception e){
                        errorMessage(e.getMessage());
                    }
                    
                    
                break;
                case "Estacion":
                       try{
                    JLabel labelServicio = new JLabel ("Precio Estacion: ");
                    JTextField fieldServicio = new JTextField ();
                    JButton save = new JButton("Guardar");
                    save.addActionListener(new ActionListener(){
                       
                        public void actionPerformed(ActionEvent e){
                            JPanel panelLugar = new JPanel(grid);
                            
                            JLabel labelT = new JLabel ("Tipo: "+ decision+ ", "+typeProperty);
                            JLabel labelN = new JLabel ("Nombre: " + fieldNombre.getText());
                            JLabel labelC = new JLabel ("Precio Compra: "+ fieldCompra.getText());
                            JLabel labelH = new JLabel ("Precio Hipoteca: "+ fieldHipoteca.getText());
                            JLabel labelS = new JLabel ("Precio Estacion: "+ fieldServicio.getText());
                            
                            
                            panelLugar.add(labelN);
                            panelLugar.add(labelT);
                            panelLugar.add(labelC);
                            panelLugar.add(labelH);
                            panelLugar.add(labelS);
                            panelLugar.add(button);
                            
                            BoxStation box = new BoxStation(fieldNombre.getText(),Integer.parseInt(fieldCompra.getText()) ,Integer.parseInt(fieldHipoteca.getText()) , Integer.parseInt(fieldServicio.getText()));
                            
                            for(int i=0;i<template.length;i++){
                                for (int j=0;j<template[0].length;j++){
                                    if(template[i][j].getButton() == button){
                                        template[i][j].createComponent(typeProperty, panelLugar, box);
                                        print();
                                    }       
                                }
                            }
                        }
                    });
                    
                    
                    panel.add(labelServicio);
                    panel.add(fieldServicio);
                    panel.add(save);
                    }catch(Exception e){
                        errorMessage(e.getMessage());
                    }
                   
                break;
                
                }
                
               
        }else{
                JLabel tipoLabel1 = new JLabel("Tipo: ");
                String[] palabras = {"Lugar","Servicio","Estacion"};
                JComboBox propiedadBox = new JComboBox(palabras);
                JButton save = new JButton("Siguiente");
                save.addActionListener(new ActionListener(){
                   
                    public void actionPerformed(ActionEvent e){
                        try {
                            frameChoose.setVisible(false);
                            frameChoose.dispose();
                            setPlantilla(decision,propiedadBox.getSelectedItem().toString(), button, true);  
                        } catch (Exception ex) {
                            Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                

                panel.add(tipoLabel1);
                panel.add(propiedadBox);
                panel.add(save);

               
        }
         
        return panel;
    }
    
    private JPanel setBonus(String decision, JButton button){
        BonusBox box = new BonusBox();
        JPanel panel = new JPanel(new GridLayout(2,1));
        JButton add = new JButton("Añadir");
        JButton save = new JButton("Guardar");
        
        add.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent a){
                Card_GUI card = new Card_GUI(box,template); 
            }
            });
        
        save.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent a){
                GridLayout grid = new GridLayout(0,1);
                JPanel BonusPanel = new JPanel(grid);
                JLabel tipoLabel = new JLabel("Casilla: " + decision);
                BonusPanel.add(tipoLabel);
                
                for(int i=0;i<box.getlength();i++){
                    BonusPanel.add(new InformativeCardsGUI(box.getCards()[i]));
                }
                BonusPanel.add(button);

                for(int i=0;i<template.length;i++){
                    for (int j=0;j<template[0].length;j++){
                        if(template[i][j].getButton() == button){
                            template[i][j].createComponent(decision, BonusPanel, box);
                            print();
                        }
                     }
                }
                }
        });
     
        panel.add(add);
        panel.add(save);
        return panel;
    }
    private JPanel setJail(String decision, JButton button){
         
        
        
        GridLayout grid = new GridLayout(0,1);
        JPanel jail = new JPanel(grid);
        JLabel tipoLabel = new JLabel("Casilla: " + decision);
        JLabel label1 = new JLabel ("Selecciona cuantos turnos retendra la casilla: ");
        JTextField textField = new JTextField();
        JButton save = new JButton("Guardar");
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    JPanel panelJail = new JPanel(new GridLayout(0,1));
                    JLabel tipoLabel = new JLabel("Casilla: " + decision);
                    JLabel jailLabel = new JLabel("Turnos perdidos: " + Integer.parseInt(textField.getText()));
                    panelJail.add(tipoLabel);
                    panelJail.add(jailLabel);
                    panelJail.add(button);

                    BoxJail box = new BoxJail(Integer.parseInt(textField.getText()));



                    for(int i=0;i<template.length;i++){
                        for (int j=0;j<template[0].length;j++){
                            if(template[i][j].getButton() == button){
                                template[i][j].createComponent(decision, panelJail, box);
                                print();
                            }
                         }
                    }
                }catch(Throwable a){
                    errorMessage(a.getMessage());
                }
            }
            
        });
        
        
        jail.add(tipoLabel);
        jail.add(label1);
        jail.add(textField);
        jail.add(save);
        
        return jail;
    }

    
    //Imprimimos de nuevo el mainFrame y le agregamos los paneles que ya han sido cambiados gracias al objeto template
    private void print(){
        
        frameChoose.setVisible(false);
        frameChoose.dispose();
        frameChoose = new JFrame();
        frameChoose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.dispose();
        
        
        mainFrame = new JFrame();
        mainFrame.setLayout(mainGrid);
        
        for(int i=0;i<template.length;i++){
            for (int j=0;j<template[0].length;j++){
                if(template[i][j].getPrimitiv()){
                    mainFrame.add(template[i][j].getButton());
                }else{
                    mainFrame.add(template[i][j].getPanel());
                }
            }
        }
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(1500,1000);
        mainFrame.setVisible(true); 
    }
    
    public void errorMessage(String error){
        JFrame errorFrame = new JFrame();
        JLabel errorLabel = new JLabel ("Error: " + error);
                            
        errorFrame.add(errorLabel);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.pack();
        errorFrame.setVisible(true);
    }
}
