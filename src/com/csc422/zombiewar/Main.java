package com.csc422.zombiewar;

import java.util.ArrayList;
import java.util.Random;

import com.csc422.zombiewar.human.*;

public class Main {
	
	public static ArrayList<Zombie> zombies = new ArrayList<>();
	public static ArrayList<Survivor> survivors = new ArrayList<>();

	public static void main(String[] args) {
		generateSurvivors();
		System.out.printf("We have %d survivors trying to make it to safety%n", survivors.size());
		generateZombies();
		System.out.printf("But there are %d zombies waiting for them%n", zombies.size());

		while(true) {
			// Make the survivors attack, if there are no more zombies alive afterwards, end game
			survivorsAttack();
			if(zombies.size() == 0) {
				printSurvivors();
				return;
			}

			// Make the zombies attack, if there are no more survivors alive afterwards, end game
			zombiesAttack();
			if(survivors.size() == 0) {
				printSurvivors();
				return;
			}
		}
	}

	/*
	* Generate a random number of survivors between 6 and 12,
	* each being picked randomly between Child, Teacher, and Soldier
	*/
	public static void generateSurvivors() {
		Random r = new Random(System.nanoTime());

		int amount = r.nextInt(6, 12);

		for(int i = 0; i < amount; i++) {
			int type = r.nextInt(3);
			switch(type) {
				case 0 -> survivors.add(new Child());
				case 1 -> survivors.add(new Teacher());
				case 2 -> survivors.add(new Soldier());
			}
		}
	}

	/*
	* Generate a random number of zombies between 3 and 9,
	* each being picked randomly between CommonInfected and Tank
	*/
	public static void generateZombies() {
		Random r = new Random(System.nanoTime());

		int amount = r.nextInt(3, 9);

		for(int i = 0; i < amount; i++) {
			int type = r.nextInt(2);
			switch(type) {
				case 0 -> zombies.add(new CommonInfected());
				case 1 -> zombies.add(new Tank());
			}
		}
	}

	/*
	* Each survivor attacks each zombie
	*/
	public static void survivorsAttack() {
		for(Survivor s : survivors) {
			for(int i = 0; i < zombies.size(); i++) {
				s.attack(zombies.get(i));
				if(zombies.get(i).isDead()) {
					zombies.remove(i);
					i--;
				}
			}
		}
	}

	/*
	* Each zombie attacks each survivor
	*/
	public static void zombiesAttack() {
		for(Zombie z : zombies) {
			for(int i = 0; i < survivors.size(); i++) {
				z.attack(survivors.get(i));
				if(survivors.get(i).isDead()) {
					survivors.remove(i);
					i--;
				}
			}
		}
	}

	public static void printSurvivors() {
		System.out.println("It seems " + survivors.size() + " have made it to safety.");
	}
}
