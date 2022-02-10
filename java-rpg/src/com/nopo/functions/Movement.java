package com.nopo.functions;

import com.nopo.Utils;
import com.nopo.items.ItemsUtils;

import static com.nopo.Main.*;
import static com.nopo.functions.GetLocation.getLocation;
import static com.nopo.functions.LocationCheck.randomNumberX;
import static com.nopo.functions.LocationCheck.randomNumberY;
import static com.nopo.items.ItemsUtils.inventory;
import static com.nopo.items.ItemsUtils.items;

public class Movement {
    public static void movement() {
        System.out.println("| What do you want to do?" + Utils.printSpaces(16) + "|");
        System.out.println("| Move (w/a/s/d) | (inv)entory | (stats) |");
        Utils.printTrimmer();
        System.out.println();
        switch (Utils.textInput()) {
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
                System.out.println("Tree X: " + randomNumberX[2] + " Y: " + randomNumberY[2]);
                System.out.println("Sword X: " + randomNumberX[3] + " Y: " + randomNumberY[3]);
                System.out.println("Purse X: " + randomNumberX[4] + " Y: " + randomNumberY[4]);
                System.out.println("Spider X: " + randomNumberX[5] + " Y: " + randomNumberY[5]);
                ItemsUtils.giveItem("Key", 8);
                getLocation();
            }
            case "ai" -> {
                for (int i = 0; i < items.length; i++) {
                    items[i] = "" + i;
                }
                movement();
            }
            case "stats" -> {
                Utils.printTrimmer();
                System.out.println("| Health: " + hp + Utils.getSpaceLength(hp, 31) + "|");
                System.out.println("| Defence: " + def + Utils.getSpaceLength(def, 30) + "|");
                System.out.println("| Attack: " + atk + Utils.getSpaceLength(atk, 31) + "|");
                System.out.println("| Coins: " + coins + Utils.getSpaceLength(coins, 32) + "|");
                System.out.println(Utils.lt);
                movement();
            }
            case "suicide" -> {
                Death.death();
            }
            default -> {
                System.out.println("Invalid input");
                movement();
            }
        }
    }
}
