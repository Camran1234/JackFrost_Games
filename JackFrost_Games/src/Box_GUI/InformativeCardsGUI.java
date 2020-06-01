/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box_GUI;

import BoxTools.Card;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author camran
 */
public class InformativeCardsGUI extends javax.swing.JPanel implements Serializable{
    private Card card;
    public InformativeCardsGUI(Card card){
        this.card = card;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(1,1));
        JLabel labelTexto = new JLabel(card.getData(),SwingConstants.CENTER);
        labelTexto.setFont(new Font("DejaVu Sans", Font.BOLD, 11));
        add(labelTexto);
    }
}
