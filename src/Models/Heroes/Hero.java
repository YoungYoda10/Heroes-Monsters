package Models.Heroes;

import Exceptions.FullInventoryException;
import Exceptions.NoWeaponException;
import Exceptions.PickUpException;
import Models.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    private int health;

    protected Weapon weapon;
    protected List<Weapon> inventory = new ArrayList<>();
    protected int position = 0;

    public abstract void getWeapon(Weapon weapon, List<Weapon> weapons) throws PickUpException, FullInventoryException;

    public void dropWeapon(List<Weapon> weapons) throws NoWeaponException {
        switch (inventory.size()) {
            case 0:
                throw new NoWeaponException("Inventory is Empty");
            case 1:
                inventory.remove(position);
                weapons.remove(weapon);
                weapon = null;
                break;
            case 2:
                inventory.remove(position);
                weapons.remove(weapon);
                position = 0;
                weapon = inventory.get(position);
                System.out.println("Weapon changed to " + weapon.getClass().getSimpleName());
                break;
        }
    }

    public void changeWeapon() throws NoWeaponException {
        switch (inventory.size()) {
            case 0:
                throw new NoWeaponException("Inventory is Empty");
            case 1:
                System.out.println("You have only one weapon");
                break;
            case 2:
                if (position == 0) {
                    weapon = inventory.get(++position);
                    System.out.println("Weapon changed to " + weapon.getClass().getSimpleName());
                } else if (position == 1) {
                    weapon = inventory.get(--position);
                    System.out.println("Weapon changed to " + weapon.getClass().getSimpleName());
                }
                break;
        }
    }

    public Hero(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
