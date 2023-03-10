
package com.spicecap.sublimepandemonium;
import java.util.Random;



public class Card implements Cloneable{
    
    public enum Type {
        TANK, FIGHTER, SUPPORT, MARKSMAN, MAGE, ASSASSIN
    }
    public enum Habbility {
        BLEED_ONE_1,      // %35 chance - 2 turns     X
        BLEED_ONE_2,      // %25 chance - 4 turns     X
        
        BLEED_TWO_1,      // %25 chance - 2 turns     X
        BLEED_TWO_2,      // %20 chance - 3 turns     X
        
        CLEAN_ONE_1,      // %40 chance - 2 pts heal  X
        CLEAN_ONE_2,      // %35 chance - 3 pts heal  X
        
        CLEAN_TWO_1,      // %25 chance - 2 pts heal  X
        CLEAN_TWO_2,      // %20 chance - 3 pts heal  X
        
        DMG_CRIT_1,       // %25 chance - 3 pts       X
        DMG_CRIT_2,       // %20 chance - 4 pts       X
        
        DMG_RED_1,        // %25 chance - 2 pts       X
        DMG_RED_2,        // %20 chance - 3 pts       X
        
        DMG_REF_1,        // %50 chance - %30 dmg     X
        DMG_REF_2,        // %30 chance - %50 dmg     X
        
        DMG_UP_SLF_1,     // %25 chance - 2 pts       X
        DMG_UP_SLF_2,     // %20 chance - 3 pts       X
        
        DMG_UP_ONE_1,     // %25 chance - 3 pts
        DMG_UP_ONE_2,     // %20 chance - 4 pts
        
        DMG_UP_TWO_1,     // %35 chance - 1 pts
        DMG_UP_TWO_2,     // %20 chance - 2 pts
        
        DMG_DOWN_ONE_1,   // %25 chance - 3 pts
        DMG_DOWN_ONE_2,   // %30 chance - 2 pts
        
        DMG_DOWN_TWO_1,   // %25 chance - 2 pts
        DMG_DOWN_TWO_2,   // %15 chance - 3 pts
        
        DODGE_1,          // %20 chance               X
        DODGE_2,          // %30 chance               X
        
        FINISH_1,         // %25 chance - 6 pts       X
        FINISH_2,         // %20 chance - 7 pts       X
        
        FIRE_ONE_1,       // %35 chance - 3 turns
        FIRE_ONE_2,       // %30 chance - 4 turns
        
        
        
        HEAL_SLF_1,       // %25 chance - 4 pts     X
        HEAL_SLF_2,       // %30 chance - 2 pts     X
        
        HEAL_TWO_1,       // %20 chance - 3 pts     X
        HEAL_TWO_2,       // %25 chance - 2 pts     X
        
        THUNDER_ONE_1,    // %25 chance - 5 pts
        THUNDER_ONE_2,    // %30 chance - 4 pts
        
        THUNDER_TWO_1,    // %20 chance - 3 pts
        THUNDER_TWO_2,    // %30 chance - 2 pts
        
        STUN_ONE_1,       // %20 chance - 2 turns  X
        STUN_ONE_2,       // %30 chance - 1 turns  X
        
        STUN_TWO_1,       // %20 chance - 1 turns  X
        STUN_TWO_2,       // %15 chance - 2 turns  X
        
        POISON_1,         // %40  chance           X
        POISON_2,         // %30  chance           X
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
    
    public boolean poisoned;
    
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
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Card copia = new Card (this.id, this.type, this.name, this.hp, this.atq, this.habbility);
        return copia;
    }
    
