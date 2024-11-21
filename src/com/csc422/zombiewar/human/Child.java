package com.csc422.zombiewar.human;

public class Child extends Survivor {
	public Child(int index) {
		super(index, 20, 2);
	}

	@Override
	public String toString() {
		return "Child " + index;
	}
}
