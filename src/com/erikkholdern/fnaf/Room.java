package com.erikkholdern.fnaf;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final String camTag;
    private final List<Animatronic> animatronicsPresent = new ArrayList<>();
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

    public List<Animatronic> getAnimatronicsPresent(){
        return animatronicsPresent;
    }

    public List<Room> getValidPaths(Animatronic animatronic){
        return switch (animatronic.getName()) {
            case "Freddy" -> validFreddyPaths;
            case "Bonnie" -> validBonniePaths;
            case "Chica" -> validChicaPaths;
            default -> null;
        };
    }

    public void setValidPaths(List<Room> bonniePaths, List<Room> chicaPaths, List<Room> freddyPaths){
        validBonniePaths = bonniePaths;
        validChicaPaths = chicaPaths;
        validFreddyPaths = freddyPaths;
    }

    public void setValidPaths(List<Room> bonniePaths, Room chicaPath, Room freddyPath){
        validBonniePaths = bonniePaths;
        validChicaPaths.add(chicaPath);
        validFreddyPaths.add(freddyPath);
    }

    public void setChicaAndFreddyPaths(List<Room> chicaPaths, Room freddyPath){
        validChicaPaths = chicaPaths;
        validFreddyPaths.add(freddyPath);
    }

    public void setBonniePaths(List<Room> bonniePaths){
        validBonniePaths = bonniePaths;
    }

    public void setBonniePaths(Room bonniePath){
        validBonniePaths.add(bonniePath);
    }

    public void setChicaPaths(List<Room> chicaPaths){
        validChicaPaths = chicaPaths;
    }

    public void setChicaPaths(Room chicaPath){
        validChicaPaths.add(chicaPath);
    }

    public void setFreddyPaths(List<Room> freddyPaths){
        validFreddyPaths = freddyPaths;
    }

    public void setFreddyPaths(Room freddyPath){
        validFreddyPaths.add(freddyPath);
    }

    public void addAnimatronic(Animatronic animatronic){
        animatronicsPresent.add(animatronic);
    }

    public void removeAnimatronic(Animatronic animatronic){
        animatronicsPresent.remove(animatronic);
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