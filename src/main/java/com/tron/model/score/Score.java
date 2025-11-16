package com.tron.model.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Score {
	
	// list of scores
	private List<Integer> highs;
	private String file;
	
	// constructor creates list of integers from .txt file
	public Score(String filename) {
		file = filename;
		try {
			highs = new ArrayList<Integer>();
			// Try to load from resources first
			InputStream is = Score.class.getResourceAsStream("/" + filename);
			BufferedReader in;
			if (is != null) {
				in = new BufferedReader(new InputStreamReader(is));
			} else {
				// Fallback to file system
				in = new BufferedReader(new FileReader(filename));
			}
			String r = in.readLine();
			int j = 0;
			while (r != null && j < 10) {
				r.trim();
				highs.add(Integer.parseInt(r));
				j++;
				r = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			highs = new ArrayList<Integer>();
		}
	}
	
	// adds a new score into the list, sorts the list,
	// and updates the .txt file
	public void addHighScore(int i) throws IOException {
		highs.add(i);
		List<Integer> sorted = new LinkedList<Integer>(highs);
		Collections.sort(sorted);
		Collections.reverse(sorted);
		while (sorted.size() > 10) {
			sorted.remove(sorted.size() - 1);
		}
		highs = sorted;
		
		try {
			// Write to resources directory if possible, otherwise to file system
			File outputFile = new File("src/main/resources/" + file);
			if (!outputFile.exists()) {
				outputFile = new File(file);
			}
			PrintStream out = new PrintStream(outputFile);
			for (int j = 0; j < highs.size(); j++) {
				out.print(highs.get(j));
				if (j != highs.size() - 1) {
					out.print('\n');
				}
			}
			out.close();
		} catch (IOException e) {
		}
	}

	// returns the list of high scores
	public List<Integer> getHighScores() {
 		return highs;
	}
}

