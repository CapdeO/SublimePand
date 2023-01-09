

package com.spicecap.sublimepandemonium;

import static com.spicecap.sublimepandemonium.Card.isDead;
import static com.spicecap.sublimepandemonium.Card.isStuned;
import static com.spicecap.sublimepandemonium.Card.isBleeding;
//import com.spicecap.sublimepandemonium.Game.attack;
import java.util.ArrayList;



public class SublimePandemonium {

    public static void main(String[] args) {
        
        Card bank[] = {
        new Card(0, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF),
        new Card(1, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STORM),
        new Card(2, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP),
        new Card(3, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT),
        new Card(4, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_2),
        };
        
        
        //Creando un ArrayList de cartas
        ArrayList<Card> deck1 = new ArrayList<Card>(5); 
        
        //ADD
        deck1.add(bank[0]);
        deck1.add(bank[1]);
        deck1.add(bank[2]);
        deck1.add(bank[3]);
        deck1.add(bank[4]);
        
        //Probando métodos de cartas
        if (isDead(deck1.get(0))) 
            System.out.println("Está muerta.");
        else
            System.out.println("No está muerta.");
        
        if (isStuned(deck1.get(0))) 
            System.out.println("Está stuneado.");
        else
            System.out.println("No está stuneado.");
        
        if (isBleeding(deck1.get(0))) 
            System.out.println("Está sangrando.");
        else
            System.out.println("No está sangrando.");
        
        //Creando un ArrayList de cartas
        ArrayList<Card> deck2 = new ArrayList<Card>(5); 
        
        //ADD
        deck2.add(bank[0]);
        deck2.add(bank[1]);
        deck2.add(bank[2]);
        deck2.add(bank[3]);
        deck2.add(bank[4]);
        
        //Imprimiendo el Array completo
        System.out.println(deck2);
        
        //SIZE
        System.out.println(deck2.size());
        
        //Método GET
        System.out.println(deck2.get(0));
        
        //Probando REMOVE
        deck2.remove(0);
        
        System.out.println(deck2);
        
        System.out.println(deck2.size());
        
        System.out.println("VIDA PREVIO AL ATAQUE");
        System.out.println(deck2.get(0));
        
        //Probando ATTACK
        attack(deck1.get(0), deck2.get(0));
        
        System.out.println("VIDA DESPUES DEL ATAQUE");
        System.out.println(deck2.get(0));
        
        
        
        
        //END MAIN
    }

    private static void attack(Card cardOrigen, Card cardDestino) {
        if (!isStuned(cardOrigen)) {
            cardDestino.hp -= cardOrigen.atq;
            
            System.out.println(cardOrigen + " Atacó a " + cardDestino);
        }
    }
}
