package ai;

import ui.UI;
import area.Area;
import character.Character;
import constants.Constants;

public class Unicorn extends AI

{

	public Unicorn(Area startingArea, Character main_character) {

		super(startingArea, main_character);
		description = "An elusive unicorn";

		type = Constants.UNICORN;
		hp = 150;
		base_hp = 150;
		currentArea.aiTypeMap.put(type, this);
	}

	public void Greeting()

	{

		UI.addToCombatLog("The gentle giant looks down upon you" +

		" with eyes unclouded by hate");

	}

}