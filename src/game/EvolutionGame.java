package game;

import java.util.Timer;
import java.util.TimerTask;

import ui.UI;
import utils.IOUtils;
import world.World;
import ai.Fox;
import ai.Penguin;
import ai.Rabbit;
import area.Area;
import character.Character;
import constants.Constants;

public class EvolutionGame

{

	private static IOUtils ioUtils;

	private static World world;

	private static Character character;

	private static Fox fox;

	private static Penguin penguin;

	private static Rabbit rabbit;

	private static Timer aiMoveTimer;

	public static UI UI;

	public EvolutionGame()

	{

		aiMoveTimer = new Timer();

		aiMoveTimer.schedule(new MoveAI(), 1000 * 10);

		world = new World();

		ioUtils = new IOUtils();

		character = new Character(world.areaIDMap.get(Constants.FIRST_AREA_ID));
		UI = new UI(character);
		UI.setSize(800, 800);
		UI.setLocationRelativeTo(null);
		UI.setVisible(true);
		UI.setAreaDescription();

		UI.addToCombatLog("\n");
		// UI.pack();
		// Panel panel = new Panel();
		// panel.setLayout(new BorderLayout());
		// panel.add(new Button("Where Am I"));
		// UI.add(panel);

		fox = new Fox(world.areaIDMap.get(Constants.FIFTH_AREA_ID), character);

		penguin = new Penguin(world.areaIDMap.get(Constants.NINTH_AREA_ID),
				character);

		rabbit = new Rabbit(world.areaIDMap.get(Constants.FOURTH_AREA_ID),
				character);

		// The following will print out all areas

		/*
		 * /for (Map.Entry<Integer, Area> entry : world.areaIDMap.entrySet()) {
		 * Integer key = entry.getKey(); Area value = entry.getValue();
		 * System.out.println("Area: " + key);
		 * System.out.println(DisplayUtils.possibleDirections(value)); //use key
		 * and value }/
		 */

	}

	class MoveAI extends TimerTask {

		public void run() {

			aiMoveTimer.schedule(new MoveAI(), 1000 * 20);

			fox.moveToArea(world.GetNextAreaRandom(fox.currentArea));

			penguin.moveToArea(world.GetNextAreaRandom(penguin.currentArea));

			rabbit.moveToArea(world.GetNextAreaRandom(rabbit.currentArea));

		}

	}

	public static void main(String args[]) {

		/*
		 * / gameFrame = new JFrame(); JLabel label = new
		 * JLabel("Text-Only Label"); label.setFont(new Font("Serif",
		 * Font.PLAIN, 22)); gameFrame.add(label); gameFrame.setSize(1800,
		 * 1000); gameFrame.setVisible(true);/
		 */

		UI.introDialog();
		EvolutionGame game = new EvolutionGame();

		while (true)

		{
			Area nextArea = ioUtils.enterCommand(character);

			if (!character.fighting) {
				if (nextArea != character.currentArea)

				{

					character.moveToArea(nextArea);
					UI.setAreaDescription();
					UI.addCharacters();

				}
			} else {

			}

		}

	}

}
