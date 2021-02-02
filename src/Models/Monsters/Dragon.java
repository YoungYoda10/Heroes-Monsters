package Models.Monsters;

import ExternalMethods.Randomizer;
import Models.Heroes.Hero;

public class Dragon extends Monster {
    public Dragon(int health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) {
        int random = Randomizer.randomNumber(0, 1);

        if (random == 0) {
            hero.setHealth(hero.getHealth() - 5);
        } else if (random == 1) {
            hero.setHealth(hero.getHealth() - 20);
        }
    }

}
