package com.zigabyte.mestaslovenije.level.menu;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.menu.ui.ButtonMainMenu;

public class MenuResult extends Menu {

	@Override
	public void addElements() {
		children.add(new ButtonMainMenu());
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Render r) {

	}

}
