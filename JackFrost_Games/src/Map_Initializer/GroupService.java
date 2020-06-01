/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import Box.Box;
import BoxTools.BoxService;
import java.io.Serializable;

/**
 * Para casillas tipo Servicio
 * @author camran
 */
public class GroupService implements Serializable {
    
    private BoxService[] servicios = new BoxService[0];
    
    /**
     * Metodo para agregar una casilla tipo servicio al grupo
     * @param estacion 
     */
    void addService(BoxService servicio){
        int cantidadServicios = servicios.length;
        BoxService[] auxServicios = new BoxService[cantidadServicios+1];
        for (int index=0;index<cantidadServicios;index++) {
            auxServicios[index] = servicios[index];
        }
        auxServicios[cantidadServicios] = servicio;
        servicios = auxServicios;
    }
    /**
     * Método que comprueba las propiedades para comprobar si pertenecen a un propietario
     * y aumentar sus multiplicadores
     */
    void checkMultipliers() {
        String[] ownersAuxiliar = new String[0]; 
        String[] ownersTrim = new String[0];
        BoxService[] auxServicios;
        //Obtenemos de primero todos los nombres a excepcion de los nombres vacios para limpiarlos y luego compararlos
        for(int index=0;index<servicios.length;index++){
            if(servicios[index].getOwner().equalsIgnoreCase("")==false){
                ownersAuxiliar = addOwner(ownersAuxiliar,servicios[index].getOwner());
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
            auxServicios = new BoxService[0];
            for(int indexServices=0;indexServices<servicios.length;indexServices++){
                if(servicios[indexServices].getOwner().equalsIgnoreCase(ownersTrim[indexOwners])){
                  auxServicios = addService(auxServicios,servicios[indexServices]);
                }
            }
            for(int indexTrimServices =0; indexTrimServices<auxServicios.length;indexTrimServices++){
                auxServicios[indexTrimServices].resetMultiplierBySameGroup();
                for(int indexRepeatIncrease=0;indexRepeatIncrease<auxServicios.length-1;indexRepeatIncrease++){
                    auxServicios[indexTrimServices].increaseMultiplierBySameGroup();
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
        System.out.println("");
        for(int index=0;index<owners.length;index++){
            if(owners[index].equalsIgnoreCase(newOwner))
                return false;
        }
        
        return true;
    }
    /**
     * Agrega una nueva propiedad servicio como una pila
     * @param servicios
     * @param newServicio
     * @return 
     */
    private BoxService[] addService(BoxService[] servicios, BoxService newServicio){
        BoxService[] auxServicios = new BoxService[servicios.length+1];
        for(int index=0;index<servicios.length;index++){
            auxServicios[index] = servicios[index];
        }
        auxServicios[servicios.length]=newServicio;
        
        return auxServicios;
    }

    
}
