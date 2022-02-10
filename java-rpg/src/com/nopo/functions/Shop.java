package com.nopo.functions;

import com.nopo.Strings;
import com.nopo.Utils;

import java.util.Locale;
import java.util.Scanner;

import static com.nopo.Main.coins;
import static com.nopo.items.ItemsUtils.giveItem;
import static com.nopo.functions.Movement.movement;

public class Shop {

    public static boolean keyStock = false;
    public static boolean encounterStock = false;
    public static boolean tpStock = false;
    public static int appleStock = 3;

    public static void shop() {
        listItemsForSale();
        if (coins < 3) {
            Utils.printFormattedLine(Strings.shop3);
            movement();
        } else {
            switch (Utils.textInput()) {
                case "apple" -> {
                    if (appleStock > 0) {
                        if (coins >= 3) {
                            giveItem("Apple", 1);
                            coins -= 3;
                            appleStock--;
                            shop();
                        } else {
                            Utils.printFormattedLine(Strings.notEnoughCoins);
                            shop();
                        }
                    } else {
                        Utils.printFormattedLine(Strings.outOfStock);
                        shop();
                    }
                }
                case "key" -> {
                    if (!keyStock) {
                        if (coins >= 25) {
                            giveItem("Key", 1);
                            coins -= 25;
                            keyStock = true;
                            shop();
                        } else {
                            Utils.printFormattedLine(Strings.notEnoughCoins);
                            shop();
                        }
                    } else {
                        Utils.printFormattedLine(Strings.outOfStock);
                        shop();
                    }
                }
                case "r" -> {
                    if (!encounterStock) {
                        if (coins >= 35) {
                            coins -= 35;
                            encounterStock = true;
                            shop();
                        } else {
                            Utils.printFormattedLine(Strings.notEnoughCoins);
                            shop();
                        }
                    } else {
                        Utils.printFormattedLine(Strings.outOfStock);
                        shop();
                    }
                }
                case "tp" -> {
                    if (!tpStock) {
                        if (coins >= 55) {
                            coins -= 55;
                            tpStock = true;
                            shop();
                        } else {
                            Utils.printFormattedLine(Strings.notEnoughCoins);
                            shop();
                        }
                    } else {
                        Utils.printFormattedLine(Strings.outOfStock);
                        shop();
                    }
                }
                case "exit" -> {
                    movement();
                }
                default -> {
                    Utils.printFormattedLine(Strings.dontHaveItem);
                    Utils.printFormattedLine(Strings.typeExit);
                    shop();
                }
            }
        }
    }
    public static void listItemsForSale() {
        Utils.printTrimmer();
        Utils.printFormattedLine(Strings.shop8);
        Utils.printFormattedLine(Strings.shop9);
        Utils.printTrimmer();
        Utils.printFormattedLine("You have " + coins + " coins.");
        if (appleStock > 0) {
            Utils.printFormattedLine("Apple (3 Coins) (" + appleStock + "x left)");
        }
        if (!keyStock) {
            Utils.printFormattedLine(Strings.shop12);
        }
        if (!encounterStock) {
            Utils.printFormattedLine(Strings.shop13);
        }
        if (!tpStock) {
            Utils.printFormattedLine("(tp) to known locations (55 Coins)");
        }
        if (keyStock && appleStock == 0 && encounterStock && tpStock) {
            Utils.printFormattedLine(Strings.shop14);
            Utils.printFormattedLine(Strings.shop15);
        }
        Utils.printTrimmer();
    }
}
