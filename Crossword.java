import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Crossword extends JFrame implements WindowListener, ActionListener {
	private JTextField[][] btnNumbers;
	private boolean[][] wordPlacements = new boolean[20][20];
	private JTextField[] clues = new JTextField[24];
	private Word[] answers = new Word[22];
	private TextField mineDisplay, timeDisplay;
	private Button newGame;
	private String[] Clue;

	public Crossword() {
		
		Panel panelDisplay = new Panel(new BorderLayout(wordPlacements.length, wordPlacements[0].length));
		mineDisplay = new TextField("21");
		mineDisplay.setEditable(false);
		panelDisplay.add(mineDisplay, BorderLayout.WEST);
		timeDisplay = new TextField("000");
		timeDisplay.setEditable(false);
		panelDisplay.add(timeDisplay, BorderLayout.EAST);
		newGame = new Button("Click to Start a New Game.");
		panelDisplay.add(newGame, BorderLayout.CENTER);
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				new Crossword();
			}
		});
		Panel panelButtons = new Panel(new GridLayout(wordPlacements.length, wordPlacements[0].length));
		btnNumbers = new JTextField[wordPlacements.length][wordPlacements[0].length];
		for (int x = 0; x < wordPlacements[0].length; x++) {
			for (int y = 0; y < wordPlacements[0].length; y++) {
				btnNumbers[x][y] = new JTextField();
				panelButtons.add(btnNumbers[x][y]);
				btnNumbers[x][y].addActionListener(this);
				btnNumbers[x][y].setEditable(false);
			}
		}
		setLayout(new BorderLayout());
		add(panelDisplay, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.CENTER);
		Panel panelClues = new Panel(new GridLayout(24, 1));
		String[] Clue = new String[24];
		Clue[0] = "ACROSS";
		Clue[1] = "3. Disney star who must be home by midnight";
		Clue[2] = "4. Cowboy In Toy Story";
		Clue[3] = "7. The rat's name in Ratatouille, brother of Emile";
		Clue[4] = "10. Aladdin's monkey";
		Clue[5] = "12. The Mad ___ from Alice in Wonderland";
		Clue[6] = "13. The Lion King's warthog friend";
		Clue[7] = "15. The Sultan's daughter in Aladdin";
		Clue[8] = "16. Boy who flies to South America in UP";
		Clue[9] = "18. Name of the boy in Toy Story";
		Clue[10] = "19. The starring lady in The Beauty and the Beast";
		Clue[11] = "20. Owner of the house that flies away in UP";
		Clue[12] = "DOWN";
		Clue[13] = "1. ___ Bell, star of her own 2008 Disney movie";
		Clue[14] = "2. Fish who is separated from his father";
		Clue[15] = "5. Color of the Rabbit in Alice in Wonderland";
		Clue[16] = "6. Space man from Toy Story";
		Clue[17] = "8. Lightning ____, from Cars";
		Clue[18] = "9. Type of cat in Alice's Wonderland";
		Clue[19] = "10. Little Mermaid's name";
		Clue[20] = "11. The Princess who kisses the Frog";
		Clue[21] = "14. Wall E's favorite robot friend";
		Clue[22] = "16. A wise baboon from The Lion King";
		Clue[23] = "17. The Lion King's name";
		for (int x = 0; x <= 23; x++) {
			clues[x] = new JTextField();
			clues[x].setText(Clue[x]);
			panelClues.add(clues[x]);
			clues[x].setEditable(false);
		}
		setAnswers();
		setGrid();
		add(panelClues, BorderLayout.SOUTH);
		setSize(900,900);
		setVisible(true);

	}

	public void setAnswers() {
		for (int x = 0; x < 22; x++) {
			answers[x] = new Word();
		}

		 answers[0].setAll("Tinker", 1, 0, 1, false);
		 answers[1].setAll("Nemo",4,0,2,false);
		 answers[2].setAll("Cinderella",0,1,3,true);
		 answers[3].setAll("Woody",3,3,4,true);
		 answers[4].setAll("White",12,3,5,false);
		 answers[5].setAll("BuzzLightyear",16,4,6,false);
		 answers[6].setAll("Remy",1,5,7,true);
		 answers[7].setAll("McQueen",3,5,8,false);
		 answers[8].setAll("Cheshire",9,5,9,false);
		 answers[9].setAll("Nemo",4,0,10,false);
		 answers[10].setAll("Cinderella",0,1,11,true);
		 answers[11].setAll("Woody",3,3,12,true);
		 answers[12].setAll("White",12,3,13,false);
		 answers[13].setAll("BuzzLightyear",16,4,14,false);
		 answers[14].setAll("Remy",1,5,15,true);
		 answers[15].setAll("McQueen",3,5,16,false);
		 answers[16].setAll("Cheshire",9,5,17,false);
		 answers[17].setAll("Nemo",4,0,18,false);
		 answers[18].setAll("Cinderella",0,1,19,true);
		 answers[19].setAll("Woody",3,3,20,true);
		 answers[20].setAll("White",12,3,21,false);
		 answers[21].setAll("BuzzLightyear",16,4,22,false);
		// answers[22].setAll("Remy",1,5,23,true);
		// answers[23].setAll("McQueen",3,5,10,false);
		//  answers[24].setAll("Cheshire",9,5,9,false);
		 

	}

	public void setGrid() {
		for (int w = 0; w < 22; w++) {
			String dummy = answers[w].getAnswer();
			int dummyX = answers[w].getY();
			int dummyY = answers[w].getX();
			int clueNum = answers[w].getClueNumber();
			boolean isHorizontal = !answers[w].getAlignment();
			for (int x = 0; x < wordPlacements.length; x++) {
				for (int y = 0; y < wordPlacements[0].length; y++) {
					if (x == dummyX && y == dummyY) {
						for (int z = 0; z < dummy.length(); z++) {
							if (isHorizontal == true) {
								btnNumbers[dummyX + z][dummyY].setEditable(true);
							} else {
								btnNumbers[x][y + z].setEditable(true);
							}
						}
						btnNumbers[x][y].setText("" + clueNum);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Crossword();
	}

	@Override
	public void windowClosing(WindowEvent evt) {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
	}

	@Override
	public void windowOpened(WindowEvent evt) {
	}

	@Override
	public void windowClosed(WindowEvent evt) {
	}

	@Override
	public void windowIconified(WindowEvent evt) {
	}

	@Override
	public void windowDeiconified(WindowEvent evt) {
	}

	@Override
	public void windowActivated(WindowEvent evt) {
	}

	@Override
	public void windowDeactivated(WindowEvent evt) {
	}
}
