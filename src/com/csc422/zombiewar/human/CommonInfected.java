package com.csc422.zombiewar.human;

public class CommonInfected extends Zombie {
	public CommonInfected(int index) {
		super(index, 30, 5);
	}

	public String toString() {
		return "CommonInfected " + index;
	}
}
