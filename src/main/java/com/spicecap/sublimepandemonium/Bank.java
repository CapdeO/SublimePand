
package com.spicecap.sublimepandemonium;




public class Bank {
    
    static Card[] bank = {
        new Card(0, Card.Type.TANK, "Taur", 25, 3, Card.Habbility.HEAL_SLF_1),
        new Card(1, Card.Type.MAGE, "Ciclops", 12, 3, Card.Habbility.STUN_ONE_1),
        new Card(2, Card.Type.FIGHTER, "Abomination", 14, 5, Card.Habbility.DMG_UP_SLF_1),
        new Card(3, Card.Type.MARKSMAN, "Elf", 12, 5, Card.Habbility.DMG_CRIT),
        new Card(4, Card.Type.SUPPORT, "Rafaela", 22, 3, Card.Habbility.HEAL_TWO_1),
        new Card(5, Card.Type.MAGE, "Duende Malo", 12, 3, Card.Habbility.BLEED_ONE_1),
        new Card(6, Card.Type.TANK, "Monster", 25, 3, Card.Habbility.DMG_RED_1),
        new Card(7, Card.Type.FIGHTER, "Gargoyle", 14, 5, Card.Habbility.DMG_REF_1),
        new Card(8, Card.Type.ASSASSIN, "Ninja", 12, 4, Card.Habbility.FINISH_1),
        new Card(9, Card.Type.SUPPORT, "Angel", 22, 3, Card.Habbility.CLEAN_1),
        };
    
    
    
    public static Card[] getBank() {
        return bank;
    }
    
    
}
