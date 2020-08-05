
package com.sivis.doodlejump;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HighScore extends Frame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	static JFrame scoreFrame;
	BufferedImage scoreBackground;
	JPanel scorePanel;
	JTable scoreTable;
	JButton returnToMenu;
	List<String> scores;

	public HighScore(int width, int height) {

		showScores(width, height);
		StartMenu.startMenu.requestFocus();

	}

	public void showScores(int width, int height) {

		scoreFrame = createFrame(width, height);
		scorePanel = drawBackground("etc/img/scores.png", HighScore.class);
		scoreTable = createScoreTable();
		returnToMenu = createButtons(200, 450, 230, 20, "Return to main Menu");
		addComponents(width, height);

	}

	public JTable createScoreTable() {

		scores = readScoresToList(GlobalElements.getURL("etc/Highscores.txt", HighScore.class));
		JTable table = fillTable(scores);

		return table;
	}

	public List<String> readScoresToList(URL url) {

		GlobalElements.scoresToSave = new LinkedList<>();
		List<String> lines = new ArrayList<>();

		try {
			File scoresFile = new File(GlobalElements.scoreLocation);
			BufferedReader bufferedReader = null;
			if (!scoresFile.exists()) {
				System.out.println("No local score file found.");
				bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

			} else {
				System.out.println("Reading score from local file.");
				bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(scoresFile)));
			}
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add((line));

			}
			bufferedReader.close();

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("could not load scores");
		}

		for (int i = 0; i < lines.size(); i++) {
			GlobalElements.scoresToSave.add(lines.get(i));
		}

		return lines;

	}

	public JTable fillTable(List<String> scores) {

		JTable table = new JTable();
		String[] header = { "Score" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		table.setModel(model);

		for (int i = 0; i < scores.size(); i++) {
			model.addRow(new Object[] { scores.get(i) });
		}

		table.setBounds(120, 150, 290, 250);
		table.setShowGrid(false);
		table.setOpaque(false);
		table.setRowHeight(41);
		table.setFont(GlobalElements.font);
		table.setBackground(new Color(0, 0, 0, 0));
		table.setEnabled(false);

		return table;

	}
	
	 public JButton createButtons(int x, int y, int width, int height, String path) {

	        button = new JButton(path);
	        button.addMouseListener(this);
	        button.setBorder(GlobalElements.border);
	        button.setFont(GlobalElements.font);
	        button.setBounds(x, y, width, height);
	        button.setOpaque(false);

	        return button;
	    }

	@Override
	public void addComponents(int widht, int height) {

		scorePanel.add(scoreTable);
		scorePanel.add(returnToMenu);
		scoreFrame.add(scorePanel);
		scoreFrame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == returnToMenu) {
			scoreFrame.dispose();

		}

	}

}