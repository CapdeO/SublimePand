

package com.spicecap.sublimepandemonium;

import static com.spicecap.sublimepandemonium.Player.checkEmptyDeck;
import static com.spicecap.sublimepandemonium.Player.deathsCount;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SublimePandemonium {
    
    
    public static void main(String[] args) {
        
        Card[] bank = Bank.getBank();
        
        Card.generarPosibilidades();
        
        //-------------------------------------------------
        Player player1 = new Player();
        
        player1.refDeck[0] = 0;
        player1.refDeck[1] = 2;
        player1.refDeck[2] = 9;
        player1.refDeck[3] = 3;
        player1.refDeck[4] = 1;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < bank.length; j++) {
                if (player1.refDeck[i] == bank[j].id) {
                    try {
                        player1.deck[i] = (Card)bank[j].clone();
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(SublimePandemonium.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        //-------------------------------------------------
        
        Player player2 = new Player();
        
        player2.refDeck[0] = 6;
        player2.refDeck[1] = 7;
        player2.refDeck[2] = 4;
        player2.refDeck[3] = 5;
        player2.refDeck[4] = 8;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < bank.length; j++) {
                if (player2.refDeck[i] == bank[j].id) {
                    try {
                        player2.deck[i] = (Card)bank[j].clone();
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(SublimePandemonium.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        //--------------------------------------------------------
        
        player1.showDeck();
        player2.showDeck();
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        
        boolean flag = true;
        int round = 0;
        
        do { 
            
            round++;
            System.out.println("-------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>> [[[ ROUND " + round + " ]]]");
            
            if (flag) {
                player2.deck[0].hp += 4;
                flag = false;
            }
            
            for (int i = 0; i < 5; i++) {
                
                
                
                //TURNO CARTA DECK 1
                if (!player1.deck[i].isDead() && !player1.deck[i].isStuned()) {
                    System.out.println("---------------------------------------------");
                    player1.deck[i].attack(player1.deck, player2.deck);
                } else if (!player1.deck[i].isDead() && player1.deck[i].isStuned()) {
                    System.out.println("---------------------------------------------");
                    System.out.println(player1.deck[i] + " IS STUNED!");
                    player1.deck[i].stuned -= 1;
                }
                  
                //TURNO CARTA DECK 2
                if (!player2.deck[i].isDead() && !player2.deck[i].isStuned()) {
                    System.out.println("---------------------------------------------");
                    player2.deck[i].attack(player2.deck, player1.deck);
                } else if (!player2.deck[i].isDead() && player2.deck[i].isStuned()) {
                    System.out.println("---------------------------------------------");
                    System.out.println(player2.deck[i] + " IS STUNED!");
                    player2.deck[i].stuned -= 1;
                }
                    
            }
            
            
            
            for (int i = 0; i < 5; i++) {
                
                if (player1.deck[i].bleeding > 0 && !player1.deck[i].dead) {
                    System.out.println("---------------------------------------------");
                    System.out.println("Bleeding for " + player1.deck[i] + "@" + Integer.toHexString(player1.deck[i].hashCode()) + "!! (-2hp)");
                    player1.deck[i].hp -= 2;
                    player1.deck[i].bleeding -= 1;
                    
                    if (Card.checkDeath(player1.deck[i])) {
                        System.out.println("(Due to bleeding)");
                    }
                    
                }
                    
                if (player2.deck[i].bleeding > 0 && !player2.deck[i].dead) {
                    System.out.println("Bleeding for " + player2.deck[i] + "@" + Integer.toHexString(player2.deck[i].hashCode()) + "!! (-2hp)");
                    player2.deck[i].hp -= 2;
                    player2.deck[i].bleeding -= 1;
                    
                    if (Card.checkDeath(player2.deck[i])) {
                        System.out.println(" (Due to bleeding)");
                    }
                }
            }
            
            
        } while (!checkEmptyDeck(player1.deck) && !checkEmptyDeck(player2.deck));
        
        
        
        
        System.out.println(">>>>>>>>>> BATTLE ENDED <<<<<<<<<<");
        System.out.println();
        player1.showDeck();
        player2.showDeck();
        
        if (deathsCount(player1.deck) < deathsCount(player2.deck)) {
            System.out.println("Player 1 WINS!");
            player1.winner = true;
        }
        else if (deathsCount(player1.deck) > deathsCount(player2.deck)) {
            System.out.println("Player 2 WINS!");
            player2.winner = true;
        } 
        else {
            System.out.println("TIE!");
        }
            
    }
}
