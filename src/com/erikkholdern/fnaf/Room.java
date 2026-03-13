package com.erikkholdern.fnaf;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final String camTag;
    private List<Animatronic> animatronicsPresent = new ArrayList<>();
    private List<Room> validBonniePaths;
    private List<Room> validChicaPaths;
    private List<Room> validFreddyPaths;

    public Room(String name, String camTag){
        this.name = name;
        this.camTag = camTag;
    }

    public String getName(){
        return name;
    }

    public String getCamTag(){
        return camTag;
    }

    public List<Room> getValidPaths(Animatronic animatronic){
        return switch (animatronic.getName()) {
            case "Freddy" -> validFreddyPaths;
            case "Bonnie" -> validBonniePaths;
            case "Chica" -> validChicaPaths;
            default -> null;
        };
    }

    public void setBonniePaths(List<Room> bonniePaths){
        validBonniePaths = bonniePaths;
    }

    public void setChicaPaths(List<Room> chicaPaths){
        validChicaPaths = chicaPaths;
    }

    public void setFreddyPaths(List<Room> freddyPaths){
        validFreddyPaths = freddyPaths;
    }

    public void addAnimatronic(Animatronic animatronic){
        animatronicsPresent.add(animatronic);
    }

    public void removeAnimatronic(Animatronic animatronic){
        animatronicsPresent.remove(animatronic);
    }

    public List<Animatronic> getAnimatronicsPresent(){
        return animatronicsPresent;
    }

    @Override
    public String toString() {
        return name;
    }

    public void showRoomCamera(){
        System.out.println("CAM " + camTag + " (" + name + ") - Animatronics Present:");
        for (Animatronic animatronic : animatronicsPresent){
            System.out.println(animatronic);
        }
    }
}
