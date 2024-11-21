package com.csc422.zombiewar;

public class Human {
	protected int health, attack;
	protected boolean isInfected;

	public Human(int health, int attack, boolean isInfected) {
		this.health = health;
		this.attack = attack;
		this.isInfected = isInfected;
	}
}
