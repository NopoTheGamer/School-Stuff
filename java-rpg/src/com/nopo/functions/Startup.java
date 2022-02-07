package com.nopo.functions;

import com.nopo.Strings;
import com.nopo.Utils;

import java.util.Scanner;

import static com.nopo.Main.*;
import static com.nopo.functions.LocationCheck.randomNumberX;
import static com.nopo.functions.LocationCheck.randomNumberY;

public class Startup {

    public static int rngSeed = 0;

    public static void startUp() {
        for (int i = 0; i < 21; i++) {
            randomNumberX[i] = (int) (Math.random() * 20);
            randomNumberY[i] = (int) (Math.random() * 20);
        }
        rngSeed = (int) (Math.random() * 100);
        System.out.println(rngSeed);
        x = randomNumberX[10];
        y = randomNumberY[10];
        Scanner scanner = new Scanner(System.in);
        Utils.printTrimmer();
        Utils.printFormattedLine(Strings.inputName);
        Utils.printTrimmer();
        name = scanner.nextLine();
        Utils.printTrimmer();
        if (name.length() > 30) {
            Utils.printFormattedLine(Strings.tooLong);
            Utils.printFormattedLine(Strings.trimmed);
            name = name.substring(0, 30);
        }
        System.out.println("| Hello \"" + name + "\"" + Utils.getSpaceLength(name, 4) + "|");
        Utils.printFormattedLine(Strings.welcome);
        Utils.printTrimmer();
        System.out.println();
        GetLocation.getLocation();
    }
}
