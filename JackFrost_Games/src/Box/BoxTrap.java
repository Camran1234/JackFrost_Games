/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box;

import BoxTools.Card;
import Player.Player;
import java.io.Serializable;

/**
 *
 * @author camran
 */
public class BoxTrap extends Box implements Serializable{

    private Card card;
    
    public void add(Card card){
        this.card = card;
    }
    
    
    @Override
    public void doBox(Player player) {
        card.setPlayers(this.player);
        card.doCard(player);
    }
    
    public Card getCard(){
        return card;
    }
    
}
