/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Player.Score;
import java.io.Serializable;

/**
 * La clase Ranking nos facilita el control de los resultados de la partida
 * almacenando un tipo score que posee los datos de los jugadores quienes hallan participado
 * @author camran
 */
public class Ranking implements Serializable {
    private Score[] resultados = new Score[0];
    
    //Recordar de siempre inicializar el constructor del objeto

    /**
     * Agrega un nuevo resultado de un jugador como una pila
     * @param resultado
     */
    
    public void addScore(Score resultado){
        Score[] resultadosAuxiliares = new Score[resultados.length+1];
        for(int index=0;index<resultados.length;index++){
            resultadosAuxiliares[index] = resultados[index];
        }
        resultadosAuxiliares[resultados.length] = resultado;
        resultados = resultadosAuxiliares;
    }
    
    /**
     * Obtenemos todos los resultados de las partidas
     * @return
     */
    public Score[] getResults(){
        return resultados;
    }
    
    /**
     * Volvemos a indicar los resultados Scores de la clase
     * @param scores
     */
    public void setResults(Score[] scores){
        this.resultados = scores;
    }
    
   
}
