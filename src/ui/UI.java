package ui;

import character.Character;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import utils.DisplayUtils;
import utils.IOUtils;

import constants.Constants;

import ai.AI;
import area.Area;

public class UI extends JFrame {

	public static JPanel contentPane;
	public static JPanel panel = new JPanel();;
	public static JPanel panel_1;
	public static JPanel panel_2;
	public static JPanel panel_3;
	public static JPanel panel_4;
	public static JPanel panel_5;
	public static JPanel panel_6;
	public static JPanel panel_8;

	public static JPanel directionButtonPanel;
	public static JPanel killPanel;
	public static JPanel actionButtonPanel;

	public static JLabel lblStats;
	public static JLabel lblNewLabel;
	public static JLabel lblNewLabel_1;
	public static JLabel areaDescription;
	public static JTextArea combatLog = new JTextArea();
	public static JScrollPane scrollPane_1;
	public static Character character;

	public static JLabel rabbitLabel;
	public static JLabel foxLabel;
	public static JLabel penguinLabel;

	public static JButton north;
	public static JButton south;
	public static JButton east;
	public static JButton west;
	public static JButton heal;
	public static JButton jump;
	public static JButton killFox;
	public static JButton killPenguin;
	public static JButton killRabbit;

	public static JMenuBar menuBar;
	public static JMenu menu, submenu;
	public static JMenuItem menuItem;
	public static JRadioButtonMenuItem rbMenuItem;
	public static JCheckBoxMenuItem cbMenuItem;

