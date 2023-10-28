package Obstacles;

import java.util.Random;

public class Snake extends Obstacle {
    public Snake() {
        super(4, "Yılan", getRandomDamage(), 12, rewardDrop());
    }

    private static int getRandomDamage() {
        Random random = new Random();
        return random.nextInt(4) + 3;
    }
    private   static int rewardDrop(){
            Random random = new Random();
        return random.nextInt(11);
        }

    }


