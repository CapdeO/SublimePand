
package com.spicecap.sublimepandemonium;




public class Bank {
    
    static Card[] bank = {
        new Card(0, Card.Type.TANK, "Taur", 12, 1, Card.Habbility.HEAL_SLF_1),
        new Card(1, Card.Type.MAGE, "Ciclops", 5, 2, Card.Habbility.STUN_ONE_1),
        new Card(2, Card.Type.FIGHTER, "Abomination", 7, 5, Card.Habbility.DMG_UP_SLF_1),
        new Card(3, Card.Type.MARKSMAN, "Elf", 4, 6, Card.Habbility.DMG_CRIT),
        new Card(4, Card.Type.SUPPORT, "Rafaela", 10, 1, Card.Habbility.HEAL_TWO_1),
        new Card(5, Card.Type.MAGE, "Duende Malo", 5, 2, Card.Habbility.BLEED_ONE_1),
        new Card(6, Card.Type.TANK, "Monster", 10, 2, Card.Habbility.DMG_RED_1),
        new Card(7, Card.Type.FIGHTER, "Gargoyle", 8, 3, Card.Habbility.DMG_REF_1),
        new Card(8, Card.Type.ASSASSIN, "Ninja", 12, 4, Card.Habbility.FINISH_1),
        new Card(9, Card.Type.SUPPORT, "Angel", 22, 3, Card.Habbility.CLEAN_1),
        };
    
        // FALTA ACTUALIZAR !!
    
    
    public static Card[] getBank() {
        return bank;
    }
    
    
}
