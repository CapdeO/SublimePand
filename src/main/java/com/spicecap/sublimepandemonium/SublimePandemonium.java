

package com.spicecap.sublimepandemonium;

import static com.spicecap.sublimepandemonium.Card.attack;
import static com.spicecap.sublimepandemonium.Card.isDead;
import static com.spicecap.sublimepandemonium.Card.isStuned;
import static com.spicecap.sublimepandemonium.Card.isBleeding;
import java.util.ArrayList;
import java.util.Random;



public class SublimePandemonium {
    
    
    public static int posibilidadActual = 0;
    
    public static int posibilidades[];
    
    
    public static void main(String[] args) {
        
        //Copiamos el array de cartas del banco de cartas
        Card[] bank = Bank.getBank();
        
        //---------------GENERANDO LAS POSIBILIDADES---------------------
        
        
        posibilidades = new int[100];
    
        for(int i = 0; i <= posibilidades.length-1; i++) {
            Random ran = new Random();
            int x = ran.nextInt(100) + 1;
            posibilidades[i] = x;
        }
        
        
        //---------------------------------------------------------------
        
        //Creando DECK1
        ArrayList<Card> deck1 = new ArrayList<Card>(5); 
        deck1.add(bank[0]);
        deck1.add(bank[1]);
        deck1.add(bank[2]);
        deck1.add(bank[3]);
        deck1.add(bank[4]);
        //Creando DECK2
        ArrayList<Card> deck2 = new ArrayList<Card>(5); 
        deck2.add(bank[0]);
        deck2.add(bank[1]);
        deck2.add(bank[2]);
        deck2.add(bank[3]);
        deck2.add(bank[4]);
        
        System.out.println(deck1);
        System.out.println(deck2);
        
        System.out.println("VIDA PREVIO AL ATAQUE");
        System.out.println(deck2.get(0));
        
        //Probando ATTACK
        attack(deck1, deck1.get(0), deck2, deck2.get(0));
        
        System.out.println("VIDA DESPUES DEL ATAQUE");
        System.out.println(deck2.get(0));
        
        
        
        //END MAIN
    }
    
    public static int posibilidad() {
        posibilidadActual++;
        return posibilidades[posibilidadActual-1];
    }
    

    
}
