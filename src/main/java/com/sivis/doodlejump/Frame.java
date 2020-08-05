package com.sivis.doodlejump;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JPanel implements KeyListener, MouseListener, ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	static JFrame frame;
	JPanel panel;
	Image backgroundImage;
	static JButton button;
	int width;
	int height;

	public JFrame createFrame(int width, int height) {

		this.width = width;
		this.height = height;

		frame = new JFrame();
		frame.setLayout(null);
		frame.setIconImage(new ImageIcon(GlobalElements.getURL("etc/img/doodleL.png", Frame.class)).getImage());
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.requestFocus();

		return frame;

	}

	public JPanel drawBackground(String path, Class<?> t) {

		backgroundImage = Toolkit.getDefaultToolkit().createImage(GlobalElements.getURL(path, t));

		panel = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g.drawImage(backgroundImage, 0, 0, width, height, null);
				g.setFont(GlobalElements.font);
				g.setColor(Color.red.darker());

				repaint();
			}
		};

		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setSize(width, height);
		panel.setBounds(0, 0, width, height);
		panel.setBorder(GlobalElements.border);
		panel.setVisible(true);

		return panel;

	}

	public JButton createButtons(int x, int y, int width, int height, URL url) {
		button = new JButton();
		button.addMouseListener(this);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setCursor(createCursor(url));
		button.setBounds(x, y, width, height);
		button.setOpaque(false);

		return button;

	}

	public Cursor createCursor(URL url) {

		Image cursorImage = Toolkit.getDefaultToolkit().createImage(url);
		Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,
				new Point(this.getX(), this.getY()), "");
		this.setCursor(customCursor);

		return customCursor;
	}

	public void addComponents(int width, int height) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}