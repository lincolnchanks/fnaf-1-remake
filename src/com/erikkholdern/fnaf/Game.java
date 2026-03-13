package com.erikkholdern.fnaf;

import java.util.Random;

public class Game {
    private static final Game instance = new Game();
    private final Pizzeria pizzeria = Pizzeria.getInstance();
    private int nightNumber;
    private int hourNumber;

    private Game(){
        nightNumber = 1;
        hourNumber = 0;
    }

    public static Game getInstance() {
        return instance;
    }

    public void runNight(){
        // Create an Animatronics class that registers each animatronic.
        // Thus, we can call the animatronics using Animatronics.FREDDY or
        // something like that.

        // Save each animatronic
        Animatronic freddy = pizzeria.getAnimatronics().getFirst();
        Animatronic bonnie = pizzeria.getAnimatronics().get(1);
        Animatronic chica = pizzeria.getAnimatronics().get(2);
        Animatronic foxy = pizzeria.getAnimatronics().get(3);

        // Set starting AI levels according to Night Number.
        setStartingAILevels(nightNumber, freddy, bonnie, chica, foxy);

        // 12AM
        for (int i = 0; i < 18; i++){
            freddy.travel();
            bonnie.travel();
            chica.travel();
        }
        // 1AM
        System.out.println("1AM");
        hourNumber++;
        bonnie.boostAILevel();
        for (int i = 0; i < 18; i++){
            freddy.travel();
            bonnie.travel();
            chica.travel();
        }
        // 2AM
        System.out.println("2AM");
        hourNumber++;
        bonnie.boostAILevel();
        chica.boostAILevel();
        foxy.boostAILevel();
        for (int i = 0; i < 18; i++){
//            freddy.travel();
            bonnie.travel();
            chica.travel();
        }
        // 3AM
        System.out.println("3AM");
        hourNumber++;
        for (int i = 0; i < 18; i++){
//            freddy.travel();
            bonnie.travel();
            chica.travel();
        }
        // 4AM
        System.out.println("4AM");
        hourNumber++;
        for (int i = 0; i < 18; i++){
//            freddy.travel();
            bonnie.travel();
            chica.travel();
        }
        // 5AM
        System.out.println("5AM");
        hourNumber++;
        for (int i = 0; i < 18; i++){
//            freddy.travel();
            bonnie.travel();
            chica.travel();
        }
        System.out.println("6AM: You win!");
    }

    public void setStartingAILevels(int nightNumber, Animatronic freddy, Animatronic bonnie,
                                    Animatronic chica, Animatronic foxy){
        switch(nightNumber){
            case 1:
                for (Animatronic animatronic : pizzeria.getAnimatronics()){
                    animatronic.setAILevel(0);
                }
            case 2:
                freddy.setAILevel(0);
                bonnie.setAILevel(3);
                chica.setAILevel(1);
                foxy.setAILevel(1);
            case 3:
                freddy.setAILevel(1);
                bonnie.setAILevel(0);
                chica.setAILevel(5);
                foxy.setAILevel(2);
            case 4:
                Random freddyRandom = new Random();
                freddy.setAILevel(freddyRandom.nextInt(1, 3));
                bonnie.setAILevel(2);
                chica.setAILevel(4);
                foxy.setAILevel(6);
            case 5:
                freddy.setAILevel(3);
                bonnie.setAILevel(5);
                chica.setAILevel(7);
                foxy.setAILevel(5);
            case 6:
                freddy.setAILevel(4);
                bonnie.setAILevel(10);
                chica.setAILevel(12);
                foxy.setAILevel(6);
        }
    }

    public static void main(String[] args){
        Game game = Game.getInstance();

        game.nightNumber = 3;
        game.runNight();

//        // At 2AM, increase Bonnie by 1
//        game.hourNumber = 2;
//        if (game.hourNumber == 2){
//            game.pizzeria.getAnimatronics().get(1).boostAILevel();
//        }
//
//        for (int i = 0; i < 9; i++){
//            game.pizzeria.getAnimatronics().get(1).travel();
//        }
//
//        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();
//
//        // At 3AM, increase everyone but Freddy by 1
//        game.hourNumber++;
//        if (game.hourNumber == 3){
//            game.pizzeria.getAnimatronics().get(1).boostAILevel();
//            game.pizzeria.getAnimatronics().get(2).boostAILevel();
//            game.pizzeria.getAnimatronics().get(3).boostAILevel();
//        }
//
//        for (int i = 0; i < 9; i++){
//            game.pizzeria.getAnimatronics().get(1).travel();
//            game.pizzeria.getAnimatronics().get(2).travel();
//        }
//
//        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();
//        game.pizzeria.getAnimatronics().get(2).getPosition().showRoomCamera();
//
//        // At 4AM, increase everyone but Freddy by 1
//        game.hourNumber++;
//        if (game.hourNumber == 4){
//            game.pizzeria.getAnimatronics().get(1).boostAILevel();
//            game.pizzeria.getAnimatronics().get(2).boostAILevel();
//            game.pizzeria.getAnimatronics().get(3).boostAILevel();
//        }
//
//        for (int i = 0; i < 9; i++){
//            game.pizzeria.getAnimatronics().get(1).travel();
//            game.pizzeria.getAnimatronics().get(2).travel();
//        }
//
//        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();
//        game.pizzeria.getAnimatronics().get(2).getPosition().showRoomCamera();
//
//        System.out.println();
//
//        // Reset the game to test it again
//        game.pizzeria.getAnimatronics().getFirst().setPosition(game.pizzeria.getRooms().getFirst());
//        game.pizzeria.getAnimatronics().get(1).setPosition(game.pizzeria.getRooms().getFirst());
//        game.pizzeria.getAnimatronics().get(2).setPosition(game.pizzeria.getRooms().getFirst());
//        game.pizzeria.getAnimatronics().get(3).setPosition(game.pizzeria.getRooms().get(2));
//
//        for (Animatronic animatronic : game.pizzeria.getAnimatronics()){
//            animatronic.setAILevel(10);
//        }
//
//        for (int i = 0; i < 9; i++){
//            game.pizzeria.getAnimatronics().getFirst().travel();
//            game.pizzeria.getAnimatronics().get(1).travel();
//            game.pizzeria.getAnimatronics().get(2).travel();
//        }
    }
}
