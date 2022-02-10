package com.nopo.functions;

import com.nopo.Main;
import com.nopo.Utils;

import static com.nopo.functions.LocationCheck.*;

public class Map {
    public static void map() {
        Utils.printTrimmer();
        Utils.printFormattedLine("Shop " + ((LocationCheck.foundShop) ? "x: " + randomNumberX[6] + ", y: " + randomNumberY[6] : "not found"));
        Utils.printFormattedLine("Key Door " + ((LocationCheck.foundKeyDoor) ? "x: " + randomNumberX[8] + ", y: " + randomNumberY[8] : "not found"));
        Utils.printFormattedLine("Dragon " + ((LocationCheck.foundDragon) ? "x: " + randomNumberX[9] + ", y: " + randomNumberY[9] : "not found"));
        if (Shop.tpStock) {
            Utils.printFormattedLine("Would you like to teleport somewhere?");
            Utils.printTrimmer();
            tpStockSwitch();
        }
        Utils.printTrimmer();
        Movement.movement();
    }
    public static void tpStockSwitch() {
        switch (Utils.textInput()) {
            case "yes" -> {
                Utils.printTrimmer();
                Utils.printFormattedLine("Where would you like to go?");
                Utils.printTrimmer();
                tpStockSwitch();
            }
            case "no" -> {
                Utils.printTrimmer();
                Movement.movement();
            }
            case "shop" -> {
                if (foundShop) {
                    Main.x = randomNumberX[6];
                    Main.y = randomNumberY[6];
                    Utils.printTrimmer();
                    LocationCheck.isImportant();
                } else {
                    Utils.printTrimmer();
                    Utils.printFormattedLine("You can't go there.");
                }
            }
            case "key door", "key", "door" -> {
                if (foundKeyDoor) {
                    Main.x = randomNumberX[8];
                    Main.y = randomNumberY[8];
                    Utils.printTrimmer();
                    LocationCheck.isImportant();
                } else {
                    Utils.printTrimmer();
                    Utils.printFormattedLine("You can't go there.");
                }
            }
            case "dragon" -> {
                if (foundDragon) {
                    Main.x = randomNumberX[9];
                    Main.y = randomNumberY[9];
                    Utils.printTrimmer();
                    LocationCheck.isImportant();
                } else {
                    Utils.printTrimmer();
                    Utils.printFormattedLine("You can't go there.");
                }
            }
        }
    }
}
