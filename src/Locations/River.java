package Locations;

import Obstacles.Bear;
import Player.Player;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "Nehir", new Bear(), "Anahtar 3",1, 2,art());
    }

    private  static String art(){
        return  "                  _.._\n" +
                "   _________....-~    ~-.______\n" +
                "~~~                            ~~~~-----...___________..--------\n" +
                "                                           |   |     |\n" +
                "                                           | |   |  ||\n" +
                "                                           |  |  |   |\n" +
                "                                           |'. .' .`.|\n" +
                "___________________________________________|0oOO0oO0o|____________\n" +
                " -          -         -       -      -    / '  '. ` ` \\    -    -\n" +
                "      --                  --       --   /    '  . `   ` \\    --\n" +
                "---            ---          ---       /  '                \\ ---\n" +
                "     ----               ----        /       ' ' .    ` `    \\  ----\n" +
                "-----         -----         ----- /   '   '        `      `   \\\n" +
                "     .-~~-.          ------     /          '    . `     `    `  \\\n" +
                "     - ---  -------           /  '    '      '      `\n" +
                "-------------       --------/     '     '   '";
    }
}
