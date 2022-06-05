package com.company;

import com.company.characters.*;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Knight knight = new Knight("Alesto",40,5,5,10,50,5,false);
    static Rouge rouge = new Rouge("Logan",25,10,5,5,50,5,false);
    static Sorcerer sorcerer = new Sorcerer("Astra",10,50,5,2,50,5,false);
    static Boss boss = new Boss("Khaotic",100,10,10,10,50,5,false);
    
    public static int userChoice(String prompt){
        int input = 0;
        boolean userCondition = true;
        while(userCondition) {
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
                userCondition = false;
            }catch(Exception e){
                System.out.println("Please enter a number");
            }
        }
        return input;
    }

    public static void printHeading(String prompt){
        System.out.println(prompt);
    }

    public static void pressAnythingToContinue(){
        System.out.println("Press anything to continue");
        scanner.next();
    }
    
    public static void clearConsole(){
        for(int i = 0; i<100;i++){
            System.out.println("");
        }
    }
    public static void printSeparator(int n){
        System.out.println("-".repeat(Math.max(0, n)));
    }
    public static void deadHero(String name){

    }

    public static void battle(){
        boolean condition = true;
        while(condition){
            printHeading(knight.getName()+" | hp: "+knight.getHp()+" | mana: "+knight.getMana());
            printSeparator(20);
            printHeading(rouge.getName()+" | hp: "+rouge.getHp()+" | mana: "+rouge.getMana());
            printSeparator(20);
            printHeading(sorcerer.getName()+" | hp: "+sorcerer.getHp()+" | mana: "+sorcerer.getMana());
            printSeparator(20);
            printHeading(boss.getName()+" | hp: "+boss.getHp()+" | mana: "+boss.getMana());
            printSeparator(20);
            playerTurn(knight,boss);
            playerTurn(rouge,boss);
            playerTurn(sorcerer,boss);
            enemyTurn(boss,knight,rouge,sorcerer);
        }
    }

    public static void ignite(NPC npc){
        if(npc.isIgnited()){
            npc.setHp(npc.getHp()-2);
            System.out.println(npc.getName()+" is ignited");
        }
    }


    public static void playerTurn(NPC npc,NPC enemy){
        if(npc.getHp()<=0){
            System.out.println(npc.getName()+" is fainted");
        }else {
            ignite(npc);
            System.out.println(npc.getName() + " turn");
            int choice = userChoice("1.Attack | 2.Use health potion | 3. Use mana Potion | 4.Special Ability");
            switch (choice) {
                case 1 -> npc.attack(npc, enemy);
                case 2 -> npc.useHealthPotion(npc);
                case 3 -> npc.useManaPotion(npc);
                case 4 -> npc.specialAbility(npc, enemy);
            }
        }
    }

    public static void enemyTurn(NPC enemy, NPC player1, NPC player2, NPC player3){
        if(enemy.getHp()<30){
            NPC.useHealthPotion(enemy);
            System.out.println("Time to drink Health Potion");
        }else if(enemy.getMana()>0){
            enemy.specialAbility(enemy,player1);
        }
        else if(enemy.getMana()==0){
            NPC.useManaPotion(enemy);
            System.out.println("Time to drink Mana Potion");
        } else {
            int lowest = Math.min(Math.min(player1.getHp(),player2.getHp()),player3.getHp());
            if(lowest==player1.getHp()){
                NPC.attack(enemy,player1);
            }else if(lowest==player2.getHp()){
                NPC.attack(enemy,player2);
            }else{
                NPC.attack(enemy,player3);
            }
        }

    }

    }

    
