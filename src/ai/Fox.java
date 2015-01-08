package ai;

import area.Area;
import constants.Constants;
import ai.AI;
import ui.UI;
import character.Character;

public class Fox extends AI

{

	public Fox(Area startingArea, Character main_character) {

		super(startingArea, main_character);
		description = "A fox";

		type = Constants.FOX;

		hp = 75;
		base_hp = 75;

		attack_speed = 4;

		currentArea.aiTypeMap.put(type, this);

	}

	public void Greeting()

	{

		UI.addToCombatLog("The fox snarls at you with disgust");

	}

}