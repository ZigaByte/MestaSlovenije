package com.zigabyte.mestaslovenije.level.components;

import com.zigabyte.mestaslovenije.math.Coordinate;
import com.zigabyte.mestaslovenije.math.Vector2f;

public class Location {
	private final int id;
	public final String name;
	public final Coordinate coordinate;
	public final Vector2f pos;

	public Location(int id, String name, Coordinate coordinate) {
		this.id = id;
		this.name = name;
		this.coordinate = coordinate;

		pos = getPos();
	}

	public Vector2f getPos() {
		return new Vector2f(coordinate.IMAGE_X, coordinate.IMAGE_Y);
	}
}
