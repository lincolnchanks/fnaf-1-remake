package com.erikkholdern.fnaf;

public class Game {
    private static final Game instance = new Game();
    private final Pizzeria pizzeria = Pizzeria.getInstance();
    private int nightNumber;

    private Game(){
        nightNumber = 1;
    }

    public static Game getInstance() {
        return instance;
    }

    public static void main(String[] args){
        Game game = Game.getInstance();

        game.pizzeria.getRooms().getFirst().showRoomCamera();
        game.pizzeria.getRooms().get(2).showRoomCamera();

        game.pizzeria.getAnimatronics().get(1).travel();
        game.pizzeria.getAnimatronics().get(1).travel();
        game.pizzeria.getAnimatronics().get(1).travel();
        game.pizzeria.getAnimatronics().get(1).travel();

        game.pizzeria.getAnimatronics().getFirst().travel();
        game.pizzeria.getAnimatronics().getFirst().travel();
        game.pizzeria.getAnimatronics().getFirst().travel();
        game.pizzeria.getAnimatronics().getFirst().travel();
        game.pizzeria.getAnimatronics().getFirst().travel();

        game.pizzeria.getAnimatronics().get(2).travel();
        game.pizzeria.getAnimatronics().get(2).travel();
        game.pizzeria.getAnimatronics().get(2).travel();
        game.pizzeria.getAnimatronics().get(2).travel();
        game.pizzeria.getAnimatronics().get(2).travel();
    }
}
