

package com.spicecap.sublimepandemonium;

import static com.spicecap.sublimepandemonium.Player.checkEmptyDeck;
import static com.spicecap.sublimepandemonium.Player.deathsCount;



public class SublimePandemonium {
    
    
    public static void main(String[] args) {
        
        Card[] bank = Bank.getBank();
        
        Card.generarPosibilidades();
        
        //-------------------------------------------------
        Player player1 = new Player();
        
        player1.deck[0] = new Card(0, Card.Type.TANK, "Taur", 25, 3, Card.Habbility.HEAL_SLF_1);
        player1.deck[1] = new Card(2, Card.Type.FIGHTER, "Abomination", 14, 5, Card.Habbility.DMG_UP_SLF_1);
        player1.deck[2] = new Card(4, Card.Type.SUPPORT, "Rafaela", 22, 3, Card.Habbility.HEAL_TWO_1);
        player1.deck[3] = new Card(1, Card.Type.MAGE, "Ciclops", 12, 3, Card.Habbility.STUN_ONE_1);
        player1.deck[4] = new Card(3, Card.Type.MARKSMAN, "Elf", 12, 5, Card.Habbility.DMG_CRIT);
        
        //-------------------------------------------------
        
        Player player2 = new Player();
        
        player2.deck[0] = new Card(6, Card.Type.TANK, "Monster", 25, 3, Card.Habbility.DMG_RED_1);
        player2.deck[1] = new Card(7, Card.Type.FIGHTER, "Gargoyle", 14, 6, Card.Habbility.DMG_REF_1);
        player2.deck[2] = new Card(9, Card.Type.SUPPORT, "Angel", 22, 3, Card.Habbility.CLEAN_1);
        player2.deck[3] = new Card(5, Card.Type.MAGE, "Duende Malo", 12, 3, Card.Habbility.BLEED_ONE_1);
        player2.deck[4] = new Card(8, Card.Type.ASSASSIN, "Ninja", 12, 4, Card.Habbility.FINISH_1);
        
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