    public boolean isDead() {
        return this.hp <= 0;
    }
    public boolean isStuned() {
        return this.stuned != 0;
    }
    public boolean isBleeding() {
        return this.bleeding != 0;
    }
    public boolean isBurning() {
        return this.fire != 0;
    }
    
    
    public void attack(Card[] deckOrig, Card[] deckDest) {
        
        
        int attackPoints = 0;
        
        switch (this.habbility) {
        // DAMAGE---------------    
            case THUNDER_ONE_1 -> thunderOne(deckDest, 25, 5);
            case THUNDER_ONE_2 -> thunderOne(deckDest, 30, 4);
            case THUNDER_TWO_1 -> thunderTwo(deckDest, 20, 3);
            case THUNDER_TWO_2 -> thunderTwo(deckDest, 30, 2);
            case FINISH_1 -> finishOne(deckDest, 25, 6);
            case FINISH_2 -> finishOne(deckDest, 20, 7);
        // BUFF --------------    
            case DMG_UP_SLF_1 -> damageUpSelf(this, 25, 2);
            case DMG_UP_SLF_2 -> damageUpSelf(this, 20, 3);
            case DMG_UP_ONE_1 -> damageUpOne(deckOrig, 25, 3);
            case DMG_UP_ONE_2 -> damageUpOne(deckOrig, 20, 4);
            case DMG_UP_TWO_1 -> damageUpTwo(deckOrig, 35, 1);
            case DMG_UP_TWO_2 -> damageUpTwo(deckOrig, 20, 2);
            case DMG_CRIT_1 -> attackPoints += damageCrit(25, 3);
            case DMG_CRIT_2 -> attackPoints += damageCrit(20, 4);
            case HEAL_SLF_1 -> healSelf(this, 25, 4);
            case HEAL_SLF_2 -> healSelf(this, 30, 2);
            case HEAL_TWO_1 -> healTwo(deckOrig, 20, 3);
            case HEAL_TWO_2 -> healTwo(deckOrig, 25, 2);
            case CLEAN_ONE_1 -> cleanOne(deckOrig, 40, 2);
            case CLEAN_ONE_2 -> cleanOne(deckOrig, 35, 3);
            case CLEAN_TWO_1 -> cleanTwo(deckOrig, 25, 2);
            case CLEAN_TWO_2 -> cleanTwo(deckOrig, 20, 3);
        // DEBUFF -------------   
            case DMG_DOWN_ONE_1 -> damageDownOne(deckDest, 25, 3);
            case DMG_DOWN_ONE_2 -> damageDownOne(deckDest, 30, 2);
            case DMG_DOWN_TWO_1 -> damageDownTwo(deckDest, 25, 2);
            case DMG_DOWN_TWO_2 -> damageDownTwo(deckDest, 15, 3);
            case STUN_ONE_1 -> stunOne(deckDest, 20, 2);
            case STUN_ONE_2 -> stunOne(deckDest, 25, 1);
            case STUN_TWO_1 -> stunTwo(deckDest, 20, 1);
            case STUN_TWO_2 -> stunTwo(deckDest, 15, 2);
            case BLEED_ONE_1 -> bleedOne(deckDest, 40, 2);
            case BLEED_ONE_2 -> bleedOne(deckDest, 30, 4);
            case BLEED_TWO_1 -> bleedTwo(deckDest, 30, 2);
            case BLEED_TWO_2 -> bleedTwo(deckDest, 25, 3);
            case FIRE_ONE_1 -> fireOne(deckDest, 35, 3);   
            case FIRE_ONE_2 -> fireOne(deckDest, 30, 4);
        }
        
        
        // ATAQUE B??SICO --------------------------------
        
        attackPoints += this.atq;
        int target = 0;
        boolean attackDone = false;
        
        do {            
            if (deckDest[target].dead) {
                target++;
            } else {
                    
                if (deckDest[target].habbility == Habbility.DMG_RED_1) 
                    attackPoints -= damageReduc(25, 2); 
                else if (deckDest[target].habbility == Habbility.DMG_RED_2)
                    attackPoints -= damageReduc(20, 3);
                
                if (attackPoints < 0) 
                        attackPoints = 0;
                
                
                switch (deckDest[target].habbility) {
                    case DMG_REF_1 -> {
                        if (posibilidad() <= 50) {
                            basicAttack(this, deckDest[target], (int) Math.round(attackPoints * 0.7));
                            System.out.println("Damage reflection ("+ (int) Math.floor(attackPoints * 0.34) + "pt)");
                            this.hp -= Math.floor(attackPoints * 0.34);
                            checkDeath(this);
                            attackDone = true;
                        } else {
                            basicAttack(this, deckDest[target], attackPoints);
                            attackDone = true;
                        }
                    }
                    
                    case DMG_REF_2 -> {
                        if (posibilidad() <= 30) {
                            basicAttack(this, deckDest[target], (int) Math.round(attackPoints * 0.5));
                            System.out.println("Damage reflection ("+ (int) Math.round(attackPoints * 0.5) + "pt)");
                            this.hp -= Math.round(attackPoints * 0.5);
                            checkDeath(this);
                            attackDone = true;
                        } else {
                            basicAttack(this, deckDest[target], attackPoints);
                            attackDone = true;
                        }
                    }
                    
                    case DODGE_1 -> {
                        if (posibilidad() <= 20) {
                            System.out.println(this + "@" + Integer.toHexString(this.hashCode()) + " ATTACKED--> " + deckDest[target] + "@" + Integer.toHexString(deckDest[target].hashCode()));
                            System.out.println("But " + deckDest[target] + " dodged his attack");
                            attackDone = true;
                        } else {
                            basicAttack(this, deckDest[target], attackPoints);
                            attackDone = true;
                        }
                    }
                    
                    case DODGE_2 -> {
                        if (posibilidad() <= 30) {
                            System.out.println(this + "@" + Integer.toHexString(this.hashCode()) + " ATTACKED--> " + deckDest[target] + "@" + Integer.toHexString(deckDest[target].hashCode()));
                            System.out.println("But " + deckDest[target] + " dodged his attack");
                            attackDone = true;
                        } else {
                            basicAttack(this, deckDest[target], attackPoints);
                            attackDone = true;
                        }
                    }
                        
                    default -> {
                        basicAttack(this, deckDest[target], attackPoints);
                        attackDone = true;
                    }
                        
                } // END SWITCH
                
            }
        } while (!attackDone && target < 5);
        
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
    
    // Damage -------------------------------------------------------------------
    // Damage -------------------------------------------------------------------
    // Damage -------------------------------------------------------------------
    
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
    
    public static void thunderTwo(Card[] deck, int chance, int points) {
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
            } else if (puntero == 1) {
                thunder(deck[array[0]], points);
                thunder(deck[array[1]], points);
            } else if (puntero > 1) {
                    
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                
                thunder(deck[array[afortunado]], points);
                thunder(deck[array[afortunado2]], points);
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
      if (!Player.checkEmptyDeck(deck)) {
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
    }
    
    
    // Buff -------------------------------------------------------------------------
    // Buff -------------------------------------------------------------------------
    // Buff -------------------------------------------------------------------------
    
    public static void damageUp(Card card, int plus) {
        System.out.println("Damage up for " + card + " (" + plus + "pt)");    
        card.atq += plus;  
    }
    
    public static void damageUpSelf(Card card, int chance, int plus) {
        if (posibilidad() <= chance) {
            damageUp(card, plus);
        }
    }
    
    public static void damageUpOne(Card[] deck, int chance, int plus) {
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
                damageUp(deck[array[0]], plus);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                damageUp(deck[array[afortunado]], plus);
            } 
        }
    }
    
