package Locations;

import Player.*;

public class ToolStore extends NormalLocation{
    private int selectCase;

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    @Override
    public boolean onLocation() throws InterruptedException {
        System.out.println("                                   /\\\n" +
                "                              /\\  //\\\\\n" +
                "                       /\\    //\\\\///\\\\\\        /\\\n" +
                "                      //\\\\  ///\\////\\\\\\\\  /\\  //\\\\\n" +
                "         /\\          /  ^ \\/^ ^/^  ^  ^ \\/^ \\/  ^ \\\n" +
                "        / ^\\    /\\  / ^   /  ^/ ^ ^ ^   ^\\ ^/  ^^  \\\n" +
                "       /^   \\  / ^\\/ ^ ^   ^ / ^  ^    ^  \\/ ^   ^  \\       *\n" +
                "      /  ^ ^ \\/^  ^\\ ^ ^ ^   ^  ^   ^   ____  ^   ^  \\     /|\\\n" +
                "     / ^ ^  ^ \\ ^  _\\___________________|  |_____^ ^  \\   /||o\\\n" +
                "    / ^^  ^ ^ ^\\  /______________________________\\ ^ ^ \\ /|o|||\\\n" +
                "   /  ^  ^^ ^ ^  /________________________________\\  ^  /|||||o|\\\n" +
                "  /^ ^  ^ ^^  ^    ||___|___||||||||||||___|__|||      /||o||||||\\\n" +
                " / ^   ^   ^    ^  ||___|___||||||||||||___|__|||          | |\n" +
                "/ ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||oooooooooo| |ooooooo\n" +
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        Thread.sleep(500);
        boolean showMenu= true;
        while (showMenu){
            System.out.println("╔═════════════════════════╗");
            System.out.println("║  Mağazaya Hoşgeldiniz!  ║");
            System.out.println("╠═════════════════════════╣");
            System.out.println("║ 1 - Silahlar            ║");
            System.out.println("║ 2 - Zırhlar             ║");
            System.out.println("║ 3 - Çıkış Yap           ║");
            System.out.println("╚═════════════════════════╝");
            int selectCase = scanner.nextInt();

            while (selectCase < 1 || selectCase > 3){
                System.out.println("Geçersiz değer, tekrar giriniz: ");
                selectCase = scanner.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    showMenu = false;
                    break;
            }

        }
        return true;
    }
    public void printWeapon() {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║              Silahlar                ║");
        System.out.println("╟──────────────────────────────────────╢");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println("║ " + weapon.getId() + " - " + weapon.getName() + padSpaces(13 - weapon.getName().length()) +
                    "Hasar: " + padSpaces(2 - String.valueOf(weapon.getDamage()).length()) + weapon.getDamage() + "  " +
                    "Para: " + padSpaces(2 - String.valueOf(weapon.getPrice()).length()) + weapon.getPrice() + " ║");
        }
        System.out.println("║ 0 - Çıkış Yap    Paran:"+this.getPlayer().getMoney()+"             ║");
        System.out.println("╚══════════════════════════════════════╝");
    }


    public static String padSpaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    public void buyWeapon(){
        System.out.print("Bir silah Seçiniz: ");
        int selectWeaponID = scanner.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectWeaponID = scanner.nextInt();
        }
        if (selectWeaponID!= 0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli Paranız bulunmamaktadır");
                }
                else {
                    if((this.getPlayer().getInventory().getWeapon().getId())>= selectedWeapon.getId()){
                        System.out.println("Bunu Alamazsınız Zaten Sizinki daha iyi :)");
                    }
                    else {
                        System.out.println(selectedWeapon.getName() + " silah satın alındı!");
                        int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    }
                }
            }
        }


    }
    public void printArmor() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║               Zırhlar              ║");
        System.out.println("╟────────────────────────────────────╢");
        for (Armor armor : Armor.armors()) {
            System.out.println("║ " + armor.getId() + " - " + armor.getName() + padSpaces(13 - armor.getName().length()) +
                    "Para: " + padSpaces(2 - String.valueOf(armor.getPrice()).length()) + armor.getPrice() + " " +
                    "Zırh: " + padSpaces(2 - String.valueOf(armor.getBlock()).length()) + armor.getBlock() + " ║");
        }
        System.out.println("║ 0 - Çıkış Yap    Paran:"+this.getPlayer().getMoney()+"           ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    public void buyArmor() {
        System.out.print("Bir zırh Seçiniz: ");
        int selectArmorID = scanner.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectArmorID = scanner.nextInt();
        }

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız bulunmamaktadır");
                } else {
                    if((getPlayer().getInventory().getArmor().getId())>= selectedArmor.getId()){
                        System.out.println("Bunu Alamazsınız Zaten Sizinki daha iyi :)");
                    }
                    else {
                        System.out.println(selectedArmor.getName() + " zırh satın alındı!");
                        int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                    }
                }

            }
        }
    }
}
