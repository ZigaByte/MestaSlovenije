package com.zigabyte.mestaslovenije.level.components;

import java.util.ArrayList;

public class Stage {

	public final int questionsPerStage = 3;
	public final String name;

	private ArrayList<Question> questions = new ArrayList<Question>();

	public Stage(StageLocations sl) {
		this.name = sl.name;
		
		questions = sl.generate(questionsPerStage);
	}

	public Question getQuestion(int index) {
		if (index >= questionsPerStage)
			System.out.println("There are not enough questions");

		return questions.get(index);
	}

}
