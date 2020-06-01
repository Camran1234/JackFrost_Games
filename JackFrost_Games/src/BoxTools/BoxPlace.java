/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import Box.BoxProperty;
import Player.Player;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Es una casilla lugar que puede agregarse edificaciones, como casas entro otras
 * @author camran
 */
public class BoxPlace extends BoxProperty implements Serializable{
    private final int bonusHouse;
    private final int bonusHotel;
    private final int housePrice;
    private final int hotelPrice;
    private int numberHouses=0;
    private int numberHotels=0;
    private String group;
    private boolean accesToBuildHouses = false;
    private boolean accesToBuildHotels = false;
    private boolean counted=false;
    
    /**
     *Constructor de una casilla tipo lugar, indicando cada uno de los parametros presentes
     * el grupo puede ser cualquier oracion
     * @param name
     * @param group
     * @param buyPrice
     * @param mortageValue
     * @param servicePrice
     * @param bonusHouse
     * @param housePrice
     * @param bonusHotel
     * @param hotelPrice
     */
    public BoxPlace(String name, String group, int buyPrice, int mortageValue, int servicePrice,
            int bonusHouse, int housePrice, int bonusHotel,int hotelPrice){
        super(name, buyPrice, mortageValue, servicePrice);
        this.group = group;
        this.bonusHotel = bonusHotel;
        this.bonusHouse = bonusHouse;
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
        System.out.println("Generado: "+group);
    }
    
    /**
     * Cambia el valor de la variable booleana counted
     * @param choice
     */
    public void setCounted(boolean choice){
        counted=choice;
    }
    
    public boolean getCounted(){
        return counted;
    }
    
    public String getGroup(){
        return group;
    }
    /**
     * Metodo que comprueba de primero si dicha propiedad no esta hipotecada y determina quien halla caido en esta casilla
     * si es el propietario no le cobrara nada pero si es alguien que no es el propietario le cobrara un costo que depende de si posee
     * construcciones o no, Si aun no tiene propietario esta casilla mandara un mensaje informativo de los datos de la propiedad
     * @param player 
     */
    @Override
    public void doBox(Player player) {
        if(this.mortageStatus==false){
            //Esta funcion comprueba si puede realizar el cobro al jugador y que no sea el propietario quien caiga     
            if(owner.equalsIgnoreCase("")==false && owner.equalsIgnoreCase(player.getNombre())==false){
                int costo= (-1)*servicePrice;
                //Con estas dos funciones determinamos que tipo de precio sera el servicio con los hoteles o con las casas
                if(accesToBuildHouses == true && accesToBuildHotels==true && numberHouses>0){
                    costo= (-1)*(servicePrice + (hotelPrice * numberHotels) )*(multiplier); 
                }else if(accesToBuildHouses == true && accesToBuildHotels==false && numberHotels>0){
                    costo= (-1)*(servicePrice + (housePrice * numberHouses) )*(multiplier); 
                }
                //le quitamos el dinero a quien callo en esta casilla     
                player.addDinero(costo);

                //le agregamos el dinero al propietario
                for(int i=0;i<this.player.length;i++){
                    if(this.player[i]!=null){
                        if(owner.equalsIgnoreCase(this.player[i].getNombre())){
                            this.player[i].addDinero((costo*-1));
                            break;
                        }
                    }
                }

                JOptionPane.showMessageDialog(new JFrame(), "Se ha quitado "+(costo*-1)+" a "+player.getNombre()+"\n"+
                        "y se le agrego "+(costo*-1)+" a "+ owner);
                //Si nadie es dueño aun lanzara un mensaje con los datos de la propiedad por si esta interesado en comprarla
            }else if(owner.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(new JFrame(),this.getData(),"DATOS DE PROPIEDAD",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Propiedad Hipotecada");
        }
    }
    
    /**
     * Obtiene informacion basica de la propiedad
     * Si no tiene dueño dara informacion potencial de compra
     * Si tiene dueño dara informacion general
     * @return
     */
    @Override
    public String getData(){
        String data;
        if(owner.equalsIgnoreCase("")){
            data = ("Tipo: Lugar"+" Nombre: "+name+ " Precio: "+buyPrice+" Grupo: "+group);
        }else{
            data = ("Tipo: Lugar"+" Nombre: "+name+" Grupo: "+group+" NumeroCasas: "+numberHouses+
                    " Costo Casa: "+housePrice+" Aumento por Casa: "+bonusHouse+" Numero Hoteles: "+numberHotels+
                    " Costo Hotel: "+hotelPrice + " Aumento por hotel: "+bonusHotel+ " Hipoteca: "+mortageValue+" Multiplicador: "+multiplier
                    +" Costo: "+servicePrice+"Estado Hipotecado: "+ mortageStatus+"\n");
        }
        return data;
    
    }

    /**
     *Tienes que agregar limite de casas para que se agreguen
     * los limites de casas estan en la clase Bank, si se llega al limite se podra
     * agregar nuevas
     * @param limitHouse
     */
    public void addHouse(int limitHouse){
            Player propietario = null;

            //Buscamos el jugador propietario de la casilla
            for(int i=0;i<this.player.length;i++){
                if(this.player[i]!=null){
                    if(this.player[i].getNombre().equalsIgnoreCase(owner)){
                        propietario = this.player[i]; 
                    }
                }
            }
            //Comprobamos de que el propietario tenga dinero suficiente para agregar la casa
            //de lo contrario no la agregara y enviara un mensaje error
            if(propietario.getDinero()>=housePrice){
                if(numberHouses < limitHouse && accesToBuildHouses == true){
                    numberHouses++;
                    propietario.addDinero((housePrice*-1));
                    if(numberHouses == limitHouse){
                        accesToBuildHotels = true;
                    }
                    JOptionPane.showMessageDialog(null, "Casa agregada");
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"No puedes seguir construyendo casas","OH NO",JOptionPane.ERROR_MESSAGE);
                }        
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"No tienes dinero suficiente","OH NO",JOptionPane.ERROR_MESSAGE);
            }
            mortgagable=false;
        
    }
    
