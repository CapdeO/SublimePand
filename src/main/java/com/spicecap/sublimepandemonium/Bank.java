
package com.spicecap.sublimepandemonium;

public class Bank {
    
    static Card[] bank = {
        
        // TANK
        
        new Card(100, Card.Type.TANK,     "Taur",        25, 3, Card.Habbility.HEAL_SLF_1),
        new Card(101, Card.Type.TANK,     "Monster",     25, 3, Card.Habbility.DMG_RED_1),
        
        // FIGHTER
        
        new Card(200, Card.Type.FIGHTER,  "Abomination", 14, 5, Card.Habbility.DMG_UP_SLF_1),
        new Card(201, Card.Type.FIGHTER,  "Gargoyle",    14, 5, Card.Habbility.DMG_REF_1),
        
        // SUPPORT
        
        new Card(300, Card.Type.SUPPORT,  "Rafaela",     22, 3, Card.Habbility.HEAL_TWO_1),
        new Card(301, Card.Type.SUPPORT,  "Angel",       22, 3, Card.Habbility.CLEAN_ONE_1),
        
        // MAGE
        
        new Card(400, Card.Type.MAGE,     "Ciclops",     12, 3, Card.Habbility.STUN_ONE_1),
        new Card(401, Card.Type.MAGE,     "Duende Malo", 12, 3, Card.Habbility.BLEED_ONE_1),
        
        // MARKSMAN
        
        new Card(500, Card.Type.MARKSMAN, "Elf",         12, 5, Card.Habbility.DMG_CRIT_1),
        
        // ASSASSIN
        
        new Card(600, Card.Type.ASSASSIN, "Ninja",       12, 4, Card.Habbility.FINISH_1),
        new Card(601, Card.Type.ASSASSIN, "Vestress",   14, 3, Card.Habbility.POISON_1),
        
        };
    
    
    public static Card[] getBank() {
        return bank;
    } 
}
