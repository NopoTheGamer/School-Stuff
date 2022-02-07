package com.nopo.functions;

import com.nopo.Strings;
import com.nopo.Utils;

import java.util.Locale;
import java.util.Scanner;

import static com.nopo.functions.Death.death;
import static com.nopo.functions.Fighting.fight;
import static com.nopo.items.ItemsUtils.getItem;
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
            Utils.printFormattedLine(Strings.lootChest1);
            if (!lootChest1) {
                Utils.printFormattedLine(Strings.lootChest2);
                coins += 10;
                Utils.printFormattedLine(Strings.lootChest3);
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
                    Utils.printFormattedLine(Strings.goblin1);
                } else {
                    Utils.printFormattedLine(Strings.goblin2);
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
                        fight(50, 3, "Short Goblin", 1);
                    }
                    case "n" -> {
                        hp -= 5;
                        Utils.printTrimmer();
                        Utils.printFormattedLine(Strings.goblin6);
                        Utils.printFormattedLine(Strings.goblin7);
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
                            getItem("Apple", 1);
                            movement();
                        } else {
                            Utils.printFormattedLine(Strings.appleTree4);
                            Utils.printFormattedLine(Strings.appleTree5);
                            hp -= 5;
                            Utils.printFormattedLine(Strings.goblin7);
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
                Utils.printFormattedLine(Strings.purse3);
                System.out.println(Utils.lt);
                purse1 = true;
            }
            movement();
        } else if (x == randomNumberX[5] && y == randomNumberY[5]) {
            if (!giantSpiderFight) {
                giantSpiderFight = true;
                Utils.printFormattedLine(Strings.giantSpider1);
                Utils.printFormattedLine(Strings.giantSpider2);
                fight(25, 6, "Giant Spider", 3);
            } else {
                movement();

            }
        } else if (x == randomNumberX[6] && y == randomNumberY[6]) {
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
            if (!keyDoor1) {
                Utils.printFormattedLine(Strings.keyDoor1);
                Utils.printFormattedLine(Strings.keyDoor2);
                System.out.println(Utils.lt);
            }
            movement();
        } else if (x == randomNumberX[9] && y == randomNumberY[9]) {
            Utils.printFormattedLine(Strings.dragon1);
            Utils.printFormattedLine(Strings.dragon2);
            Utils.printFormattedLine(Strings.dragon3);
            Utils.printFormattedLine(Strings.promptYesNo);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input.toLowerCase(Locale.ENGLISH)) {
                case "y" -> {
                    fight(50, 12, "Dragon", 6);
                }
                case "n" -> {
                    Utils.printTrimmer();
                    Utils.printFormattedLine(Strings.goblin7); //fix this when not lazy
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