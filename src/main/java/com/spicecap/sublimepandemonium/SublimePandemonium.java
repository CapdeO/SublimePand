

package com.spicecap.sublimepandemonium;

import static com.spicecap.sublimepandemonium.Card.isDead;
import static com.spicecap.sublimepandemonium.Card.isStuned;
import static com.spicecap.sublimepandemonium.Card.isBleeding;


public class SublimePandemonium {

    public static void main(String[] args) {
        
        Card bank[] = {
        new Card(1, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF),
        new Card(2, Card.Type.MAGE, "Ciclops", 5, 3, Card.Habbility.STORM)
        };
        
        
        Card[] deck1 = new Card[5];
        
        deck1[0] = bank[0];
        deck1[1] = bank[1];
        
        
       
        System.out.println(deck1[0]);
        System.out.println(deck1[1]);
        
        if (isDead(deck1[0])) 
            System.out.println("Está muerta.");
        else
            System.out.println("No está muerta.");
        
        if (isStuned(deck1[0])) 
            System.out.println("Está stuneado.");
        else
            System.out.println("No está stuneado.");
        
        if (isBleeding(deck1[0])) 
            System.out.println("Está sangrando.");
        else
            System.out.println("No está sangrando.");
        
        
        
                
    }
}
