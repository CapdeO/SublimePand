

package com.spicecap.sublimepandemonium;


public class SublimePandemonium {

    public static void main(String[] args) {
        
        Card bank[] = {
        new Card(1, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF),
        new Card(2, Card.Type.MAGE, "Ciclops", 5, 3, Card.Habbility.STORM)
        };
        
        System.out.println(bank[0]);
        System.out.println(bank[1]);
        
        Card[] deck1 = new Card[5];
        
        deck1[0] = bank[0];
        deck1[1] = bank[1];
        deck1[2] = bank[1];
        deck1[3] = bank[1];
        deck1[4] = bank[1];
        
       
        System.out.println(deck1[0]);
        System.out.println(deck1[1]);
        System.out.println(deck1[2]);
        System.out.println(deck1[3]);
        System.out.println(deck1[4]);          
    }
}
