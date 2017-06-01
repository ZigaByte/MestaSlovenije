package com.zigabyte.mestaslovenije.math.timing;

import com.badlogic.gdx.Gdx;

public class Timer {

	public float time = 0;
	public boolean finished = false;

	/**
	 * @param duration
	 *            - in seconds
	 */
	public Timer() {
	}

	public void update() {
		time += Gdx.graphics.getDeltaTime();
	}

	public void reset() {
		finished = false;
		time = 0;
	}

}
