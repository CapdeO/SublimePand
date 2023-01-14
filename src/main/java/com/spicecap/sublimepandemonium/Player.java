
package com.spicecap.sublimepandemonium;


public class Player {
    
    public Card[] deck = new Card[5];
    
    public int cardsLeft;
    
    public boolean winner;
    
    public Player() {
        this.cardsLeft = 5;
    }
    
    public void showDeck() {
        System.out.println(this);
        for (int i = 0; i < 5; i++) {
            if (this.deck[i].isDead() == false) 
                System.out.print(this.deck[i]);
        }
        System.out.println();
    }
    
}
