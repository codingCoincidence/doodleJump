
package com.sivis.doodlejump;

public class Score {

    public Score() {
        editScore();
    }

    public void editScore() {

        if (GameTimer.timer.isRunning()) {

            GlobalElements.score += 0.05;

        }

    }

}