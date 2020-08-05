package com.sivis.doodlejump;

import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;

public class GameOver extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JFrame gameOverFrame;
    JButton returnToMenu;
    JPanel gameOverPanel;
    int score;
    int width;
    int height;

    public GameOver(int width, int height) {

        score = (int) GlobalElements.score;
        new SaveScore(score, GlobalElements.userName);
        endGame(width, height);
        killAllInstances();
        

    }

    public void endGame(int width, int height) {

        this.width = width;
        this.height = height;

        gameOverFrame = createFrame(width, height);
        drawPanel();
        returnToMenu = createButtons(70, 160, 160, 50, GlobalElements.getURL("etc/img/doodleR-Big.png", GameOver.class));

        addComponents(width, height);
        gameOverFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
            	gameOverFrame.dispose();
                    System.exit(0);    // force application exit
            }
      });

    }

    @Override
    public void addComponents(int width, int height) {

        gameOverPanel.add(returnToMenu);
        gameOverPanel.setSize(width, height);
        gameOverPanel.setBounds(0, 0, width, height);
        gameOverPanel.setBorder(GlobalElements.border);
        gameOverPanel.setOpaque(true);
        gameOverPanel.setVisible(true);
        gameOverFrame.add(gameOverPanel);
        gameOverFrame.setVisible(true);

    }

    public void drawPanel() {

        gameOverPanel = new JPanel() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g.drawImage(GlobalElements.gameOverImage, 0, 0, width, height, null);
                g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 34));
                g.setColor(Color.orange);

                g.drawString(String.valueOf(score), 300, 410);

                repaint();
            }
        };

        gameOverPanel.setLayout(null);

    }

    private void killAllInstances() {

        GlobalElements.time = 0.3;
        GlobalElements.moveLeft = false;
        GlobalElements.moveRight = false;
        GlobalElements.gameFrame = null;
        GlobalElements.draw = null;
        GlobalElements.keyActions = null;
        GlobalElements.monsters = null;
        GlobalElements.gameTimer = null;
        GlobalElements.doodleMovement = null;
        GlobalElements.collision = null;
        GlobalElements.hitSpecial = null;
        GlobalElements.shoots = null;
        GlobalElements.jump = null;
        GlobalElements.movingPlatform = null;
        GlobalElements.globalElements = null;
        GlobalElements.editScore = null;
        GreenPlatform greenPlatform = null;
        BluePlatform bluePlatform = null;
        WhitePlatform whitePlatform = null;
        BrownPlatform brownPlatform = null;
        SpringPlatform springPlatform = null;
        RocketPlatform rocketPlatform = null;
        DarkPlatforms darkPlatform = null;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == returnToMenu) {
            new StartMenu(450, 600);
            gameOverFrame.dispose();
        }

    }
}