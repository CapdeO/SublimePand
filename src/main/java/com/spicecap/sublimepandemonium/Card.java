
package com.spicecap.sublimepandemonium;


public final class Card {
    
    public static enum Type {
        TANK, FIGHTER, SUPPORT, MARKSMAN, MAGE, ASSASSIN
    }
    public static enum Habbility {
        BLEED, DMG_CRIT, DMG_RED, DMG_REF, DMG_UP, DODGE, HEAL_SLF, STORM, HEAL_2
    }
    
    
    public int id;
    public Type type;
    
    public String name;
    
    public int hp;
    public int atq;
    public Habbility habbility;
    
    //Son enteros para poder asignarles sangrado o aturdido por x turnos
    public int stuned;
    public int bleeding;
    
    //Constructor 
    public Card(int id, Type type, String name, int hp, int atq, Habbility habbility) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.hp = hp;
        this.atq = atq;
        this.habbility = habbility;
    }
    
    @Override
    public String toString() {
        return "ID "+id+" Type: "+type+" Name: "+name+" Hp: "+hp+" Att: "+atq+" Habbility: "+habbility;
    }
    
    public static boolean isDead(Card card) {
        if (card.hp <= 0) 
            return true;
        else 
            return false;
    }
    public static boolean isStuned(Card card) {
        if (card.stuned == 0)
            return false;
        else 
            return true;
    }
    public static boolean isBleeding(Card card) {
        if (card.bleeding == 0) 
            return false;
        else
            return true;
    }
    
    
    
    
    //End Card
}
