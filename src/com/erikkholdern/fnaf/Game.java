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

        // At 2AM, increase Bonnie by 1
        game.hourNumber = 2;
        if (game.hourNumber == 2){
            game.pizzeria.getAnimatronics().get(1).boostAILevel();
        }

        for (int i = 0; i < 9; i++){
            game.pizzeria.getAnimatronics().get(1).travel();
        }

        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();

        // At 3AM, increase everyone but Freddy by 1
        game.hourNumber++;
        if (game.hourNumber == 3){
            game.pizzeria.getAnimatronics().get(1).boostAILevel();
            game.pizzeria.getAnimatronics().get(2).boostAILevel();
            game.pizzeria.getAnimatronics().get(3).boostAILevel();
        }

        for (int i = 0; i < 9; i++){
            game.pizzeria.getAnimatronics().get(1).travel();
            game.pizzeria.getAnimatronics().get(2).travel();
        }

        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();
        game.pizzeria.getAnimatronics().get(2).getPosition().showRoomCamera();

        // At 4AM, increase everyone but Freddy by 1
        game.hourNumber++;
        if (game.hourNumber == 4){
            game.pizzeria.getAnimatronics().get(1).boostAILevel();
            game.pizzeria.getAnimatronics().get(2).boostAILevel();
            game.pizzeria.getAnimatronics().get(3).boostAILevel();
        }

        for (int i = 0; i < 9; i++){
            game.pizzeria.getAnimatronics().get(1).travel();
            game.pizzeria.getAnimatronics().get(2).travel();
        }

        game.pizzeria.getAnimatronics().get(1).getPosition().showRoomCamera();
        game.pizzeria.getAnimatronics().get(2).getPosition().showRoomCamera();

        System.out.println();

        // Reset the game to test it again
        game.pizzeria.getAnimatronics().getFirst().setPosition(game.pizzeria.getRooms().getFirst());
        game.pizzeria.getAnimatronics().get(1).setPosition(game.pizzeria.getRooms().getFirst());
        game.pizzeria.getAnimatronics().get(2).setPosition(game.pizzeria.getRooms().getFirst());
        game.pizzeria.getAnimatronics().get(3).setPosition(game.pizzeria.getRooms().get(2));

        for (Animatronic animatronic : game.pizzeria.getAnimatronics()){
            animatronic.setAILevel(10);
        }

        for (int i = 0; i < 9; i++){
            game.pizzeria.getAnimatronics().getFirst().travel();
            game.pizzeria.getAnimatronics().get(1).travel();
            game.pizzeria.getAnimatronics().get(2).travel();
        }
    }
}
