package Models.Heroes;

import Exceptions.FullInventoryException;
import Exceptions.PickUpException;
import Models.Weapons.Spear;
import Models.Weapons.Spell;
import Models.Weapons.Sword;
import Models.Weapons.Weapon;

public class Swordsman extends Hero {
    public Swordsman() {
        super(100);
    }

    @Override
    public void getWeapon(Weapon weapon) throws PickUpException, FullInventoryException {
        if (weapon instanceof Spell) {
            throw new PickUpException("Swordsman can't pickup this weapon");
        } else if (weapon instanceof Sword || weapon instanceof Spear) {
            if (inventory.size() == 0 || inventory.size() == 1) {
                inventory.add(weapon);
                System.out.println(weapon.getClass().getSimpleName() + " added to inventory");
            } else {
                throw new FullInventoryException("Inventory is full");
            }
        }
    }

    @Override
    public void dropWeapon(Weapon weapon) {

    }
}
