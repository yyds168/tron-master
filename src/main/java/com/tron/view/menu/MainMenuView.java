package com.tron.view.menu;

import java.awt.*;
import javax.swing.*;

import com.tron.model.util.Picture;

@SuppressWarnings("serial")
public class MainMenuView extends JPanel {
	
	private JButton playButton;
	private JButton instructionsButton;
	private JButton quitButton;
	private JComponent pictureComponent;
	private JComponent instructionsComponent;
	
	public MainMenuView() {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		// main menu screen image
		pictureComponent = new JComponent() {
			public void paintComponent(Graphics gc) {
				super.paintComponent(gc);
				Picture.draw(gc, "tron0_0.jpg", 0, 0);
			}
		};
		
		// instructions image
		instructionsComponent = new JComponent() {
			public void paintComponent(Graphics gc) {
				super.paintComponent(gc);
				Picture.draw(gc, "instructions_page.png", 0, 0);
			}
		};
		
		// panel for main menu buttons
		JPanel topMenu = new JPanel();
		topMenu.setLayout(new GridLayout(1, 3));
		topMenu.setBackground(Color.BLACK);
		
		// buttons for main menu
		playButton = new JButton(loadIcon("play_before.png"));
		topMenu.add(playButton);
		instructionsButton = new JButton(loadIcon("instructions_before.png"));
		topMenu.add(instructionsButton);
		quitButton = new JButton(loadIcon("quit_before.png"));
		topMenu.add(quitButton);
		
		// adds components to the main menu panel
		add(pictureComponent, BorderLayout.CENTER);
		add(topMenu, BorderLayout.SOUTH);
	}
	
	public JButton getPlayButton() {
		return playButton;
	}
	
	public JButton getInstructionsButton() {
		return instructionsButton;
	}
	
	public JButton getQuitButton() {
		return quitButton;
	}
	
	public JComponent getPictureComponent() {
		return pictureComponent;
	}
	
	public JComponent getInstructionsComponent() {
		return instructionsComponent;
	}
	
	public void showInstructions(boolean show) {
		removeAll();
		if (show) {
			add(instructionsComponent, BorderLayout.CENTER);
			instructionsButton.setIcon(loadIcon("main_menu.png"));
		} else {
			add(pictureComponent, BorderLayout.CENTER);
			instructionsButton.setIcon(loadIcon("instructions_before.png"));
		}
		JPanel topMenu = new JPanel();
		topMenu.setLayout(new GridLayout(1, 3));
		topMenu.setBackground(Color.BLACK);
		topMenu.add(playButton);
		topMenu.add(instructionsButton);
		topMenu.add(quitButton);
		add(topMenu, BorderLayout.SOUTH);
		revalidate();
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

