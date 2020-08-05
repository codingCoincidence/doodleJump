package com.sivis.doodlejump;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Options extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JFrame optionFrame;
    BufferedImage options;
    JPanel optionPanel;
    JButton mute;
    JButton unmute;
    JButton returnToMenu;
    static JTextField changeScreenWidth;
    static JTextField changeScreenHeight;
    JButton submit;
    JLabel setWidth;
    JLabel setHeight;

    public Options(int width, int height) {

        showOptions(width, height);
        StartMenu.startMenu.requestFocus();

    }
    
    public boolean checkFrameSize(int desiredHeight) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(desiredHeight >= screenSize.height - 100) {
			return false;
			} else {	
			return true;
		}
				
	}

    public void showOptions(int width, int height) {

        optionFrame = createFrame(width, height);
        optionPanel = drawBackground("etc/img/border-f.png", Options.class);

        mute = createButtons(120, 200, 200, 50, "mute game sound");
        unmute = createButtons(120, 260, 200, 50, "umute game sound");
        returnToMenu = createButtons(100, 450, 230, 20, "Return to main Menu");
        createTextFields();

        addComponents(width, height);

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
    public void addComponents(int width, int height) {

        optionPanel.add(mute);
        optionPanel.add(unmute);
        optionPanel.add(returnToMenu);
        optionPanel.add(changeScreenHeight);
        optionPanel.add(changeScreenWidth);

        optionPanel.add(submit);
        optionFrame.add(optionPanel);
        optionFrame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == mute) {
            GlobalElements.enableSound = false;
            System.out.println(GlobalElements.enableSound);
        }

        if (e.getSource() == unmute) {
            GlobalElements.enableSound = true;
            System.out.println(GlobalElements.enableSound);
        }
        
        if (e.getSource() == returnToMenu) {
        	optionFrame.dispose();
        }

        if (e.getSource() == submit) {
            try {
               int screenWidth = Integer.parseInt(changeScreenWidth.getText());
               int screenHeight = Integer.parseInt(changeScreenHeight.getText());
                GlobalElements.backY2 = -GlobalElements.screenHeight;
                GlobalElements.backY1 = 0;
                
                if (checkFrameSize(screenHeight)) {
                	
                	GlobalElements.screenHeight = screenHeight;
                	GlobalElements.screenWidth = screenWidth;
                	 GlobalElements.backY2 = -screenHeight;
                	showConfirmMessage();
                	
                } else {
                	setInitialFrameSize();
                	showErrorMessage("Your game canvas can not be greater than your screensize");
                }


            } catch (NumberFormatException a) {            
            	setInitialFrameSize();
                showErrorMessage("Oups, values must be integers");
            }

        }
    }
    
    public void setInitialFrameSize() {
    	  GlobalElements.screenHeight = 1000;
          GlobalElements.backY2 = -1000;
          GlobalElements.backY1 = 0;
          GlobalElements.screenWidth = 700;    	
    }

    public void createTextFields() {
        changeScreenHeight = new JTextField("change screenheight here");
        changeScreenWidth = new JTextField("change screenwidth here");
        setWidth = new JLabel("screenwidth for game field");
        setHeight = new JLabel("screenheight for game field");
        changeScreenHeight.setBounds(120, 350, 200, 20);
        changeScreenWidth.setBounds(120, 375, 200, 20);
        submit = new JButton("submit");
        submit.setBounds(170, 400, 100, 20);
        submit.addMouseListener(this);

    }

    public void showConfirmMessage(){
        JOptionPane validInput = new JOptionPane();
        JOptionPane.showMessageDialog(optionPanel,
                "SCREENHEIGHT is set to " + changeScreenHeight.getText() + " and SCREENWIDTH is set to " + changeScreenWidth.getText(), "Sizes of game field successfully changed",
                JOptionPane.INFORMATION_MESSAGE);
        validInput.setVisible(true);

    }

    public void showErrorMessage(String errorText) {
        JOptionPane invalidInput = new JOptionPane();
        JOptionPane.showMessageDialog(optionPanel,
               errorText + " , game field size is set to default", "WARNING",
                JOptionPane.WARNING_MESSAGE);
        invalidInput.setVisible(true);
    }

}
