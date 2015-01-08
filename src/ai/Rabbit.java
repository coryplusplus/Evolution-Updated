package ai;

import constants.Constants;
import area.Area;
import character.Character;

public class Rabbit extends AI

{

	public Rabbit(Area startingArea, Character main_character) {

		super(startingArea, main_character);
		description = "A rabbit";

		type = Constants.RABBIT;
		hp = 75;
		base_hp = 75;
		currentArea.aiTypeMap.put(type, this);

	}

}
