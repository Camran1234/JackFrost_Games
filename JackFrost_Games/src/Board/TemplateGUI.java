/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Map_Initializer.Template;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author camran
 */
public class TemplateGUI extends JPanel implements Serializable{
    
    /**
     * Ruta para sacar en los componentes, seleccionar panel 1 que contenga a todos, this, panel n 
     * a continuacion de sus label
     * @param template
     */
    public TemplateGUI(Template template,int posicion){
        this.setLayout(new GridLayout(4,1));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 8));
        initComponents(template,posicion);
        this.setVisible(true);
    }
    
    public void initComponents(Template template,int posicionC){
        JPanel panelTipo = new JPanel(new GridLayout(1,1));
        JPanel panelNombre = new JPanel(new GridLayout(1,1));
        JPanel panelJugadores = new JPanel(new GridLayout(2,3));
        JPanel panelPosicion = new JPanel(new GridLayout(1,1));
        
        //Esto va en panelTipo
        JLabel labelTipo = new JLabel(template.getType(),SwingConstants.CENTER);
        labelTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
        //Esto va en panelNombre
        JLabel labelNombre = new JLabel(template.getBox().getName(),SwingConstants.CENTER);
        labelNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
        //Esto va en panelJUgadores
        JLabel jugador1 = new JLabel();
        JLabel jugador2 = new JLabel();
        JLabel jugador3 = new JLabel();
        JLabel jugador4 = new JLabel();
        JLabel jugador5 = new JLabel();
        JLabel jugador6 = new JLabel();
        
        jugador1.setOpaque(true);
        jugador2.setOpaque(true);
        jugador3.setOpaque(true);
        jugador4.setOpaque(true);
        jugador5.setOpaque(true);
        jugador6.setOpaque(true);
        
        jugador1.setBackground(Color.white);
        jugador2.setBackground(Color.white);
        jugador3.setBackground(Color.white);
        jugador4.setBackground(Color.white);
        jugador5.setBackground(Color.white);
        jugador6.setBackground(Color.white);
        
        //Esto va en panelPosicion
        JLabel labelPosicion = new JLabel(Integer.toString(posicionC),SwingConstants.CENTER);
        labelPosicion.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
        
        panelTipo.add(labelTipo);
        panelNombre.add(labelNombre);
        panelJugadores.add(jugador1);
        panelJugadores.add(jugador2);
        panelJugadores.add(jugador3);
        panelJugadores.add(jugador4);
        panelJugadores.add(jugador5);
        panelJugadores.add(jugador6);
        panelPosicion.add(labelPosicion);
        
        add(panelTipo);
        add(panelNombre);
        add(panelJugadores);
        add(panelPosicion);
        
    }
}
