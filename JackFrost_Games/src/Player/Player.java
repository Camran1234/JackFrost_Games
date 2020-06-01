/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import BoxTools.Card;
import Map_Initializer.Route;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class Player implements Serializable{
    private int dineroInicial=0;
    private String nombre=null;
    private Color color=null;
    private Route ruta;
    private int position =0;
    //Usar esta variable para cuando sea finalizar turno
    private int turnosPerdidos =0;
    private boolean accestoPlay=true;
    private boolean results=false;
    private Card[] card = new Card[0];
    private int score=0;
    
    public Player(Route ruta, Color color, int dinero,String nombre){
        this.ruta = ruta;
        this.color = color;
        this.dineroInicial = dinero;
        this.nombre = nombre;
    }
    
    public boolean getResultado(){
        return results;
    }
    
    /**
     * Para indicar si el jugadro continuara jugando o no
     * @param looser
     */
    public void setLooser(){
        results=false;
        accestoPlay=false;
        score= dineroInicial;
        dineroInicial=0;
    }
    
    /**
     *Asignamos la puntuacion del ganador, en puntuacion solo se debe de enviar el numero de construcciones multiplicadas por su valor
     * mas la suma de las propiedades
     * @param puntuacion
     */
    public void setWinner(){
        results=true;
    }
    
    public void resetScore(){
        score = dineroInicial;
    }
    
    public void addScore(int newScore){
        score +=newScore;
    }
    
    public int getScore(){
        return score;
    }
    
    public void useCard(){
        card[card.length-1].doCard(this);
        eliminateCard();
        JOptionPane.showMessageDialog(null,nombre + " ha usado una carta para salir de la carcel");
    }
    
    public Card[] getCards(){
        return card;
    }
    
    /**
     * Debe de ser verdadero para que deje jugar, false indica que no puede continuar
     * @return
     */
    public boolean getaccestoPlay(){
        return accestoPlay;
    }
    
    public void addCard(Card newCard){
        int size = card.length+1;
        Card[] auxiliarCards = new Card[size];
        for(int i=0 ;i<(size-1);i++){
            auxiliarCards[i] = card[i];
        }
        auxiliarCards[size-1] = newCard;
        card = auxiliarCards;
    }
    
    public void eliminateCard(){
        int size = card.length-1;
        Card[] auxiliarCards = new Card[size];
        for(int i=0 ;i<(size);i++){
            auxiliarCards[i] = card[i];
        }
        card = auxiliarCards;
    }
    
    public void passTurn(){
        if(turnosPerdidos!=0){
            turnosPerdidos--;
        }
    }
    
    public void setPosition(int position){
        this.position = position;
    }
    
    public Route getRoute(){
        return ruta;
    }
    
    public void setTurnosPerdidos(int turnos){
        turnosPerdidos = turnos+1;
        if(card.length>0){
            this.useCard();
        }
    }
    
    public int getTurnosPerdidos(){
        return turnosPerdidos;
    }
    
    /**
     *Mueve de posicion al jugador, si este sobrepasa el tamaño de la ruta entonces
     * se le resta el tamaño de la ruta y se le agrega el dinero indicado
     * @param mover
     */
    public void move(int mover){
        position += mover;
        while(true){
            if(position >= ruta.getRoute().length){
                position -= ruta.getRoute().length;
                ruta.getRoute()[0].getBox().doBox(this);
            }else{
                break;
            }
        }
    }
    
    public void addDinero(int dineroInicial){
        System.out.println(dineroInicial);
        this.dineroInicial += dineroInicial;
        if(this.dineroInicial<=0){
            accestoPlay=false;
        }else{
            accestoPlay=true;
        }
    }
    
    
    public int getPosition(){
        return position;
    }
    
    
    
    public int getDinero(){
        return dineroInicial;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Color getColor(){
        return color;
    }
    
    
}
