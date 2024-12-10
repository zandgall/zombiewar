package com.csc422.zombiewar;

import java.util.ArrayList;
import java.util.Random;

import com.csc422.zombiewar.WeaponCache.WEAPON;
import com.csc422.zombiewar.human.*;

public class Main {
	
	public static ArrayList<Zombie> zombies = new ArrayList<>();
	public static ArrayList<Survivor> survivors = new ArrayList<>();

	public static void main(String[] args) {
		generateSurvivors();
		generateZombies();

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
	
		int numChild = 0, numTeacher = 0, numSoldier = 0;
	
		for (int i = 0; i < amount; i++) {
			Survivor survivor;
			int type = r.nextInt(3);
			switch (type) {
				case 0 -> survivor = new Child(numChild++);
				case 1 -> survivor = new Teacher(numTeacher++);
				case 2 -> survivor = new Soldier(numSoldier++);
				default -> throw new IllegalStateException("Unexpected value: " + type);
			}
	
			// Assign a random weapon
			WeaponCache.WEAPON randomWeapon = WEAPON.getRandomWeapon();
			survivor.setWeapon(randomWeapon);
			System.out.printf("%s was given a %s%n", survivor, randomWeapon);
	
			survivors.add(survivor);
		}
		System.out.printf("We have %d survivors trying to make it to safety (%d children, %d teachers, %d soldiers)%n", survivors.size(), numChild, numTeacher, numSoldier);
	}
	

	/*
	* Generate a random number of zombies between 3 and 9,
	* each being picked randomly between CommonInfected and Tank
	*/
	public static void generateZombies() {
		Random r = new Random(System.nanoTime());

		int amount = r.nextInt(3, 9);
		int numCommon = 0, numTank = 0;

		for(int i = 0; i < amount; i++) {
			int type = r.nextInt(2);
			switch(type) {
				case 0 -> {
					zombies.add(new CommonInfected(numCommon));
					numCommon++;
				}
				case 1 -> {
					zombies.add(new Tank(numTank));
					numTank++;
				}
			}
		}
		System.out.printf("But there are %d zombies waiting for them (%d common infected, %d tank)%n", zombies.size(), numCommon, numTank);
	}

	/*
	* Each survivor attacks each zombie
	*/
	public static void survivorsAttack() {
		for(Survivor s : survivors) {
			// Attack all zombies, setting them to null if they die
			for(int i = zombies.size() - 1; i >= 0; i--) {
				Zombie z = zombies.get(i);
				if(z == null)
					continue;
				s.attack(z);
				if(z.isDead()) {
					System.out.printf("%s killed %s%n", s, z);
					zombies.set(i, null);
				}
			}
		}

		// remove all null zombies from the array
		for(int i = zombies.size() - 1; i >= 0; i--)
			if(zombies.get(i) == null)
				zombies.remove(i);
	}

	/*
	* Each zombie attacks each survivor
	*/
	public static void zombiesAttack() {
		for(Zombie z : zombies) {
			// Attack all survivors, set survivor to null if dead
			for(int i = survivors.size() - 1; i >= 0; i--) {
				Survivor s = survivors.get(i);
				if(s == null)
					continue;
				z.attack(s);
				if(s.isDead()) {
					System.out.printf("%s killed %s%n", z, s);
					survivors.set(i, null);
				}
			}
		}

		// Remove all null survivors
		for(int i = survivors.size() - 1; i >= 0; i--)
			if(survivors.get(i) == null)
				survivors.remove(i);

	}

	public static void printSurvivors() {
		if(survivors.size() == 0)
			System.out.println("None of the survivors made it.");
		else
			System.out.println("It seems " + survivors.size() + " have made it to safety.");
	}
}
