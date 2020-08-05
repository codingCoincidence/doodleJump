package com.sivis.doodlejump;

public class GreenPlatform extends Platform {

    public GreenPlatform() {
        super();
        calculateMaximumCoordinates();
        createPlatform();
    }

    
    @Override
    public void createPlatform() {

        for (int i = 0; i < GlobalElements.numberOfGreenPlatforms; i++) {

            GlobalElements.greenPlatformY[i] += GlobalElements.backgroundSpeed;
        }

        if (GlobalElements.greenPlatformY[0] >= GlobalElements.screenHeight) {
            GlobalElements.greenPlatformY[0] = (int) (greenY * Math.random());
            GlobalElements.greenPlatformX[0] = (int) (maximumX * Math.random());
        }

        for (int i = 1; i < GlobalElements.numberOfGreenPlatforms; i++) {

            if (GlobalElements.greenPlatformY[i] >= GlobalElements.screenHeight) {

                GlobalElements.greenPlatformY[i] = (int) (greenY * Math.random());

                GlobalElements.greenPlatformX[i] = (int) (maximumX * Math.random());

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