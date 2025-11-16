package com.tron.view.game;

import java.awt.*;
import javax.swing.*;

import com.tron.model.game.TronMapSurvival;

@SuppressWarnings("serial")
public class SurvivalGameView extends JPanel {
	
	private TronMapSurvival gameMap;
	private JLabel scoreLabel;
	private JButton resetButton;
	private JButton exitButton;
	
	public SurvivalGameView(TronMapSurvival gameMap) {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		this.gameMap = gameMap;
		gameMap.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		// panel that holds the buttons and label for the survival mode
		JPanel survMenu = new JPanel();
		survMenu.setLayout(new GridLayout(1, 3));
		survMenu.setBackground(Color.BLACK);
		
		// use the label from gameMap
		scoreLabel = gameMap.getScore1();
		if (scoreLabel == null) {
			scoreLabel = new JLabel("   Score: 0" + "   Boost: 3");
			scoreLabel.setForeground(Color.WHITE);
			scoreLabel.setBackground(Color.BLACK);
			gameMap.setScore1(scoreLabel);
		}
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBackground(Color.BLACK);
		survMenu.add(scoreLabel);
		
		// buttons for returning to the menu and reseting the game
		resetButton = new JButton(loadIcon("restart.png"));
		survMenu.add(resetButton);
		exitButton = new JButton(loadIcon("play_before.png"));
		survMenu.add(exitButton);
		
		add(gameMap, BorderLayout.CENTER);
		add(survMenu, BorderLayout.SOUTH);
	}
	
	public TronMapSurvival getGameMap() {
		return gameMap;
	}
	
	public JLabel getScoreLabel() {
		return scoreLabel;
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

