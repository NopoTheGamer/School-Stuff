package com.nopo.functions;

import com.nopo.Utils;

import static com.nopo.Main.*;
import static com.nopo.functions.Fighting.fight;
import static com.nopo.functions.LocationCheck.isImportant;

public class GetLocation {
    public static void getLocation() {
        if (Shop.encounterStock) {
            if ((int) (Math.random() * 100) > 94) {
                System.out.println("A bat decides to attack you!");
                fight(5, 6, "Small bat", 2);
            }
        }
        if (x < 0) {
            System.out.println("You can't go that way");
            x = 0;
            getLocation();
        } else if (y < 0) {
            System.out.println("You can't go that way");
            y = 0;
            getLocation();
        } else if (x > 20) {
            System.out.println("You can't go that way");
            x = 20;
        } else if (y > 20) {
            System.out.println("You can't go that way");
            y = 20;
        }
        Utils.printTrimmer();
        System.out.println("| Your location is: x: " + x + ", y: " + y + Utils.getSpaceLength(x, 10) + Utils.getSpaceLength(y, 3) + "|");
        isImportant();
    }
}
