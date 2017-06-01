package com.zigabyte.mestaslovenije.level.components.parts;

import com.badlogic.gdx.graphics.Color;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.components.Question;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.math.Coordinate;
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

		// Draw all the lines between the results and such
		for(int i = 0; i < stage.questionsPerStage; i++){
			Question q = stage.getQuestion(i);	
			Coordinate answer = q.answer;
			Coordinate correct = q.location.coordinate;
			
			r.drawLine(correct.IMAGE_X, correct.IMAGE_Y, answer.IMAGE_X, answer.IMAGE_Y);
			r.drawCirlce(Color.GREEN, correct.IMAGE_X, correct.IMAGE_Y, 10);
			r.drawCirlce(Color.RED, answer.IMAGE_X, answer.IMAGE_Y, 10);
			r.drawText(q.location.name, Color.BLACK, correct.IMAGE_X + 10, correct.IMAGE_Y + ((correct.IMAGE_Y - answer.IMAGE_Y < 0)? -10 : 30), 32);
		}
	}

}
