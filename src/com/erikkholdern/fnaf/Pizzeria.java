package com.erikkholdern.fnaf;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private final List<Room> rooms;
    private final List<Animatronic> animatronics;
    private static final Pizzeria instance = new Pizzeria();
    private boolean powerOut = false;
    // If this has no usages I'll remove it in the final build.
    private final Office office = Office.getInstance();

    private Pizzeria(){
        // Add each room with its values
        rooms = initRooms();
        // Add each animatronic at 0 AI value
        animatronics = initAnimatronics(rooms);
    }

    private List<Animatronic> initAnimatronics(List<Room> rooms){
        Animatronic freddy = new Animatronic(0, rooms.getFirst(), "Freddy", 3.02);
        Animatronic bonnie = new Animatronic(0, rooms.getFirst(), "Bonnie", 4.97);
        Animatronic chica = new Animatronic(0, rooms.getFirst(), "Chica", 4.98);
        Animatronic foxy = new Animatronic(0, rooms.get(2), "Foxy", 5.01);

        List<Animatronic> animatronics = new ArrayList<>();
        animatronics.add(freddy);
        animatronics.add(bonnie);
        animatronics.add(chica);
        animatronics.add(foxy);

        return animatronics;
    }

    private List<Room> initRooms(){
        Room showStage = new Room("Show Stage", "1A");
        Room diningHall = new Room("Dining Hall", "1B");
        Room piratesCove = new Room("Pirate's Cove", "1C");
        Room westHall = new Room("West Hall", "2A");
        Room westHallCorner = new Room("West Hall Corner", "2B");
        Room supplyCloset = new Room("Supply Closet", "3");
        Room eastHall = new Room("East Hall", "4A");
        Room eastHallCorner = new Room("East Hall Corner", "4B");
        Room backstage = new Room("Backstage", "5");
        Room kitchen = new Room("Kitchen", "6");
        Room restrooms = new Room("Restrooms", "7");

        // We may want to add a new Subclass of Room for rooms that
        // do or don't show up on the camera.
        Room leftDoor = new Room("Left Door", null);
        Room rightDoor = new Room("Right Door", null);
        Room office = new Room("Office", null);

        List<Room> rooms = new ArrayList<>();
        rooms.add(showStage);
        rooms.add(diningHall);
        rooms.add(piratesCove);
        rooms.add(westHall);
        rooms.add(westHallCorner);
        rooms.add(supplyCloset);
        rooms.add(eastHall);
        rooms.add(eastHallCorner);
        rooms.add(backstage);
        rooms.add(kitchen);
        rooms.add(restrooms);
        rooms.add(leftDoor);
        rooms.add(rightDoor);
        rooms.add(office);

        // Make a new method signature that can take single Room objects and pass those into the list.
        showStage.setValidPaths(List.of(diningHall, backstage), List.of(diningHall), List.of(diningHall));
        diningHall.setValidPaths(List.of(backstage, westHall), List.of(restrooms), List.of(restrooms));

        westHall.setBonniePaths(List.of(westHallCorner, supplyCloset));
        westHallCorner.setBonniePaths(List.of(supplyCloset, leftDoor));
        supplyCloset.setBonniePaths(List.of(westHall, leftDoor));
        backstage.setBonniePaths(List.of(diningHall, westHall));

        eastHall.setValidPaths(null, List.of(diningHall, eastHallCorner), List.of(eastHallCorner));
        eastHallCorner.setValidPaths(null, List.of(eastHall, rightDoor), List.of(office));
        kitchen.setValidPaths(null, List.of(eastHall, restrooms), List.of(eastHall));
        restrooms.setValidPaths(null, List.of(eastHall, kitchen), List.of(kitchen));

        leftDoor.setBonniePaths(List.of(diningHall));
        rightDoor.setChicaPaths(List.of(eastHall));

        return rooms;
    }

    public static Pizzeria getInstance(){
        return instance;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Animatronic> getAnimatronics(){
        return  animatronics;
    }

    public boolean isPowerOut(){
        return powerOut;
    }

    public void blackout(){
        powerOut = true;
    }
}
