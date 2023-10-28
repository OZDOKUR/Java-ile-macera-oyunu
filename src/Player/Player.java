package Player;

import Characters.*;

import java.util.Scanner;


public class Player {
    private int damage;
    private int healthy;
    private int originalHealth;
    private int money;
    private  String name;
    private String characterName;
    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory;

    private boolean[] award = {false, false, false,false};

    public Player (){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){

        GameCharacter[] characterList = {new Samurai(),new Archer(),new Knight()};

        System.out.println("##################################################");

        for (GameCharacter gameCharacter: characterList) {

            System.out.println("ID:"+gameCharacter.getId()+"\t"
                    + gameCharacter.getName()+
                    "\t Hasar:\t"+gameCharacter.getDamage()+
                    "\t Sağlık: "+gameCharacter.getHealth()+
                    "\t Para:\t"+gameCharacter.getMoney());

        }
        System.out.println("##################################################");
        System.out.print("Lütfen bir Karakter (ID)Seçiniz: ");
        int selectCharacter = scanner.nextInt();
        switch (selectCharacter){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        System.out.println(this.getCharacterName()+" karakterini seçtiniz.");
    }

    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealthy(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharacterName(gameCharacter.getName());

    }

    public void printInfo(){
        System.out.println("+------------------------+");
        System.out.println("| Sağlık : "+this.getHealthy()+"            |\n| Para : "+this.getMoney()+"               |");
        System.out.println("+------------------------+");
        System.out.println("| Silah : "+this.getInventory().getWeapon().getName()+"         |\n| Hasar : "+this.getTotalDamage()+"              |");
        System.out.println("+------------------------+");
        System.out.println("| Zırh : "+this.getInventory().getArmor().getName()+"             |\n| Bloklama : "+this.getInventory().getArmor().getBlock()+"           |");
        System.out.println("+------------------------+");
        System.out.println();
        for (int i = 0; i < award.length; i++) {
               if (award [i]== true)
               System.out.printf(" | Madalya %d |",(i+1));
        }
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public boolean[] getAward() {
        return award;
    }

    public void setAward(int index, boolean value) {
        award[index] = value;
    }
}
