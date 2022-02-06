package com.nopo.functions;

import com.nopo.Strings;
import com.nopo.Utils;

import java.util.Locale;
import java.util.Scanner;

import static com.nopo.functions.Death.death;
import static com.nopo.functions.Fighting.fight;
import static com.nopo.functions.GetItem.getItem;
import static com.nopo.functions.Movement.movement;
import static com.nopo.Main.*;
import static com.nopo.functions.Shop.shop;
import static com.nopo.functions.Startup.rngSeed;

public class LocationCheck {
    //one time encounter flags
    public static boolean lootChest1 = false;
    public static boolean appleTree1 = false;
    public static int swordLevel = 0;
    public static boolean purse1 = false;
    public static boolean goblinFight = false;
    public static boolean giantSpiderFight = false;
    public static boolean keyDoor1 = false;

    public static int[] randomNumberX = new int[21];
    public static int[] randomNumberY = new int[21];

    public static void isImportant() {
        if (x == randomNumberX[0] && y == randomNumberY[0]) {
            System.out.println("| You found a loot chest!" + Utils.printSpaces(16) + "|");
            if (!lootChest1) {
                System.out.println("| You found 10 coins!" + Utils.printSpaces(20) + "|");
                coins += 10;
                System.out.println("| You now have " + coins + " coins!" + Utils.getSpaceLength(coins, 19) + "|");

                if (rngSeed > 50) {
                    System.out.println("| Your attack increased by 2!" + Utils.printSpaces(12) + "|");
                    atk += 2;
                } else {
                    System.out.println("| Your defense increased by 2!" + Utils.printSpaces(11) + "|");
                    def += 2;
                }
                lootChest1 = true;
            } else {
                System.out.println("| But it's empty!" + Utils.printSpaces(24) + "|");
            }
            movement();
        } else if (x == randomNumberX[1] && y == randomNumberY[1]) {
            if (!goblinFight) {
                goblinFight = true;
                if (name.length() < 11) {
                    System.out.println("| Look out " + name + "! There's a monster!" + Utils.getSpaceLength(name, 25) + "|");
                } else {
                    System.out.println("| Look out " + name +  Utils.getSpaceLength(name, 5) + "|");
                    System.out.println("! There's a monster!" + Utils.printSpaces(21) + "|");
                }
                System.out.println("| Do you want to fight it?" + Utils.printSpaces(15) + "|");
                System.out.println("|       (Y)es       |        (N)o        |");
                Utils.printTrimmer();
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                switch (input.toLowerCase(Locale.ENGLISH)) {
                    case "y" -> {
                        fight(100, 3, "Short Goblin", 1);
                    }
                    case "n" -> {
                        hp -= 5;
                        Utils.printTrimmer();
                        System.out.println("| You got hit for 5 hp" + Utils.printSpaces(19) + "|");
                        System.out.println("| Your hp is now: " + hp + Utils.getSpaceLength(hp, 23) + "|");
                        movement();
                    }
                    default -> {
                        goblinFight = false;
                        Utils.printTrimmer();
                        System.out.println("| Invalid input" + Utils.printSpaces(26) + "|");
                        isImportant();
                    }
                }
            } else {
                movement();
            }
        } else if (x == randomNumberX[2] && y == randomNumberY[2]) {
            if (!appleTree1) {
                System.out.println("| Looks like an apple tree!" + Utils.printSpaces(14) + "|");
                System.out.println("| Do you want to shake it?   (y) | (n)   |");
                Utils.printTrimmer();
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                Utils.printTrimmer();
                switch (input.toLowerCase(Locale.ENGLISH)) {
                    case "y" -> {
                        appleTree1 = true;
                        if (rngSeed > 20) {
                            System.out.println("| You found an apple!" + Utils.printSpaces(20) + "|");
                            getItem("Apple", 1);
                            movement();
                        } else {
                            System.out.println("| Some bees attacked you!" + Utils.printSpaces(16) + "|");
                            System.out.println("| You got hit for 5 hp" + Utils.printSpaces(19) + "|");
                            hp -= 5;
                            if (hp < 1) {
                                death();
                            } else {
                                movement();
                            }
                        }
                    }
                    case "n" -> {
                        System.out.println("| You didn't shake it!" + Utils.printSpaces(19) + "|");
                        movement();
                    }
                    default -> {
                        System.out.println("| Invalid input" + Utils.printSpaces(26) + "|");
                        isImportant();
                    }
                }
            } else {
                movement();
            }
        } else if (x == randomNumberX[3] && y == randomNumberY[3]) {
            if (swordLevel < 1) {
                System.out.println("| You found a rusty sword" + Utils.printSpaces(16) + "|");
                System.out.println("| It was just lying on the ground!" + Utils.printSpaces(7) + "|");
                System.out.println("| It gives you +3 attack!" + Utils.printSpaces(16) + "|" + Utils.lnt);
                swordLevel = 1;
                atk += 3;
            }
            movement();
        } else if (x == randomNumberX[4] && y == randomNumberY[4]) {
            if (!purse1) {
                System.out.println("| Looks like someone dropped their purse |" + Utils.ln + "| You took the money from the purse!" + Utils.printSpaces(5) + "|");
                coins += 10;
                System.out.println("| You now have " + coins + " coins!" + Utils.getSpaceLength(coins, 19) + "|" + Utils.lnt);
                purse1 = true;
            }
            movement();
        } else if (x == randomNumberX[5] && y == randomNumberY[5]) {
            if (!giantSpiderFight) {
                giantSpiderFight = true;
                System.out.println("| Look out " + name + "!" + Utils.getSpaceLength(name, 6) + "|");
                System.out.println("| There's a giant spider!" + Utils.printSpaces(16) + "|");
                fight(25, 6, "Giant Spider", 3);
            } else {
                movement();

            }
        } else if (x == randomNumberX[6] && y == randomNumberY[6]) {
            System.out.println("| There is a shop!" + Utils.printSpaces(23) + "|");
            System.out.println("| Go inside?      (y)     |     (n)      |");
            Utils.printTrimmer();
            System.out.println("");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().toLowerCase(Locale.ENGLISH).equals("y")) {
                shop();
            } else {
                movement();
            }
        } else if (x == randomNumberX[7] && y == randomNumberY[7]) {
            if (swordLevel < 2) {
                System.out.println("| You found a iron sword" + Utils.printSpaces(16) + "|");
                System.out.println("| It was left on the side of this rock" + Utils.printSpaces(3) + "|");
                System.out.println("| It gives you +" + ((swordLevel == 1) ? "3" : "5") + " attack!" + Utils.printSpaces(16) + "|" + Utils.lnt);
                atk += ((swordLevel == 1) ? 3 : 5);
                swordLevel = 2;
            }
            movement();
        } else if (x == randomNumberX[8] && y == randomNumberY[8]) {
            if (!keyDoor1) {
                System.out.println(Strings.keyDoor1 + Utils.printSpaces(41 - Strings.keyDoor1.length()) + "|");
            }
        }
        else {
            movement();
        }
    }
}
