package com.zigabyte.mestaslovenije.level.components;

import java.util.ArrayList;
import java.util.Random;

import com.zigabyte.mestaslovenije.input.LocationsLoader;

public class StageLocations {

	public static StageLocations testStage = new StageLocations("Test Stage", "coordinates.txt");

	public final String name;

	public final ArrayList<Location> allLocations;

	public StageLocations(String name, String fileName) {
		this.name = name;
		allLocations = LocationsLoader.load(fileName);
	}

	public ArrayList<Question> generate(int questionsPerStage) {
		ArrayList<Location> locations = new ArrayList<Location>();

		Random random = new Random();

		while (locations.size() < questionsPerStage) {
			Location l = allLocations.get(random.nextInt(allLocations.size()));
			
			if (!locations.contains(l))
				locations.add(l);
		}

		ArrayList<Question> questions = new ArrayList<>();
		for (Location l : locations) {
			questions.add(new Question(l));
		}

		return questions;
	}

}
