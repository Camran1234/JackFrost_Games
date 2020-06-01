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
public class CardWalk extends Card{
    private int desplazamiento;
    
    /**
     * Constructor de la Carta tipo Caminar, que moviliza al jugador 
     * x cantidad de casillas, indicalas en este constructor
     * @param desplazamiento
     */
    public CardWalk(int desplazamiento){
        this.desplazamiento = desplazamiento;
    }
    /**
     * Desplaza al jugador la cantidad indicada en el constructor
     * @param player 
     */
    @Override
    public void doCard(Player player) {
        player.move(desplazamiento);
        JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(6),"ME HAN DESPLAZADO",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getData() {
        return("Carta: Desplazar casillas\n Desplazamiento: "+desplazamiento+"\n");
    }

    
    
}
