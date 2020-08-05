package com.sivis.doodlejump;

public class BrownPlatform extends Platform {

    public BrownPlatform() {
        super();
        calculateMaximumCoordinates();
        createPlatform();
    }


    @Override
    public void createPlatform() {

        for (int i = 0; i < GlobalElements.brownPlatformX.length; i++) {
            GlobalElements.brownPlatformY[i] += GlobalElements.backgroundSpeed;
            if (GlobalElements.brownPlatformY[i] >= GlobalElements.screenHeight) {
                GlobalElements.brownPlatformY[i] = (int) (brownY * Math.random());
                GlobalElements.brownPlatformX[i] = (int) (maximumX * Math.random());
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