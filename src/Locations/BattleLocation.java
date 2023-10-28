package Locations;

import Obstacles.Obstacle;
import Player.*;

import java.util.Objects;
import java.util.Random;

public abstract class BattleLocation extends Location {
    private  int id;
    private Obstacle obstacle;

    private String award;
    private int maxObstacle;

    private String art;
    public BattleLocation(Player player, String name,Obstacle obstacle,String award,int maxObstacle,int id,String art) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.id= id;
        this.art = art;
    }
    @Override
    public boolean onLocation() throws InterruptedException {
        int obstacleNumber = this.randomObstacleNumber();
        System.out.println(this.getArt());
        System.out.println("Şuan buradasınız : "+this.getName());
        Thread.sleep(500);
        System.out.println("Dikkat!! Burada "+ obstacleNumber+" tane "+this.getObstacle().getName() +" yaşıyor!");
        System.out.println("(1)Savaş veya (2)Kaç");
        int selectCase= scanner.nextInt();
        if (selectCase == 1 && combat(obstacleNumber)) {
            System.out.println("     _______________\n" +
                    "    \\@@@@|     |####/\n" +
                    "     \\@@@|     |###/\n" +
                    "      `@@|_____|##'\n" +
                    "           (O)\n" +
                    "        .-'''''-.\n" +
                    "      .'  * * *  `.\n" +
                    "     :  *       *  :\n" +
                    "    : ~           ~ :\n" +
                    "    : ~            ~ :\n" +
                    "     :  *       *  :\n" +
                    "      `.  * * *  .'\n" +
                    "        `-.....-'");
            System.out.println(this.getName()+" tüm düşmanları yendiniz ve Madalya kazandınız!");
            this.getPlayer().setAward(this.getId(),true);
            return true;
        }

        if(this.getPlayer().getHealthy()<=0){
            System.out.println("  /$$$$$$  /$$       /$$$$$$$  /$$   /$$ /$$   /$$ /$$   /$$ /$$$$$$$$\n" +
                    " /$$__  $$| $$      | $$__  $$| $$  | $$| $$$ | $$| $$  | $$|_____ $$ \n" +
                    "| $$  \\ $$| $$      | $$  \\ $$| $$  | $$| $$$$| $$| $$  | $$     /$$/ \n" +
                    "| $$  | $$| $$      | $$  | $$| $$  | $$| $$ $$ $$| $$  | $$    /$$/  \n" +
                    "| $$  | $$| $$      | $$  | $$| $$  | $$| $$  $$$$| $$  | $$   /$$/   \n" +
                    "| $$  | $$| $$      | $$  | $$| $$  | $$| $$\\  $$$| $$  | $$  /$$/    \n" +
                    "|  $$$$$$/| $$$$$$$$| $$$$$$$/|  $$$$$$/| $$ \\  $$|  $$$$$$/ /$$$$$$$$\n" +
                    " \\______/ |________/|_______/  \\______/ |__/  \\__/ \\______/ |________/");
            return false;
        }

        return true;
    }
    public boolean combat(int obstacleNumber){
        for (int i=0; i< obstacleNumber; i++){
            this.getObstacle().setHealth(getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealthy()> 0 && this.getObstacle().getHealth()>0){
                System.out.println("(1)Vur (2)Kaç");
                int selectCombat = scanner.nextInt();
                if (selectCombat == 1) {
                    if (this.getObstacle().getHealth()>0){
                        Random random = new Random();
                        int chance = random.nextInt(2);
                        if (chance == 1) {
                            System.out.println("İlk sen vurdun, ardından "+ this.getObstacle().getName()+ " vurdu!!!");
                            int obstacleDamage;
                            if(this.getObstacle().getDamage()>=this.getPlayer().getInventory().getArmor().getBlock()){
                               obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            }
                            else{
                                 obstacleDamage = 0;
                            }
                            this.getObstacle().setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                            if (this.getObstacle().getHealth()>0){this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);}
                        }
                        else {
                            System.out.println("ilk "+ this.getObstacle().getName()+" vurdu, ardından sen vurdun");
                            int obstacleDamage;
                            if(this.getObstacle().getDamage()>=this.getPlayer().getInventory().getArmor().getBlock()){
                                obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            }
                            else {
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                            this.getObstacle().setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());

                        }
                        afterHit();
                    }

                }
                else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth()<this.getPlayer().getHealthy()){
                System.out.println("Düşmanı Yendiniz");

                if (!Objects.equals(this.getObstacle().getId(), 4)) {
                    System.out.println(this.getObstacle().getAward()+" para kazandınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                    System.out.println("Güncel Paranız "+this.getPlayer().getMoney());

                }
                else {
                    if (this.getObstacle().getAward()<=3){
                        int[] priceRate ={10,10,5,5,5,1,1,1,1,1};
                        Random random = new Random();
                        int choice = random.nextInt((priceRate.length)-1);
                        System.out.println(priceRate[choice]+" para kazandınız !");
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+priceRate[choice]);

                    } else if (this.getObstacle().getAward()>3 && this.getObstacle().getAward()<=5) {
                        int[] weaponRate ={1,1,1,1,1,2,2,2,3,3};
                        Random random = new Random();
                        int choice = random.nextInt((weaponRate.length)-1);
                        Weapon selectedWeapon = Weapon.getWeaponObjById(weaponRate[choice]);
                        if (selectedWeapon != null) {
                            if((getPlayer().getInventory().getWeapon().getId())<= selectedWeapon.getId()) {
                                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                                System.out.println(getPlayer().getInventory().getWeapon().getName() + " Silahını Kazandınız");
                            }
                        }

                    }
                    else if (this.getObstacle().getAward()==6) {
                        int[] armorRate ={1,1,1,1,1,2,2,2,3,3};
                        Random random = new Random();
                        int choice = random.nextInt((armorRate.length)-1);
                        Armor selectedArmor = Armor.getArmorObjById(armorRate[choice]);
                        if (selectedArmor != null) {
                            if((getPlayer().getInventory().getArmor().getId())<= selectedArmor.getId()){
                                this.getPlayer().getInventory().setArmor(selectedArmor);
                                System.out.println(getPlayer().getInventory().getArmor().getName() + " Zırhını kazandınız");

                            }
                        }


                    }
                    else {
                        System.out.println("HİÇ BİR ŞEY ÇIKMADI");

                    }

                }


            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("------------------------");
        System.out.println("Canın : "+getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName()+" Canı : "+this.getObstacle().getHealth());
        System.out.println("------------------------");
    }
    public void playerStats(){
        System.out.println("==============================\n" +
                "|      Oyuncu Değerleri      \n" +
                "==============================\n" +
                "| " + "\t\u2764" + "Sağlık    : " + this.getPlayer().getHealthy() + "\n" +
                "| " + "\t\u2694" + " Hasar     : " + this.getPlayer().getTotalDamage() + "\n" +
                "| " + "\t\uD83D\uDEE1" + " Bloklama  : " + this.getPlayer().getInventory().getArmor().getBlock() + "\n" +
                "| " + "\t\uD83D\uDCB0" + " Para      : " + this.getPlayer().getMoney() + "\n" +
                "==============================\n" +
                "\n" );
    }
    public void obstacleStats(int i){
        System.out.println((i+1)+"."+this.getObstacle().getName()+" Değerleri");
        System.out.println("------------------------");
        System.out.println("❤ Sağlık : "+ this.getObstacle().getHealth());
        System.out.println("⚔ Hasar : "+ this.getObstacle().getDamage());
        if (Objects.equals(this.getObstacle().getId(), 4)){System.out.println("Ödül : ?");}
        else {System.out.println("\uD83C\uDF81 Ödül : "+ this.getObstacle().getAward());}
        System.out.println();
    }

    public int randomObstacleNumber(){
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle())+5;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }
}
