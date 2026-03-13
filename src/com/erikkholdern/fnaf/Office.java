package com.erikkholdern.fnaf;

public class Office {
    private int powerLevel = 100;
    private int usageLevel = 1;

    private boolean camsUp = false;
    private boolean leftDoorClosed = false;
    private boolean rightDoorClosed = false;
    private boolean leftLightOn = false;
    private boolean rightLightOn = false;

    public int getPowerLevel(){
        return powerLevel;
    }

    public void drainPower(int drainAmount){
        powerLevel -= drainAmount;
        if (powerLevel < 0){
            blackout();
        }
    }

    public void blackout(){
        // This will later be replaced with more robust code for
        // Freddy's blackout jumpscare. That code itself will not
        // be related to the Freddy object itself.
        System.out.println("You ran out of power. Game over!");

        // This sets powerOut to true, which stops all animatronics
        // from progressing. It should also prevent the user from
        // using things that have power.
        Pizzeria.getInstance().blackout();

        // Turn off all power-using tools.
        usageLevel = 0;
        camsUp = false;
        leftDoorClosed = false;
        rightDoorClosed = false;
        leftLightOn = false;
        rightLightOn = false;
    }

    public int getUsageLevel(){
        // This does not have a setter because only things in this
        // class should be affecting the usage level.
        return usageLevel;
    }

    public void updateUsage(boolean bool){
        if (bool)
            usageLevel++;
        else
            usageLevel--;
    }

    public boolean isCamsUp(){
        return camsUp;
    }

    public void toggleCams(){
        camsUp = !camsUp;
        updateUsage(camsUp);
    }

    public boolean isLeftDoorClosed(){
        return leftDoorClosed;
    }

    public void toggleLeftDoor(){
        leftDoorClosed = !leftDoorClosed;
        updateUsage(leftDoorClosed);
    }

    public boolean isRightDoorClosed(){
        return rightDoorClosed;
    }

    public void toggleRightDoor(){
        rightDoorClosed = !rightDoorClosed;
        updateUsage(rightDoorClosed);
    }

    public boolean isLeftLightOn(){
        return leftLightOn;
    }

    public void toggleLeftLight(){
        leftLightOn = !leftLightOn;
        updateUsage(leftLightOn);
    }

    public boolean isRightLightOn(){
        return rightLightOn;
    }

    public void toggleRightLight(){
        rightLightOn = !rightLightOn;
        updateUsage(rightLightOn);
    }
}
