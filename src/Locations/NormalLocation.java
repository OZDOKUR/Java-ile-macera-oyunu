package Locations;

import Player.Player;

public abstract class NormalLocation extends Location{
    public NormalLocation(Player player, String name) {
        super(player, name);
    }
    @Override
    public boolean onLocation() throws InterruptedException {return true;}
}
