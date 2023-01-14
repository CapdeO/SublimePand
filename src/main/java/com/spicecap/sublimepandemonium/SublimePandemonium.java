

package com.spicecap.sublimepandemonium;



public class SublimePandemonium {
    
    
    public static void main(String[] args) {
        
        Card[] bank = Bank.getBank();
        
        Card.generarPosibilidades();
        
        //-------------------------------------------------
        Player player1 = new Player();
        
        player1.deck[0] = new Card(0, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF);
        player1.deck[1] = new Card(2, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP);
        player1.deck[2] = new Card(4, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_2);
        player1.deck[3] = new Card(1, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STORM);
        player1.deck[4] = new Card(3, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT);
        
        //-------------------------------------------------
        
        Player player2 = new Player();
        
        player2.deck[0] = new Card(0, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF);
        player2.deck[1] = new Card(2, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP);
        player2.deck[2] = new Card(4, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_2);
        player2.deck[3] = new Card(1, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STORM);
        player2.deck[4] = new Card(3, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT);
        
        //--------------------------------------------------------
        
        player1.showDeck();
        player2.showDeck();
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        
        boolean flag = true;
        
        do { 
            
            if (flag == true) {
                player2.deck[0].hp += 4;
                flag = false;
            }
            
            for (int i = 0; i < 5; i++) {
                if (player1.deck[i].isDead() == false) 
                    player1.deck[i].attack(player1.deck, player2.deck);
                if (player2.deck[i].isDead() == false) 
                    player2.deck[i].attack(player2.deck, player1.deck);
            }
            
            player1.cardsLeft = 5;
            player2.cardsLeft = 5;
            
            for (int i = 0; i < 5; i++) {
                if (player1.deck[i].dead == true) 
                    player1.cardsLeft -= 1;
                if (player2.deck[i].dead == true) 
                    player2.cardsLeft -= 1;
            }
            
             
        } while (player1.cardsLeft > 0 && player2.cardsLeft > 0);
        
        
        
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        player1.showDeck();
        player2.showDeck();
        
        if (player1.cardsLeft > player2.cardsLeft) {
            System.out.println("Player 1 WINS!");
            player1.winner = true;
        }
        else if (player1.cardsLeft < player2.cardsLeft) {
            System.out.println("Player 2 WINS!");
            player2.winner = true;
        } 
        else {
            System.out.println("TIE!");
        }
            
    }
}
