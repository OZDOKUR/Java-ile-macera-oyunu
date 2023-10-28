package Player;

import Locations.Cave;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String award;

    public Inventory() {
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor = new Armor(-1,"Yok",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
