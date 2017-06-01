package com.zigabyte.mestaslovenije.level.components;

import com.zigabyte.mestaslovenije.math.Vector2f;

public class Question {

	public Location location;
	public Vector2f answer;

	public float score;

	public Question(Location location) {
		this.location = location;
	}

	public void answer(Vector2f answer) {
		this.answer = answer;

		score = 1;
	}

}
