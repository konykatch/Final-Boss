package com.company.characters;

import com.company.GameLogic;

public abstract class NPC {
    private String name;
    private int hp,maxhp,mana,maxmana,damage,armor;
    private boolean isIgnited;

    public NPC(String name, int hp, int mana, int damage, int armor, int maxhp,int maxmana, boolean isIgnited) {
        this.name = name;
        this.hp = hp;
        this.maxhp = maxhp;
        this.mana = mana;
        this.maxmana = maxmana;
        this.damage = damage;
        this.armor = armor;
        this.isIgnited = isIgnited;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getmaxhp() {
        return maxhp;
    }

    public int getmaxmana() {
        return maxmana;
    }

    public void setIgnited(boolean ignited) {
        isIgnited = ignited;
    }

    public boolean isIgnited() {
        return isIgnited;
    }

    public static void attack(NPC npc, NPC enemy){
        int trueDamage = enemy.getArmor()- npc.getDamage();
        enemy.setHp(enemy.getHp()-trueDamage);
        System.out.println(npc.getName()+ " hits "+ enemy.getName()+ " by "+ -trueDamage);
        GameLogic.printSeparator(30);
    }
    public static void useHealthPotion(NPC npc){
        int healthPotion = 20;
        if((npc.getHp()+healthPotion)>npc.getmaxhp()){
            npc.setHp(npc.getmaxhp());
        }else {
            npc.setHp(npc.getHp() + healthPotion);
        }
        System.out.println(npc.getName() + " used health potion");
        GameLogic.printSeparator(30);
    }
    public static void useManaPotion(NPC npc){
        int manaPotion = 20;
        if((npc.getHp()+manaPotion)>npc.getmaxmana()){
            npc.setHp(npc.getmaxmana());
        }else {
            npc.setHp(npc.getHp() + manaPotion);
        }
        System.out.println(npc.getName() + " used mana potion");
        GameLogic.printSeparator(30);
    }

    public abstract void specialAbility(NPC npc, NPC enemy);
}

