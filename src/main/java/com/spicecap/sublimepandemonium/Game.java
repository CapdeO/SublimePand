
package com.spicecap.sublimepandemonium;

import static com.spicecap.sublimepandemonium.Card.isDead;
import static com.spicecap.sublimepandemonium.Card.isStuned;
import static com.spicecap.sublimepandemonium.Card.isBleeding;

import java.util.ArrayList;


public class Game {
    
    public void attack(Card cardOrigen, Card cardDestino) {
        if (!isStuned(cardOrigen)) {
            cardDestino.hp -= cardOrigen.atq;
            
            System.out.println(cardOrigen + "Atacó a " + cardDestino);
        }
    }
    
    
    
}
