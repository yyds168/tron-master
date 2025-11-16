package com.tron.view.menu;

import java.awt.*;
import javax.swing.*;

import com.tron.model.util.Picture;

@SuppressWarnings("serial")
public class PlayMenuView extends JPanel {
	
	private JButton storyButton;
	private JButton survivalButton;
	private JButton twoPlayerButton;
	private JButton highScoresButton;
	private JButton backButton;
	private JPanel playMenuUpper;
	
	public PlayMenuView() {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		// panel that displays an image or high scores and game type buttons
		playMenuUpper = new JPanel();
		playMenuUpper.setLayout(new GridLayout(2, 1));
		playMenuUpper.setBackground(Color.BLACK);
		
		// panel that holds the buttons for each game type
		JPanel modes = new JPanel();
		modes.setLayout(new GridLayout(1, 3));
		modes.setBackground(Color.BLACK);
		
		// buttons for playMenuUpper
		storyButton = new JButton(loadIcon("story.png"));
		modes.add(storyButton);
		survivalButton = new JButton(loadIcon("survival.png"));
		modes.add(survivalButton);
		twoPlayerButton = new JButton(loadIcon("two_player.png"));
		modes.add(twoPlayerButton);
		
		// an image to be displayed by playMenuUpper
		JComponent menuPict = new JComponent() {
			public void paintComponent(Graphics gc) {
				super.paintComponent(gc);
				Picture.draw(gc, "play_menu.jpg", 0, 0);
			}
		};
		
		// adds panels to playMenuUpper
		playMenuUpper.add(modes);
		playMenuUpper.add(menuPict);
		
		// panel that hold high score and main menu buttons
		JPanel bottomMenu = new JPanel();
		bottomMenu.setBackground(Color.BLACK);
		
		// buttons for bottomMenu
		highScoresButton = new JButton(loadIcon("high_scores.png"));
		bottomMenu.add(highScoresButton);
		backButton = new JButton(loadIcon("main_menu.png"));
		bottomMenu.add(backButton);
		
		// adds bottomMenu and playMenuUpper to playMenu
		add(playMenuUpper, BorderLayout.CENTER);
		add(bottomMenu, BorderLayout.SOUTH);
	}
	
	public JButton getStoryButton() {
		return storyButton;
	}
	
	public JButton getSurvivalButton() {
		return survivalButton;
	}
	
	public JButton getTwoPlayerButton() {
		return twoPlayerButton;
	}
	
	public JButton getHighScoresButton() {
		return highScoresButton;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JPanel getPlayMenuUpper() {
		return playMenuUpper;
	}
	
	public void showHighScores(JPanel highScoresPanel) {
		playMenuUpper.removeAll();
		playMenuUpper.add(highScoresPanel);
		playMenuUpper.revalidate();
		repaint();
	}
	
	public void showGameModes() {
		playMenuUpper.removeAll();
		JPanel modes = new JPanel();
		modes.setLayout(new GridLayout(1, 3));
		modes.setBackground(Color.BLACK);
		modes.add(storyButton);
		modes.add(survivalButton);
		modes.add(twoPlayerButton);
		
		JComponent menuPict = new JComponent() {
			public void paintComponent(Graphics gc) {
				super.paintComponent(gc);
				Picture.draw(gc, "play_menu.jpg", 0, 0);
			}
		};
		
		playMenuUpper.add(modes);
		playMenuUpper.add(menuPict);
		playMenuUpper.revalidate();
		repaint();
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

