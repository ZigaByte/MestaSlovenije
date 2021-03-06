package com.zigabyte.mestaslovenije.level.menu.ui;

import com.badlogic.gdx.graphics.Color;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.level.menu.MenuLevel;
import com.zigabyte.mestaslovenije.math.Vector2f;

public class ButtonPlay extends Button {

	@Override
	protected void pressed() {
		game.setMenu(new MenuLevel());
	}

	@Override
	protected void initLocation() {
		pos = new Vector2f(50, 50);
		size = new Vector2f(500, 100);
	}

	@Override
	public void render(Render r) {
		super.render(r);
		r.drawText("IGRAJ", Color.BLACK, pos.x + size.x / 2, pos.y + size.y / 2, 64);

	}

}
