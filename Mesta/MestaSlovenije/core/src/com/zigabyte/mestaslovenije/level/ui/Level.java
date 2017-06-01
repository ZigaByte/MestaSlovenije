package com.zigabyte.mestaslovenije.level.ui;

import com.badlogic.gdx.graphics.Color;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.graphics.SpriteLoader;
import com.zigabyte.mestaslovenije.level.components.Location;
import com.zigabyte.mestaslovenije.level.components.Question;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.level.components.StageLocations;
import com.zigabyte.mestaslovenije.math.Vector2f;
import com.zigabyte.mestaslovenije.math.timing.Timer;
import com.zigabyte.mestaslovenije.math.timing.TimerLimit;

public class Level extends UIElement {

	private Stage currentStage;

	private Timer gameTime;
	private Timer gameOverTimer;

	public Level() {
		pos = new Vector2f(0, 0);
		size = new Vector2f(Render.WIDTH, Render.HEIGHT);

		currentStage = new Stage(StageLocations.testStage);

		// SPAGHETTI OR NOT???
		timers.add(gameTime = new Timer());
		/*timers.add(gameOverTimer = new TimerLimit(2, () -> {
			currentStage = new Stage(StageLocations.testStage);
			gameOverTimer.reset();
		}));*/
		timers.add(new Timer());
		

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

		for (int i = 0; i < currentStage.questionsPerStage; i++) {
			Question q = currentStage.getQuestion(i);
			Location l = q.location;
			r.drawCirlce(Color.BLACK, l.pos.x, l.pos.y, 10);
			System.out.println(l.name);
			r.drawText("" + l.name, Color.BLACK, l.pos.x + 20, l.pos.y, 24);
		}
	}

}
