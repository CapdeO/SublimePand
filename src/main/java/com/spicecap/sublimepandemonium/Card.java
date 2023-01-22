
package com.spicecap.sublimepandemonium;
import java.util.Random;
import static com.spicecap.sublimepandemonium.Player.checkEmptyDeck;



public class Card {
    
    public enum Type {
        TANK, FIGHTER, SUPPORT, MARKSMAN, MAGE, ASSASSIN
    }
    public enum Habbility {
        BLEED_ONE_1,
        CLEAN_1, // FALTA ASIGNAR
        DMG_CRIT,
        DMG_RED_1,
        DMG_REF_1,
        DMG_UP_SLF_1,
        DODGE_1,  // FALTA ASIGNAR
        FINISH_1,  
        FIRE_ONE_1, 
        HEAL_SLF_1,
        HEAL_TWO_1,
        THUNDER_ONE_1,  // FALTA ASIGNAR
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
    public int fire;
    
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
    
    public boolean isBurning() {
        if (this.fire == 0) 
            return false;
        else 
            return true;
    }
    
    
    public void attack(Card[] deckOrig, Card[] deckDest) {
        
        int attackPoints = 0;
        
      if (!checkEmptyDeck(deckDest)) {
            
    // HABILIDADES DE DAÑO DIRECTO--------------------
        
        if (this.habbility == Habbility.THUNDER_ONE_1) 
            thunderOne(deckDest, 20, 3);
        else if (this.habbility == Habbility.FIRE_ONE_1) 
            fireOne(deckDest, 25, 3);
        else if (this.habbility == Habbility.FINISH_1) 
            finishOne(deckDest, 25, 7);
        
        
        
        
        
        
    // HABILIDADES BUFF ------------------------------
        
        else if (this.habbility == Habbility.DMG_UP_SLF_1) 
            damageUpSelf(this, 30, 3);
        else if (this.habbility == Habbility.DMG_CRIT)
            attackPoints += damageCrit();
        else if (this.habbility == Habbility.HEAL_SLF_1) 
            healSelf(this, 30, 3);
        else if (this.habbility == Habbility.HEAL_TWO_1) 
            healTwo(deckOrig, 22, 3);
        else if (this.habbility == Habbility.CLEAN_1) 
            cleanOne(deckOrig, 50);
        
            
    // HABILIDADES DEBUFF ----------------------------
        
        else if (this.habbility == Habbility.STUN_ONE_1) 
            stunOne(deckDest, 20, 2);
        else if (this.habbility == Habbility.BLEED_ONE_1) 
            bleedOne(deckDest, 35, 2);
        
        
      }
      if (!checkEmptyDeck(deckDest)) {
          
    // ATAQUE BÁSICO --------------------------------
        
        attackPoints += this.atq;
        int target = 0;
        boolean attackDone = false;
        
        do {            
            if (deckDest[target].dead) {
                target++;
            } else {
                    
                if (deckDest[target].habbility == Habbility.DMG_RED_1) {
                    attackPoints -= damageReduc(25, 2);
                    if (attackPoints < 0) 
                        attackPoints = 0;
                }   
                    
                if (deckDest[target].habbility == Habbility.DMG_REF_1) {
                    if (posibilidad() <= 70) {
                        basicAttack(this, deckDest[target], (int) Math.round(attackPoints * 0.7));
                        System.out.println("Damage reflection ("+ (int) Math.floor(attackPoints * 0.34) + "pt)");
                        this.hp -= Math.floor(attackPoints * 0.34);
                        checkDeath(this);
                        attackDone = true;
                    } else {
                        basicAttack(this, deckDest[target], attackPoints);
                        attackDone = true;
                    } 
                } else if (deckDest[target].habbility == Habbility.DODGE_1) {
                    if (posibilidad() <= 20) {
                        System.out.println(this + "@" + Integer.toHexString(this.hashCode()) + " ATTACKED--> " + deckDest[target] + "@" + Integer.toHexString(deckDest[target].hashCode()));
                        System.out.println("But " + deckDest[target] + " dodged his attack");
                        attackDone = true;
                    } else {
                        basicAttack(this, deckDest[target], attackPoints);
                        attackDone = true;
                    } 
                } else {
                    basicAttack(this, deckDest[target], attackPoints);
                    attackDone = true;
                }
 
            }
        } while (!attackDone && target < 5);
        
      }
        
        if (this.fire > 0) {
            System.out.println("Fire for " + this + "(-2hp");
            this.hp -= 2;
            this.fire -= 1;
            if (checkDeath(this)) 
                System.out.println("Due to fire");
        }
      
    }
    
    //----------------------------------------------------
    //---------------------HABILIDADES--------------------
    //----------------------------------------------------
    
    // Habilidades de daño directo
    
