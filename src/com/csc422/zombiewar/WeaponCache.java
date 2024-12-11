package com.csc422.zombiewar;

import java.util.Random;

public class WeaponCache {
    public enum WEAPON {
        AXE(15, 1.00f);

        private final int damage;
        private final float accuracy;

        WEAPON(int damage, float accuracy) {
            this.damage = damage;
            this.accuracy = accuracy;
        }

        public int getDamage() {
            return damage;
        }

        public float getAccuracy() {
            return accuracy;
        }

        public static WEAPON getRandomWeapon() {
            Random random = new Random();
            int randomIndex = random.nextInt(WEAPON.values().length);
            return WEAPON.values()[randomIndex];
        }
    }
}
