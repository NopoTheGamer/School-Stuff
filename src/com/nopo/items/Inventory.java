package com.nopo.items;

import com.nopo.Utils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static com.nopo.functions.Movement.movement;

public class Inventory {

    public static String[] items = new String[10];

    public static void inventory() {
        String itemList = Arrays.toString(items).replace("[", "").replace("]", "").replace(",", "").replace("null", "");
        if (!itemList.equals("         ")) {
            System.out.println("You have: " + itemList.trim());
            System.out.println("Do you want to use an item? (say item name/n)");
            Scanner scanner = new Scanner(System.in);
            String item = scanner.nextLine();
            if (item.equals("n")) {
                movement();
            } else {
                for (int i = 0; items.length > i; i++) {
                    if (items[i] != null && item.toLowerCase(Locale.ENGLISH).equals(items[i].toLowerCase(Locale.ENGLISH))) {
                        switch (item.toLowerCase(Locale.ENGLISH)) {
                            case "apple" -> {
                                Apple.apple();
                                items[i] = null;
                            }
                            case "key" -> {
                                System.out.println("You used key");
                                items[i] = null;
                            }
                        }
                        break;
                    }
                }
            }
        } else {
            Utils.printTrimmer();
            System.out.println("| You have nothing." + Utils.printSpaces(22) + "|");
        }
        movement();
    }
}
