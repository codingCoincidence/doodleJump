package com.sivis.doodlejump;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * contains variables for interaction between different classes
 * 
 * @author jluge
 *
 */
public class GlobalElements extends JPanel {

	private static final long serialVersionUID = 1L;

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static GameFrame gameFrame;
	static Draw draw;
	static InitialPlatform initialPlatform;
	static KeyActions keyActions;
	static Monster monsters;
	static GameTimer gameTimer;
	static DoodleMovement doodleMovement;
	static Hit collision;
	static HitSpecial hitSpecial;
	static Shoot shoots;
	static Jump jump;
	static MovePlatform movingPlatform;
	static GlobalElements globalElements;
	static EditScore editScore;
	static HighScore highScore;
	static GreenPlatform greenPlatform;
	static BluePlatform bluePlatform;
	static WhitePlatform whitePlatform;
	static BrownPlatform brownPlatform;
	static SpringPlatform springPlatform;
	static RocketPlatform rocketPlatform;
	static DarkPlatforms darkPlatform;

	// variables for JFrame
	static JFrame playFrame;
	static final Border border = new LineBorder(Color.red.darker(), 2);
	static final Font font = new Font(Font.SANS_SERIF, Font.BOLD, 18);
	static int screenWidth = (int)(screenSize.width / 2.5), screenHeight =  (int) (screenSize.height - 100);
	static boolean gamePaused = false;
	static Image gameOverImage;

	// variables for moving doodle
	static int speedUp, speedLeft = 5, speedRight = 5;
	static int springTurningPoint;
	static double time = 0.3;
	static double doodleX, doodleY;
	static boolean moveRight = false, moveLeft = false;
	static boolean rocketHit = false;
	static boolean killed = false;
	static boolean hit = false;
	static boolean hitBrownP = false;
	static boolean hitSpringP = false;
	static boolean createShootingDoodle = false;
	static boolean falling = false;
	static double movingDirection;

	// variables for game frame
	static JPanel gamePanel;
	static int backY1 = 0; 
	static int backY2 = -screenHeight;

	// Images
	static Image turningDoodle, pBrownGif, movingSpring, monsterToDraw, backImg1, backImg2, doodle, doodleR, doodleL,
			doodleRocket, topBar, pGreen, pBlue, pWhite, pSpring1, pDark, pBrown1, rocket, monster;

	static BufferedImage monster1, monster2, monster3, monster4;
	static Image bullet;
	static Image shootingDoodle;
	static Image greenBorder;
	static URL url;

	// variables for moving background
	static int backgroundSpeed;

	// variables for platforms
	static int numberOfGreenPlatforms = 20, numberOfWhitePlatforms = 6, numberOfBluePlatforms = 5;
	static int pSpringX, pSpringY;
	static int springCoordinateX, springCoordinateY;
	static int rocketX, rocketY;
	static double bluePlatformSpeed = 0.2;
	static int[] greenPlatformX = new int[numberOfGreenPlatforms], greenPlatformY = new int[numberOfGreenPlatforms];
	static int[] brownPlatformX = new int[4], brownPlatformY = new int[4];
	static int[] brownCoordinateX = new int[4], brownCoordinateY = new int[4];
	static int[] whitePlatformX = new int[5], whitePlatformY = new int[5];
	static int[] darkPlatformX = new int[4], darkPlatformY = new int[4];
	static double[] bluePlatformX = new double[numberOfBluePlatforms],
			bluePlatformY = new double[numberOfBluePlatforms];
	static String[] pBlueDirection;

	// variables for monsters
	static int monsterX, monsterY;
	static int monsterDelay = 20000;
	static List<Image> monsterList = new ArrayList<>();
	static String monsterDirection = "right";
	static boolean killedMonster = false;
	static boolean enableSound = false;

	// variables for shooting
	static int bulletSpeed = 9;
	static int clickX, clickY;
	static double bulletX = doodleX, bulletY = doodleY;
	static double dX, dY;
	static double angle;
	static double firePosX, firePosY;
	static boolean shoot = false;

	// variables for score, username
	static double score = 0;
	static double intermediateScore = 0;
	static String userName;
	static LinkedList<String> scoresToSave;
	public static String scoreLocation;
	
	// public static String scoreLocation = System.getProperty("user.home") + "/DoodleScore.txt";
	

	public GlobalElements() {
		
		// initializeFrameSize();
		try {
			
		scoreLocation = new File("Z:/95 Temp/Jakob") + "/DoodleScore.txt";
		} catch(Exception e){
			System.out.println("could not load scores");
			
		}
		readImages();
		initializeBlueDirections();

	}
	

	public void readImages() {
		
		try {

		for (int i = 0; i < brownCoordinateX.length; i++) {
			brownCoordinateX[i] = 10000;
			brownCoordinateY[i] = 10000;
		}

		// import all images for game here
		backImg1 = backImg2 = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/bg-grid.png", GlobalElements.class));
		doodleR = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/doodleR.png", GlobalElements.class));
		doodleL = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/doodleL.png", GlobalElements.class));
		doodle = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/doodleL.png", GlobalElements.class));
		topBar = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/topbar.png", GlobalElements.class));
		pGreen = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/p-green.png", GlobalElements.class));
		pBlue = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/p-blue.png", GlobalElements.class));
		pBrown1 = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/p-brown-1.png", GlobalElements.class));
		pBrownGif = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/brownGif.gif", GlobalElements.class));
		pWhite = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/p-white.png", GlobalElements.class));
		pSpring1 = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/p-green-s0.png", GlobalElements.class));
		pSpring1 = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/p-green-s1.png", GlobalElements.class));
		doodleRocket = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/doodleRocket.png", GlobalElements.class));
		rocket = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/pRocket.png", GlobalElements.class));
		pDark = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/pdark.png", GlobalElements.class));
		greenBorder = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/border-f.png", GlobalElements.class));

		for (int i = 1; i <= 3; i++) {
			monster = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/monster" + i + ".png", GlobalElements.class));
			monsterList.add(i - 1, monster);
		}

		bullet = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/bullet.png", GlobalElements.class));
		shootingDoodle = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/doodleS.png", GlobalElements.class));
		gameOverImage = Toolkit.getDefaultToolkit().createImage(getURL("etc/img/gameover0.png", GlobalElements.class));
		} catch (Exception e) {
			System.out.println("could not load images");
		}

	}

	public static URL getURL(String path, Class<?> t) {

		ClassLoader classLoader = t.getClassLoader();

		URL url = classLoader.getResource(path);

		if (url == null)
			try {
				url = new File(path).toURI()
									.toURL();
			} catch (MalformedURLException e) {
				System.out.println("No file found for " + path);
			}
		if (url == null)
			try {
				url = new File("./" + path).toURI()
											.toURL();
			} catch (MalformedURLException e) {
				System.out.println("No file found for ./" + path + ", either");
			}

		return url;

	}

	public void initializeBlueDirections() {

		pBlueDirection = new String[6];

		pBlueDirection[0] = "right";
		pBlueDirection[1] = "right";
		pBlueDirection[2] = "left";
		pBlueDirection[3] = "left";
		pBlueDirection[4] = "left";
		pBlueDirection[5] = "right";

	}

}