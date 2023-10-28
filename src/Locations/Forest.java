package Locations;

import Obstacles.Vampire;
import Player.Player;

import java.util.Random;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Anahtar 2",3, 1,art());

    }
    private   static String art(){

        return "                                                         .\n" +
                "                                              .         ;  \n" +
                "                 .              .              ;%     ;;   \n" +
                "                   ,           ,                :;%  %;   \n" +
                "                    :         ;                   :;%;'     .,   \n" +
                "           ,.        %;     %;            ;        %;'    ,;\n" +
                "             ;       ;%;  %%;        ,     %;    ;%;    ,%'\n" +
                "              %;       %;%;      ,  ;       %;  ;%;   ,%;' \n" +
                "               ;%;      %;        ;%;        % ;%;  ,%;'\n" +
                "                `%;.     ;%;     %;'         `;%%;.%;'\n" +
                "                 `:;%.    ;%%. %@;        %; ;@%;%'\n" +
                "                    `:%;.  :;bd%;          %;@%;'\n" +
                "                      `@%:.  :;%.         ;@@%;'   \n" +
                "                        `@%.  `;@%.      ;@@%;         \n" +
                "                          `@%%. `@%%    ;@@%;        \n" +
                "                            ;@%. :@%%  %@@%;       \n" +
                "                              %@bd%%%bd%%:;     \n" +
                "                                #@%%%%%:;;\n" +
                "                                %@@%%%::;\n" +
                "                                %@@@%(o);  . '         \n" +
                "                                %@@@o%;:(.,'         \n" +
                "                            `.. %@@@o%::;         \n" +
                "                               `)@@@o%::;         \n" +
                "                                %@@(o)::;        \n" +
                "                               .%@@@@%::;         \n" +
                "                               ;%@@@@%::;.          \n" +
                "                              ;%@@@@%%:;;;. \n" +
                "                          ...;%@@@@@%%:;;;;,..    ";
    }
}
