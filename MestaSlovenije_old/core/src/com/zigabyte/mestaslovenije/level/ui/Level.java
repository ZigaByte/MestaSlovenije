package com.zigabyte.mestaslovenije.level.ui;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.graphics.SpriteLoader;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.level.components.StageLocations;
import com.zigabyte.mestaslovenije.math.Vector2f;
import com.zigabyte.mestaslovenije.math.timing.Timer;

public class Level extends UIElement {

	private Stage currentStage;
	private int currentStageNumber = 0;;

	private Timer gameTime;

	public Level() {
		pos = new Vector2f(0, 0);
		size = new Vector2f(Render.WIDTH, Render.HEIGHT);

		currentStage = new Stage(this, StageLocations.mesta1, currentStageNumber);
		children.add(currentStage);

		timers.add(gameTime = new Timer());
	}

	/**
	 * Move to next stage. Deactivate current and activate next
	 */
	public void nextStage() {
		currentStage.setActive(false);
		currentStageNumber++;
		children.add(currentStage = new Stage(this, StageLocations.mesta2, currentStageNumber));
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

}