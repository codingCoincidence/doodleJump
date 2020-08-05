package com.sivis.doodlejump;

public class InitialPlatform extends Platform {

    public InitialPlatform() {
        super();
        calculateMaximumCoordinates();
        initializePlatform();

    }

    @Override
    public void calculateMaximumCoordinates() {

        maximumX = (GlobalElements.screenWidth / 1.08);
        greenY = GlobalElements.screenHeight / 50;
        blueY = GlobalElements.screenHeight / 1.12;
        brownY = GlobalElements.screenHeight / 20;
        whiteY = GlobalElements.screenHeight / 1.12;
        springY = GlobalElements.screenHeight / 50;
        rocketY = GlobalElements.screenHeight / 25;
        darkY = GlobalElements.screenHeight / 1.12;

    }

    @Override
    public void initializePlatform() {

        createFirstPlatform();

        for (int i = 1; i <= GlobalElements.numberOfGreenPlatforms - 1; i++) {
            GlobalElements.greenPlatformY[i] = (int) (GlobalElements.greenPlatformY[i - 1] - 120 * Math.random());
            GlobalElements.greenPlatformX[i] = (int) (maximumX * Math.random());
        }

        for (int i = 0; i < GlobalElements.brownPlatformX.length; i++) {
            GlobalElements.brownPlatformY[i] = (int) ((GlobalElements.screenHeight / 1.43) * Math.random());
            GlobalElements.brownPlatformX[i] = (int) (maximumX * Math.random());

        }

        for (int i = 1; i < GlobalElements.numberOfWhitePlatforms - 1; i++) {

            GlobalElements.whitePlatformY[i] = (int) (GlobalElements.whitePlatformY[i - 1] - 120 * Math.random());
            GlobalElements.whitePlatformX[i] = (int) (maximumX * Math.random());

            GlobalElements.bluePlatformY[i] = (int) (GlobalElements.bluePlatformY[i - 1] - 110 * Math.random());
            GlobalElements.bluePlatformX[i] = (int) (maximumX * Math.random());
        }

        for (int i = 1; i < GlobalElements.darkPlatformX.length; i++) {
            GlobalElements.darkPlatformX[i] = (int) (maximumX * Math.random());
            GlobalElements.darkPlatformY[i] = (int) (GlobalElements.screenHeight / 40 * Math.random());
        }

        GlobalElements.pSpringY = (int) ((GlobalElements.screenHeight / 50) * Math.random());
        GlobalElements.pSpringX = (int) (maximumX * Math.random());

        GlobalElements.rocketY = (int) ((GlobalElements.screenHeight / 20) * Math.random());
        GlobalElements.rocketX = (int) (maximumX * Math.random());
    }

    public void createFirstPlatform() {
        GlobalElements.greenPlatformX[0] = (int) GlobalElements.screenWidth / 2;
        GlobalElements.greenPlatformY[0] = (int) GlobalElements.doodleY + 60;
        GlobalElements.whitePlatformX[0] = (int) (maximumX * Math.random());
        GlobalElements.whitePlatformY[0] = (int) ((GlobalElements.screenHeight / 100) * Math.random());
        GlobalElements.bluePlatformX[0] = (int) (maximumX * Math.random());
        GlobalElements.bluePlatformY[0] = (int) ((GlobalElements.screenHeight / 50) * Math.random());
        GlobalElements.darkPlatformX[0] = (int) (maximumX * Math.random());
        GlobalElements.darkPlatformY[0] = (int) ((GlobalElements.screenHeight / 20) * Math.random());

    }

    @Override
    public void createPlatform() {

    }

}