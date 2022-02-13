package com.nopo.functions;

import com.nopo.Strings;
import com.nopo.Utils;

import java.util.Locale;
import java.util.Scanner;

import static com.nopo.functions.Death.death;
import static com.nopo.functions.Fighting.fight;
import static com.nopo.items.ItemsUtils.giveItem;
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
    public static boolean foundKeyDoor = false;
    public static boolean dragonFight = false;
    public static boolean foundDragon = false;
    public static boolean manVSGorilla = false;
    public static boolean foundShop = false;

    public static int[] randomNumberX = new int[21];
    public static int[] randomNumberY = new int[21];

    public static void isImportant() {
        if (x == randomNumberX[0] && y == randomNumberY[0]) {
            Utils.printFormattedLine(Strings.lootChest1);
            if (!lootChest1) {
                Utils.printFormattedLine(Strings.lootChest2);
                coins += 10;
                Utils.printFormattedLine("You now have " + coins + " coins!");
                if (rngSeed > 50) {
                    Utils.printFormattedLine(Strings.lootChest4);
                    atk += 2;
                } else {
                    Utils.printFormattedLine(Strings.lootChest5);
                    def += 2;
                }
                lootChest1 = true;
            } else {
                Utils.printFormattedLine(Strings.lootChest6);
            }
            movement();
        } else if (x == randomNumberX[1] && y == randomNumberY[1]) {
            if (!goblinFight) {
                goblinFight = true;
                if (name.length() < 11) {
                    Utils.printFormattedLine("Look out " + name + "! There's a monster!");
                } else {
                    Utils.printFormattedLine("Look out " + name);
                    Utils.printFormattedLine(Strings.goblin3);
                }
                Utils.printFormattedLine(Strings.goblin4);
                Utils.printFormattedLine(Strings.promptYesNo);
                Utils.printTrimmer();
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                switch (input.toLowerCase(Locale.ENGLISH)) {
                    case "y" -> {
                        fight(50, 3, "Short Goblin", 1,"", 0, false);
                    }
                    case "n" -> {
                        hp -= 5;
                        Utils.printTrimmer();
                        Utils.printFormattedLine(Strings.goblin6);
                        Utils.printFormattedLine("Your hp is now: " + hp);
                        movement();
                    }
                    default -> {
                        goblinFight = false;
                        Utils.printTrimmer();
                        Utils.printFormattedLine(Strings.invalidInput);
                        isImportant();
                    }
                }
            } else {
                movement();
            }
        } else if (x == randomNumberX[2] && y == randomNumberY[2]) {
            if (!appleTree1) {
                Utils.printFormattedLine(Strings.appleTree1);
                Utils.printFormattedLine(Strings.appleTree2);
                Utils.printTrimmer();
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                Utils.printTrimmer();
                switch (input.toLowerCase(Locale.ENGLISH)) {
                    case "y" -> {
                        appleTree1 = true;
                        if (rngSeed > 20) {
                            Utils.printFormattedLine(Strings.appleTree3);
                            giveItem("Apple", 1);
                            movement();
                        } else {
                            Utils.printFormattedLine(Strings.appleTree4);
                            Utils.printFormattedLine(Strings.appleTree5);
                            hp -= 5;
                            Utils.printFormattedLine("Your hp is now: " + hp);
                            if (hp < 1) {
                                death();
                            } else {
                                movement();
                            }
                        }
                    }
                    case "n" -> {
                        Utils.printFormattedLine(Strings.appleTree6);
                        movement();
                    }
                    default -> {
                        Utils.printFormattedLine(Strings.invalidInput);
                        isImportant();
                    }
                }
            } else {
                movement();
            }
        } else if (x == randomNumberX[3] && y == randomNumberY[3]) {
            if (swordLevel < 1) {
                Utils.printFormattedLine(Strings.rustySword1);
                Utils.printFormattedLine(Strings.rustySword2);
                Utils.printFormattedLine(Strings.rustySword3);
                System.out.println(Utils.lt);
                swordLevel = 1;
                atk += 3;
            }
            movement();
        } else if (x == randomNumberX[4] && y == randomNumberY[4]) {
            if (!purse1) {
                coins += 10;
                Utils.printFormattedLine(Strings.purse1);
                Utils.printFormattedLine(Strings.purse2);
                Utils.printFormattedLine("You now have " + coins + " coins!");
                System.out.println(Utils.lt);
                purse1 = true;
            }
            movement();
        } else if (x == randomNumberX[5] && y == randomNumberY[5]) {
            if (!giantSpiderFight) {
                giantSpiderFight = true;
                Utils.printFormattedLine("Look out " + name + "!");
                Utils.printFormattedLine(Strings.giantSpider2);
                fight(25, 6, "Giant Spider", 3, "", 0, false);
            } else {
                movement();

            }
        } else if (x == randomNumberX[6] && y == randomNumberY[6]) {
            foundShop = true;
            Utils.printFormattedLine(Strings.shop1);
            Utils.printFormattedLine(Strings.shop2);
            Utils.printTrimmer();
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().toLowerCase(Locale.ENGLISH).equals("y")) {
                shop();
            } else {
                movement();
            }
        } else if (x == randomNumberX[7] && y == randomNumberY[7]) {
            if (swordLevel < 2) {
                Utils.printFormattedLine(Strings.ironSword1);
                Utils.printFormattedLine(Strings.ironSword2);
                System.out.println("| It gives you +" + ((swordLevel == 1) ? "3" : "5") + " attack!" + Utils.printSpaces(16) + "|" + Utils.lnt);
                atk += ((swordLevel == 1) ? 3 : 5);
                swordLevel = 2;
            }
            movement();
        } else if (x == randomNumberX[8] && y == randomNumberY[8]) {
            foundKeyDoor = true;
            if (!keyDoor1) {
                Utils.printFormattedLine(Strings.keyDoor1);
                Utils.printFormattedLine(Strings.keyDoor2);
                System.out.println(Utils.lt);
            }
            movement();
        } else if (x == randomNumberX[9] && y == randomNumberY[9]) {
            if (!dragonFight) {
                foundDragon = true;
                Utils.printFormattedLine(Strings.dragon1);
                Utils.printFormattedLine(Strings.dragon2);
                Utils.printFormattedLine(Strings.dragon3);
                Utils.printFormattedLine(Strings.promptYesNo);
                Utils.printTrimmer();
                switch (Utils.textInput()) {
                    case "y" -> {
                        System.out.println();
                        dragonFight = true;
                        foundDragon = false;
                        fight(50, 12, "Dragon", 6, "Potion", 2, false);
                    }
                    case "n" -> {
                        Utils.printTrimmer();
                        Utils.printFormattedLine(Strings.dragon4);
                        movement();
                    }
                    default -> {
                        Utils.printTrimmer();
                        Utils.printFormattedLine(Strings.invalidInput);
                        isImportant();
                    }
                }
            }
        } else if (x == randomNumberX[10] && y == randomNumberY[10]) {
            if (!manVSGorilla) {
                Utils.printFormattedLine("You enter a forest.");
                Utils.printFormattedLine("You spot a gorilla");
                Utils.printFormattedLine("Do you walk upto it?");
                Utils.printFormattedLine(Strings.promptYesNo);
                Utils.printTrimmer();
                switch (Utils.textInput()) {
                    case "y" -> {
                        Utils.printTrimmer();
                        Utils.printFormattedLine("The gorilla notices you.");
                        Utils.printFormattedLine("It reaches out");
                        Utils.printFormattedLine("You get given a banana gun");
                        Utils.printFormattedLine("+5 attack");
                        atk += 5;
                        manVSGorilla = true;
                    }
                    case "n" -> {
                        Utils.printTrimmer();
                        Utils.printFormattedLine("You get away quickly");
                        manVSGorilla = true;
                    }
                    default -> {
                        Utils.printTrimmer();
                        Utils.printFormattedLine(Strings.invalidInput);
                        isImportant();
                    }
                }
                movement();
            } else {
                movement();
            }
        } else if (x == randomNumberX[11] && y == randomNumberY[11]) {
            Utils.printTrimmer();
            Utils.printFormattedLine("You found a coliseum!");
            Utils.printFormattedLine("Do you want to enter?");
            Utils.printFormattedLine(Strings.promptYesNo);
            Utils.printTrimmer();
            switch (Utils.textInput()) {
                case "y" -> {
                    BattleHouse.enter();
                }
                case "n" -> {
                    movement();
                }
                default -> {
                    Utils.printTrimmer();
                    Utils.printFormattedLine(Strings.invalidInput);
                    isImportant();
                }
            }
        }
        else {
            movement();
        }
    }
}
