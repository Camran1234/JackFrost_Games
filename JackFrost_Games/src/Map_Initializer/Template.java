/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import Box.Box;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase que es autoEditable y almacena los datos de las casillas agregadas al tablero, puede considerarse como la plantilla
 * del tablero donde se editara y sobre todo se utilizará para visualizar el tablero
 * @author camran
 */
public class Template implements Serializable {
    
    private String type;
    private boolean primitiv = true;
    private JButton button;
    private JPanel panel;
    private JPanel showPanel= new JPanel();
    private Box box;

    /**
     * Retorna un booleano para indicar si devolvera el boton o
     * un Panel, si es verdadero indica que no se ha modificado esta
     * casilla, si es falso indica que se ha modificado esta casilla
     * @return
     */
    public boolean getPrimitiv(){    
       return primitiv;
    }
    
    public Box getBox(){
        return box;
    }
    
    /**
     *Retornamos un panel que se usara como en la presentacion del videoJuego
     * @return
     */
    public JPanel getPanelGame(){
        return showPanel;
    }
    
    public void setPanelGame(JPanel panel){
        this.showPanel = panel;
    }
    
    public String getType(){
        return type;
    }
    public void assignButton (JButton button){
        this.button = button;
    }
    
    public JButton getButton (){
        return button;
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public void reset(){
        this.box = null;
        this.type = null;
        this.panel=null;
        this.showPanel = new JPanel();
        primitiv = true;
    }
    
    public void createComponent(String type, JPanel panel, Box box){
        this.type = type;
        this.panel = panel;
        this.box = box;
        this.primitiv = false;   
     
    }
    
    

    
    
}