    public static void thunder(Card card, int points) {
        System.out.println("Thunder for " + card + " (" + points + "pt)");
        card.hp -= points;
        checkDeath(card);
    }
    
    public static void thunderOne(Card[] deck, int chance, int points) {
        if (posibilidad() <= chance) {
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
                thunder(deck[array[0]], points);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                thunder(deck[array[afortunado]], points);
            }
        }
    }
    
    public static void fire(Card card, int turns) {
        card.fire += turns;
        System.out.println("Fire caused to " + card + " ("+ turns + " turn(s))");
    }
    
    public static void fireOne(Card[] deck, int chance, int turns) {
        if (posibilidad() <= chance) {
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
                fire(deck[array[0]], turns);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                fire(deck[array[afortunado]], turns);
            }
        }
    }
    
    public static void finish(Card card, int points) {
        System.out.println("Attempt to finish " + card + "(With " + points + " attack pts)");
        card.hp -= points;
        checkDeath(card);
    }
    
    public static void finishOne(Card[] deck, int chance, int points) {
        if (posibilidad() <= chance) {
            int menorHp = 0;
            boolean firstFound = false;
            
            do {      
                if (deck[menorHp].dead) 
                    menorHp++;
                else
                    firstFound = true;
            } while (!firstFound);
            
            
            for (int i = menorHp; i < 4; i++) {
                if ((deck[i+1].hp < deck[menorHp].hp) && (!deck[i+1].dead) ) {
                    menorHp = i+1;
                }
            }
            finish(deck[menorHp], points);
        }
    }
    
    
    
    
    // Habilidades buff
    
    public static void damageUp(Card card, int plus) {
        System.out.println("Damage up for " + card + " (" + plus + "pt)");    
        card.atq += plus;  
    }
    
    public static void damageUpSelf(Card card, int chance, int plus) {
        if (posibilidad() <= chance) {
            damageUp(card, plus);
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
    
    public static void healSelf(Card card, int chance, int plus) {
        if (posibilidad() <= chance) {
            heal(card, plus);
        }
    }
    
    public static void healTwo(Card[] deck, int chance, int plus) {
        if (posibilidad() <= chance) {
                
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
                heal(deck[array[0]], plus);
            } else if (puntero == 1) {
                heal(deck[array[0]], plus);
                heal(deck[array[1]], plus);
            } else {
                    
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                    
                heal(deck[array[afortunado]], plus);
                heal(deck[array[afortunado2]], plus);
            }    
        } 
    }
    
    public static void clean(Card card) {
        card.bleeding = 0;
        card.fire = 0;
        card.stuned = 0;
        System.out.println(card + " is now clean");
    }
    
    public static void cleanOne(Card[] deck, int chance) {
        int[] array = new int[5];
        int puntero = 0;
        
        for (int i = 0; i < 5; i++) {
            if (deck[i].isStuned() || deck[i].isBleeding() || deck[i].isBurning()) {
                array[puntero] = i;
                puntero++;
            }
        }
        
        puntero -= 1;
                
        if (puntero == 0) {
            clean(deck[array[0]]);
        } else if (puntero > 0) {
            Random ran = new Random();
            int afortunado = ran.nextInt(puntero) + 0;
            clean(deck[array[afortunado]]);
        }   
    }
    
    // Habilidades debuff
    
    public static void stun(Card card, int turns) {
        card.stuned += turns;
        System.out.println("Stun caused to " + card + " ("+ turns + " turn(s))");
    }
    
    public static void stunOne(Card[] deck, int chance, int turns) {
        if (posibilidad() <= chance) {
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
                stun(deck[array[0]], turns);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                stun(deck[array[afortunado]], turns);
            }
        }
    }
    
    public static void bleed(Card card, int turns) {
        card.bleeding += turns;
        System.out.println("Bleeding caused to " + card + " ("+ turns + " turn(s))");
    }
    
    public static void bleedOne(Card[] deck, int chance, int turns) {
        if (posibilidad() <= chance) {
                
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
                bleed(deck[array[0]], turns);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                bleed(deck[array[afortunado]], turns);
            }
        }
    }
    
    
    
    // Otras habilidades
    
    public static int damageReduc(int chance, int points) {
        if (posibilidad() <= chance) {
            System.out.println("Damage reduction ("+ points + "pt)");
            return points;
        } 
        else 
            return 0;
    }
    
    
    
    
    //--------------------------------------------
    //--------------------------------------------
    
    public static void basicAttack(Card attacker, Card target, int points) {
        System.out.println(attacker + "@" + Integer.toHexString(attacker.hashCode()) + " ATTACKED--> " + target + "@" + Integer.toHexString(target.hashCode()));
        target.hp -= points;
        checkDeath(target);
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
