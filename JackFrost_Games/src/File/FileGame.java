/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Map_Initializer.Map;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase que facilita la creacion del Ranking del juego
 * @author camran
 */
public class FileGame {
    
    
    
    /**
     * Guarda un objeto tipo ranking en la direccion indicada
     * @param path
     * @param ranking
     * @throws ErrorException_GUI
     */
    public void saveResults(String path, Ranking ranking) throws ErrorException_GUI{
        try(ObjectOutputStream outPutStream = new ObjectOutputStream(new FileOutputStream(path))){
            outPutStream.writeObject(ranking);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
    
    /**
     * Carga un archivo binario que contiene un objeto de la clase Ranking, en caso que no se encuentre ningun tipo
     * de clase tipo ranking creara uno por medio del metodo saveResults y retornara dicho
     * objeto vacio
     * @param path
     * @return
     * @throws ErrorException_GUI
     */
    public Ranking loadResults(String path) throws ErrorException_GUI{
        try(ObjectInputStream inPutStream = new ObjectInputStream(new FileInputStream(path))){
            Object ranking = inPutStream.readObject();
            
            return (Ranking)ranking;
        }catch(Exception e){
            Ranking ranking = new Ranking();
            this.saveResults(path, ranking);
            return ranking;
        }
    }
}
