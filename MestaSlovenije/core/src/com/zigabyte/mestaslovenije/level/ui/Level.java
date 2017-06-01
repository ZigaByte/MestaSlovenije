package com.zigabyte.mestaslovenije.level.ui;

import java.util.ArrayList;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.graphics.SpriteLoader;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.level.components.StageLocations;
import com.zigabyte.mestaslovenije.level.menu.MenuResult;
import com.zigabyte.mestaslovenije.math.Vector2f;
import com.zigabyte.mestaslovenije.math.timing.Timer;

public class Level extends UIElement {

	// ArrayList of all generated stages of the game
	private ArrayList<Stage> stages = new ArrayList<Stage>();

	private Stage currentStage;
	private int currentStageNumber = 0;

	public Level() {
		pos = new Vector2f(0, 0);
		size = new Vector2f(Render.WIDTH, Render.HEIGHT);

		generateStages();
		nextStage();
	}

	private void generateStages() {
		stages.add(new Stage(this, StageLocations.mesta1, 0));
		stages.add(new Stage(this, StageLocations.mesta2, 1));
		stages.add(new Stage(this, StageLocations.mesta3, 2));
		stages.add(new Stage(this, StageLocations.mesta4, 3));
	}

	/**
	 * Move to next stage. Deactivate current and activate next
	 */
	public void nextStage() {
		if (currentStage != null)
			currentStage.setActive(false);

		currentStageNumber++;

		// Check if we are over with the stages
		if (currentStageNumber < stages.size()) {
			children.add(currentStage = stages.get(currentStageNumber));
		} else {
			// Finish up or something
			game.setMenu(new MenuResult());

		}
	}

	@Override
	public boolean processInput(Vector2f input) {
		return currentStage.processInput(input);
	}

	@Override
	protected void loadTexture() {
		texture = SpriteLoader.background;
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Render r) {
		r.drawTexture(texture, pos.x, pos.y, size.x, size.y);
	}

	/**
	 * Adds up all the scores from all the stages
	 * */
	public float getScore() {
		float score = 0;
		for(Stage s : stages){
			score += s.getScore();
		}
		return score;
	}

}