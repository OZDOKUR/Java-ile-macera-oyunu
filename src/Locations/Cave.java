package Locations;

import Obstacles.Zombie;
import Player.Player;

import java.util.Random;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player,"Mağara", new Zombie(), "Ödül 1",3,0,art());
    }

    private   static String art(){
        return  "           ,                  /\\.__      _.-\\\n" +
                "          /~\\,      __       /~    \\   ./    \\\n" +
                "        ,/  /_\\   _/  \\    ,/~,_.~'\"\\ /_\\_  /'\\\n" +
                "       / \\ /## \\ / V#\\/\\  /~8#  # ## V8  #\\/8 8\\\n" +
                "     /~#------##V&#&# ##\\/88#\"#8# #\" #\\#&\"##\" ##\\\n" +
                "    j# #|     |#\"#\\&&\"####/###&  #\"#&## #&\" #\"#&#\"#'\\\n" +
                "   /#\"#\"|     |###'\\&##\"/&#\"####\"### # #&#&##\"#\"### \\\n" +
                "  J#\"###|     |####'\\# #\"##\"#\"##\"#\"#####&\"## \"#\"&\"##|\\";
    }
}
