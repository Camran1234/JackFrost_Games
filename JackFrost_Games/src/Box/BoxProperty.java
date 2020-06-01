/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box;

import Player.Player;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class BoxProperty extends Box implements Grupo,Serializable{

   /*
        Se usara el multiplicador como indicador de cuantas veces se debe
        de aumentar el valor del servicio
    */ 
   protected String owner = "";
   protected int buyPrice;
   protected int mortageValue;
   protected double mortagePrice;
   protected boolean mortageStatus =false;
   protected boolean mortgagable=true;
   protected int multiplier = 1;
   protected int servicePrice;

   public BoxProperty(String name, int buyPrice, int mortageValue, int servicePrice){
       this.name = name;
       this.buyPrice = buyPrice;
       this.mortageValue = mortageValue;
       this.mortagePrice = mortageValue;
       this.servicePrice = servicePrice;
       //Se usara la variable mortageValue como el precio de la hipoteca
       // Y la variable mortagePrice como el precio de la propiedad hipotecada + los intereses
   }
   
    @Override
    public void doBox(Player player) {
       
    }
    /**
     * Retorna el costo de esta propiedad
     * @return 
     */
    public int getBuyPrice(){
        return buyPrice;
    }
    
    /**
     * Funcion para resetear todas las caracteristicas de esta propiedad
     */
    public void reset(){
        owner="";
        mortageStatus=false;
        mortgagable=true;
        multiplier =1;
        mortagePrice=mortageValue;
        
    }
    
    public void setOwner(Player player ){
        this.owner = player.getNombre();
        player.addDinero((buyPrice*-1));
    }
    
    /**
     * Método para hipotecar una propiedad, por medio del dinero del jugador
     * Es utilizable solo en la clase Hipotecar GUI
     * @param player
     */
    public void mortage(Player player){
        if(mortageStatus==false && mortgagable==true){
            player.addDinero(mortageValue);
            mortageStatus=true;
            JOptionPane.showMessageDialog(null, this.name+" Ha sido hipotecada, "+ player.getNombre()+" recupera " + this.mortageValue);
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Propiedad Hipotecada o con construcciones");
        }
    }
    
    /**
     * Método que comprueba la capacidad de cambiar el estado de hipoteca de la propiedad
     * a cambio del dinero del jugador
     * Es utilizable solo en la clase Hipotecar GUI
     * @param player
     */
    public void recoverFromMortage(Player player){
        if(player.getDinero()>=mortagePrice && mortageStatus==true){
            player.addDinero(((int)mortagePrice)*-1);
            mortageStatus = false;
            mortagePrice = mortageValue;
            JOptionPane.showMessageDialog(null,player.getNombre()+" ha recuperado "+ name + " por una cuota de "+ (((int)mortagePrice)));
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Dinero insuficiente, precio para recuperar: "+mortagePrice+ " o propiedad no hipotecada");
        }
    }
    
    /**
     * Agrega intereses al precio
     * @param interests
     */
    public void addInterests(double interests){
        if(mortageStatus==true){
            mortagePrice = mortagePrice + (mortagePrice*(interests/100));
        }
    }
    
    public int getmortageValue(){
        return mortageValue;
    }
    
    /**
     * Falso si no esta hipotecada
     * Verdadero si esta hipotecada
     * @param status
     */
    public void setmortageStatus(boolean status){
        mortageStatus = status;
    }
    
    /**
     *Falso si no esta hipotecado
     * verdadero si esta hipotecao
     * @return
     */
    public boolean getmortageStatus(){
        return mortageStatus;
    }

    @Override
    public void increaseMultiplierBySameGroup() {
        System.out.println("Nada");
    }

    @Override
    public void decreaseMultiplierBySameGroup() {        
        System.out.println("Nada");
    }

    @Override
    public String getData() {
        return "Nada";
    }
    
    @Override
    public void resetMultiplierBySameGroup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getScore(){
        return buyPrice;
    }
    
    public String getOwner(){
        return owner;
    }

    

    
    
}
