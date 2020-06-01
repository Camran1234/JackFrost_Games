/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import Box.Box;
import File.ErrorException_GUI;
import File.FileGame;
import File.Ranking;
import Player.Player;
import Player.Score;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase importante que almacenara todos los datos importantes de un tablero
 * creado por el usuario, todas las características, cantidad de jugadores, entre otros 
 * que se asignan a cada clase, ESTA CLASE ES LA CLASE DE MAYOR PRIORIDAD
 * @author camran
 */
public class Map implements Serializable{
   private String nombreMapa;
   private Template[][] template = null;
   private Box[] box;
   private Bank bank = new Bank();
   private PlayerHandler playerHandler= new PlayerHandler();
   private Route ruta = new Route();
   private int segundos=0;
   private int minutos=0;
   private int horas=0;
   private boolean recentlyLoad=false;
   private boolean dadosTirados=false;
   
    /**
     * Metodo para saber la hora del reloj
     */
    public void addSegundo(){
       segundos++;
       if(segundos==60){
           segundos=0;
           minutos++;
       }
       
       if(minutos==60){
           minutos=0;
           horas++;
       }
   }
   
   public int getSegundos(){
       return segundos;
   }
   
   public int getMinutos(){
       return minutos;
   }
   
   public int getHoras(){
       return horas;
   }
   
  public boolean getRecentlyLoad(){
      return recentlyLoad;
  } 
   
  public void setRecentlyLoad(boolean recentlyLoad){
      this.recentlyLoad = recentlyLoad;
  }
  
   public Route getRoute(){
       return ruta;
   } 
   
    public Template[][] getTemplate(){
       return template;
   }
   
    public Bank getBank(){
       return bank;
   }
   

    public Box[] getBox(){
       return box;
   }
           
    public String getNameMap(){
        return nombreMapa;
    }
    
    public PlayerHandler getPlayerHandler(){
        return playerHandler;
    }
    
    public void setNameMap(String nombreMap){
        this.nombreMapa = nombreMap;
    }
      
    public void setTemplate(Template[][] template){
        this.template = template;
        System.out.println("Template Modificado");
    }
    
    public void setRoute(Route ruta){
       this.ruta = ruta;
    }
    
    public void setDadosTirados(boolean dados){
        this.dadosTirados=dados;
    }
    
    public boolean getDadosTirados(){
        return dadosTirados;
    }

    /**
     * Comprueba que hallan ganadores de primero por punteos y luego por 
     * ultimo hombre en pie
     * @return
     */
    public boolean checkForWinners() {
        if(bank.checkForWinners(playerHandler.getPlayers()) || playerHandler.checkForWinners() ){
            return true;
        }
        
      return false;
    }

    /**
     * Método que se lanza al final de cada partida, y obtiene los resultados de los jugadores
     * añadiendoles un nombre, punteo(asignado en la clase banco) y un resultado booleano que indica si gano
     * o perdio, luego carga un archivo para agregarselo y guardarlo nuevamente
     * @throws ErrorException_GUI
     */
    public void doResults() throws ErrorException_GUI {
        FileGame file = new FileGame();
        Ranking ranking = file.loadResults("./Punteos/Ranking.rank");
        Player[] playersResults = playerHandler.getPlayers();
        for(int index=0;index<playersResults.length;index++){
            if(playersResults[index]!=null){
                Score score = new Score(playersResults[index].getNombre(),playersResults[index].getScore(),playersResults[index].getResultado());
                ranking.addScore(score);
            }
        }
        file.saveResults("./Punteos/Ranking.rank", ranking);
        JOptionPane.showMessageDialog(null, "Juego Terminado");
    }

    /**
     *  Determinar el ganador por punteo, determinado por el dinero que posee y las propiedades y construcciones
     */
    public void checkForWinnersForResults() {
        bank.checkWinnersForGlory(playerHandler.getPlayers());
       try {
           doResults();
       } catch (ErrorException_GUI ex) {
           Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    
}
