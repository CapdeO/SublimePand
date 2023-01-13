

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
        
        
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("ROUND 1");
        System.out.println("-----------------------------");
        
        for (int i = 0; i < deck1.size(); i++) {
            deck1.get(i).attack(deck1, deck2, deck2.get(0));
        }
        
        //for (int i = 0; i < deck2.size(); i++) {
        //    deck2.get(i).attack(deck2, deck1, deck1.get(0));
        //}
        
        //do {            
            
            
            
        //} while (!deck1.isEmpty() || !deck2.isEmpty());
        
        //deck1.get(0).attack(deck1, deck2, deck2.get(0));
        //deck2.get(0).attack(deck2, deck1, deck1.get(0));
        //deck1.get(1).attack(deck1, deck2, deck2.get(0));
        //deck2.get(1).attack(deck2, deck1, deck1.get(0));
        //deck1.get(2).attack(deck1, deck2, deck2.get(0));
        //deck2.get(2).attack(deck2, deck1, deck1.get(0));
        //deck1.get(3).attack(deck1, deck2, deck2.get(0));
        //deck2.get(3).attack(deck2, deck1, deck1.get(0));
        //deck1.get(4).attack(deck1, deck2, deck2.get(0));
        //deck2.get(4).attack(deck2, deck1, deck1.get(0));
        
        
        
        
        
        
        
        
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("DECK 1");
        System.out.println(deck1);
        System.out.println("DECK 2");
        System.out.println(deck2);
    }
}
