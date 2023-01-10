
package com.spicecap.sublimepandemonium;
import java.util.ArrayList;


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
        return "[["+ name+" HP:"+hp+" ATT:"+atq+"]]";
    }
    
    //Métodos de "estado"
    
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
    
    //En este método se centra prácticamente la mayor parte de la lógica del juego
    
    public static void attack(ArrayList deckOrig, Card cardOrig, ArrayList deckDest, Card cardDest) {
        
        int attackPoints;
        
        //Ataque básico
        if (!isStuned(cardOrig)) {
            cardDest.hp -= cardOrig.atq;
            
            System.out.println(cardOrig + " ATACÓ--> " + cardDest);
            
            
            if (isDead(cardDest)) { //Por si lo mata
                System.out.println("Murió " + cardDest);
                deckDest.remove(cardDest); 
            }    
            else if (isDead(cardOrig)) { //Por si el ataque rebota y lo mata
                System.out.println("Murió " + cardOrig);
                deckOrig.remove(cardOrig); 
            }
                
        }
        
        
        
        
        
        
        
        
        
        
    }
    
    
    //End Card
}
