package com.company.characters;

public class Knight extends NPC{


    public Knight(String name, int hp, int mana, int damage, int armor,int maxhp,int maxmana,boolean isIgnited) {
        super(name, hp, mana, damage, armor, maxhp,maxmana,isIgnited);
    }

    @Override
    public void specialAbility(NPC npc,NPC enemy) {
        enemy.setHp(enemy.getHp()-npc.getDamage());
        System.out.println(npc.getName()+ " uses Windmill and deals "+ npc.getDamage()+" of true damage");
    }

}
