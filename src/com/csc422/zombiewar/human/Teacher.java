package com.csc422.zombiewar.human;

public class Teacher extends Survivor {
	public Teacher(int index) {
		super(index, 50, 5);
	}

	public String toString() {
		return "Teacher " + index;
	}
}
