package com.csc422.zombiewar.human;

public class Survivor extends Human {

	public Survivor(int index, int health, int attack) {
		super(index, health, attack, false);
	}

	public void attack(Zombie target) {
		target.health -= this.attack;
	}

}
