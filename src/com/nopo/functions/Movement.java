package com.nopo.functions;

import com.nopo.Utils;

import java.util.Scanner;
import static com.nopo.Main.*;

import static com.nopo.functions.GetLocation.getLocation;
import static com.nopo.items.Inventory.inventory;
import static com.nopo.items.Inventory.items;
import static com.nopo.functions.LocationCheck.randomNumberX;
import static com.nopo.functions.LocationCheck.randomNumberY;

public class Movement {
    public static void movement() {
        System.out.println("| What do you want to do?" + Utils.printSpaces(16) + "|");
        System.out.println("| Move (w/a/s/d) | (inv)entory |  (map)  |");
        Utils.printTrimmer();
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "w" -> {
                y++;
                getLocation();
            }
            case "s" -> {
                y--;
                getLocation();
            }
            case "a" -> {
                x--;
                getLocation();
            }
            case "d" -> {
                x++;
                getLocation();
            }
            case "inv" -> {
                inventory();
            }
            case "cheat" -> {
                System.out.println("Chest X: " + randomNumberX[0] + " Y: " + randomNumberY[0]);
                System.out.println("Goblin X: " + randomNumberX[1] + " Y: " + randomNumberY[1]);
                getLocation();
            }
            case "ai" -> {
                for (int i = 0; i < items.length; i++) {
                    items[i] = "" + i;
                }
                movement();
            }
            default -> {
                System.out.println("Invalid input");
                movement();
            }
        }
    }
}
