package com.nopo.functions;

import static com.nopo.functions.GetLocation.getLocation;
import static com.nopo.functions.LocationCheck.randomNumberX;
import static com.nopo.functions.LocationCheck.randomNumberY;
import static com.nopo.functions.Movement.movement;
import static com.nopo.Main.*;

public class Death {
    public static int deathCount = 0;
    public static void death() {
        deathCount ++;
        if (deathCount > 18) {
            deathCount = 0;
        }
        x = randomNumberX[10 + deathCount];
        y = randomNumberY[10 + deathCount];
        hp = 75;
        System.out.println("You died!");
        coins /= 2;
        if (coins > 0) {
            System.out.println("You lost half your coins!" + ln + "You now have " + coins + " coins");
        }
        movement();
    }
}
