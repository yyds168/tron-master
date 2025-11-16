package com.tron.view.game;

import java.awt.*;
import javax.swing.*;

import com.tron.model.game.TronMapTwoPlayer;

@SuppressWarnings("serial")
public class TwoPlayerGameView extends JPanel {
	
	private TronMapTwoPlayer gameMap;
	private JLabel scoreLabel1;
	private JLabel scoreLabel2;
	private JButton resetButton;
	private JButton exitButton;
	
	public TwoPlayerGameView(TronMapTwoPlayer gameMap) {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		this.gameMap = gameMap;
		gameMap.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		// panel that holds the buttons and labels for two-player mode
		JPanel twoMenu = new JPanel();
		twoMenu.setLayout(new GridLayout(1, 4));
		twoMenu.setBackground(Color.BLACK);
		
		// panel that holds the scores and boost for each player
		JPanel scoresTwo = new JPanel();
		scoresTwo.setLayout(new GridLayout(2, 1));
		scoresTwo.setBackground(Color.BLACK);
		
		// use the labels from gameMap
		scoreLabel1 = gameMap.getScore1();
		scoreLabel2 = gameMap.getScore2();
		if (scoreLabel1 == null) {
			scoreLabel1 = new JLabel("   Player 1: 0" + "    Boost: 3");
			gameMap.setScore1(scoreLabel1);
		}
		if (scoreLabel2 == null) {
			scoreLabel2 = new JLabel("   Player 2: 0" + "    Boost: 3");
			gameMap.setScore2(scoreLabel2);
		}
		scoreLabel1.setForeground(Color.WHITE);
		scoreLabel1.setBackground(Color.BLACK);
		scoreLabel2.setForeground(Color.WHITE);
		scoreLabel2.setBackground(Color.BLACK);
		scoresTwo.add(scoreLabel1);
		scoresTwo.add(scoreLabel2);
		twoMenu.add(scoresTwo);
		
		// the reset and main menu buttons for two-player mode
		resetButton = new JButton(loadIcon("restart.png"));
		twoMenu.add(resetButton);
		exitButton = new JButton(loadIcon("play_before.png"));
		twoMenu.add(exitButton);
		
		add(gameMap, BorderLayout.CENTER);
		add(twoMenu, BorderLayout.SOUTH);
	}
	
	public TronMapTwoPlayer getGameMap() {
		return gameMap;
	}
	
	public JLabel getScoreLabel1() {
		return scoreLabel1;
	}
	
	public JLabel getScoreLabel2() {
		return scoreLabel2;
	}
	
	public JButton getResetButton() {
		return resetButton;
	}
	
	public JButton getExitButton() {
		return exitButton;
	}
	
	private ImageIcon loadIcon(String filename) {
		java.net.URL imgURL = getClass().getResource("/" + filename);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return new ImageIcon("src/main/resources/" + filename);
		}
	}
}

