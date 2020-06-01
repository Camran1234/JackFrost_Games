/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Map_Initializer.Map;
import java.awt.Font;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author camran
 */
public class Clock extends JLabel implements Serializable  {

    /**
     *  Reloj de tiempo Ilimitado
     */
    public Clock(Map map) {
        run(map);
    }
    
    /**
     * Método que va cambiando constantemente la información de un mapa
     * esperando 1 segundo para actualizarse
     * @param map
     */
    public void run(Map map) {
        setFont(new Font("Dina", Font.BOLD, 14));
        setAlignmentX(SwingConstants.CENTER);
        setAlignmentY(SwingConstants.CENTER);
        while(true){
            setText(map.getHoras()+":"+map.getMinutos()+":"+map.getSegundos());
        
            map.addSegundo();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               ex.getStackTrace();
            }
        }
    }
    
    
    
    
}
