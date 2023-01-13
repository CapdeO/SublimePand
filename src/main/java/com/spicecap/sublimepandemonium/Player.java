
package com.spicecap.sublimepandemonium;


public class Player {
    
    public Card[] deck = new Card[5];
    
    public int cardsLeft;
    
    public Player() {
        this.cardsLeft = 5;
    }
    
    public void showDeck() {
        System.out.println(this);
        for (int i = 0; i < this.cardsLeft-1; i++) {
            System.out.print(this.deck[i]);
        }
        System.out.println();
    }
    
}
