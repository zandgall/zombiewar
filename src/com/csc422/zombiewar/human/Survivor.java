package com.csc422.zombiewar.human;

import com.csc422.zombiewar.WeaponCache;

public class Survivor extends Human {
    private WeaponCache.WEAPON weapon;

    public Survivor(int index, int health, int attack) {
        super(index, health, attack, false);
    }

    public void setWeapon(WeaponCache.WEAPON weapon) {
        this.weapon = weapon;
    }

    public void attack(Zombie target) {
        if(weapon != null && Math.random() > weapon.getAccuracy()) {
            System.out.printf("%s attacks %s with %s, but misses!%n", this, target, weapon);
            return;
        }

        int damage = weapon != null ? weapon.getDamage() : this.attack;
        target.health -= damage;
        System.out.printf("%s attacks %s with %s, dealing %d damage%n", this, target, weapon == null ? "nothing" : weapon, damage);
    }
}
