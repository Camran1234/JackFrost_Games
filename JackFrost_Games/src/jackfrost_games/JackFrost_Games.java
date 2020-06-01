/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackfrost_games;

import File.ErrorException_GUI;
import Menu_GUI.Menu_GUI;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author camran
 */
public class JackFrost_Games {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ErrorException_GUI {
        File tableros = new File("./Tableros");
        File juegos = new File("./Juegos");
        File punteos = new File("./Punteos");
        if(!tableros.exists()) {
            JOptionPane.showMessageDialog(null, tableros.getAbsolutePath());
            tableros.mkdir();
        }
        if(!juegos.exists()) {
            juegos.mkdir();
        }
        if(!punteos.exists()) {
            punteos.mkdir();
        }
        new Menu_GUI();      
    }
    

}
