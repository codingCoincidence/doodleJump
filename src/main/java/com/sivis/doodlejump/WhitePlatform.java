package com.sivis.doodlejump;

public class WhitePlatform extends Platform {

    public WhitePlatform() {
        super();
        calculateMaximumCoordinates();
        createPlatform();
    }

    @Override
    public void createPlatform() {

        for (int i = 0; i < GlobalElements.numberOfWhitePlatforms - 1; i++) {
            GlobalElements.whitePlatformY[i] += GlobalElements.backgroundSpeed;
        }
        if (GlobalElements.whitePlatformY[0] >= GlobalElements.screenHeight) {
            GlobalElements.whitePlatformY[0] = (int) (GlobalElements.whitePlatformY[0] - whiteY * Math.random());
            GlobalElements.whitePlatformX[0] = (int) (maximumX * Math.random());
        }

        for (int i = 1; i < GlobalElements.numberOfWhitePlatforms - 1; i++) {

            if (GlobalElements.whitePlatformY[i] >= GlobalElements.screenHeight) {

                GlobalElements.whitePlatformY[i] = (int) (GlobalElements.whitePlatformY[i - 1]
                        - whiteY * Math.random());

                GlobalElements.whitePlatformX[i] = (int) (maximumX * Math.random());

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

