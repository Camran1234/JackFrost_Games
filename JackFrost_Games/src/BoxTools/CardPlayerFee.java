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
public class CardPlayerFee extends Card{
    public int fee;
    
    /**
     * Constructor de la casilla playerFee, que sirve para darle una cantidad
     * de dinero a los demas jugadores del propio dinero
     * @param fee
     */
    public CardPlayerFee(int fee){
        this.fee = fee;
    }

    /**
     * En esta carta tendremos un arreglo de todos los jugadores que hay
     * si se encuentra el jugador enviado en el metodo en el arreglo le quitaremos
     * la multa
     * @param player
     */
    @Override
    public void doCard(Player player) {
       int contadora=0;
       
       for(int indexPlayers=0;indexPlayers<players.length;indexPlayers++){
           if(players[indexPlayers]!=null){ 
                if(players[indexPlayers]==player){
                    contadora++;
                     player.addDinero((-fee)*players.length);
                 }else{
                     player.addDinero(fee);
                }
           }
        }
       player.addDinero((-fee)*contadora);
        JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(5)+fee,"OH WOW",JOptionPane.INFORMATION_MESSAGE);
    
}

    @Override
    public String getData() {
        return("Carta: Pagar a Jugadores\n Pago: " + fee+"\n");
    }

    
    
}
