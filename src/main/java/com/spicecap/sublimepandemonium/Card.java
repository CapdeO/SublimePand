
package com.spicecap.sublimepandemonium;
import java.util.Random;



public class Card {
    
    public enum Type {
        TANK, FIGHTER, SUPPORT, MARKSMAN, MAGE, ASSASSIN
    }
    public enum Habbility {
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
    
    public boolean dead;
    
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
    
    //public String showCard() {
    //    return "[["+ this.name+" HP:"+this.hp+" ATT:"+this.atq+"]]";
    //}
    
    
    public boolean isDead() {
        if (this.hp <= 0) 
            return true;
        else 
            return false;
    }
    public boolean isStuned() {
        if (this.stuned == 0)
            return false;
        else 
            return true;
    }
    public boolean isBleeding() {
        if (this.bleeding == 0) 
            return false;
        else
            return true;
    }
    
    
    public void attack(Card[] deckOrig, Card[] deckDest) {
        
        boolean attackDone = false;
        
        int target = 0;
        
        int attackPoints = this.atq;
        
        if (this.habbility == Habbility.DMG_CRIT){
            if (posibilidad() <= 30) {
                attackPoints += 2;
                System.out.println("CRITIC DAMAGE!!");
            }
        }
        
        //Ataque básico
        do {            
            if (deckDest[target].dead == true) {
                target++;
            } else {
                if (!this.isStuned()) {

                    deckDest[target].hp -= attackPoints;

                    System.out.println(this + " ATTACKED--> " + deckDest[target]);

                    if (deckDest[target].isDead()) { //Por si lo mata
                        System.out.println("Murió " + deckDest[target]);
                        deckDest[target].dead = true;
                        attackDone = true;    
                    }    
                    else if (this.isDead()) { //Por si el ataque rebota y lo mata
                        System.out.println("Murió " + this);
                        this.dead = true;
                        attackDone = true; 
                    }
                }
            }
        } while (attackDone == false);
        
            

        
        
    }
    
    
    //--------------------------------------------
    public static int posibilidadActual = 0;
    
    public static int[] posibilidades = new int[100];    

    public static void generarPosibilidades() {
        for(int i = 0; i <= posibilidades.length-1; i++) {
            Random ran = new Random();
            int x = ran.nextInt(100) + 1;
            posibilidades[i] = x;
        }
    }
       
    public int posibilidad() {
        posibilidadActual++;
        return posibilidades[posibilidadActual-1];
    }

    //--------------------------------------------
    
 

    

    
    
   

   

    
    
    
}
