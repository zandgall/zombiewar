package com.csc422.zombiewar.human;

public class Tank extends Zombie {
	public Tank(int index) {
		super(index, 150, 20);
	}

	public String toString() {
		return "Tank " + index;
	}
}
