/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import Box.BoxProperty;
import BoxTools.BoxStation;
import java.io.Serializable;

/**
 * Para casillas tipo Estacion
 * @author camran
 */
public class GroupStation implements Serializable {
    
    private BoxStation[] estaciones = new BoxStation[0];
    /**
     * Metodo para agregar una casilla tipo estacion al grupo
     * @param estacion 
     */
    void addStation(BoxProperty estacion){
        int cantidadEstaciones = estaciones.length;
        BoxStation[] auxEstaciones = new BoxStation[cantidadEstaciones+1];
        for (int index=0;index<cantidadEstaciones;index++) {
            auxEstaciones[index] = estaciones[index];
        }
        auxEstaciones[cantidadEstaciones] = (BoxStation)estacion;
        estaciones = auxEstaciones;
    }

    void checkMultipliers() {
        String[] ownersAuxiliar =  new String[0]; 
        String[] ownersTrim = new String[0];
        BoxStation[] auxStations;
        //Obtenemos de primero todos los nombres a excepcion de los nombres vacios para limpiarlos y luego compararlos
        for(int index=0;index<estaciones.length;index++){
            if(estaciones[index].getOwner().equalsIgnoreCase("")==false){
                ownersAuxiliar = addOwner(ownersAuxiliar,estaciones[index].getOwner());
            }
        }
        //Limpiamos el vector string de nombres
        for(int indexOwners=0;indexOwners<ownersAuxiliar.length;indexOwners++){
            if(checkForSimilarsOwners(ownersTrim,ownersAuxiliar[indexOwners])){
                ownersTrim = addOwner(ownersTrim,ownersAuxiliar[indexOwners]);
            }
        }
        
        //Creamos de primero un ciclo general que compararemos los propietarios
        //que hay en el vector limpio de string para irle asignando las casillas de servicio que son pertenecientes
        //a ese grupo, por lo que al llenar nuestro vector auxServicios en el primer ciclo en el segundo ciclo
        //le asignamos al grupo la cantidad de veces que deben de incrementarse su multiplicador y para evitar 
        //que algun grupo tenga un multiplicador mayor que deberia de tener por algun previo multiplicador usamos la funcion resetMultiplerBySameGroup
        //que nos permite reiniciar el multiplicador y empezar de nuevo a incrementarlo por el segundo for que esta aniado con el segundo for
        //adentro del for general
        for(int indexOwners=0;indexOwners<ownersTrim.length;indexOwners++){
            auxStations = new BoxStation[0];
            for(int indexServices=0;indexServices<estaciones.length;indexServices++){
                if(estaciones[indexServices].getOwner().equalsIgnoreCase(ownersTrim[indexOwners])){
                  auxStations = addStation(auxStations,estaciones[indexServices]);
                }
            }
            for(int indexTrimServices =0; indexTrimServices<auxStations.length;indexTrimServices++){
                auxStations[indexTrimServices].resetMultiplierBySameGroup();
                for(int indexRepeatIncrease=0;indexRepeatIncrease<auxStations.length-1;indexRepeatIncrease++){
                    auxStations[indexTrimServices].increaseMultiplierBySameGroup();
                }
            }
        
        
        }
        
    }
    //Añade a un nuevo propietario al vector como una pila
    private String[] addOwner(String[] owners,String newOwner) {
        String[] ownersTrim = new String [owners.length+1];
        for(int index=0;index<owners.length;index++){
            ownersTrim[index] = owners[index];
        }
        ownersTrim[owners.length] = newOwner;
        return ownersTrim;
    }
    //Verifica si no se repite algun propietario con la lista limpia, si no encuentra ninguno retorna como verdadero
    // de lo contrario retornara un parametro falso
    private boolean checkForSimilarsOwners(String[] owners,String newOwner){
        
        for(int index=0;index<owners.length;index++){
            if(owners[index].equalsIgnoreCase(newOwner))
                return false;
        }
        
        return true;
    }
    /**
     * Agrega una nueva estacion como pila
     * @param servicios
     * @param newStation
     * @return 
     */
    private BoxStation[] addStation(BoxStation[] servicios, BoxStation newStation){
        BoxStation[] auxServicios = new BoxStation[servicios.length+1];
        for(int index=0;index<servicios.length;index++){
            auxServicios[index] = servicios[index];
        }
        auxServicios[servicios.length]=newStation;
        
        return auxServicios;
    }
    
    
    
}
