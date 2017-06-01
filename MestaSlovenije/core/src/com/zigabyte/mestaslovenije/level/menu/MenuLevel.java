package com.zigabyte.mestaslovenije.level.menu;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.ui.LabelScore;
import com.zigabyte.mestaslovenije.level.ui.Level;

public class MenuLevel extends Menu {

	@Override
	public void addElements() {
		children.add(new Level());
		children.add(new LabelScore());
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Render r) {
	}

	public Level getLevel() {
		// Do not change the order of adding them or this will break :D
		return (Level) children.get(0);
	}

}
