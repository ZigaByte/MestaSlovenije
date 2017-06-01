package com.zigabyte.mestaslovenije.level.components;

import java.util.ArrayList;
import java.util.Random;

import com.zigabyte.mestaslovenije.input.LocationsLoader;

public class StageLocations {

	public static StageLocations testStage = new StageLocations("Test Stage", "coordinates.txt");
	public static StageLocations mesta1 = new StageLocations("Ve�ja mesta ", "mesta1.txt");
	public static StageLocations mesta2 = new StageLocations("Mesta", "mesta2.txt");
	public static StageLocations mesta3 = new StageLocations("Manj�a mesta", "mesta3.txt");
	public static StageLocations mesta4 = new StageLocations("Manj�a mesta drugi�", "mesta4.txt");

	public final String name;

	public final ArrayList<Location> allLocations;

	public StageLocations(String name, String fileName) {
		this.name = name;
		allLocations = LocationsLoader.load(fileName);
	}

	public ArrayList<Question> generate(int questionsPerStage) {
		ArrayList<Location> locations = new ArrayList<Location>();

		// Make sure not too many questions are requested
		if (questionsPerStage >= allLocations.size()) {
			System.out.println("Too many questions requested!!");
		}

		Random random = new Random();

		// Select questions in a random order until either enough were chosen or
		// all were chosen
		while (locations.size() < questionsPerStage && locations.size() < allLocations.size()) {
			Location l = allLocations.get(random.nextInt(allLocations.size()));

			if (!locations.contains(l))
				locations.add(l);
		}

		// Return this array of empty questions
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Location l : locations) {
			questions.add(new Question(l));
		}

		return questions;
	}

}
