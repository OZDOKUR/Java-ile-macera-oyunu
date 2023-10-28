import Locations.*;
import Player.*;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    public void start() throws InterruptedException {
        System.out.println("Macera Oyununa Hoşgeldiniz");
        Player player = new Player();
        System.out.println("Bir Karakter Seçiniz!");
        player.selectCharacter();
        Location location = null;
        while (true){
            Thread.sleep(500);
            player.printInfo();
            Thread.sleep(500);
            System.out.println();
            System.out.println();
            System.out.println("############ Bölgeler ###########");
            System.out.println("# 1 - Güvenli Ev                #");
            System.out.println("# 2 - Eşya Dükkanı              #");
            System.out.println("# 3 - Mağara     <Madalya 1>    #");
            System.out.println("# 4 - Orman      <Madalya 2>    #");
            System.out.println("# 5 - Nehir      <Madalya 3>    #");
            System.out.println("# 6 - Maden      <Madalya 4>    #");
            System.out.println("# 0 - Çıkış Yap                 #");
            System.out.println("#################################");
            int selectLocation = scanner.nextInt();
            location = switch (selectLocation) {
                case 0 -> null;
                case 1 -> new SafeHouse(player);
                case 2 -> new ToolStore(player);
                case 3 -> new Cave(player);
                case 4 -> new Forest(player);
                case 5 -> new River(player);
                case 6 -> new Mine(player);
                default -> new SafeHouse(player);
            };
            if (location == null){
                System.out.println("Oyundan Çıkılıyor...");
                System.out.println("Oyundan çıkıldı");
                break;
            }
            if(!location.onLocation())
            {
                System.out.println("OYUN BİTTİ");
                break;
            }
            if(location instanceof SafeHouse){
                boolean allTrue = true;
                for (int i = 0; i < (player.getAward()).length; i++) {
                    if (!(player.getAward()[i])) {
                        allTrue = false;
                        break;
                    }
                }
                if (allTrue){
                    System.out.println(" /$$$$$$$$ /$$$$$$$$ /$$$$$$$  /$$$$$$$  /$$$$$$ /$$   /$$       /$$$$$$$$ /$$$$$$$  /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$      /$$\n" +
                            "|__  $$__/| $$_____/| $$__  $$| $$__  $$|_  $$_/| $$  /$$/      | $$_____/| $$__  $$| $$_____/| $$__  $$|_  $$_/| $$$    /$$$\n" +
                            "   | $$   | $$      | $$  \\ $$| $$  \\ $$  | $$  | $$ /$$/       | $$      | $$  \\ $$| $$      | $$  \\ $$  | $$  | $$$$  /$$$$\n" +
                            "   | $$   | $$$$$   | $$$$$$$ | $$$$$$$/  | $$  | $$$$$/        | $$$$$   | $$  | $$| $$$$$   | $$$$$$$/  | $$  | $$ $$/$$ $$\n" +
                            "   | $$   | $$__/   | $$__  $$| $$__  $$  | $$  | $$  $$        | $$__/   | $$  | $$| $$__/   | $$__  $$  | $$  | $$  $$$| $$\n" +
                            "   | $$   | $$      | $$  \\ $$| $$  \\ $$  | $$  | $$\\  $$       | $$      | $$  | $$| $$      | $$  \\ $$  | $$  | $$\\  $ | $$\n" +
                            "   | $$   | $$$$$$$$| $$$$$$$/| $$  | $$ /$$$$$$| $$ \\  $$      | $$$$$$$$| $$$$$$$/| $$$$$$$$| $$  | $$ /$$$$$$| $$ \\/  | $$\n" +
                            "   |__/   |________/|_______/ |__/  |__/|______/|__/  \\__/      |________/|_______/ |________/|__/  |__/|______/|__/     |__/\n" +
                            "                                                                                                                             \n" +
                            "                                                                                                                             \n" +
                            "                                                                                                                             \n" +
                            " /$$   /$$  /$$$$$$  /$$$$$$$$  /$$$$$$  /$$   /$$ /$$$$$$$  /$$$$$$ /$$   /$$ /$$$$$$ /$$$$$$$$                             \n" +
                            "| $$  /$$/ /$$__  $$|_____ $$  /$$__  $$| $$$ | $$| $$__  $$|_  $$_/| $$$ | $$|_  $$_/|_____ $$                              \n" +
                            "| $$ /$$/ | $$  \\ $$     /$$/ | $$  \\ $$| $$$$| $$| $$  \\ $$  | $$  | $$$$| $$  | $$       /$$/                              \n" +
                            "| $$$$$/  | $$$$$$$$    /$$/  | $$$$$$$$| $$ $$ $$| $$  | $$  | $$  | $$ $$ $$  | $$      /$$/                               \n" +
                            "| $$  $$  | $$__  $$   /$$/   | $$__  $$| $$  $$$$| $$  | $$  | $$  | $$  $$$$  | $$     /$$/                                \n" +
                            "| $$\\  $$ | $$  | $$  /$$/    | $$  | $$| $$\\  $$$| $$  | $$  | $$  | $$\\  $$$  | $$    /$$/                                 \n" +
                            "| $$ \\  $$| $$  | $$ /$$$$$$$$| $$  | $$| $$ \\  $$| $$$$$$$/ /$$$$$$| $$ \\  $$ /$$$$$$ /$$$$$$$$                             \n" +
                            "|__/  \\__/|__/  |__/|________/|__/  |__/|__/  \\__/|_______/ |______/|__/  \\__/|______/|________/    ");
                    break;
                }
            }

        }
    }
}
