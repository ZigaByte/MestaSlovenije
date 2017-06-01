package com.zigabyte.mestaslovenije.level;

import java.util.ArrayList;

import com.zigabyte.mestaslovenije.graphics.Render;
import com.zigabyte.mestaslovenije.math.Vector2f;
import com.zigabyte.mestaslovenije.math.timing.Time;

public abstract class Entity implements Time {

	protected ArrayList<Entity> children;

	public Entity() {
		children = new ArrayList<Entity>();
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
			children.get(i).render(r);
			children.get(i).renderChildren(r);
		}
	}

	public abstract void render(Render r);

	public boolean processInput(Vector2f input) {
		return false;
	}

}
