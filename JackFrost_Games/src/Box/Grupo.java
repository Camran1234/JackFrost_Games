/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box;


/**
 * Interfaz que nos falicitara el aumento del multiplicador de las propiedades, como
 * la obtención de datos de las propiedades
 * @author camran
 */
public interface Grupo {
    
    public void increaseMultiplierBySameGroup();
    public void decreaseMultiplierBySameGroup();
    public void resetMultiplierBySameGroup();
    public String getData();
}
