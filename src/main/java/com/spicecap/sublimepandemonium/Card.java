
package com.spicecap.sublimepandemonium;
import java.util.Random;



public class Card {
    
    public enum Type {
        TANK, FIGHTER, SUPPORT, MARKSMAN, MAGE, ASSASSIN
    }
    public enum Habbility {
        BLEED_ONE_1,
        DMG_CRIT,
        DMG_RED_1,
        DMG_REF_1,
        DMG_UP_SLF_1,
        DODGE, //FALTA
        HEAL_SLF_1,
        HEAL_TWO_1,
        STORM, //FALTA
        STUN_ONE_1,
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
        
        
        int attackPoints = 0;
        
        // HABILIDADES BUFF ------------------------------
        
        if (this.habbility == Habbility.DMG_UP_SLF_1) 
            damageUpSelf1(this);
        else if (this.habbility == Habbility.DMG_CRIT)
            attackPoints += damageCrit();
        else if (this.habbility == Habbility.HEAL_SLF_1) 
            healSelf1(this);
        else if (this.habbility == Habbility.HEAL_TWO_1) 
            healTwo1(deckOrig);
            
        // HABILIDADES DEBUFF ----------------------------
        
        else if (this.habbility == Habbility.STUN_ONE_1) 
            stunOne1(deckDest);
        else if (this.habbility == Habbility.BLEED_ONE_1) 
            bleedOne1(deckDest);
        
        
        
        
        // ATAQUE BÁSICO --------------------------------
        
        attackPoints += this.atq;
        int target = 0;
        boolean attackDone = false;
        
        do {            
            if (deckDest[target].dead) {
                target++;
            } else {
                    
                    if (deckDest[target].habbility == Habbility.DMG_RED_1) {
                        if (posibilidad() <= 25) {
                            attackPoints -= 2;
                            if (attackPoints < 0) {
                                attackPoints = 0;
                            }
                            System.out.println("Damage reduction (2pt)");
                        }
                    }
                    
                    
                    if (deckDest[target].habbility == Habbility.DMG_REF_1) {
                        if (posibilidad() <= 70) {
                            System.out.println(this + "@" + Integer.toHexString(this.hashCode()) + " ATTACKED--> " + deckDest[target] + "@" + Integer.toHexString(deckDest[target].hashCode()));
                            System.out.println("Damage reflection ("+ (int) Math.floor(attackPoints * 0.34) + "pt)");
                            this.hp -= Math.floor(attackPoints * 0.34);
                            deckDest[target].hp -= Math.round(attackPoints * 0.7);
                            attackDone = true;
                            checkDeath(this);
                            checkDeath(deckDest[target]);
                        } else {
                            System.out.println(this + "@" + Integer.toHexString(this.hashCode()) + " ATTACKED--> " + deckDest[target] + "@" + Integer.toHexString(deckDest[target].hashCode()));
                            deckDest[target].hp -= attackPoints;
                            attackDone = true;
                            checkDeath(deckDest[target]);
                        } 
                    } else {
                        System.out.println(this + "@" + Integer.toHexString(this.hashCode()) + " ATTACKED--> " + deckDest[target] + "@" + Integer.toHexString(deckDest[target].hashCode()));
                        deckDest[target].hp -= attackPoints;
                        attackDone = true;
                        checkDeath(deckDest[target]);
                    }
 
            }
        } while (!attackDone && target < 5);
        
    }
    
    //----------------------------------------------------
    //---------------------HABILIDADES--------------------
    //----------------------------------------------------
    
    // Habilidades buff
    
    public static void damageUp(Card card, int plus) {
        System.out.println("Damage up for " + card + " (" + plus + "pt)");    
        card.atq += plus;  
    }
    
    public static void damageUpSelf1(Card card) {
        if (posibilidad() <= 30) {
            damageUp(card, 3);
        }
    }
    
    public static int damageCrit() {
        if (posibilidad() <= 25) {
            System.out.println("CRITIC DAMAGE!!");
            return 3;
        } else {
            return 0;
        } 
    }
    
    public static void heal(Card card, int plus) {
        System.out.println("Healing " + plus + "hp for " + card);
        card.hp += plus;
    }
    
    public static void healSelf1(Card card) {
        if (posibilidad() <= 30) {
            heal(card, 3);
        }
    }
    
    public static void healTwo1(Card[] deck) {
        if (posibilidad() <= 22) {
                
            int[] array = new int[5];
            int puntero = 0;
                
            for (int i = 0; i < 5; i++) {
                if (!deck[i].dead) {
                    array[puntero] = i;
                    puntero++;
                }
            }
                
            puntero -= 1;
                
            if (puntero == 0) {
                heal(deck[array[0]], 2);
            } else if (puntero == 1) {
                heal(deck[array[0]], 2);
                heal(deck[array[1]], 2);
            } else {
                    
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                    
                heal(deck[array[afortunado]], 2);
                heal(deck[array[afortunado2]], 2);
            }    
        } 
    }
    
    // Habilidades debuff
    
    public static void stun(Card card, int turns) {
        card.stuned += turns;
        System.out.println("Stun caused to " + card + " ("+ turns + " turn(s))");
    }
    
    public static void stunOne1(Card[] deck) {
        if (posibilidad() <= 20) {
            int[] array = new int[5];
            int puntero = 0;
            for (int i = 0; i < 5; i++) {
                if (!deck[i].dead) {
                    array[puntero] = i;
                    puntero++;
                }
            }   
            puntero -= 1; 
            if (puntero == 0) {
                stun(deck[array[0]], 2);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                stun(deck[array[afortunado]], 2);
            }
        }
    }
    
    public static void bleed(Card card, int turns) {
        card.bleeding += turns;
        System.out.println("Bleeding caused to " + card + " ("+ turns + " turn(s))");
    }
    
    public static void bleedOne1(Card[] deck) {
        if (posibilidad() <= 35) {
                
            int[] array = new int[5];
            int puntero = 0;
                
            for (int i = 0; i < 5; i++) {
                if (!deck[i].dead) {
                    array[puntero] = i;
                    puntero++;
                }
            }
                
            puntero -= 1;
                
            if (puntero == 0) {
                bleed(deck[array[0]], 2);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                bleed(deck[array[afortunado]], 2);
            }
        }
    }
    
    
    
    
    //--------------------------------------------
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
       
    public static int posibilidad() {
        posibilidadActual++;
        return posibilidades[posibilidadActual-1];
    }

    //--------------------------------------------
    
    public static boolean checkDeath(Card card) {
        if (card.isDead()) {
            System.out.println("++X++ " + card + " DIED! ++X++");
            card.dead = true;
            return true;
        }
        else
            return false;
    }
     
}
