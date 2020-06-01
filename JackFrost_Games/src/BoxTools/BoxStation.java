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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class BoxStation extends BoxProperty implements Serializable{
 
    public BoxStation(String name, int buyPrice, int mortageValue, int servicePrice) {
        super(name, buyPrice, mortageValue, servicePrice);
    }
    /**
     * Método que le quita dinero al jugador que haya caido en esta casilla, si es el propietario 
     * no sucede nada, si esta propiedad aun no posee propietario entonces enviara información basica de esta propiedad
     * @param player 
     */
    @Override
    public void doBox(Player player){
        if(mortageStatus==false){
            if(owner.equalsIgnoreCase("")==false && owner.equalsIgnoreCase(player.getNombre())==false){
                int costo= servicePrice*multiplier*-1;
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
     * Se dobla el multiplicador para cuando es una estacion
     */
    @Override
    public void increaseMultiplierBySameGroup() {
        this.multiplier*=2;
    }

    /**
     *Se divide por dos el multiplicador cuando es estacion
     */
    @Override
    public void decreaseMultiplierBySameGroup() {
        this.multiplier/=2;
    }
 /**
  * Retorna información básica de esta propiedad 
  * @return 
  */
    @Override
    public String getData(){
        String data;
        if(owner.equalsIgnoreCase("")){
            data = ("Tipo: Estacion"+" Nombre: "+name+ " Precio: "+buyPrice+"\n Servicio: "+servicePrice+" Hipoteca: "+mortageValue);
        }else{
            data = ("Tipo: Estacion"+" Nombre: "+name+" Servicio: "+servicePrice+" Hipoteca: "+mortageValue
                    +"Multiplicador: "+multiplier+"Estado Hipotecado: "+ mortageStatus+"\n");
        }
        return data;
    }
    
    @Override
    public void resetMultiplierBySameGroup() {
        this.multiplier=1;
    }
    
    @Override
    public void reset(){
        owner="";
        mortageStatus=false;
        mortgagable=true;
        multiplier =1;
        mortagePrice=mortageValue;
        
    }
}
