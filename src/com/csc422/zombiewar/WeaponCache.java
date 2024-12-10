package com.csc422.zombiewar;

import java.util.Random;

public class WeaponCache {
    public enum WEAPON {
        AXE(15);

        private final int damage;

        WEAPON(int damage) {
            this.damage = damage;
        }

        public int getDamage() {
            return damage;
        }

        public static WEAPON getRandomWeapon() {
            Random random = new Random();
            int randomIndex = random.nextInt(WEAPON.values().length);
            return WEAPON.values()[randomIndex];
        }
    }
}
