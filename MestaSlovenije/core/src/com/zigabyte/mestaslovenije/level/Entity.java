package com.zigabyte.mestaslovenije.level;

import java.util.ArrayList;

import com.zigabyte.mestaslovenije.Game;
import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.math.Vector2f;
import com.zigabyte.mestaslovenije.math.timing.Time;

public abstract class Entity implements Time {
	
	protected static Game game;

	protected ArrayList<Entity> children;
	public boolean active;

	public Entity() {
		children = new ArrayList<Entity>();

		active = true;
	}

	public void updateChildren() {
		for (int i = 0; i < children.size(); i++) {
			children.get(i).update();
			children.get(i).updateChildren();
		}
	}

	public abstract void update();

	public void renderChildren(Render r) {
		for (int i = 0; i < children.size(); i++) {

			// Only render active children
			if (children.get(i).active) {
				children.get(i).render(r);
				children.get(i).renderChildren(r);
			}
		}
	}

	public abstract void render(Render r);

	public boolean processInput(Vector2f input) {
		for (Entity e : children) {
			if (e.active && e.processInput(input))
				return true;
		}
		return false;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static void setGame(Game game) {
		Entity.game = game;
	}

}
