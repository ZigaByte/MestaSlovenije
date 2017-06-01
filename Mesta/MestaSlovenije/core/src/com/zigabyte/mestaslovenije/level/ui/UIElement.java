package com.zigabyte.mestaslovenije.level.ui;

import com.badlogic.gdx.graphics.Texture;
import com.zigabyte.mestaslovenije.level.Entity;
import com.zigabyte.mestaslovenije.math.Rectangle;
import com.zigabyte.mestaslovenije.math.Vector2f;

public abstract class UIElement extends Entity {

	protected Vector2f pos;
	protected Vector2f size;

	protected Rectangle rectangle;

	protected Texture texture;

	public UIElement() {
		pos = new Vector2f();
		size = new Vector2f();
		rectangle = new Rectangle(pos, pos.add(size));

		loadTexture();
	}

	protected abstract void loadTexture();

}
