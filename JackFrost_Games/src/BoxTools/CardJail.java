/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import Map_Initializer.Route;
import Player.Player;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase para salir de la carcel
 * @author camran
 */
public class CardJail extends Card{
    private int price;
    
    /**
     * Realiza una carta para salir de la carcel, donde se le asigna
     * precio de venta
     * @param price
     */
    public CardJail(int price){
        this.price = price;
        this.type = "Jail";
    }
    
    /**
     * Al activar esta casilla reestablecemos los turnos del jugador nuevamente
     * @param player 
     */
    @Override
    public void doCard(Player player) {
        player.setTurnosPerdidos(0);
        JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(2),"GENIAL" ,JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getData() {
        return("Carta: Salir Carcel\n Precio: "+price+"\n");
    }

    public String getType(){
        return type;
    }
    
    public int getPrice(){
        return price;
    }
    
}
