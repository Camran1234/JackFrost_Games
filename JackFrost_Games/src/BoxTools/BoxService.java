/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import Box.BoxProperty;
import Box.Grupo;
import Player.Player;
import java.io.Serializable;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class BoxService extends BoxProperty implements Serializable{
    private int numberDices=1;
    
    public BoxService(String name, int buyPrice, int mortageValue, int servicePrice) {
        super(name, buyPrice, mortageValue, servicePrice);
    }
    
    public void setNumberDices(int dados){
        numberDices=dados;
        //Agregar codigo de dados
    }
    /**
     * Método que cobra a un jugador que haya accionado esta casilla y que no sea el propietario
     * Si es el propietario no hara ninguna accion, y si no posee aún ningun propietario 
     * enviara información básica de esta propiedad
     * @param player 
     */
    @Override
    public void doBox(Player player){
        
        if(mortageStatus ==false){   
           if(owner.equalsIgnoreCase("")==false && owner.equalsIgnoreCase(player.getNombre())==false){
               Random random = new Random();
               int costo= servicePrice*multiplier*-1;
               costo = costo * random.nextInt(6+1) * numberDices;
               //le quitamos el dinero a quien callo en esta casilla     
               player.addDinero(costo);

               //le agregamos el dinero al propietario
               for(int i=0;i<this.player.length;i++){
                   if(this.player[i]!=null)
                   if(owner.equalsIgnoreCase(this.player[i].getNombre())){
                       this.player[i].addDinero((costo*-1));
                       break;
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
     *Multiplicador servicios,solo aumenta por 1 segun la cantidad de propiedades que se tenga
     */
    @Override
    public void increaseMultiplierBySameGroup() {
        this.multiplier++;
    }

    /**
     *Multiplicador servicios,solo disminuye por 1 segun la cantidad de propiedades que se tenga
     */
    @Override
    public void decreaseMultiplierBySameGroup() {
        this.multiplier--;
    }
    
    /**
     * Retorna informacion de esta casilla, informacion para comprarla y luego para venderla
     * @return
     */
    @Override
    public String getData(){
        String data;
        if(owner.equalsIgnoreCase("")){
            data = ("Tipo: Estacion"+" Nombre: "+name+ " Precio: "+buyPrice+" Grupo: Estacion\n"+" Servicio: "+servicePrice+" Hipoteca: "+mortageValue);
        }else{
            data = ("Tipo: Servicio"+" Nombre: "+name+" Servicio: "+servicePrice+" Hipoteca: "+mortageValue
                    +"Multiplicador: "+multiplier+"Estado Hipotecado: "+ mortageStatus+"\n");
        }
        return data;
    }
    
    /**
     * Resetea el multiplicador
     */
    @Override
    public void resetMultiplierBySameGroup() {
        this.multiplier=1;
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
        
    }
    
}
