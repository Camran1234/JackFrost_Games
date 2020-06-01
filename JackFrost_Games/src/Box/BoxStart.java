/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box;

import Player.Player;

/**
 *
 * @author camran
 */
public class BoxStart extends Box {

    private int initialMoney;
    
    public BoxStart(int initialMoney){
        this.initialMoney = initialMoney;
    }
    
    @Override
    public void doBox(Player player) {
        player.addDinero(initialMoney);
    }
    
}
