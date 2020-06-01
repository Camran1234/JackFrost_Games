/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box;

import Player.Player;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class BoxJail extends Box {

    private int turns;
    
    public BoxJail(int turns){
        this.turns = turns;
    }

    @Override
    public void doBox(Player player) {
        player.setTurnosPerdidos(turns);
        JOptionPane.showMessageDialog(null,player.getNombre()+" Ha perdido "+turns + " turnos");
    }
    
}
