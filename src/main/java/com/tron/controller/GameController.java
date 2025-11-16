package com.tron.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.tron.model.game.*;
import com.tron.view.game.*;
import com.tron.view.menu.*;

public class GameController implements Runnable {
	
	private JFrame frame;
	private MainMenuView mainMenuView;
	private PlayMenuView playMenuView;
	private SurvivalGameView survivalGameView;
	private TwoPlayerGameView twoPlayerGameView;
	private StoryGameView storyGameView;
	
	private boolean instructOn = false;
	private boolean scoresOn = false;
	
	public void run() {
		// Top-level frame
		frame = new JFrame("Tron");
		frame.setBackground(Color.BLACK);
		frame.setPreferredSize(new Dimension(500, 560));
		frame.setLocation(400, 100);
		frame.setResizable(false);
		
		// Initialize views
		mainMenuView = new MainMenuView();
		playMenuView = new PlayMenuView();
		
		// Create temporary labels for game maps
		JLabel tempSurvLabel = new JLabel("   Score: 0" + "   Boost: 3");
		JLabel tempTwoLabel1 = new JLabel("   Player 1: 0" + "    Boost: 3");
		JLabel tempTwoLabel2 = new JLabel("   Player 2: 0" + "    Boost: 3");
		JLabel tempStoryLabel1 = new JLabel("     Score: = 0" + "    Level: 1");
		JLabel tempStoryLabel2 = new JLabel("             Boost: 3");
		
		// Initialize game maps with temporary labels
		TronMapSurvival levelSurv = new TronMapSurvival(tempSurvLabel, 1);
		TronMapTwoPlayer levelTwoPlayer = new TronMapTwoPlayer(tempTwoLabel1, tempTwoLabel2, 2);
		TronMapStory levelStory = new TronMapStory(tempStoryLabel1, tempStoryLabel2, 2);
		
		// Initialize game views (views will use labels from gameMap)
		survivalGameView = new SurvivalGameView(levelSurv);
		twoPlayerGameView = new TwoPlayerGameView(levelTwoPlayer);
		storyGameView = new StoryGameView(levelStory);
		
		// Add main menu to frame
		frame.add(mainMenuView);
		
		// Setup action listeners
		setupMainMenuListeners();
		setupPlayMenuListeners(levelSurv);
		setupGameListeners();
		
		// Put the frame on the screen
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Start the game running
		levelSurv.reset();
		levelTwoPlayer.reset();
		levelStory.reset();
	}
	
	private void setupMainMenuListeners() {
		mainMenuView.getPlayButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuView);
				frame.add(playMenuView);
				frame.update(frame.getGraphics());
				playMenuView.revalidate();
			}
		});
		
		mainMenuView.getInstructionsButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instructOn = !instructOn;
				mainMenuView.showInstructions(instructOn);
				frame.repaint();
			}
		});
		
		mainMenuView.getQuitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}
	
	private void setupPlayMenuListeners(TronMapSurvival levelSurv) {
		playMenuView.getHighScoresButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (scoresOn) {
					playMenuView.showGameModes();
				} else {
					playMenuView.showHighScores(levelSurv.getHighs());
				}
				scoresOn = !scoresOn;
				frame.repaint();
			}
		});
		
		playMenuView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(playMenuView);
				frame.add(mainMenuView);
				frame.update(frame.getGraphics());
			}
		});
	}
	
	private void setupGameListeners() {
		// Survival mode
		playMenuView.getSurvivalButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(playMenuView);
				frame.setLayout(new BorderLayout());
				frame.add(survivalGameView.getGameMap(), BorderLayout.CENTER);
				frame.add(survivalGameView, BorderLayout.SOUTH);
				frame.update(frame.getGraphics());
				survivalGameView.getGameMap().requestFocusInWindow();
				survivalGameView.getGameMap().revalidate();
				survivalGameView.getGameMap().reset();
			}
		});
		
		survivalGameView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				survivalGameView.getGameMap().reset();
			}
		});
		
		survivalGameView.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(survivalGameView.getGameMap());
				frame.remove(survivalGameView);
				frame.add(playMenuView);
				frame.update(frame.getGraphics());
				playMenuView.revalidate();
			}
		});
		
		// Two player mode
		playMenuView.getTwoPlayerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(playMenuView);
				frame.setLayout(new BorderLayout());
				frame.add(twoPlayerGameView.getGameMap(), BorderLayout.CENTER);
				frame.add(twoPlayerGameView, BorderLayout.SOUTH);
				frame.update(frame.getGraphics());
				twoPlayerGameView.getGameMap().requestFocusInWindow();
				twoPlayerGameView.getGameMap().revalidate();
				twoPlayerGameView.getGameMap().reset();
			}
		});
		
		twoPlayerGameView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				twoPlayerGameView.getGameMap().reset();
			}
		});
		
		twoPlayerGameView.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(twoPlayerGameView.getGameMap());
				frame.remove(twoPlayerGameView);
				frame.add(playMenuView);
				frame.update(frame.getGraphics());
				playMenuView.revalidate();
				twoPlayerGameView.getGameMap().restartGame();
			}
		});
		
		// Story mode
		playMenuView.getStoryButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(playMenuView);
				frame.setLayout(new BorderLayout());
				frame.add(storyGameView.getGameMap(), BorderLayout.CENTER);
				frame.add(storyGameView, BorderLayout.SOUTH);
				frame.update(frame.getGraphics());
				storyGameView.getGameMap().requestFocusInWindow();
				storyGameView.getGameMap().revalidate();
				storyGameView.getGameMap().reset();
			}
		});
		
		storyGameView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storyGameView.getGameMap().reset();
			}
		});
		
		storyGameView.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(storyGameView.getGameMap());
				frame.remove(storyGameView);
				frame.add(playMenuView);
				frame.update(frame.getGraphics());
				playMenuView.revalidate();
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new GameController());
	}
}

