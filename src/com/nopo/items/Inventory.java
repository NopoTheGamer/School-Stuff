package com.nopo.items;

import java.util.Arrays;
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
                    if (item.equals(items[i])) {
                        switch (item) {
                            case "apple" -> {
                                Apple.apple();
                                items[i] = null;
                            }
                        }
                        break;
                    }
                }
            }
        } else {
            System.out.println("You have nothing.");
        }
        movement();
    }
}
