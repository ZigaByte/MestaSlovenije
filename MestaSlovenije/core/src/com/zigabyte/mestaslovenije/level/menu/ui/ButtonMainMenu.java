package com.zigabyte.mestaslovenije.level.menu.ui;

import com.zigabyte.mestaslovenije.level.menu.MenuMain;
import com.zigabyte.mestaslovenije.math.Vector2f;

public class ButtonMainMenu extends Button {

	@Override
	protected void initLocation() {
		pos = new Vector2f(1000, 100);
		size = new Vector2f(500, 100);
	}

	@Override
	protected void pressed() {
		game.setMenu(new MenuMain());
	}

}
