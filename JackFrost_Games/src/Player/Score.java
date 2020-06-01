/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.io.Serializable;

/**
 * Clase que guarda el resultado final de un jugador de x Partida
 * Y es importante que sea asignado junto a una clase Ranking para accionarlo correctamente
 * @author camran
 */
public class Score implements Serializable{
    private String name;
    private int score;
    //Esta variable determina si es ganador o perdedor
    private boolean statusPlayin;
    
    /**
     * Se envia verdadero si el resultado fue ganador
     * Se envia falso si el resultado fue perdedor
     * @param name
     * @param score
     * @param statusPlayin
     */
    public Score(String name, int score, boolean statusPlayin){
        this.name = name;
        this.score = score;
        this.statusPlayin = statusPlayin;
    }

    public Score() {
        
    }
    
    public int getScore(){
        return score;
    }
    
    public String getData(){
        String data = "Nombre: "+name+" || Puntuacion: "+score+" || Estado: ";
        if(statusPlayin){
            data+= "Ganador";
        }else{
            data+= "Perdedor";
        }
        data+="\n";
        return data;
    }
    
    public boolean getstatusPlayin(){
        return statusPlayin;
    }
}
