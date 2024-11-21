package com.csc422.zombiewar.human;

public class Zombie extends Human {

	public Zombie(int health, int attack) {
		super(health, attack, true);
	}

	public void attack(Survivor target) {
		target.health -= this.attack;
	}

}
