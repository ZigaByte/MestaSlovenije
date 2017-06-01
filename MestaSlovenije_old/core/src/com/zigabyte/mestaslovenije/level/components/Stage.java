package com.zigabyte.mestaslovenije.level.components;

import java.util.ArrayList;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.Entity;
import com.zigabyte.mestaslovenije.level.components.parts.Part;
import com.zigabyte.mestaslovenije.level.components.parts.PartAnswer;
import com.zigabyte.mestaslovenije.level.components.parts.PartQuestion;
import com.zigabyte.mestaslovenije.level.components.parts.PartResults;
import com.zigabyte.mestaslovenije.level.components.parts.PartStageName;
import com.zigabyte.mestaslovenije.level.ui.Level;
import com.zigabyte.mestaslovenije.math.Vector2f;

public class Stage extends Component {

	private Level level;
	private final int stageNumber;

	public final int questionsPerStage = 3;
	public final String name;

	private ArrayList<Question> questions = new ArrayList<Question>();

	private Part currentPart;
	private int currentQuestion = 0;

	public Stage(Level level, StageLocations sl, int index) {
		this.level = level;
		this.name = sl.name;
		this.stageNumber = index;

		// Get random questions
		questions = sl.generate(questionsPerStage);

		begin();
	}

	public void begin() {
		currentPart = new PartStageName(this);
		currentPart.setActive(true);
		children.add(currentPart);
	}

	public void displayAnswer(PartQuestion part) {
		currentPart.setActive(false);

		PartAnswer answer = new PartAnswer(this, part);
		children.add(answer);

		currentPart = answer;
		currentPart.setActive(true);
	}

	public void nextQuestion() {
		currentPart.setActive(false);

		if (currentQuestion < questionsPerStage) {
			Part question = new PartQuestion(this, questions.get(currentQuestion), currentQuestion);
			children.add(question);

			currentPart = question;

			currentPart.setActive(true);
			currentQuestion++;
		} else {
			displayResults();
		}
	}

	private void displayResults() {
		currentPart = new PartResults(this);
		currentPart.setActive(true);
		children.add(currentPart);
	}

	// This method ends the current stage and tells level to go to next stage
	public void complete() {
		level.nextStage();
	}

	public Question getQuestion(int index) {
		if (index >= questionsPerStage)
			System.out.println("There are not enough questions");

		return questions.get(index);
	}
}
