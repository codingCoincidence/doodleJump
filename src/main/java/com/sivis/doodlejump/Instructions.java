package com.sivis.doodlejump;


import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Instructions extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    JFrame instructionFrame;
    Image instructions;
    JPanel instructionPanel;

    public Instructions(int width, int height) {

        showInstructions(width, height);

    }

    public void showInstructions(int width, int height) {

        instructionFrame = createFrame(width, height);
        instructionPanel = drawBackground("etc/img/Instructions-1.png", Instructions.class);
        addComponents(width, height);
    }

    @Override
    public void addComponents(int width, int height) {
        instructionFrame.add(instructionPanel);
        instructionFrame.setVisible(true);
    }

   

}