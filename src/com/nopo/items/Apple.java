package com.nopo.items;

import static com.nopo.Main.hp;
import static com.nopo.functions.Startup.rngSeed;

public class Apple {
    public static boolean badApple = false;
    public static void apple() {
        if (rngSeed > 94 && !badApple) {
            badApple = true;
            System.out.println("That apple must of been rotten.");
            hp -= 5;
            System.out.println("You lost 5 HP. Your health is now " + hp);
        } else {
            System.out.println("You ate the apple and gained 10 HP!");
            hp += 10;
            System.out.println("Your health is now " + hp);
        }
    }
}
