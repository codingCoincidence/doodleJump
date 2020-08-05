package com.sivis.doodlejump;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartMenu extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static JFrame startMenu;
    static JPanel startMenuPanel;
    static JButton play;
    static JButton scores;
    JButton challenge;
    JButton options;
    static Boolean openInstructions = false;
    JOptionPane createUserName = new JOptionPane();

    public StartMenu(int width, int height) {

        createStartMenu(width, height);
        startMenu.requestFocus();
        GlobalElements.highScore = new HighScore(450, 600);
        HighScore.scoreFrame.setVisible(false);

    }

    public void createStartMenu(int width, int height) {
        startMenu = createFrame(width, height);
        startMenuPanel = drawBackground("etc/img/startMenu.png", StartMenu.class);
              play = createButtons(70, 160, 160, 50, GlobalElements.getURL("etc/img/doodleR-Big.png", StartMenu.class));
        scores = createButtons(270, 400, 160, 70, GlobalElements.getURL("etc/img/rocketCollectible.png", StartMenu.class));
        options = createButtons(230, 470, 160, 70, GlobalElements.getURL("etc/img/bat1.png", StartMenu.class));
        challenge = createButtons(90, 230, 160, 50, GlobalElements.getURL("etc/img/monster2.png", StartMenu.class));
        addComponents(width, height);
        
      startMenu.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                  startMenu.dispose();
                    System.exit(0);    // force application exit
            }
      });

    }

    @Override
    public void addComponents(int width, int height) {

        startMenuPanel.add(play);
        startMenuPanel.add(options);
        startMenuPanel.add(scores);
        startMenuPanel.add(challenge);
        startMenu.add(startMenuPanel);
        startMenu.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == options) {
            new Options(450, 600);
        } else if (e.getSource() == play) {
            startGame();
        } else if (e.getSource() == scores) {
            new HighScore(450, 600);
        } else if (e.getSource() == challenge) {
            new Challenge(450, 600);
        }

    }

    public void startGame() {

        String userName = JOptionPane.showInputDialog(startMenu, "Valid usernames may contain characters only!",
                "ENTER A VALID USERNAME", JOptionPane.PLAIN_MESSAGE);

        if ((userName != null) && (userName.length() > 0) && (userName.length() <= 15) && (userName.matches("[a-zA-Z]+"))) {

            GlobalElements.globalElements = new GlobalElements();
            GlobalElements.numberOfGreenPlatforms = 20;
            GlobalElements.monsterDelay = 20000;
            GlobalElements.doodleX = GlobalElements.screenWidth / 2;
            GlobalElements.doodleY = GlobalElements.screenHeight / 1.18;
            GlobalElements.userName = userName;
            GlobalElements.score = 0;
            GlobalElements.killed = false;
            GlobalElements.killedMonster = false;
            GlobalElements.bluePlatformSpeed = 1;
            GlobalElements.initialPlatform = new InitialPlatform();
            GlobalElements.gameFrame = new GameFrame();
            GlobalElements.draw = new Draw();
            GlobalElements.keyActions = new KeyActions();
            GlobalElements.monsters = new Monster();
            GlobalElements.gameTimer = new GameTimer();
            GlobalElements.doodleMovement = new DoodleMovement();
            GlobalElements.collision = new Hit();
            GlobalElements.hitSpecial = new HitSpecial();
            GlobalElements.shoots = new Shoot();
            GlobalElements.jump = new Jump();
            GlobalElements.movingPlatform = new MovePlatform();

            startMenu.dispose();
            GlobalElements.playFrame.requestFocus();

        } else if ((userName != null)
                && (userName.length() > 15 ) | (userName.length() == 0) | (!userName.matches("[^a-zA-Z]+")) | (userName.matches("[0-9]"))) {
            JOptionPane userNameMustBeCreated = new JOptionPane();
            JOptionPane.showMessageDialog(startMenu,
                    "Oups, your choosen username seems to be invalid, please note our username guidelines", "WARNING",
                    JOptionPane.WARNING_MESSAGE);
            userNameMustBeCreated.setVisible(true);

        } else {

            createUserName.setVisible(false);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_F1) {

            new Instructions(600, 800);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
