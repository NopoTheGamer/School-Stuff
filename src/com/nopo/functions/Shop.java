package com.nopo.functions;

import com.nopo.Utils;

import java.util.Locale;
import java.util.Scanner;

import static com.nopo.Main.coins;
import static com.nopo.Utils.ln;
import static com.nopo.functions.GetItem.getItem;
import static com.nopo.functions.Movement.movement;

public class Shop {

    public static boolean keyStock = false;
    public static boolean encounterStock = false;
    public static int appleStock = 3;

    public static void shop() {
        listItemsForSale();
        if (coins < 3) {
            System.out.println("You don't have enough coins to buy anything.");
            movement();
        } else {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input.toLowerCase(Locale.ENGLISH)) {
                case "apple" -> {
                    if (appleStock > 0) {
                        if (coins >= 3) {
                            getItem("Apple", 1);
                            coins -= 3;
                            appleStock--;
                            shop();
                        } else {
                            System.out.println("You don't have enough coins to buy this item.");
                            shop();
                        }
                    } else {
                        System.out.println("Sorry, we're out of stock of this item.");
                        shop();
                    }
                }
                case "key" -> {
                    if (!keyStock) {
                        if (coins >= 25) {
                            getItem("Key", 1);
                            coins -= 25;
                            keyStock = true;
                            shop();
                        } else {
                            System.out.println("You don't have enough coins to buy this item.");
                            shop();
                        }
                    } else {
                        System.out.println("Sorry, we're out of stock of this item.");
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
                            System.out.println("You don't have enough coins to buy this item.");
                            shop();
                        }
                    } else {
                        System.out.println("Sorry, we're out of stock of this item.");
                        shop();
                    }
                }
                case "exit" -> {
                    movement();
                }
                default -> {
                    System.out.println("We dont have that item." + ln + "If you want to exit, type 'exit'");
                    shop();
                }
            }
        }
    }
    public static void listItemsForSale() {

        System.out.println("Welcome to the shop!");
        System.out.println("What would you like to buy?");
        Utils.printTrimmer();
        System.out.println("| You have " + coins + " coins." + Utils.getSpaceLength(coins, 23) + "|");
        if (appleStock > 0) {
            System.out.println("| Apple (3 Coins) (" + appleStock + "x left)" + Utils.printSpaces(14) + "|");
        }
        if (!keyStock) {
            System.out.println("| Key (25 Coins)" + Utils.printSpaces(25) + "|");
        }
        if (keyStock && appleStock == 0 && encounterStock) {
            System.out.println("| This shop is out of stock!" + Utils.printSpaces(13) + "|" + ln + "| Type 'exit' to exit" + Utils.printSpaces(20) + "|");
        }
        if (!encounterStock) {
            System.out.println("| (R)andom encounters (35 Coins)" + Utils.printSpaces(9) + "|");
        }
        Utils.printTrimmer();
    }
}
