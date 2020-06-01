/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import File.ErrorException_GUI;
import Player.Player;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author camran
 */
public class PlayerHandler implements Serializable{
    private Player[] player;
    private int numberDices;
    private int playersLimit;
    private int turno=0;
    private int playersAdded=0;
    
    
    public int getTurn(){
        return turno;
    }
    
    public void turnPass(){
        turno++;
        if(turno == playersAdded){
            turno=0;
            //Cada vez que termina una ronda, todos los jugadores se les quitara un turno
            for(int i=0;i<player.length;i++){
            if(player[i]!=null)                
                player[i].passTurn();
            }
        }
        
        
    }
    
    
    public int getPlayersAdded(){
        return playersAdded;
    }
    
    public int getPlayersLimit(){
        return playersLimit;
    }
    
    public int getNumberDices(){
        return numberDices;
    }
    
    public Player[] getPlayers(){
        return player;
    }
    
    /**
     * Indica el limite de jugadores de la partida y crea un vector del tamaño indicado
     * @param playersLimit
     */
    public void setPlayersLimit(int playersLimit){
        this.playersLimit = playersLimit;
        player = new Player[playersLimit];
    }
    
    /**
     * Agrega un nuevo jugador con caracteristicas al vector
     * @param newPlayer
     * @throws ErrorException_GUI
     */
    public void addPlayer(Player newPlayer) throws ErrorException_GUI{
        boolean agregado = false;
        try{
            for(int i=0;i<player.length;i++){
                if(player[i]==null && newPlayer!=null){
                    player[i] = newPlayer;
                    agregado=true;
                    playersAdded++;
                    break;
                }
            }
            
            if(agregado!=true){
                throw new ErrorException_GUI("Ya no se pueden agregar más jugadores");
            }
        }catch(Exception e){
            throw new ErrorException_GUI(e.getMessage());
        }
        
    }
    
    /**
     * Agrega los valores básicos de esta clase
     * @param playersLimit
     * @param numberDices
     */
    public void addComponents(int playersLimit, int numberDices){
        this.playersLimit = playersLimit;
        this.numberDices = numberDices;
        player = new Player[playersLimit];
    }
    //Realizamos una variable (numero) estatica que nos permitira manejar la funcion interna del hilo
    
    public static int numero;

    /**
     *  Simula dados en un objeto TextArea que cambia rapidamente el numero dando un resultado aleatorio
     * @param text
     * @return
     */
    public int lanzarDados(JTextArea text){
        Thread dados = new Thread() {
            public void run() {
                Random random = new Random();
                for(int i=0;i<30;i++){
                    numero = random.nextInt(5+1)+1;
                    text.setText(Integer.toString(numero)+"\n");
                    text.revalidate();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                
            }
        };
        dados.start();
        return numero;
    }
    
    /**
     * Metodo que funciona como hilo aparte para empezar un cronometraje para que el boton se vuelva visible de nuevo
     * (Boton para lanzar dados)
     * @param button
     */
    public void setVisibletheButton(JButton button){
        Thread respawn = new Thread() {
            public void run() {
                try {
                    button.setVisible(false);
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                }
                button.setText("Continuar");
                button.setVisible(true);
            }
        };
        respawn.start();
    }

    /**
     * Funcion para comprobar que haya algun ganador es decir, que solo un jugador aun no se halla declarado en bancarrota
     * Retornara falso por defecto si el juego sigue de pie, retornara verdadero si solo queda un jugador, y termina el juego.
     * Analiza el tamaño del arreglo primero y comprueba con una variable contadora el numero de jugadores que aun tengan acceso al juego
     * @return
     */
    public boolean checkForWinners() {
        int contadoraJugadoresEnJuego =0;
        Player winner;
        boolean answer=false;
        for(int index=0; index<playersAdded;index++){
            if(player[index].getaccestoPlay()==false && player[index]!=null){
                contadoraJugadoresEnJuego++;
            }
        }
       
        if(contadoraJugadoresEnJuego==playersAdded-1){
            for(int index=0; index<playersAdded;index++){
                if(player[index].getaccestoPlay()==true){
                    JOptionPane.showMessageDialog(new JFrame(),player[index].getNombre()+" ha Ganado", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE);
                    answer =  true;
                    player[index].setWinner();
                }else{
                    player[index].setLooser();
                }
            }
        }
        
        return answer;
    }
}
