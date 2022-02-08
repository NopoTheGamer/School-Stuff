package com.nopo.functions;

import com.nopo.Utils;
import com.nopo.items.ItemsUtils;

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
    public static boolean giveRewardItem = true;

    public static void fight(int monsterHp, int monsterAtk, String monsterName, int monsterLevel, String rewardItem, int rewardItemAmount) {
        if (rewardItemAmount == 0) {
            giveRewardItem = false;
        }
        monsterHealth = monsterHp;
        monsterAttack = monsterAtk;
        Utils.printTrimmer();
        System.out.println("|" + Utils.getSpaceLength(monsterName, 14) + Utils.getSpaceLength(monsterHp, 10) + monsterName + " has " + monsterHp + " hp |" + Utils.lnt);
        System.out.println("| You have " + hp + " hp" + Utils.getSpaceLength(hp, 27) + "|");
        while (hp > 0 && monsterHealth > 0) {
            System.out.println("|      (a)ttack      |      (d)efend     |");
            Utils.printTrimmer();
            System.out.println();
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
            if (giveRewardItem) {
                ItemsUtils.giveItem(rewardItem, rewardItemAmount);
                Utils.printFormattedLineFront("You got " + rewardItem + ((rewardItemAmount > 1) ? " x" + rewardItemAmount + " " : " " ) + "from the " + monsterName + "!");
            }
            System.out.println("|" + Utils.getSpaceLength(monsterName, 9) + "You defeated " + monsterName + " |" + Utils.lnt);
            System.out.println("| You have " + hp + " hp" + Utils.getSpaceLength(hp, 27) + "|");
            coins += 5 * monsterLevel;
            System.out.println("| You gained " + (5 * monsterLevel) + " coins!" + Utils.getSpaceLength(5 * monsterLevel, 21) + "|");
            System.out.println("| You now have " + coins + " coins" + Utils.getSpaceLength(coins, 20) + "|");
            Utils.printTrimmer();
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
            Utils.printTrimmer();
            System.out.println("|" + Utils.getSpaceLength(playerDamage, 7) + "You hit the monster for " + playerDamage + " damage! |");
        } else {
            System.out.println("| While trying to defend" + Utils.printSpaces(17) + "|");
            System.out.println("| The monster attacked you!" + Utils.printSpaces(14)  + "|");
            Utils.printTrimmer();
            failedDefend = false;
        }
            if (monsterHealth > 0) {
                System.out.println("|" + Utils.getSpaceLength(monsterHealth, 20) + "The monster has " + monsterHealth + " hp |" + Utils.lnt);
                if (defendCooldown > 0) {
                    defendCooldown -= 1;
                }
                if (protectedTurns == 0) {
                    protectedAmount = 100;
                    hp = hp - monsterDamage;
                    System.out.println("| The monster hits you for " + monsterDamage + " damage!" + Utils.getSpaceLength(monsterDamage, 6) + "|");
                } else if (protectedTurns >= 1) {
                    protectedTurns -= 1;
                    if (protectedAmount == 0) {
                        System.out.println("The monster hits you but you fully protected yourself");
                    } else if (protectedAmount > 0) {
                        float floatMonsterDamage = monsterDamage;
                        float damage = ((floatMonsterDamage / 100) * protectedAmount);
                            hp = (int) (hp - damage);
                            System.out.println("| The monster hits you for " + Math.round(damage) + " damage!" + Utils.getSpaceLength((int) damage, 6) + "|");
                        }
                    }
                if (hp > 0) {
                    System.out.println("| You have " + hp + " hp" + Utils.getSpaceLength(hp, 27) + "|");
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
                    Utils.printTrimmer();
                    if (def > monsterAttack) {
                        Utils.printFormattedLine("You block all damage next turn!");
                        protectedTurns += 1;
                        defendCooldown = 3;
                        protectedAmount = 0;
                    } else if (def == monsterAttack) {
                        Utils.printFormattedLine("The monster does half damage");
                        Utils.printFormattedLine("for the next 2 turns!");
                        protectedAmount = 50;
                        protectedTurns += 2;
                        defendCooldown = 3;
                    } else {
                        System.out.println("| The monster does a quarter less damage |" + Utils.ln + "| to you for the next turn!" + Utils.printSpaces(14) + "|" + Utils.lnt);
                        protectedAmount = 75;
                        protectedTurns += 1;
                        defendCooldown = 3;
                    }
                } else {
                    Utils.printTrimmer();
                    System.out.println("| You can't defend yourself for" + Utils.printSpaces(10) + "|");
                    System.out.println("| " + defendCooldown + " more turn" + ((defendCooldown > 1) ? "s!" : "! ") + Utils.printSpaces(26) + "|");
                    System.out.println(Utils.lnt);
                    failedDefend = true;
                    attack();
                }
            }
        }
    }
