
package com.sivis.doodlejump;

public class EditScore {

    public EditScore() {
        editScore();
    }

    public void editScore() {

        if (GameTimer.timer.isRunning()) {

            GlobalElements.score += 0.05;

        }

    }

}