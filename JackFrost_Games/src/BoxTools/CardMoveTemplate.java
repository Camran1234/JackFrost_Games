/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import Map_Initializer.Template;
import Player.Player;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class CardMoveTemplate extends Card {
    private int templatePosition;
    
    /**
     * Indica la posicion en donde se debe desplazar el jugador
     * Dicha posicion es establecida automaticamente durante el editor de mapas
     * @param templatePosition
     */
    public CardMoveTemplate(int templatePosition){
        this.templatePosition = templatePosition;
    }

    /**
     * Modificamos la posicion del jugador y activamos la casilla en donde cayo
     * en su nombre
     * @param player
     */
    @Override
    public void doCard(Player player) {
        
       for(int i=0;i<player.getRoute().getRoute().length;i++){
            if(templatePosition == player.getRoute().getnumerosAntesCasillas()[i]){
                player.setPosition(i);
                player.getRoute().getRoute()[i].getBox().doBox(player);
                break;
            }  
       } 
       JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(4)+" "+(templatePosition-1),"GENIAL",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getData() {
        return("Carta: Mover a Casilla\n Casilla: "+templatePosition+"\n");
    }

    
    
}
