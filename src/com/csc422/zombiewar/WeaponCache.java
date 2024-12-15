package com.csc422.zombiewar;

import java.util.Random;

public class WeaponCache {
    public enum WEAPON {
        AXE(15, 1.00f),
        FRYING_PAN(100, 0.50f), // Added Frying Pan with 100 damage and 50% accuracy
        CROWBAR(10, 1.00f),
        SUBMACHINE_GUN(40, 0.7f),
        ASSAULT_RIFLE(80, 0.6f);
        PISTOL(25, 0.85f); //Added Pistol with 25 damage and 85% accuracy
        SHOTGUN(70, 0.5f); //Added shotgun with 70 damage and 50% accuracy

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
