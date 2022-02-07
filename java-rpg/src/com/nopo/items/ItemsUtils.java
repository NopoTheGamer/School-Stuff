package com.nopo.items;

import com.nopo.Strings;
import com.nopo.Utils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static com.nopo.functions.Movement.movement;

public class ItemsUtils {

    public static String[] items = new String[10];

    public static String itemList1 = "";
    public static String itemList2 = "";

    public static void giveItem(String item, int Amount) {
        int amount = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                amount++;
                items[i] = item;
                if (amount == Amount) {
                    break;
                }
            }
        }
    }

    public static void inventory() {
        String itemList = Arrays.toString(items).replace("[", "").replace("]", "").replace(",", "").replace("null", "");
        Utils.printTrimmer();
        if (!itemList.equals("         ")) {
            if (itemList.trim().length() > 29) {
                int itemSplit = itemList.substring(0, 29).lastIndexOf(" ");
                itemList1 = itemList.substring(0, itemSplit);
                itemList2 = itemList.substring(itemSplit + 1, itemList.trim().length());
                Utils.printFormattedLine(Strings.inventory3);
                Utils.printFormattedLine(itemList1);
                Utils.printFormattedLine(itemList2);
                System.out.println(Utils.lt);
            } else {
                System.out.println("| You have: " + itemList.trim() + Utils.getSpaceLength(itemList.trim(), 6) + "|");
            }
            Utils.printFormattedLine(Strings.inventory1);
            Utils.printTrimmer();
            Scanner scanner = new Scanner(System.in);
            String item = scanner.nextLine();
            if (item.equals("n")) {
                movement();
            } else {
                for (int i = 0; items.length > i; i++) {
                    if (items[i] != null && item.toLowerCase(Locale.ENGLISH).equals(items[i].toLowerCase(Locale.ENGLISH))) {
                        switch (item.toLowerCase(Locale.ENGLISH)) {
                            case "apple" -> {
                                Items.apple();
                                items[i] = null;
                            }
                            case "key" -> {
                                Items.key(i);
                            }
                            case "cookie" -> {
                                Items.cookie();
                                items[i] = null;
                            }
                            case "potion" -> {
                                Items.potion();
                                items[i] = null;
                            }
                        }
                        break;
                    }
                }
            }
        } else {
            Utils.printFormattedLine(Strings.inventory2);
        }
        movement();
    }
}
