/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import File.ErrorException_GUI;
import Player.Player;

/**
 *
 * @author camran
 */
public class CardCustomizable extends Card {
    private Card card1;
    private Card card2;
    
    /**
     * Constructor de carta customizable, solo mantiene dos objetos tipo cartas
     * que son agregadas como una pila y su metodo doCard son los metodos de las cartas
     * que hallas sido agregadas
     */
    public CardCustomizable(){
    }

    public void add(Card card){
        try{
            if(card1==null){
                card1=card;
            }else if(card2==null){
                card2=card;
            }else{    
                new ErrorException_GUI("Error: Cartas Llenas");
            }
        }catch(Exception e){
            new ErrorException_GUI(e.getMessage());
        }
    }
    
    @Override
    public void doCard(Player player) {
        card1.doCard(player);
        card2.doCard(player);
    }

    @Override
    public String getData() {
        return (card1.getData() +"\n"+ card2.getData());
    }

    
}
