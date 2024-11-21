package com.csc422.zombiewar;

public class Survivor extends Human {

	public Survivor(int health, int attack) {
		super(health, attack, false);
	}

	public void attack(Zombie target) {
		target.health -= this.attack;
	}

}