    public static void damageUpTwo(Card[] deck, int chance, int plus) {
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
                damageUp(deck[array[0]], plus);
            } else if (puntero == 1) {
                damageUp(deck[array[0]], plus);
                damageUp(deck[array[1]], plus);
            } else if  (puntero > 1){  
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                    
                damageUp(deck[array[afortunado]], plus);
                damageUp(deck[array[afortunado2]], plus);
            } 
        }
    }
    
    public static int damageCrit(int chance, int critic) {
        if (posibilidad() <= chance) {
            System.out.println("CRITIC DAMAGE!!");
            return critic;
        } else {
            return 0;
        } 
    }
    
    public static void heal(Card card, int plus) {
        System.out.println("Healing " + plus + "hp for " + card);
        card.hp += plus;
    }
    
    public static void healSelf(Card card, int chance, int plus) {
        if (!card.poisoned) {
            if (posibilidad() <= chance) {
            heal(card, plus); 
            }
        } else 
            System.out.println(card + " can??t heal himself because is poisoned");
    }
    
    public static void healTwo(Card[] deck, int chance, int plus) {
        if (posibilidad() <= chance) {
                
            int[] array = new int[5];
            int puntero = 0;
                
            for (int i = 0; i < 5; i++) {
                if (!deck[i].dead && !deck[i].poisoned) {
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
            } else if (puntero > 1) {
                    
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
    
    public static void cleanOne(Card[] deck, int chance, int heal) {
        if (posibilidad() <= chance) {
            int[] array = new int[5];
            int puntero = 0;

            for (int i = 0; i < 5; i++) {
                if (deck[i].isStuned() || deck[i].isBleeding() || deck[i].isBurning()) {
                    if (!deck[i].dead) {
                        array[puntero] = i;
                        puntero++; 
                    }
                }
            }

            puntero -= 1;

            if (puntero == 0) {
                clean(deck[array[0]]);
                if (!deck[array[0]].poisoned) 
                    heal(deck[array[0]], heal);  
                else
                    System.out.println(deck[array[0]] + " is poisoned and can??t be healed");
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                clean(deck[array[afortunado]]);
                if (!deck[array[afortunado]].poisoned) 
                    heal(deck[array[afortunado]], heal);
                else
                    System.out.println(deck[array[afortunado]] + " is poisoned and can??t be healed");
            }   
        }
    }
    
    public static void cleanTwo(Card[] deck, int chance, int heal) {
        if (posibilidad() <= chance) {
                
            int[] array = new int[5];
            int puntero = 0;
                
            for (int i = 0; i < 5; i++) {
                if (deck[i].isStuned() || deck[i].isBleeding() || deck[i].isBurning()) {
                    if (!deck[i].dead) {
                        array[puntero] = i;
                        puntero++; 
                    }
                }
            }
                
            puntero -= 1;
                
            if (puntero == 0) {
                clean(deck[array[0]]);
                if (!deck[array[0]].poisoned) 
                    heal(deck[array[0]], heal);
                else
                    System.out.println(deck[array[0]] + " is poisoned and can??t be healed");
            } else if (puntero == 1) {
                clean(deck[array[0]]);
                if (!deck[array[0]].poisoned) 
                    heal(deck[array[0]], heal);
                else
                    System.out.println(deck[array[0]] + " is poisoned and can??t be healed");
                clean(deck[array[1]]);
                if (!deck[array[1]].poisoned) 
                    heal(deck[array[1]], heal);
                else 
                    System.out.println(deck[array[1]] + " is poisoned and can??t be healed");
            } else if (puntero > 1) {
                    
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                
                clean(deck[array[afortunado]]);
                if (!deck[array[afortunado]].poisoned) 
                    heal(deck[array[afortunado]], heal);
                else
                    System.out.println(deck[array[afortunado]] + " is poisoned and can??t be healed");
                clean(deck[array[afortunado2]]);
                if (!deck[array[afortunado2]].poisoned) 
                    heal(deck[array[afortunado2]], heal);
                else
                    System.out.println(deck[array[afortunado2]] + " is poisoned and can??t be healed");
            }    
        }
    }
    
    // Debuff --------------------------------------------------------------------------
    // Debuff --------------------------------------------------------------------------
    // Debuff --------------------------------------------------------------------------
    
    public static void damageDown(Card card, int less) {
        System.out.println("Damage down for " + card + " (" + less + "pt)");    
        card.atq -= less;  
    }
    
    
    public static void damageDownOne(Card[] deck, int chance, int less) {
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
                damageDown(deck[array[0]], less);
            } else if (puntero > 0) {
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                damageDown(deck[array[afortunado]], less);
            } 
        }
    }
    
    public static void damageDownTwo(Card[] deck, int chance, int less) {
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
                damageDown(deck[array[0]], less);
            } else if (puntero == 1) {
                damageDown(deck[array[0]], less);
                damageDown(deck[array[1]], less);
            } else if (puntero > 1){  
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                    
                damageDown(deck[array[afortunado]], less);
                damageDown(deck[array[afortunado2]], less);
            } 
        }
    }
    
    
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
    
    public static void stunTwo(Card[] deck, int chance, int turns) {
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
            } else if (puntero == 1) {
                stun(deck[array[0]], turns);
                stun(deck[array[1]], turns);
            } else if (puntero > 1) {
                    
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                
                stun(deck[array[afortunado]], turns);
                stun(deck[array[afortunado2]], turns);
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
    
    public static void bleedTwo(Card[] deck, int chance, int turns) {
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
            } else if (puntero == 1) {
                bleed(deck[array[0]], turns);
                bleed(deck[array[1]], turns);
            } else if (puntero > 1) {
                    
                Random ran = new Random();
                int afortunado = ran.nextInt(puntero) + 0;
                int afortunado2;
                    
                do {    
                    afortunado2 = ran.nextInt(puntero) + 0;
                } while (afortunado2 == afortunado);
                
                bleed(deck[array[afortunado]], turns);
                bleed(deck[array[afortunado2]], turns);
            }    
        }
    }
    
    public static void poison(Card card, int chance) {
        if (posibilidad() <= chance) {
            card.poisoned = true;
            System.out.println("Poison caused to " + card);
        }
    }
    
    
    // Otras --------------------------------------------------------------------
    // Otras --------------------------------------------------------------------
    // Otras --------------------------------------------------------------------
    
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
        
        if (!target.dead && attacker.habbility == Habbility.POISON_1) {
            if (posibilidad() <= 40) {
                target.poisoned = true;
                System.out.println("XXXX " + target + " is poisoned");
            }
        } else if (!target.dead && attacker.habbility == Habbility.POISON_2) {
            if (posibilidad() <= 30) {
                target.poisoned = true;
                System.out.println("XXXX " + target + " is poisoned");
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
