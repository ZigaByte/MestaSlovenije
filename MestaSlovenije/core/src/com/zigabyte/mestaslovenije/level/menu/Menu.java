package com.zigabyte.mestaslovenije.level.menu;

import com.zigabyte.mestaslovenije.level.Entity;

public abstract class Menu extends Entity {

	public Menu() {
		addElements();
	}

	public abstract void addElements();
}
