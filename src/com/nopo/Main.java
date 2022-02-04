package com.nopo;

import com.nopo.functions.Startup;

import java.util.Scanner;

import static com.nopo.functions.Death.death;
import static com.nopo.functions.GetLocation.getLocation;
import static com.nopo.functions.LocationCheck.isImportant;
import static com.nopo.functions.Movement.movement;

public class Main {

    public static String ln = System.lineSeparator();
    public static String name = "Nopo";

    public static int x = 0;
    public static int y = 0;
    //Player stats
    public static int hp = 4;
    public static int atk = 2;
    public static int def = 4;
    public static int coins = 0;
    //Fight stats
    public static int monsterHealth = 0;
    public static int monsterAttack = 0;

    public static void main(String[] args) {
        Startup.startUp();
        getLocation();
    }
}