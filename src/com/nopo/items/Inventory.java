package com.nopo.items;

import java.util.Arrays;

import static com.nopo.functions.Movement.movement;

public class Inventory {

    public static String[] items = new String[10];

    public static void inventory() {
        String itemList = Arrays.toString(items).replace("[", "").replace("]", "").replace(",", "").replace("null", "");
        if (!itemList.equals("         ")) {
        System.out.println("You have: " + itemList);
        } else {
            System.out.println("You have nothing.");
        }
        movement();
    }
}
