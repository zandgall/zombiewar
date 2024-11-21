package com.csc422.zombiewar.human;

public class Human {
	protected int health, attack;
	protected boolean isInfected;

	public Human(int health, int attack, boolean isInfected) {
		this.health = health;
		this.attack = attack;
		this.isInfected = isInfected;
	}

	public boolean isDead() {
		return health <= 0;
	}
}
