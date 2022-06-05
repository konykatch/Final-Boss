package com.company.characters;

public class Rouge extends NPC {


    public Rouge(String name, int hp, int mana, int damage, int armor,int maxhp,int maxmana,boolean isIgnited) {
        super(name, hp, mana, damage, armor, maxhp,maxmana,isIgnited);
    }

    @Override
    public void specialAbility(NPC npc, NPC enemy) {

    }
}
