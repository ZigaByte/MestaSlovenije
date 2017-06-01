package com.zigabyte.mestaslovenije.level.components.parts;

import com.badlogic.gdx.graphics.Color;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.math.Coordinate;
import com.zigabyte.mestaslovenije.math.Vector2f;

public class PartAnswer extends Part {

	private PartQuestion partQuestion;

	public PartAnswer(Stage stage, PartQuestion partQuestion) {
		super(stage);
		this.partQuestion = partQuestion;
	}

	@Override
	public boolean processInput(Vector2f pos) {
		stage.nextQuestion();
		return true;
	}

	@Override
	public void render(Render r) {
		partQuestion.render(r);

		Coordinate answer = partQuestion.getAnswer();
		Coordinate correct = partQuestion.getQuestion().location.coordinate;
		r.drawCirlce(Color.GREEN, correct.IMAGE_X, correct.IMAGE_Y, 10);
		r.drawCirlce(Color.RED, answer.IMAGE_X, answer.IMAGE_Y, 10);
	}

}
