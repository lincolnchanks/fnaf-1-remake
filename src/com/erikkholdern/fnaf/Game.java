package com.erikkholdern.fnaf;

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

    public static void main(String[] args){
        Game game = Game.getInstance();

        // Game ticks over to 2 AM
        game.hourNumber = 2;
        if (game.hourNumber == 2){
            game.pizzeria.getAnimatronics().get(1).setAILevel(1);
        }

        for (int i = 0; i < 9; i++){
            game.pizzeria.getAnimatronics().get(1).travel();
        }

        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();

        game.hourNumber++;
        if (game.hourNumber == 3){
            game.pizzeria.getAnimatronics().get(1).setAILevel(2);
            game.pizzeria.getAnimatronics().get(2).setAILevel(1);
            game.pizzeria.getAnimatronics().get(3).setAILevel(1);
        }

        for (int i = 0; i < 9; i++){
            game.pizzeria.getAnimatronics().get(1).travel();
            game.pizzeria.getAnimatronics().get(2).travel();
        }

        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();
        game.pizzeria.getAnimatronics().get(2).getPosition().showRoomCamera();

        game.hourNumber++;
        if (game.hourNumber == 4){
            game.pizzeria.getAnimatronics().get(1).setAILevel(3);
            game.pizzeria.getAnimatronics().get(2).setAILevel(2);
            game.pizzeria.getAnimatronics().get(3).setAILevel(2);
        }

        for (int i = 0; i < 9; i++){
            game.pizzeria.getAnimatronics().get(1).travel();
            game.pizzeria.getAnimatronics().get(2).travel();
        }

        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();
        game.pizzeria.getAnimatronics().get(2).getPosition().showRoomCamera();

//        game.pizzeria.getRooms().getFirst().showRoomCamera();
//        game.pizzeria.getRooms().get(2).showRoomCamera();
//
//        game.pizzeria.getAnimatronics().get(1).travel();
//        game.pizzeria.getAnimatronics().get(1).travel();
//        game.pizzeria.getAnimatronics().get(1).travel();
//        game.pizzeria.getAnimatronics().get(1).travel();
//
//        game.pizzeria.getAnimatronics().getFirst().travel();
//        game.pizzeria.getAnimatronics().getFirst().travel();
//        game.pizzeria.getAnimatronics().getFirst().travel();
//        game.pizzeria.getAnimatronics().getFirst().travel();
//        game.pizzeria.getAnimatronics().getFirst().travel();
//
//        game.pizzeria.getAnimatronics().get(2).travel();
//        game.pizzeria.getAnimatronics().get(2).travel();
//        game.pizzeria.getAnimatronics().get(2).travel();
//        game.pizzeria.getAnimatronics().get(2).travel();
//        game.pizzeria.getAnimatronics().get(2).travel();
    }
}
