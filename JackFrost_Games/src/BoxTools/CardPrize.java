/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import Player.Player;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class CardPrize extends Card {
    private int bonusMoney;
    
    /**
     * Constructor de la carta premio, asigna el dinero que dara esta carta
     * @param bonusMoney
     */
    public CardPrize(int bonusMoney){
        this.bonusMoney = bonusMoney;
    }
    /**
     * Se le agrega el dinero indicado al jugador con su metodo addDinero
     * la cantidad agregada es indicada en el constructor
     * @param player 
     */
    @Override
    public void doCard(Player player) {
        player.addDinero(bonusMoney);
        JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(8)+bonusMoney,"OH WOW",JOptionPane.INFORMATION_MESSAGE);
        
    }

    @Override
    public String getData() {
        return("Carta: Premio\n Premio: "+ bonusMoney+"\n");
    }

    
    
}