	/**
	 * Create the frame.
	 */
	public UI(Character mainChar) {
		super("EVOLUTION");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		character = mainChar;
		rabbitLabel = new JLabel();
		foxLabel = new JLabel();
		penguinLabel = new JLabel();

		ImageIcon foxImage = new ImageIcon(getClass().getResource(
				"/resources/images/fox.jpg"));
		ImageIcon penguinImage = new ImageIcon(getClass().getResource(
				"/resources/images/penguin.jpg"));
		ImageIcon rabbitImage = new ImageIcon(getClass().getResource(
				"/resources/images/rabbit.jpg"));
		rabbitLabel.setIcon(rabbitImage);
		rabbitLabel.add(new JButton("Kill"));
		foxLabel.setIcon(foxImage);
		penguinLabel.setIcon(penguinImage);
		killPanel = new JPanel();
		directionButtonPanel = new JPanel();
		actionButtonPanel = new JPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		contentPane.setBackground(Color.BLACK);

		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));

		panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));

		lblNewLabel = new JLabel("In This Area...");
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 22));

		panel_3.add(lblNewLabel);

		panel_8 = new JPanel();
		panel_8.setLayout(new FlowLayout());
		panel_3.add(panel_8);

		panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));

		lblStats = new JLabel("Stats");
		lblStats.setVerticalAlignment(SwingConstants.CENTER);
		lblStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblStats.setFont(new Font("Serif", Font.PLAIN, 22));
		;
		panel_4.add(lblStats);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(DisplayUtils.getStats(character));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Courier New", Font.ITALIC, 12));
		lblNewLabel_1.setForeground(Color.RED);

		panel_4.add(lblNewLabel_1);
		// panel_4.add(killPanel);

		panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));

		panel_5 = new JPanel();
		panel_2.add(panel_5);

		areaDescription = new JLabel();
		areaDescription.setFont(new Font("Courier New", Font.ITALIC, 12));
		setAreaDescription();

		panel_5.add(areaDescription);

		panel_6 = new JPanel();
		panel_2.add(panel_6);

		// combatLog = new JTextArea();
		combatLog.setEditable(false);
		// combatLog.setPreferredSize(new Dimension(600,200));

		scrollPane_1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.getViewport().add(combatLog);
		scrollPane_1.setPreferredSize(new Dimension(600, 125));
		panel_6.add(scrollPane_1);

		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 1));
		directionButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(directionButtonPanel);
		panel.add(actionButtonPanel);
		panel.add(killPanel);

		initButtons();
		initMenuBars();
		this.setJMenuBar(menuBar);

	}

	public static void addCharacters() {
		panel_8.removeAll();
		killPanel.removeAll();
		AI ai = new AI();
		if (character.currentArea.GetAI(Constants.FOX_STRING, ai)) {
			killPanel.add(killFox);
			panel_8.add(foxLabel);
		}
		if (character.currentArea.GetAI(Constants.PENGUIN_STRING, ai)) {
			killPanel.add(killPenguin);
			panel_8.add(penguinLabel);
		}
		if (character.currentArea.GetAI(Constants.RABBIT_STRING, ai)) {
			killPanel.add(killRabbit);
			panel_8.add(rabbitLabel);
		}
		panel_8.revalidate();
		panel_8.repaint();
		killPanel.revalidate();
		killPanel.repaint();
	}

	public static void updateStats() {
		lblNewLabel_1.setText(DisplayUtils.getStats(character));
	}

	public static void setAreaDescription() {
		areaDescription.setText(character.currentArea.description);
		panel_5.revalidate();
		panel_5.repaint();

	}

	public static void addToCombatLog(String string) {
		combatLog.append(string);
		combatLog.append("\n");
		combatLog.setCaretPosition(combatLog.getDocument().getLength());
		panel_6.revalidate();
		panel_6.repaint();

	}

	public static void initButtons() {

		north = new JButton("North");
		north.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!character.fighting) {
					Area nextArea = character.currentArea.areaMap
							.get(Constants.North);
					character.moveToArea(nextArea);
					setAreaDescription();
					addCharacters();
				}
			}
		});
		north.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		directionButtonPanel.add(north);

		south = new JButton("South");
		south.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!character.fighting) {
					Area nextArea = character.currentArea.areaMap
							.get(Constants.South);
					character.moveToArea(nextArea);
					setAreaDescription();
					addCharacters();
				}
			}
		});
		directionButtonPanel.add(south);

		east = new JButton("East");
		east.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!character.fighting) {
					Area nextArea = character.currentArea.areaMap
							.get(Constants.East);
					character.moveToArea(nextArea);
					setAreaDescription();
					addCharacters();
				}
			}
		});
		directionButtonPanel.add(east);

		west = new JButton("West");
		west.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!character.fighting) {
					Area nextArea = character.currentArea.areaMap
							.get(Constants.West);
					character.moveToArea(nextArea);
					setAreaDescription();
					addCharacters();
				}
			}
		});
		directionButtonPanel.add(west);

		jump = new JButton("Jump");
		jump.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IOUtils.HandleJump();
			}
		});
		actionButtonPanel.add(jump);

		heal = new JButton("Heal");
		heal.setBackground(Color.GREEN);
		heal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IOUtils.HandleHeal(character);
			}
		});
		actionButtonPanel.add(heal);

		setupKillButtons();

	}

	private static void setupKillButtons() {
		killFox = createButton("Kill fox");
		killRabbit = createButton("Kill rabbit");
		killPenguin = createButton("Kill penguin");
		setupKillCallbacks();

	}

	private static JButton createButton(String btnLabel) {
		JButton btn = new JButton(btnLabel);
		btn.setPreferredSize(new Dimension(120, 25));
		btn.setBackground(Color.RED);
		btn.setForeground(Color.WHITE);
		return btn;
	}

	private static void setupKillCallbacks() {
		setupKillCallback(killFox);
		setupKillCallback(killRabbit);
		setupKillCallback(killPenguin);
	}

	private static void setupKillCallback(final JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IOUtils.HandleKill(character, btn.getText());
				btn.setVisible(false);
			}
		});
	}

	public static void updateButtons() {
		switch (character.currentArea.paths)

		{

		case Constants.North:
			setDirectionVisibility(true, false, false, false);
			break;

		case Constants.South:
			setDirectionVisibility(false, true, false, false);
			break;

		case Constants.East:
			setDirectionVisibility(false, false, true, false);
			break;

		case Constants.West:
			setDirectionVisibility(false, false, false, true);
			break;

		case Constants.NorthAndSouth:
			setDirectionVisibility(true, true, false, false);
			break;

		case Constants.NorthAndEast:
			setDirectionVisibility(true, false, true, false);
			break;

		case Constants.NorthAndWest:
			setDirectionVisibility(true, false, false, true);
			break;

		case Constants.SouthAndEast:
			setDirectionVisibility(false, true, true, false);
			break;

		case Constants.SouthAndWest:
			setDirectionVisibility(false, true, false, true);
			break;

		case Constants.EastAndWest:
			setDirectionVisibility(false, false, true, true);
			break;

		case Constants.NorthSouthAndEast:
			setDirectionVisibility(true, true, true, false);
			break;

		case Constants.NorthSouthAndWest:

			setDirectionVisibility(true, true, false, true);
			break;

		case Constants.NorthEastAndWest:

			setDirectionVisibility(true, false, true, true);
			break;

		case Constants.SouthEastAndWest:

			setDirectionVisibility(false, true, true, true);
			break;

		case Constants.NorthSouthEastAndWest:

			setDirectionVisibility(true, true, true, true);
			break;

		default:

			break;

		}
	}

	public static void setDirectionVisibility(boolean n, boolean s, boolean e,
			boolean w) {
		north.setVisible(n);
		south.setVisible(s);
		east.setVisible(e);
		west.setVisible(w);
	}

	public static boolean possessDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;

		int dialogResult = JOptionPane.showConfirmDialog(null,
				"Would you like to possess this creature?", "Congratz!!",
				dialogButton);
		if (dialogResult == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}

	}

	public static void introDialog() {

		String intro = "You hear a faint humming sound and aren't able to focus on anything.\n"
				+ "A voice in the distance seems to be getting closer and as it does,\nsome form of comfort washes over your consciousness.\n"
				+ "You are in between worlds, says the voice, and we are counting on you \nto summon every ounce of courage you have remaining in order to defeat\n"
				+ "the evil within. Just like that, the voice disappeared. Your eyesight finally \nreturns and you are surprised when you realize you have"
				+ "no physical form. \nYou remember Lliam mentioning some technique allowing a soul to \"possess\" \na creature once it has been \"kill\"ed."
				+ "You had better start exploring before your soul \nis vanquished into the nether."
				+ "You are strong in this form but with every passing \nsecond you are losing your hold in this realm. Find a vessel, and fast!\n"
				+ "If things get scary try and \"heal\" yourself";

		JOptionPane.showConfirmDialog(null, intro, "EVOLUTION",
				JOptionPane.DEFAULT_OPTION);
	}

	public static void initMenuBars() {
		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("Options");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("Quit", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Both text and icon", new ImageIcon(
				"images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		// a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		// a group of check box menu items
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);

		// a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		// Build second menu in the menu bar.
		menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");
		menuBar.add(menu);
	}
	
    public static class BackgroundColorTimer extends TimerTask {

    	Color changeColor = Color.black;
    	public BackgroundColorTimer(Color color)
    	{
    		changeColor = color;
    	}
        public void run() {

       	 contentPane.setBackground(changeColor);
         if(changeColor == Color.red)
         {
             Timer timer = new Timer();
             timer.schedule(new BackgroundColorTimer(Color.black), 30);
        	 
         }
         else
         {
        	 this.cancel();
         }

        }

    }
    
	public static void flashRed()
	{
        Timer timer = new Timer();
        timer.schedule(new BackgroundColorTimer(Color.red), 1);
	}
}