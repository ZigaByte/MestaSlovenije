package com.zigabyte.mestaslovenije.level.components.parts;

import com.badlogic.gdx.graphics.Color;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.components.Question;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.math.Coordinate;
import com.zigabyte.mestaslovenije.math.Vector2f;

public class PartQuestion extends Part {

	private Question question;
	public final int questionNumber;

	private Coordinate answer;

	public PartQuestion(Stage stage, Question question, int questionNumber) {
		super(stage);
		this.question = question;
		this.questionNumber = questionNumber;
	}

	@Override
	/* The argument is still in pixels */
	public boolean processInput(Vector2f pos) {
		answer = new Coordinate(pos.x, pos.y, true);
		question.answer(answer);

		stage.displayAnswer(this);
		return true;
	}

	@Override
	public void render(Render r) {
		r.drawText("" + question.location.name, Color.BLACK, 100, 450, 64);
	}

	public Question getQuestion() {
		return question;
	}

	public Coordinate getAnswer() {
		return answer;
	}
}