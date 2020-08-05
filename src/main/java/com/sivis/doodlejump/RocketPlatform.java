package com.sivis.doodlejump;

public class RocketPlatform extends Platform {

    public RocketPlatform() {
        super();
        calculateMaximumCoordinates();
        createPlatform();
    }


    @Override
    public void createPlatform() {

        GlobalElements.rocketY = (int) (rocketY * Math.random());
        GlobalElements.rocketX = (int) (maximumX * Math.random());

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