    /**
     * Funcion para añadir un hotel
     * @param limitHotel
     */
    public void addHotel(int limitHotel){
        Player propietario = null;
        
        //Buscamos el jugador propietario de la casilla
        for(int i=0;i<this.player.length;i++){
            if(this.player[i]!=null){
                if(this.player[i].getNombre().equalsIgnoreCase(owner)){
                propietario = this.player[i]; 
                }
            }
            
        }
        //Comprobamos de que el propietario tenga dinero suficiente para agregar el hotel
        //de lo contrario no la agregara y enviara un mensaje error
        if(propietario.getDinero()>=hotelPrice){
            if(numberHotels < limitHotel && accesToBuildHotels == true){
                numberHotels++;
                propietario.addDinero((hotelPrice*-1));
                JOptionPane.showMessageDialog(null, "Hotel agregado");
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"No puedes seguir construyendo hoteles","OH NO",JOptionPane.ERROR_MESSAGE);
            }        
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"No tienes dinero suficiente","OH NO",JOptionPane.ERROR_MESSAGE);
        }
        mortgagable=false;
    }
    
    /**
     *Se vende un hotel y le añade el dinero al propietario
     */
    public void sellHotel(){
        Player propietario = null;
        
        //Buscamos el jugador propietario de la casilla
        for(int i=0;i<this.player.length;i++){
            if(this.player[i]!=null){
                if(this.player[i].getNombre().equalsIgnoreCase(owner)){
                    propietario = this.player[i]; 
                }
            }
        }
        //Miramos si hay suficientes hoteles y si entra le añadimos el dinero al jugador
        if(numberHotels>0&& propietario!=null){
            numberHotels--;
            propietario.addDinero(hotelPrice);
            JOptionPane.showMessageDialog(null, "Hotel vendido");
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"No hay hoteles para vender","OH NO",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Vende una casa y le añade el dinero al propietario
     */
    public void sellHouse(){
        Player propietario = null;
        
        //Buscamos el jugador propietario de la casilla
        for(int i=0;i<this.player.length;i++){
            if(this.player[i]!=null){
                if(this.player[i].getNombre().equalsIgnoreCase(owner)){
                    propietario = this.player[i]; 
                }
            }
        }
        //Miramos si hay suficientes casas para vender y que no halla hoteles luego le 
        //añadimos el dinero al propietario
        if(numberHouses>0 && numberHotels==0 && propietario!=null){
            numberHouses--;
            propietario.addDinero(housePrice);
            accesToBuildHotels=false;
            if(numberHouses==0){
            mortgagable=true;
            }
            JOptionPane.showMessageDialog(null, "Casa vendida");
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"No se pueden vender casas","OH NO",JOptionPane.ERROR_MESSAGE);
        }
        
                
    }
    /**
     * Con este metodo indicamos que un jugador posee todas las propiedades
     * de este grupo y se le incrementa su multiplicador y capacidad de construir
     */
    @Override
    public void increaseMultiplierBySameGroup() {
        this.multiplier=2;
        accesToBuildHouses=true;
    }

    @Override
    public void decreaseMultiplierBySameGroup() {
        this.multiplier=1;
        accesToBuildHouses=false;
    }
    /**
     * Resetea las caracteristicas de esta propiedad
     */
    @Override
    public void reset(){
        owner="";
        mortageStatus=false;
        mortagePrice=mortageValue;
        mortgagable=true;
        multiplier =1;
        numberHouses=0;
        numberHotels=0;
        accesToBuildHouses=false;
        accesToBuildHotels=false;        
    }
    
    public int getScore(){
       if(mortageStatus==false)
           return (buyPrice+(numberHouses*housePrice)+(numberHotels*hotelPrice));
        
       return 0;
    }
    
}
