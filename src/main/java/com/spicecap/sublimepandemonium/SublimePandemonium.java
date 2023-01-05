

package com.spicecap.sublimepandemonium;

import static com.spicecap.sublimepandemonium.Card.isDead;
import static com.spicecap.sublimepandemonium.Card.isStuned;
import static com.spicecap.sublimepandemonium.Card.isBleeding;


public class SublimePandemonium {

    public static void main(String[] args) {
        
        Card bank[] = {
        new Card(1, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF),
        new Card(2, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STORM),
        new Card(3, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP),
        new Card(4, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT),
        new Card(5, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_2),
        };
        
        
        Card[] deck1 = new Card[5];
        
        deck1[0] = bank[0];
        deck1[1] = bank[3];
        deck1[2] = bank[2];
        deck1[3] = bank[1];
        deck1[4] = bank[4];
        
        
       
        System.out.println(deck1[0]);
        System.out.println(deck1[1]);
        System.out.println(deck1[2]);
        System.out.println(deck1[3]);
        System.out.println(deck1[4]);
        
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
