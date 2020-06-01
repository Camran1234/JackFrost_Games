/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;


import Box.BoxProperty;
import BoxTools.BoxService;
import BoxTools.BoxStation;
import BoxTools.BoxPlace;
import Player.Player;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class Bank implements Serializable{
    private double intereses;
    private int limiteCasas;
    private int limiteHoteles;
    private int dineroInicial;
    private BoxProperty[] propiedades;
    private GroupPlace[] gruposLugar = new GroupPlace[0];
    private GroupStation estaciones = new GroupStation();
    private GroupService servicios = new GroupService();
    
    public BoxProperty[] getPropiedades(){
        return propiedades;
    }
    
    public double getIntereses(){
        return intereses;
    }
    
    public int getlimiteCasas(){
        return limiteCasas;
    }
    
    public int getlimiteHoteles(){
        return limiteHoteles;
    }
    
    public int getDineroInicial(){
        return dineroInicial;
    }
    
    /**
     * Se le añade los datos básicos a este banco, sobre ciertas caracteristicas relacionado
     * con lo financiero del juego
     * @param intereses
     * @param limiteCasas
     * @param limiteHoteles
     * @param dineroInicial
     */
    public void addComponents(double intereses, int limiteCasas, int limiteHoteles, int dineroInicial){
         this.intereses = intereses;
        this.limiteCasas =limiteCasas;
        this.limiteHoteles = limiteHoteles;     
        this.dineroInicial = dineroInicial;
    }

    /**
     * Método en el cual le asignamos las propiedades a este banco que las administrara, y creara subgrupos
     * 1.- Lugares(Puede ser más de un grupo)
     * 2- Servicios
     * 3.- Estaciones
     * @param casillasAux
     */
    public void setPropiedades(BoxProperty[] casillasAux) {
        int contadora=0;
        this.propiedades = casillasAux;
        boolean resetFor=false;
        GroupPlace[] grupoAuxiliar;
        GroupPlace[] groupTrim;
        estaciones = new GroupStation();
        servicios = new GroupService();
        boolean empezarConteo=false;
        try{
        /*
            Hacemos un ciclo en el cual la primera condicion contara el numero de casillasLugar que existen y reiniciaremos su variable
            booleana para que pueda ser tomado en cuenta con la condicion, Luego en la siguiente condicion agregamos una casillaServicio
            al grupo de servicios y lo mismo para la tercera condicion pero para casillasEstaciones
            */
            for(int indexPropertyPlace=0;indexPropertyPlace<casillasAux.length;indexPropertyPlace++){
            if(casillasAux[indexPropertyPlace] instanceof BoxPlace){
                contadora++;
                //Se reinicia los contadores
                ((BoxPlace)casillasAux[indexPropertyPlace]).setCounted(false);
            }else if(casillasAux[indexPropertyPlace] instanceof BoxService){
                this.servicios.addService((BoxService)((BoxProperty)casillasAux[indexPropertyPlace]));
            }else if (casillasAux[indexPropertyPlace] instanceof BoxStation){
                this.estaciones.addStation((BoxStation)((BoxProperty)casillasAux[indexPropertyPlace]));
            }
            
        }
        grupoAuxiliar = new GroupPlace[contadora];
        for(int index=0;index<grupoAuxiliar.length;index++){
            grupoAuxiliar[index] = new GroupPlace();
        }
        contadora=0;
        
        //En este ciclo meteremos nuestro vector GroupPlace para extraer los grupos que posee y sus magnitudes
        //Generaremos de primero si no se ha tomado en cuenta, al no ser tomado en cuenta utilizaremos la funcion compareTo
        //de la clase GroupPlace que permite contarse y asignarse a un grupo, y cambia la variable booleana de estado contado
        //de la clase BoxPlace para que no vuelva a ser tomada en cuenta, si ya se encuentra un grupo que no concuerda con el grupo que se
        //esta trabajando se coloca una condicion que reiniciara el for y aumentara la magnitud del vector de la clase GroupPlace
        //y volvera a realizar el mismo proceso pero no podra acceder a los grupos ya contados
        for(int indexAuxiliar=0;indexAuxiliar<casillasAux.length;indexAuxiliar++){
            if(casillasAux[indexAuxiliar] instanceof BoxPlace){
                if(((BoxPlace)casillasAux[indexAuxiliar]).getCounted()==false){
                    if(grupoAuxiliar[contadora].compareTo(((BoxPlace)casillasAux[indexAuxiliar]).getGroup())){
                        ((BoxPlace)casillasAux[indexAuxiliar]).setCounted(true);
                        grupoAuxiliar[contadora].setBox((BoxPlace)casillasAux[indexAuxiliar]);
                        empezarConteo=true;
                        System.out.println("Ingreso "+indexAuxiliar);
                    }else{
                        resetFor=true;
                    }
                }
            }
            
            if(resetFor && indexAuxiliar==(casillasAux.length-1)){
                contadora++;
                indexAuxiliar=-1;
                resetFor=false;
            }
        }
        
        //Condicion en caso que no se halla asignado ningun BoxPlace
        if(empezarConteo){
            System.out.println("Empezar Conteo Verdadero");
            groupTrim = new GroupPlace[contadora+1];
        
            for(int index=0;index<groupTrim.length;index++){
                groupTrim[index]=new GroupPlace();
            }
            
            System.out.println(groupTrim.length);
            for(int index=0;index<groupTrim.length;index++){
                    System.out.println("EntroTRIM"+index);
                    groupTrim[index] = grupoAuxiliar[index]; 
            }
            this.gruposLugar = groupTrim;
        }else{
           this.gruposLugar = new GroupPlace[1]; 
           this.gruposLugar[0] = new GroupPlace();
        }
        
        
       
        }catch(Throwable e){
            System.out.println("Empezar Conteo Falso");
            e.printStackTrace();
        }
    }
    
    /**
     *Funcion que utilizaremos para verificar si hay propiedades del mismo grupo y aumentarles su multiplicador
     * Comprobando los grupos de propiedades lugares, y las estaciones con servicios
     */
    public void aumentarGrupos(){
        
        //Actualizamos el estado de cada grupo de propiedades
        for (GroupPlace gruposLugar1 : gruposLugar) {
            gruposLugar1.checkForMultiplier();
        }
        
        //Llamamos las funciones checkMultipliers para aumentar el multiplicador de cada servicio y estacion
        this.servicios.checkMultipliers();
        this.estaciones.checkMultipliers();
        
        
    }

    /**
     * Agrega intereses a las casillas propiedades que esten hipotecadas
     */
    public void addInterests() {
        for(int i=0;i<propiedades.length;i++){
            if(propiedades[i].getmortageStatus())
                propiedades[i].addInterests(intereses);
        }
    }

    /**
     * Resetea las propiedades de un jugador que se ha considerado en bancarrota
     * @param player
     */
    public void resetPropertys(Player player) {
       for(int index=0;index<propiedades.length;index++){
           if(propiedades[index].getOwner().equalsIgnoreCase(player.getNombre())){
               propiedades[index].reset();
           }
       }
    }

    /**
     * Determina quien tiene todas las propiedades
     * @param players
     * @return 
     */
    boolean checkForWinners(Player[] players) {
        int contadoraPropiedades=0;
        Player winner = null;
        for(int indexPlayers=0;indexPlayers<players.length;indexPlayers++){
            contadoraPropiedades=0;
            if(players[indexPlayers]!=null){
                //La puntuacion es la cantidad de dinero y propiedades con construcciones que no esten hipotecadas
                //y usamos la funcion resetScore para volver a reiniciar el punteo y asignarle 
                players[indexPlayers].resetScore();
                contadoraPropiedades=0;
                for(int indexPropertys=0;indexPropertys<propiedades.length;indexPropertys++){
                    if(propiedades[indexPropertys].getOwner().equalsIgnoreCase(players[indexPlayers].getNombre())){
                        contadoraPropiedades++;
                        players[indexPlayers].addScore(propiedades[indexPropertys].getScore());
                        winner=players[indexPlayers];
                    }
                }
            }
            //Con esta condicion comparamos quien halla tenido todas las propiedades y le agregamos la funcion setWinners
            if(contadoraPropiedades==propiedades.length && winner!=null){
                for(int index=0;index<players.length;index++){
                    if(players[index]!=null){
                        if(players[index] == winner){
                            players[index].setWinner();
                        }else{
                            players[index].setLooser();
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Determina quien gano y quien perdio dependiendo de quien tenga mas dinero y propiedades
     * @param players 
     */
    void checkWinnersForGlory(Player[] players) {
        int scoreMaximum=0;
        Player winner=null;
        for(int indexPlayers=0;indexPlayers<players.length;indexPlayers++){
            if(players[indexPlayers]!=null){
                //La puntuacion es la cantidad de dinero y propiedades con construcciones que no esten hipotecadas
                //y usamos la funcion resetScore para volver a reiniciar el punteo y asignarle 
                players[indexPlayers].resetScore();
                for(int indexPropertys=0;indexPropertys<propiedades.length;indexPropertys++){
                    if(propiedades[indexPropertys].getOwner().equalsIgnoreCase(players[indexPlayers].getNombre())){
                        players[indexPlayers].addScore(propiedades[indexPropertys].getScore());                        
                    }
                }
                //Utilizamos esta condicion para determinar si el punteo del jugador es mayor que un punteo maximo 
                //que va determinando el mayor punteo encontrado, y se encuentra el ganador
                if(players[indexPlayers].getScore()>scoreMaximum){
                    scoreMaximum = players[indexPlayers].getScore();
                    winner=players[indexPlayers];
                }
            }
        }
        
        if(winner!=null && scoreMaximum!=0){
            for(int indexPlayers=0;indexPlayers<players.length;indexPlayers++){
                if(players[indexPlayers]!=null){
                    //Comprobamos que si el jugador es el ganador o tiene la misma cantidad que la variable ScoreMaximum se le considera ganador
                    if(players[indexPlayers] == winner || players[indexPlayers].getScore() == scoreMaximum){
                        players[indexPlayers].setWinner();
                        JOptionPane.showMessageDialog(null, winner.getNombre() + " ha ganado");
                    }else{
                        players[indexPlayers].setLooser();
                    }
                }
            }
        }
        
    }
    
}
