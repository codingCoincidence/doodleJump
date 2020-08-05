package com.sivis.doodlejump;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class SaveScore {

	String reachedScore;

	public SaveScore(int score, String userName) {

		saveScore(score, userName);

	}

	public void saveScore(int score, String userName) {
		
		if(GlobalElements.userName.length() > 5 ) {		
		
		reachedScore = userName + "               " + score;
		
		} else if (GlobalElements.userName.length() > 7) {
			reachedScore = userName + "           " + score;
		} else if (GlobalElements.userName.length() > 10) {
			reachedScore = userName + "         " + score;
		} else if (GlobalElements.userName.length() > 13) {
			reachedScore = userName + "      " + score;
		} else if (GlobalElements.userName.length() > 14) {
			reachedScore = userName + "    " + score;
		} else {
			reachedScore = userName + "                  " + score;
		}

		GlobalElements.scoresToSave.add(reachedScore);

		compareScores();

		if (GlobalElements.scoresToSave.size() > 6) {
			GlobalElements.scoresToSave.removeLast();
		}

		File scoresFile = new File(GlobalElements.scoreLocation);
		if (!scoresFile.exists()) {
			try {
				File directory = new File(scoresFile.getParent());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				scoresFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Excepton creating score file: " + e.toString());
			}
		}

		try {
			FileWriter scoreWriter = new FileWriter(scoresFile.getAbsoluteFile(), false);

			BufferedWriter bufferWriter = new BufferedWriter(scoreWriter);
			for (int i = 0; i < GlobalElements.scoresToSave.size(); i++) {
				bufferWriter.write(GlobalElements.scoresToSave.get(i));
				bufferWriter.newLine();
			}
			bufferWriter.close();
			System.out.println("Score successfully saved: " + reachedScore);
		} catch (IOException e) {
			System.out.println("Excepton saving score: " + e.toString());
		}

	}

	public void compareScores() {

		Collections.sort(GlobalElements.scoresToSave, new Comparator<String>() {
			public int compare(String string1, String string2) {
				return extractInt(string2) - extractInt(string1);
			}

			int extractInt(String s) {
				String num = s.replaceAll("\\D", "");
				return num.isEmpty() ? 0 : Integer.parseInt(num);
			}
		});
	}

}