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
public abstract class Box implements Serializable {
    protected String name="";
    protected Player[] player;
    /**
     * Se crea el metodo abstracto doBox que hara una diferente accion depende del tipo de la casilla
     * Para la clase jail se le asignara una cantidad de turnos perdidos al jugador
     * para la clase BoxNeutral no hara nada
     * Para la clase Property es especial porque dependendiendo de que clase hija se convertira ya sea boxPlace, boxService, y boxStation
     * que agrega un costo al quien cae que no sea compatible con el propietario de boxProperty o envia datos si el dueño no es nadie o esta en ""
     * 
     * Para la clase Start asignara el dinero indicado al jugador o cualquiera que caiga en dicha casilla
     * Para la clase trampa reutilizamos la funcionalidad de las tarjetas y hacemos que solo pueda ingresarse 3 tipos de tarjetas
     * Por ende esta clase solo activa la funcion abstracta doCard de la clase CARD
     */
    public abstract void doBox(Player player);
    public void add(Card card){
        
    }
    
    public void setPlayers(Player[] player){
        this.player = player;
    }
    
    public String getName(){
        return name;
    }
    
    
}
