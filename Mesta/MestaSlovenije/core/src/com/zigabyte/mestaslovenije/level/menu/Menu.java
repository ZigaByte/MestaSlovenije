package com.zigabyte.mestaslovenije.level.menu;

import com.zigabyte.mestaslovenije.level.Entity;
import com.zigabyte.mestaslovenije.math.Vector2f;

public abstract class Menu extends Entity {

	public Menu() {
		addElements();
	}

	public abstract void addElements();

	public boolean processInput(Vector2f input) {
		return true;
	}

}
