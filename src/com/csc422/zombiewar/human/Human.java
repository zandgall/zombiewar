package com.csc422.zombiewar.human;

public class Human {
	protected int index, health, attack;
	protected boolean isInfected;

	public Human(int index, int health, int attack, boolean isInfected) {
		this.index = index;
		this.health = health;
		this.attack = attack;
		this.isInfected = isInfected;
	}

	public boolean isDead() {
		return health <= 0;
	}
}
