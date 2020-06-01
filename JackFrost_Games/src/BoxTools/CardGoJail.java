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
 * Clase para ir a la carcel
 * @author camran
 */
public class CardGoJail extends Card{
    private String go="Cárcel";
    
    /**
     * Metodo que envia al jugador a la cárcel más cercana, si no encuentra ninguna 
     * lanza un mensaje y ya no realiza nada. 
     * Buscamos por toda la ruta una casilla tipo Carcel igualandolo con su tipo 
     * y almacenamos su posicion, priorizara de primero las casillas cárceles más cercanas
     * del jugador.
     * 
     * @param player 
     */
    @Override
    public void doCard(Player player) {
         Route ruta = player.getRoute();
        
        
        int casillas = 0;
        int carcelAux =0;
        int numero=0;
        
        //Metodo que nos permite saber cual es la casilla carcel mas cercana
        for(int i=0;i<ruta.getRoute().length;i++){
            if(ruta.getRoute()[i].getType().equalsIgnoreCase(go)){
                if(casillas==0){
                    carcelAux=i;
                    casillas++;
                }else{
                    numero = player.getPosition() - i;
                    if(numero<0)
                        numero=numero*(-1);
                    
                    if(numero<=carcelAux){
                        carcelAux = numero;
                    }
                }
            }
        }
        if(casillas!=0){
            player.setPosition(carcelAux);
            ruta.getRoute()[carcelAux].getBox().doBox(player);
            JOptionPane.showMessageDialog(new JFrame(), phrases.getPhrases(3)+" Va a la carcel","OH NO" ,JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "No se ha encontrado una carcel");
        }
    }

    @Override
    public String getData() {
        return("Carta: Ir a Carcel"+"\n");
    }

    
    
}
