package com.nopo.functions;

import static com.nopo.Main.*;
import static com.nopo.functions.LocationCheck.isImportant;

public class GetLocation {
    public static void getLocation() {
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
        System.out.println("Your location is: x: " + x + ", y: " + y);
        isImportant();
    }
}
