package Locations;

import Player.Player;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    public static Scanner scanner = new Scanner(System.in);
    public abstract boolean onLocation() throws InterruptedException;

    public static void selectLocation(){
    }
    public Location(Player player,String name) {
        this.player = player;
        this.name = name;

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
