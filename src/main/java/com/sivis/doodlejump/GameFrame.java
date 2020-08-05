package com.sivis.doodlejump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame implements ActionListener {

    // class for GUI, initiate JFrames, sizes, bounds etc

    public GameFrame() {
        setupGameFrame();
    }

    public static void setupGameFrame() {

        GlobalElements.playFrame = new JFrame();
        GlobalElements.playFrame.setLayout(null);
        GlobalElements.playFrame.setSize(GlobalElements.screenWidth, GlobalElements.screenHeight);
         GlobalElements.playFrame.setLocationRelativeTo(null);
        GlobalElements.playFrame.setResizable(false);
        ImageIcon doodleImage = new ImageIcon(GlobalElements.getURL("etc/img/doodleL.png", GameFrame.class));
        GlobalElements.playFrame.setIconImage(doodleImage.getImage());
        GlobalElements.playFrame.addKeyListener(new KeyActions());
        GlobalElements.playFrame.addMouseListener(new KeyActions());
        GlobalElements.playFrame.requestFocus();

        new Draw();

        GlobalElements.gamePanel.setOpaque(true);
        GlobalElements.gamePanel.setSize(GlobalElements.screenWidth, GlobalElements.screenHeight);
        GlobalElements.gamePanel.setBounds(0, 0, GlobalElements.screenWidth, GlobalElements.screenHeight);
        GlobalElements.gamePanel.setBorder(GlobalElements.border);

        GlobalElements.gamePanel.setVisible(true);

        GlobalElements.playFrame.add(GlobalElements.gamePanel);
        GlobalElements.playFrame.setVisible(true);
        Toolkit.getDefaultToolkit().sync();
        
      GlobalElements.playFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                   GlobalElements.playFrame.dispose();
                    System.exit(0);    // force application exit
            }
      });
     }
    

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}