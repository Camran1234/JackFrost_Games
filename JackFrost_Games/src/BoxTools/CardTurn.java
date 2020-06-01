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
public class CardTurn extends Card{
    private int turns;

    /**
     * Constructor de la carta tipo pierde Turno, indica cuantos turnos perderá el jugador
     * quien caiga en esta casilla
     * @param turns
     */
    public CardTurn(int turns){
        this.turns = turns;
    }
    /**
     * Se le agrega los turnos perdidos al jugador
     * @param player 
     */
    @Override
    public void doCard(Player player) {
        player.setTurnosPerdidos(turns);
        JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(7),"OH NO",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getData() {
        return("Carta: Pierde Turno\n Turnos: "+turns+"\n");
    }

    
    
}
