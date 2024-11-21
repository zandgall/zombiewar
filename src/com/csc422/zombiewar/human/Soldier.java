package com.csc422.zombiewar.human;

public class Soldier extends Survivor {
	public Soldier(int index) {
		super(index, 100, 10);
	}

	public String toString() {
		return "Soldier " + index;
	}
}
