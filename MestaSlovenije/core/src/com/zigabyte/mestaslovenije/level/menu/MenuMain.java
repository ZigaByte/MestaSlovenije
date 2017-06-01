package com.zigabyte.mestaslovenije.level.menu;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.menu.ui.ButtonAbout;
import com.zigabyte.mestaslovenije.level.menu.ui.ButtonPlay;
import com.zigabyte.mestaslovenije.level.menu.ui.ButtonTutorial;

public class MenuMain extends Menu {

	public MenuMain() {

	}

	@Override
	public void addElements() {
		children.add(new ButtonPlay());
		children.add(new ButtonTutorial());
		children.add(new ButtonAbout());
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Render r) {
	}
}
