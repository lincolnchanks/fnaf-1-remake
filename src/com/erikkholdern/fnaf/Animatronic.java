package com.erikkholdern.fnaf;

import java.util.List;
import java.util.Random;

public class Animatronic {
    private int AILevel;
    private Room position;
    private final String name;
    private final Random random = new Random();
    private final Double movementInterval;

    public Animatronic(int AILevel, Room startingPosition, String name, Double movementInterval){
        this.AILevel = AILevel;
        this.position = startingPosition;
        this.name = name;
        this.movementInterval = movementInterval;

        // Add the Animatronic to its starting room.
        position.addAnimatronic(this);
    }

    public int getAILevel(){
        return AILevel;
    }

    public void setAILevel(int AILevel){
        this.AILevel = AILevel;
    }

    public void boostAILevel(){
        AILevel++;
    }

    public Room getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void setPosition(Room position){
        // This will most likely be replaced by a move() method.
        // Unless we need it for Foxy. Then it will move to Foxy's class.
        this.position = position;
    }

    public Double getMovementInterval(){
        return movementInterval;
    }

    public boolean checkMovementOpportunity(){
        // Animatronic rolls to see if it can move.
        // This is called every time an in-game interval passes.

        // Generate a random number between 1 and 20.
        // Return true if the number is <= the AI value.
        int moveValue = random.nextInt(1, 21);
        return moveValue <= AILevel;
    }
    public void travel(){
        // If the animatronic succeeds its movement check:

        // Get the valid paths for the animatronic's position.
        // Remove the animatronic from its position room.
        // Choose a random room and send the animatronic there.
        // Add the animatronic to its destination room.

        if (checkMovementOpportunity()){
            List<Room> validPaths = position.getValidPaths(this);
            position.removeAnimatronic(this);
            position = validPaths.get(random.nextInt(validPaths.size()));
            position.addAnimatronic(this);

            System.out.println(this + " has moved to " + position + ".");
        }
        else {
            System.out.println(this + " has failed their movement check.");
        }
//        position.showRoomCamera();
    }

    @Override
    public String toString() {
        return name;
    }
}
