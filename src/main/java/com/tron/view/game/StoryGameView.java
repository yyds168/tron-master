package com.tron.view.game;

import java.awt.*;
import javax.swing.*;

import com.tron.model.game.TronMapStory;

@SuppressWarnings("serial")
public class StoryGameView extends JPanel {
	
	private TronMapStory gameMap;
	private JLabel scoreLabel1;
	private JLabel scoreLabel2;
	private JButton resetButton;
	private JButton exitButton;
	
	public StoryGameView(TronMapStory gameMap) {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		this.gameMap = gameMap;
		gameMap.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		// panel that holds the buttons and labels for story mode
		JPanel storyMenu = new JPanel();
		storyMenu.setLayout(new GridLayout(1, 4));
		storyMenu.setBackground(Color.BLACK);
		
		// panel that holds the score, level number, and boost
		JPanel scoresStory = new JPanel();
		scoresStory.setLayout(new GridLayout(2, 1));
		scoresStory.setBackground(Color.BLACK);

		// use the labels from gameMap
		scoreLabel1 = gameMap.getScore1();
		scoreLabel2 = gameMap.getScore2();
		if (scoreLabel1 == null) {
			scoreLabel1 = new JLabel("     Score: = 0" + "    Level: 1");
			gameMap.setScore1(scoreLabel1);
		}
		if (scoreLabel2 == null) {
			scoreLabel2 = new JLabel("             Boost: 3");
			gameMap.setScore2(scoreLabel2);
		}
		scoreLabel1.setForeground(Color.WHITE);
		scoreLabel1.setBackground(Color.BLACK);
		scoreLabel2.setForeground(Color.WHITE);
		scoreLabel2.setBackground(Color.BLACK);
		scoresStory.add(scoreLabel1);
		scoresStory.add(scoreLabel2);
		storyMenu.add(scoresStory);
		
		// buttons for reseting the game and returning to the play menu
		resetButton = new JButton(loadIcon("restart.png"));
		storyMenu.add(resetButton);
		exitButton = new JButton(loadIcon("play_before.png"));
		storyMenu.add(exitButton);
		
		add(gameMap, BorderLayout.CENTER);
		add(storyMenu, BorderLayout.SOUTH);
	}
	
	public TronMapStory getGameMap() {
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

