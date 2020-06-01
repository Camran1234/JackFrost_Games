/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Map_Initializer.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase que facilita la creacion y guarda archivos
 * de los mapas editables del programa
 * @author camran
 */
public class FileMap {
    
    /**
     * Guarda el objeto indicado de la clase mapa
     * @param path
     * @param map
     * @throws ErrorException_GUI
     */
    public void saveMap(String path, Map map) throws ErrorException_GUI{
        File file = new File("Tableros");
        System.out.println(file.getAbsolutePath());
        try(ObjectOutputStream outPutStream = new ObjectOutputStream(new FileOutputStream(path))){
            outPutStream.writeObject(map);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
    
    /**
     * Carga el archivo binario que almacena un objeto tipo Mapa y lo retorna
     * @param path
     * @return
     * @throws ErrorException_GUI
     */
    public Map loadMap(String path) throws ErrorException_GUI{
        try(ObjectInputStream inPutStream = new ObjectInputStream(new FileInputStream(path))){
            Object map = inPutStream.readObject();
            
            return (Map) map;
        }catch(Exception e){
            throw new ErrorException_GUI(e.getMessage());
        }
    }
}
