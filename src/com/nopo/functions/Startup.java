package com.nopo.functions;

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
        x = randomNumberX[8];
        y = randomNumberY[8];
        //Scanner scanner = new Scanner(System.in);
        Utils.printTrimmer();
        System.out.println("| Input your characters name" + Utils.printSpaces(13) + "|");
        Utils.printTrimmer();
        //name = scanner.nextLine();
        Utils.printTrimmer();
        if (name.length() > 30) {
            System.out.println("| Your name is too long, " + Utils.printSpaces(16) + "|");
            System.out.println("| so I trimmed it for you" + Utils.printSpaces(16) + "|");
            name = name.substring(0, 30);
        }
        System.out.println("| Hello \"" + name + "\"" + Utils.getSpaceLength(name, 4) + "|" + Utils.ln +
                           "| Welcome to the world of Nopo" + Utils.printSpaces(11) + "|");
        Utils.printTrimmer();
        System.out.println("");
    }
}
