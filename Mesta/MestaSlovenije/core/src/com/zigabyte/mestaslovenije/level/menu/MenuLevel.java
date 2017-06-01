package com.zigabyte.mestaslovenije.level.menu;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.ui.Level;

public class MenuLevel extends Menu {

	@Override
	public void addElements() {
		children.add(new Level());
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Render r) {
	}

}
