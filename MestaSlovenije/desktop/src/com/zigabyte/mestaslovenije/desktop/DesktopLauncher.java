package com.zigabyte.mestaslovenije.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zigabyte.mestaslovenije.Game;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 450;
		config.samples = 4;
		new LwjglApplication(new Game(), config);
	}
}
