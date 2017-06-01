package com.zigabyte.mestaslovenije.level.components.parts;

import com.badlogic.gdx.graphics.Color;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.level.components.parts.Part;
import com.zigabyte.mestaslovenije.math.Vector2f;

public class PartResults extends Part {

	public PartResults(Stage stage) {
		super(stage);
	}

	@Override
	public boolean processInput(Vector2f pos) {
		stage.complete();
		return true;
	}

	@Override
	public void render(Render r) {
		r.drawText("It's a results part", Color.BLACK, 100, 450, 64);
	}

}
