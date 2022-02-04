package com.nopo.functions;

import java.util.Scanner;

import static com.nopo.Main.*;
import static com.nopo.functions.LocationCheck.randomNumberX;
import static com.nopo.functions.LocationCheck.randomNumberY;

public class Startup {

    public static int rngSeed = 0;

    public static void startUp() {
        for (int i = 0; i < 21; i++) {
            randomNumberX[i] = (int) (Math.random() * 10);
            randomNumberY[i] = (int) (Math.random() * 10);
        }
        rngSeed = (int) (Math.random() * 100);
        System.out.println(rngSeed);
        x = randomNumberX[2];
        y = randomNumberY[2];
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Input your characters name");
        //name = scanner.nextLine();
        System.out.println("Hello \"" + name + "\"" + ln + "Welcome to the world of Nopo");
    }
}
