
package com.spicecap.sublimepandemonium;

public class Bank {
    
    static Card[] bank = {
        
        // TANK ------------------------------------------------------------------------------------------------------
        
        new Card(100, Card.Type.TANK,     "Tank",      25, 3, Card.Habbility.HEAL_SLF_1),
        new Card(101, Card.Type.TANK,     "Tank1",     25, 3, Card.Habbility.HEAL_SLF_2),
        
        new Card(102, Card.Type.TANK,     "Tank2",     25, 3, Card.Habbility.DMG_RED_1),
        new Card(103, Card.Type.TANK,     "Tank3",     25, 3, Card.Habbility.DMG_RED_2),
        
        
        // FIGHTER ---------------------------------------------------------------------------------------------------
        
        new Card(200, Card.Type.FIGHTER,  "Fighter1", 14, 5, Card.Habbility.DMG_UP_SLF_1),
        new Card(201, Card.Type.FIGHTER,  "Fighter2", 14, 5, Card.Habbility.DMG_UP_SLF_2),
        
        new Card(202, Card.Type.FIGHTER,  "Fighter3",    14, 5, Card.Habbility.DMG_REF_1),
        new Card(203, Card.Type.FIGHTER,  "Fighter4",    14, 5, Card.Habbility.DMG_REF_2),
        
        new Card(204, Card.Type.FIGHTER,  "Fighter5",    14, 5, Card.Habbility.DODGE_1),
        new Card(205, Card.Type.FIGHTER,  "Fighter6",    14, 5, Card.Habbility.DODGE_2),
        
        // SUPPORT ---------------------------------------------------------------------------------------------------
        
        new Card(300, Card.Type.SUPPORT,  "Supp1",     22, 3, Card.Habbility.HEAL_TWO_1),
        new Card(301, Card.Type.SUPPORT,  "Supp2",     22, 3, Card.Habbility.HEAL_TWO_2),
        
        new Card(302, Card.Type.SUPPORT,  "Supp3",       22, 3, Card.Habbility.CLEAN_ONE_1),
        new Card(303, Card.Type.SUPPORT,  "Supp4",       22, 3, Card.Habbility.CLEAN_ONE_2),
        
        new Card(304, Card.Type.SUPPORT,  "Supp5",       22, 3, Card.Habbility.CLEAN_TWO_1),
        new Card(305, Card.Type.SUPPORT,  "Supp6",       22, 3, Card.Habbility.CLEAN_TWO_2),
        
        // MAGE ------------------------------------------------------------------------------------------------------
        
        new Card(400, Card.Type.MAGE,     "Mage1",     12, 3, Card.Habbility.STUN_ONE_1),
        new Card(401, Card.Type.MAGE,     "Mage2",     12, 3, Card.Habbility.STUN_ONE_2),
        
        new Card(402, Card.Type.MAGE,     "Mage3",     12, 3, Card.Habbility.STUN_TWO_1),
        new Card(403, Card.Type.MAGE,     "Mage4",     12, 3, Card.Habbility.STUN_TWO_2),
        
        new Card(404, Card.Type.MAGE,     "Mage5",     12, 3, Card.Habbility.FIRE_ONE_1),
        new Card(405, Card.Type.MAGE,     "Mage6",     12, 3, Card.Habbility.FIRE_ONE_2),
        
        // MARKSMAN --------------------------------------------------------------------------------------------------
        
        new Card(500, Card.Type.MARKSMAN, "Marksman1", 12, 5, Card.Habbility.DMG_CRIT_1),
        new Card(501, Card.Type.MARKSMAN, "Marksman2", 12, 5, Card.Habbility.DMG_CRIT_2),
        
        new Card(502, Card.Type.MARKSMAN, "Marksman3", 12, 3, Card.Habbility.BLEED_ONE_1),
        new Card(503, Card.Type.MARKSMAN, "Marksman4", 12, 3, Card.Habbility.BLEED_ONE_2),
        
        new Card(504, Card.Type.MARKSMAN, "Marksman5", 12, 3, Card.Habbility.BLEED_TWO_1),
        new Card(505, Card.Type.MARKSMAN, "Marksman6", 12, 3, Card.Habbility.BLEED_TWO_2),
        
        
        // ASSASSIN --------------------------------------------------------------------------------------------------
        
        new Card(600, Card.Type.ASSASSIN, "Assassin1",       12, 4, Card.Habbility.FINISH_1),
        new Card(601, Card.Type.ASSASSIN, "Assassin2",       12, 4, Card.Habbility.FINISH_2),
        
        new Card(602, Card.Type.ASSASSIN, "Assassin3",   14, 3, Card.Habbility.POISON_1),
        new Card(603, Card.Type.ASSASSIN, "Assassin4",   14, 3, Card.Habbility.POISON_2),
        
        };
    
    
    public static Card[] getBank() {
        return bank;
    } 
}
