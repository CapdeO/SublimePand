

package com.spicecap.sublimepandemonium;
import java.util.ArrayList;



public class SublimePandemonium {
    
    
    public static void main(String[] args) {
        
        Card[] bank = Bank.getBank();
        
        Card.generarPosibilidades();
        
        ArrayList<Card> deck1 = new ArrayList<Card>(5); 
        
        deck1.add(new Card(0, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF));
        deck1.add(new Card(2, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP));
        deck1.add(new Card(4, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_2));
        deck1.add(new Card(1, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STORM));
        deck1.add(new Card(3, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT));
        
        
        
        ArrayList<Card> deck2 = new ArrayList<Card>(5); 
        
        deck2.add(new Card(0, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF));
        deck2.add(new Card(2, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP));
        deck2.add(new Card(4, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_2));
        deck2.add(new Card(1, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STORM));
        deck2.add(new Card(3, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT));
        
        //--------------------------------------------------------
        
        System.out.println("DECK 1");
        System.out.println(deck1);
        System.out.println("DECK 2");
        System.out.println(deck2);
        
    }
}
