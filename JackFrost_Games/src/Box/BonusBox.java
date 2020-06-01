/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box;

import BoxTools.Card;
import BoxTools.CardJail;
import Player.Player;
import java.io.Serializable;

/**
 *
 * @author camran
 */
public class BonusBox extends Box implements Serializable{
    private Card[] cards;
    private int tamaño =0;
    private int tope;
    
    public void add(Card card) {
        tamaño++;
        Card[] auxiliarCards = new Card[tamaño];
        for(int i=0 ;i<(tamaño-1);i++){
            auxiliarCards[i] = cards[i];
        }
        auxiliarCards[tamaño-1] = card;
        cards = auxiliarCards;
        tope=tamaño;
    }
    
    public Card[] getCards(){
        return cards;
    }
    
    public int getlength(){
        return tamaño;
    }
    
    //En este caso el metodo doBox solo accionaremos
    //el atributo de la carta, sin embargo como el 
    //jugador la tomara y la devuelve al final de la pila de cartas
    //entonces se manejara como una pila
    @Override
    public void doBox(Player player) {
        cards[tope-1].setPlayers(this.player);
        if( cards[tope-1] instanceof CardJail){
            player.addCard(cards[tope-1]);
        }else{
            cards[tope-1].doCard(player);
        }
        tope--;
        if(tope==0){
            tope=tamaño;
        }
        
    }

    
}
