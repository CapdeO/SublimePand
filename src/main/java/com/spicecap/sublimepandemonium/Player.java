
package com.spicecap.sublimepandemonium;


public class Player {
    
    public int[] refDeck = new int[5];
    
    public Card[] deck = new Card[5];
    
    public boolean winner;
    
    public Player() {
    }
    
    public void showDeck() {
        System.out.println(this);
        for (int i = 0; i < 5; i++) {
            if (this.deck[i].isDead() == false) 
                System.out.print(this.deck[i]);
        }
        System.out.println();
    }
    
    public static int deathsCount(Card[] deck) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (deck[i].dead) {
                count++;
            }
        }
        return count;
    }
    
    public static boolean checkEmptyDeck(Card[] deck) {
        if (deathsCount(deck) == 5) 
            return true;
        else
            return false;
    }
}
