package com.nopo.functions;

import jdk.jshell.spi.SPIResolutionException;

import java.util.Scanner;

import static com.nopo.functions.Death.death;
import static com.nopo.functions.Movement.movement;
import static com.nopo.Main.*;

public class Fighting {

    public static int defendCooldown = 0;
    public static int protectedTurns = 0;
    public static int protectedAmount = 100;
    public static int monsterDamage = 0;
    public static int playerDamage = 0;
    public static boolean failedDefend = false;

    public static void fight(int monsterHp, int monsterAtk, String monsterName) {
        monsterHealth = monsterHp;
        monsterAttack = monsterAtk;
        System.out.println("You have " + hp + " hp");
        System.out.println(monsterName + " has " + monsterHp + " hp");
        while (hp > 0 && monsterHealth > 0) {

            System.out.println("What do you want to do? (a/d)");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "a" -> {
                    attack();
                }
                case "d" -> {
                    defend();
                }
                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
        if (hp > 0) {
            System.out.println("You defeated " + monsterName);
            System.out.println("You have " + hp + " hp");
            coins += 5;
            System.out.println("You gained 5 coins!" + ln + "You now have " + coins + " coins");
            movement();
        } else {
            death();
        }
    }
    static void attack() {
        monsterDamage = (int) ((Math.random() * 2) * monsterAttack);
        playerDamage = (int) ((Math.random() * 4) * atk);
        if (!failedDefend) {
            monsterHealth = monsterHealth - playerDamage;
            System.out.println("You hit the monster for " + playerDamage + " damage!");
        } else {
            System.out.println("While trying to defend the monster attacked you!");
            failedDefend = false;
        }
            if (monsterHealth > 0) {
                System.out.println("The monster has " + monsterHealth + " hp");
                if (protectedTurns == 0) {
                    protectedAmount = 100;
                    hp = hp - monsterDamage;
                    System.out.println("The monster hits you for " + monsterDamage + " damage");
                } else if (protectedTurns >= 1) {
                    protectedTurns -= 1;
                    defendCooldown -= 1;
                    if (protectedAmount == 0) {
                        System.out.println("The monster hits you but you fully protected yourself");
                    } else if (protectedAmount > 0) {
                        float floatMonsterDamage = monsterDamage;
                        float damage = ((floatMonsterDamage / 100) * protectedAmount);
                            hp = (int) (hp - damage);
                            System.out.println("The monster hits you for " + ((monsterDamage / 100) * protectedAmount) + " damage");
                        }
                    }
                if (hp > 0) {
                    System.out.println("You have " + hp + " hp");
                }
            } else {
                monsterHealth = 0;
            }
        }
        static void defend() {
            if (def == 0) {
                System.out.println("You need defence to defend yourself... ");
            } else {
                if (defendCooldown < 1) {
                    if (def > monsterAttack) {
                        System.out.println("You block all damage from the monster next turn!");
                        protectedTurns += 1;
                        defendCooldown = 3;
                        protectedAmount = 0;
                    } else if (def == monsterAttack) {
                        System.out.println("The monster does half damage to you for the next 2 turns!");
                        protectedAmount = 50;
                        protectedTurns += 2;
                    }
                } else {
                    System.out.println("You can't defend yourself for " + defendCooldown + " more turn" + ((defendCooldown > 1) ? "s!" : "!"));
                    failedDefend = true;
                    attack();
                }
            }
        }
    }
