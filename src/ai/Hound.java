package ai;

import area.Area;
import character.Character;
import constants.Constants;

public class Hound extends AI

{

	public Hound(Area startingArea, Character main_character) {

		super(startingArea, main_character);
		description = "A hound";

		type = Constants.HOUND;
		hp = 45;
		base_hp = 45;
		currentArea.aiTypeMap.put(type, this);

	}

}