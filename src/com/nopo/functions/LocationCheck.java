package com.nopo.functions;

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
    public static boolean hasSword = false;
    public static int swordLevel = 0;
    public static boolean purse1 = false;
    public static boolean goblinFight = false;
    public static boolean giantSpiderFight = false;


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
                System.out.println("");
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
                System.out.println("| Looks like an apple tree!" + Utils.printSpaces(13) + "|");
                System.out.println("| Do you want to shake it? (y/n)");
                Scanner scanner = new Scanner(System.in);
                if (scanner.nextLine().equals("y")) {
                    if (rngSeed > 20) {
                        System.out.println("You found an apple!");
                        getItem("Apple", 1);
                        movement();
                    } else {
                        System.out.println("Some bees attacked you!" + Utils.ln + "You got hit for 5 hp");
                        hp -= 5;
                        if (hp < 1) {
                            death();
                        } else {
                            movement();
                        }
                    }
                    appleTree1 = true;
                } else if (scanner.nextLine().equals("n")) {
                    System.out.println("You didn't shake it!");
                } else {
                    System.out.println("Invalid input");
                }
            }
        } else if (x == randomNumberX[3] && y == randomNumberY[3]) {
            if (!hasSword || swordLevel < 1) {
                System.out.println("You found a rusty sword lying on the ground!");
                System.out.println("This will give you +3 attack!");
                swordLevel = 1;
                hasSword = true;
                atk += 3;
            }
            movement();
        } else if (x == randomNumberX[4] && y == randomNumberY[4]) {
            if (!purse1) {
                System.out.println("Looks like someone dropped their purse!" + Utils.ln + "You took the money from the purse!");
                coins += 10;
                System.out.println("You now have " + coins + " coins!");
                movement();
            }
        } else if (x == randomNumberX[5] && y == randomNumberY[5]) {
            if (!giantSpiderFight) {
                giantSpiderFight = true;
                System.out.println("Look out " + name + "! There's a giant spider!");
                fight(25, 6, "Giant Spider", 3);
            } else {
                movement();

            }
        } else if (x == randomNumberX[6] && y == randomNumberY[6]) {
            System.out.println("There is a shop!" + Utils.ln + "Would you like to go inside? (y/n)");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("y")) {
                shop();
            } else {
                movement();
            }
        }
        else {
            movement();
        }
    }
}
