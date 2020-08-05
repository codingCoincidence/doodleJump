package com.sivis.doodlejump;

public class DarkPlatforms extends Platform {

    public DarkPlatforms() {
        super();
        calculateMaximumCoordinates();
        createPlatform();
    }

    @Override
    public void createPlatform() {

        for (int i = 0; i < GlobalElements.darkPlatformX.length; i++) {
            GlobalElements.darkPlatformY[i] += GlobalElements.backgroundSpeed;
            if (GlobalElements.darkPlatformY[i] >= GlobalElements.screenHeight) {
                GlobalElements.darkPlatformY[i] = (int) (brownY * Math.random());
                GlobalElements.darkPlatformX[i] = (int) (maximumX * Math.random());
            }
        }

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

    }

    @Override
    public void initializePlatform() {

    }
}