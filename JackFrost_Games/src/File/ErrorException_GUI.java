/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author camran
 */
public class ErrorException_GUI extends Exception{    

    /**
     * Lanza una ventana emergente con el error indicado
     * @param error
     */
    public ErrorException_GUI(String error){
        JFrame errorFrame = new JFrame();
        JLabel errorLabel = new JLabel ("Error: " + error);
                            
        errorFrame.add(errorLabel);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.pack();
        errorFrame.setVisible(true);
    }
}
