package com.zigabyte.mestaslovenije.input;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.zigabyte.mestaslovenije.level.components.Location;
import com.zigabyte.mestaslovenije.math.Coordinate;

public class LocationsLoader {

	public static ArrayList<Location> load(String fileName) {
		FileHandle file = Gdx.files.internal("data/" + fileName);
		String text = file.readString();

		// Individual lines of the file
		String[] linesOriginal = text.split("\n");

		ArrayList<Location> locations = new ArrayList<Location>();

		for (String s : linesOriginal) {
			String[] parts = s.split(",");

			int id = Integer.parseInt(parts[0].trim());
			String name = parts[1].trim();
			int population = Integer.parseInt(parts[2].trim());
			float n = Float.parseFloat(parts[3].trim());
			float e = Float.parseFloat(parts[4].trim());
			Coordinate coordinate = new Coordinate(n, e);

			locations.add(new Location(id, name, coordinate));
		}

		return locations;

	}

}
