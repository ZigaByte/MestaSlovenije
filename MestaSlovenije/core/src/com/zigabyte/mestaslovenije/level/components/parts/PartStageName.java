package com.zigabyte.mestaslovenije.level.components.parts;

import com.badlogic.gdx.graphics.Color;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.math.Vector2f;
import com.zigabyte.mestaslovenije.math.timing.Action;
import com.zigabyte.mestaslovenije.math.timing.TimerLimit;

public class PartStageName extends Part {

	public PartStageName(Stage s) {
		super(s);

		timers.add(new TimerLimit(0.5f, new Action() {
			@Override
			public void execute() {
				stage.nextQuestion();
			}
		}));
	}

	@Override
	public boolean processInput(Vector2f pos) {
		return true;
	}

	@Override
	public void render(Render r) {
		r.drawText("BLA" + stage.name, Color.BLACK, 100, 450, 64);
	}

}
