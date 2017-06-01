package com.zigabyte.mestaslovenije.level.components.parts;

import com.zigabyte.mestaslovenije.level.components.Component;
import com.zigabyte.mestaslovenije.level.components.Stage;
import com.zigabyte.mestaslovenije.math.Vector2f;

public abstract class Part extends Component {

	protected Stage stage;

	public Part(Stage stage) {
		this.stage = stage;

		active = false;
	}

	@Override
	public boolean processInput(Vector2f input) {
		return active;
	}

}
