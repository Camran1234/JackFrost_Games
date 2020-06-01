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
public class CardFee extends Card {
    private int fee;
    
    /**
     * Ingresa una cuota en positivo para cuando se active el metodo doCard se le quite
     * esa cantidad de dinero al jugador por su accion .addDinero()
     * @param fee
     */
    public CardFee(int fee){
        this.fee = fee;
    }
    
    @Override
    public void doCard(Player player) {
        int cuota= fee *-1;
        player.addDinero(cuota);
        JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(1)+" "+fee,"OH NO" ,JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public String getData() {
        return ("Carta: Multa\n Multa: " + fee);
    }
    
    

    
    
}
