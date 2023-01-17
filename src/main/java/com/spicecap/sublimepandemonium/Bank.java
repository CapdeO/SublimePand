
package com.spicecap.sublimepandemonium;




public class Bank {
    
    static Card[] bank = {
        new Card(0, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF),
        new Card(1, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STUN),
        new Card(2, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP),
        new Card(3, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT),
        new Card(4, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_2),
        new Card(5, Card.Type.MAGE, "Duende Malo", 5, 2, Card.Habbility.BLEED),
        new Card(6, Card.Type.TANK, "Monster", 10, 2, Card.Habbility.DMG_RED),
        };
    
    
    public static Card[] getBank() {
        return bank;
    }
    
    
}
