package com.sivis.doodlejump;

public class SpringPlatform extends Platform {

    public SpringPlatform() {
        super();
        calculateMaximumCoordinates();
        createPlatform();
    }


    @Override
    public void createPlatform() {

        GlobalElements.pSpringY += GlobalElements.backgroundSpeed;
        GlobalElements.springCoordinateY += GlobalElements.backgroundSpeed;
        if (GlobalElements.pSpringY >= GlobalElements.screenHeight) {
            GlobalElements.pSpringY = (int) (springY * Math.random());
            GlobalElements.pSpringX = (int) (maximumX * Math.random());
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