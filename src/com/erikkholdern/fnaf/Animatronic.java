package com.erikkholdern.fnaf;

import java.util.List;
import java.util.Random;

public class Animatronic {
    private int AILevel;
    private Room position;
    private final String name;
    private final Random random = new Random();

    public Animatronic(int AILevel, Room startingPosition, String name){
        this.AILevel = AILevel;
        this.position = startingPosition;
        this.name = name;

        // Add the Animatronic to its starting room.
        position.addAnimatronic(this);
    }

    public int getAILevel(){
        return AILevel;
    }

    public void setAILevel(int AILevel){
        this.AILevel = AILevel;
    }

    public Room getPosition(){
        return position;
    }

    // This will most likely be replaced by a move() method.
    public void setPosition(Room position){
        this.position = position;
    }

    public void travel(){
        // Save the list of valid paths for this animatronic
        List<Room> validPaths = position.getValidPaths(this);

        // Choose a random room from the list (double check that the upper bound isn't exclusive).
        position = validPaths.get(random.nextInt(validPaths.size()));
        position.addAnimatronic(this);

        System.out.println(this + " has moved to " + position);
//        position.showRoomCamera();
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
