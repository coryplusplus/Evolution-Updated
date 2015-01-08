package ai;

import area.Area;
import character.Character;
import constants.Constants;

public class Penguin extends AI

{

	public Penguin(Area startingArea, Character main_character) {

		super(startingArea, main_character);
		description = "A penguin";

		type = Constants.PENGUIN;
		hp = 75;
		base_hp = 75;
		currentArea.aiTypeMap.put(type, this);

	}

}
