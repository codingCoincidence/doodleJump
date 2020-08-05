package com.sivis.doodlejump;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Challenge extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JFrame challengeFrame;
    BufferedImage challengeBackground;
    JPanel challengePanel;
    JButton returnToMenu;
    int width;
    int height;

    int doodleY;
    String doodle;
    int monster1X;
    int monster2X;
    int monster3X;
    int turningPointUDoodle;
    int turningPointDDoodle;
    int turningPointRMonster1;
    int turningPointLMonster1;
    int turningPointRMonster2;
    int turningPointLMonster2;
    int turningPointRMonster3;
    int turningPointLMonster3;
    String doodleDirection = "left", monster1Direction = "right", monster2Direction = "left",
            monster3Direction = "right";

    public Challenge(int width, int height) {

        initializeVariables();

        showChallenge(width, height);
        StartMenu.startMenu.requestFocus();
    }

    public void initializeVariables() {
        doodleY = 300;
        doodle = "doodle";
        monster1X = 60;
        monster2X = 300;
        monster3X = 240;
        turningPointUDoodle = 200;
        turningPointDDoodle = 500;
        turningPointRMonster1 = 120;
        turningPointLMonster1 = 50;
        turningPointRMonster2 = 320;
        turningPointLMonster2 = 280;
        turningPointRMonster3 = 290;
        turningPointLMonster3 = 200;
    }
    

    public void showChallenge(int width, int height) {

        this.width = width;
        this.height = height;

        challengeFrame = createFrame(width, height);
        returnToMenu = createButtons(100, 450, 230, 20, "Return to main Menu");
        drawComponents();
        addComponents(width, height);
        timer.start();

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


    public void drawComponents() {

        challengePanel = new JPanel() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setFont(GlobalElements.font);

                g.setColor(Color.red.darker());

                g.drawImage(GlobalElements.greenBorder, 0, 0, width, height, null);

                g.drawImage(GlobalElements.doodle, 20, doodleY, 60, 59, null);

                g.drawImage(GlobalElements.monsterList.get(0), monster1X, 100, 60, 59, null);

                g.drawImage(GlobalElements.monsterList.get(1), monster2X, 120, 60, 59, null);

                g.drawImage(GlobalElements.monsterList.get(2), monster3X, 370, 60, 59, null);

                if (GlobalElements.scoresToSave.isEmpty()) {

                    g.drawString("Oups",190, 250);
                    g.drawString("There is no Highscore to beat yet", 90, 300);


                } else {
                    g.drawString("The Highscore to beat: ", 120, 250);
                    g.drawString(GlobalElements.scoresToSave.get(0), 120, 300);
                }

                repaint();
            }

        };

        challengePanel.setLayout(null);
        challengePanel.setOpaque(true);
        challengePanel.setSize(width, height);
        challengePanel.setBounds(0, 0, width, height);

        challengePanel.setVisible(true);

    }

    @Override
    public void addComponents(int width, int height) {
        challengeFrame.add(challengePanel);
        challengePanel.add(returnToMenu);
        challengeFrame.setVisible(true);
    }

    Timer timer = new Timer(2, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            doodleDirection = checkDirection(doodleY, turningPointDDoodle, turningPointUDoodle, doodleDirection,
                    doodle);
            doodleY = moveImage(doodleY, turningPointDDoodle, turningPointUDoodle, doodleDirection, doodle);
            monster1Direction = checkDirection(monster1X, turningPointRMonster1, turningPointLMonster1,
                    monster1Direction, "");
            monster1X = moveImage(monster1X, turningPointRMonster1, turningPointLMonster1, monster1Direction, "");
            monster2Direction = checkDirection(monster2X, turningPointRMonster2, turningPointLMonster2,
                    monster2Direction, "");
            monster2X = moveImage(monster2X, turningPointRMonster2, turningPointLMonster2, monster2Direction, "");
            monster3Direction = checkDirection(monster3X, turningPointRMonster3, turningPointLMonster3,
                    monster3Direction, "");
            monster3X = moveImage(monster3X, turningPointRMonster3, turningPointLMonster3, monster3Direction, "");

        }
    });

    private String checkDirection(int position, int turningPoint1, int turningPoint2, String direction, String check) {

        if ((position < turningPoint1) && (position > turningPoint2) && (direction.equals("right"))) {
            if (check.equals("doodle")) {
                position -= 1;
            } else {
                position += 1;
            }

        } else if ((position < turningPoint1) && (position > turningPoint2) && (direction.equals("left"))) {
            if (check.equals("doodle")) {
                position += 1;
            } else {
                position -= 1;
            }
        }

        if (position == turningPoint1) {
            if (check.equals("doodle")) {
                position -= 1;
                direction = "right";
            } else {
                position += 1;
                direction = "left";
            }

        } else if (position == turningPoint2) {
            if (check.equals("doodle")) {
                position += 1;
                direction = "left";
            } else {
                position -= 1;
                direction = "right";
            }
        }

        return direction;

    }

    private int moveImage(int position, int turningPoint1, int turningPoint2, String direction, String check) {

        if ((position < turningPoint1) && (position > turningPoint2) && (direction.equals("right"))) {
            if (check.equals("doodle")) {
                position -= 1;
            } else {
                position += 1;
            }
        } else if ((position < turningPoint1) && (position > turningPoint2) && (direction.equals("left"))) {
            if (check.equals("doodle")) {
                position += 1;
            } else {
                position -= 1;
            }
        }

        if (position == turningPoint1) {
            if (check.equals("doodle")) {
                position -= 1;
                direction = "right";
            } else {
                position += 1;
                direction = "left";
            }

        } else if (position == turningPoint2) {
            if (check.equals("doodle")) {
                position += 1;
                direction = "left";
            } else {
                position -= 1;
                direction = "right";
            }
        }

        return position;

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == returnToMenu) {
        	challengeFrame.dispose();
        }

    
    }


}