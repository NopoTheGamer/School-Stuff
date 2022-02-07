package com.nopo;

import com.nopo.functions.Startup;

import static com.nopo.functions.GetLocation.getLocation;

public class Main {

    public static String name = "Nopo";

    public static int x = 0;
    public static int y = 0;
    //Player stats
    public static int hp = 100;
    public static int atk = 3;
    public static int def = 4;
    public static int coins = 30;
    //Fight stats
    public static int monsterHealth = 0;
    public static int monsterAttack = 0;

    public static void main(String[] args) {
        Startup.startUp();
        getLocation();
    }
}