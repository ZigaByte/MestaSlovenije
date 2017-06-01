package com.zigabyte.mestaslovenije.level.menu.ui;

import com.zigabyte.mestaslovenije.math.Vector2f;

public class ButtonAbout extends Button {

	@Override
	protected void pressed() {

	}

	@Override
	protected void initLocation() {
		pos = new Vector2f(50, 350);
		size = new Vector2f(500, 100);
	}

}
