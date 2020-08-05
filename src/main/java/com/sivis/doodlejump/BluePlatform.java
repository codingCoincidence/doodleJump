package com.sivis.doodlejump;

public class BluePlatform extends Platform {

    public BluePlatform() {
        super();
        calculateMaximumCoordinates();
        createPlatform();
    }

    @Override
    public void createPlatform() {

        for (int i = 0; i < GlobalElements.numberOfBluePlatforms - 1; i++) {

            GlobalElements.bluePlatformY[i] += GlobalElements.backgroundSpeed;
        }

        if (GlobalElements.bluePlatformY[0] >= GlobalElements.screenHeight) {
            GlobalElements.bluePlatformY[0] = (int) (GlobalElements.bluePlatformY[GlobalElements.numberOfBluePlatforms
                    - 1] - blueY * Math.random());
            GlobalElements.bluePlatformX[0] = (int) (maximumX * Math.random());
        }

        for (int i = 1; i < GlobalElements.numberOfBluePlatforms - 1; i++) {

            if (GlobalElements.bluePlatformY[i] >= GlobalElements.screenHeight) {

                GlobalElements.bluePlatformY[i] = (int) (GlobalElements.bluePlatformY[i - 1] - blueY * Math.random());

                GlobalElements.bluePlatformX[i] = (int) (maximumX * Math.random());

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