package com.nopo.items;

import com.nopo.Strings;
import com.nopo.Utils;
import com.nopo.functions.LocationCheck;

import static com.nopo.Main.*;
import static com.nopo.functions.LocationCheck.*;
import static com.nopo.functions.Startup.rngSeed;

public class Items {

    public static boolean badApple = false;
    public static boolean hpOver100 = false;

    public static void apple() {
        Utils.printTrimmer();
        if (rngSeed > 94 && !badApple) {
            badApple = true;
            Utils.printFormattedLine(Strings.apple1);
            hp -= 5;
            Utils.printFormattedLine("You lost 5 HP. Your health is now " + hp);
        } else {
            Utils.printFormattedLine(Strings.apple2);
            hp += 10;
            Utils.printFormattedLine("Your health is now " + hp);
        }
    }

    public static void key(int itemSlot) {
        Utils.printTrimmer();
        if (x == randomNumberX[8] && y == randomNumberY[8] && !keyDoor1) {
            ItemsUtils.items[itemSlot] = null;
            def += 5;
            coins += 35;
            ItemsUtils.giveItem("Cookie", 1);
            Utils.printFormattedLine(Strings.key1);
            Utils.printFormattedLine(Strings.key2);
            Utils.printFormattedLine(Strings.key3);
            Utils.printFormattedLine(Strings.key4);
            Utils.printFormattedLine(Strings.key5);
            Utils.printFormattedLine(Strings.key6);
            Utils.printFormattedLine(Strings.key7);
            Utils.printTrimmer();
            LocationCheck.keyDoor1 = true;
        } else {
            Utils.printFormattedLine(Strings.wrongKeySpot);
        }
    }

    public static void cookie() {
        Utils.printTrimmer();
        if (rngSeed > 35 && rngSeed < 45) {
            hp -= 5;
            Utils.printFormattedLine(Strings.cookieBad);
            Utils.printFormattedLine(Strings.cookieBad1);
            Utils.printFormattedLine("You lost 5 HP. You have " + hp + " HP");
        } else {
            hp += 10;
            Utils.printFormattedLine(Strings.cookieGood);
            Utils.printFormattedLine("Your health is now: " + hp);
        }
    }

    public static void potion() {
        if (hp < 100) {
            hp += 20;
            hpOver100 = false;
        } else {
            hp += 5;
            hpOver100 = true;
        }
        atk += 5;
        def += 3;
        Utils.printFormattedLine(Strings.potion1);
        Utils.printFormattedLine(Strings.potion2);
        Utils.printFormattedLine((hpOver100) ? "You gained 5 hp" : "You gained 20 hp");
        Utils.printFormattedLine("You now have " + hp + " HP");
        Utils.printFormattedLine(Strings.potion3);
        Utils.printFormattedLine(Strings.potion4);
    }
}
