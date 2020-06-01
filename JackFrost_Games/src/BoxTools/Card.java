/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import Player.Player;
import java.io.Serializable;

/**
 *
 * @author camran
 */
public abstract class Card implements Serializable{
    Player[] players = new Player[0];
    Phrases phrases = new Phrases();
    String type;
    
    /**
     * 
     * @param player
     */
    public abstract void doCard(Player player);

    /**
     * Retorna informacion básica de la tarjeta, con propiedades
     * @return
     */
    public abstract String getData();
    public void add(Card card){
        
    }
    
    public void setPlayers(Player[] players){
        this.players = players;
    }
}
