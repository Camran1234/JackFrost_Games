/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Box_GUI;

import Box.BonusBox;
import Box.Box;
import BoxTools.Card;
import BoxTools.CardGoJail;

/**
 *
 * @author camran
 */
public class GoJail_GUI {
    
    
    public GoJail_GUI(Box box){
        initComponents(box);
    }
    
    public GoJail_GUI(Card card){
        initComponents(card);
    }
    
    private void initComponents(Box box){
        box.add(new CardGoJail());
    }
    
    private void initComponents(Card card){
        card.add(new CardGoJail());
    }
}
