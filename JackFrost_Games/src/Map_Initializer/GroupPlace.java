/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import BoxTools.BoxPlace;
import java.io.Serializable;

/**
 * Clase para almacenar los grupos de las casillas propiedades
 * Se almacenara el nombre y la cantidad de grupos que hay de este
 * @author camran
 */
public class GroupPlace implements Serializable {
    private String nombreGrupo="";
    private int cantidad=0;
    private BoxPlace[] propertys = new BoxPlace[0];
    
    /**
     * Funcion que nos permite agregar nuevas propiedades a este grupo, iniciando de primero que si comparten el mismo
     * nombre del grupo se añadira la cantidad, de lo contrario se le agregara un nombre al grupo
     * @param grupo
     * @return
     */
    public boolean compareTo(String grupo){
        if(nombreGrupo.equalsIgnoreCase(grupo)){
            cantidad++;
            return true;
        }else if(nombreGrupo.equalsIgnoreCase("") && grupo.equalsIgnoreCase("")==false) {
            nombreGrupo=grupo;
            cantidad++;
            return true;
        }
        return false;
    }
    
    int getCantidadGrupo(){
        return cantidad;
    }
    
    String getnombreGrupo(){
        return nombreGrupo;
    }
    /**
     * Añade una nueva casilla tipo lugar como pila
     * @param boxPlace 
     */
    void setBox(BoxPlace boxPlace) {
        int cantidadPropiedades=propertys.length;
        BoxPlace[] auxPropertys = new BoxPlace[cantidadPropiedades+1];
        
        for(int index=0;index<propertys.length;index++){
            auxPropertys[index] = propertys[index];
        }
        auxPropertys[cantidadPropiedades] = boxPlace;
        propertys = auxPropertys;
    }
    /**
     * Comprueba que todas las propiedades de tipo propiedad de ese grupo pertenezcan a una sola persona
     * @return 
     */
    void checkForMultiplier(){
            System.out.println(propertys.length);
            String propietario = propertys[0].getOwner();
            int contadoraMismoPropietario=0;

            //Comparamos que el propietario 
            for (BoxPlace property : propertys) {
                if(propietario.equalsIgnoreCase(property.getOwner()) && property.getOwner().equalsIgnoreCase("")==false){
                    contadoraMismoPropietario++;
                }
            }

            //Condicion que nos hace comprobar si la cantidad de propiedades con el mismo propietario es la misma cantidad de propiedades 
            //pertenecientes a ese grupo 
            if(contadoraMismoPropietario == propertys.length){
                for (BoxPlace property : propertys) {
                    property.increaseMultiplierBySameGroup();
                }
            }else{
                for (BoxPlace property : propertys) {
                    property.decreaseMultiplierBySameGroup();
                }
            }
        
    }
    
}
