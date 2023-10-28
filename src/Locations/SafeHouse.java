package Locations;

import Player.Player;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Güvenli Bölge");
    }

    @Override
    public boolean onLocation() throws InterruptedException {
        System.out.println("Güvenli Bölgedesiniz");
        System.out.println("           )\n" +
                "         ( _   _._\n" +
                "          |_|-'_~_`-._\n" +
                "       _.-'-_~_-~_-~-_`-._\n" +
                "   _.-'_~-_~-_-~-_~_~-_~-_`-._\n" +
                "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "    |  []  []   []   []  [] |\n" +
                "    |           __    ___   |\n" +
                "  ._|  []  []  | .|  [___]  |_._._._._._._._._._._._._._._._._.\n" +
                "  |=|________()|__|()_______|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|\n" +
                "^^^^^^^^^^^^^^^ === ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        Thread.sleep(500);
        System.out.println("CANINIZ YENİLENDİ");
        System.out.println();
        this.getPlayer().setHealthy(this.getPlayer().getOriginalHealth());
        return true;}
}
