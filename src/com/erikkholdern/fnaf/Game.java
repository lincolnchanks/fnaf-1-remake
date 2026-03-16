package com.erikkholdern.fnaf;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private static final Game instance = new Game();
    private final Pizzeria pizzeria = Pizzeria.getInstance();
    private int nightNumber;
    private int hourNumber;

    private int timeSeconds = 0;

    // 12AM is 90 seconds (90,000 milliseconds)
    // 1AM and onward are 89 seconds (89,000 milliseconds)

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

        System.out.println(bonnie.getAILevel());
        System.out.println(chica.getAILevel());

        // Calling this twice does not make the program wait 5 seconds between calls,
        // which it should be doing.
        testTimer();
//        testTimer();

//        while (hourNumber < 6){
//            // Run code
//
//            // Call testTimer(), which runs a movement check on each
//            // animatronic then increments timeSeconds by 5 (it runs every second but only
//            // updates the time every 5 seconds).
//
//            // Error in this line. I'm calling this multiple times per second when it's supposed
//            // to wait 5 seconds. I need to put the while() loop inside the timer method I think.
////            testTimer();
//
//            // At the end of each hour, reset time in seconds and increment the hour.
//            if ((timeSeconds == 90 && hourNumber == 0) || (timeSeconds == 89 && hourNumber > 0)){
//                timeSeconds = 0;
//                hourNumber++;
//            }
//        }
//
         // Anything called after the timer method will be executed before the game ends.
//        System.out.println("6AM: You win! (flag outside timer)");



//        // 12AM
//        for (int i = 0; i < 18; i++){
//            freddy.travel();
//            bonnie.travel();
//            chica.travel();
//        }
//        // 1AM
//        System.out.println("1AM");
//        hourNumber++;
//        bonnie.boostAILevel();
//        for (int i = 0; i < 18; i++){
//            freddy.travel();
//            bonnie.travel();
//            chica.travel();
//        }
//        // 2AM
//        System.out.println("2AM");
//        hourNumber++;
//        bonnie.boostAILevel();
//        chica.boostAILevel();
//        foxy.boostAILevel();
//        for (int i = 0; i < 18; i++){
////            freddy.travel();
//            bonnie.travel();
//            chica.travel();
//        }
//        // 3AM
//        System.out.println("3AM");
//        hourNumber++;
//        for (int i = 0; i < 18; i++){
////            freddy.travel();
//            bonnie.travel();
//            chica.travel();
//        }
//        // 4AM
//        System.out.println("4AM");
//        hourNumber++;
//        for (int i = 0; i < 18; i++){
////            freddy.travel();
//            bonnie.travel();
//            chica.travel();
//        }
//        // 5AM
//        System.out.println("5AM");
//        hourNumber++;
//        for (int i = 0; i < 18; i++){
////            freddy.travel();
//            bonnie.travel();
//            chica.travel();
//        }
//        System.out.println("6AM: You win!");
    }

    public void setStartingAILevels(int nightNumber, Animatronic freddy, Animatronic bonnie,
                                    Animatronic chica, Animatronic foxy){
        switch(nightNumber){
            // Should we save these by night? E.g. save the starting AI
            // values on each animatronic in question?
            case 1:
                for (Animatronic animatronic : pizzeria.getAnimatronics()){
                    animatronic.setAILevel(0);
                }
                break;
                // without these break statements, the program defaults to
                // the final case.
            case 2:
                freddy.setAILevel(0);
                bonnie.setAILevel(3);
                chica.setAILevel(1);
                foxy.setAILevel(1);
                break;
            case 3:
                freddy.setAILevel(1);
                bonnie.setAILevel(0);
                chica.setAILevel(5);
                foxy.setAILevel(2);
                break;
            case 4:
                Random freddyRandom = new Random();
                freddy.setAILevel(freddyRandom.nextInt(1, 3));
                bonnie.setAILevel(2);
                chica.setAILevel(4);
                foxy.setAILevel(6);
                break;
            case 5:
                freddy.setAILevel(3);
                bonnie.setAILevel(5);
                chica.setAILevel(7);
                foxy.setAILevel(5);
                break;
            case 6:
                freddy.setAILevel(4);
                bonnie.setAILevel(10);
                chica.setAILevel(12);
                foxy.setAILevel(6);
                break;
        }
    }

    public static void main(String[] args){
        Game game = Game.getInstance();

        game.nightNumber = 3;
        game.runNight();
//        game.testTimer();
    }

    public void testTimer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int count = 89;

            @Override
            public void run() {
                // Decrement the time
                count--;

                // Run every 5 seconds (when count is divisible by 5)
                if (count % 5 == 0){
                    System.out.println("Movement opportunity!");
                    // Roll movement for Bonnie and Chica
                    pizzeria.getAnimatronics().get(1).travel();
                    pizzeria.getAnimatronics().get(2).travel();
                    System.out.println();

                    // Increment the in-game time.
//                    timeSeconds += 5;
                }
                if (count == 0){
                    hourNumber++;
                    System.out.println(hourNumber + "AM");
                    count = 89;
                    if (hourNumber == 6){
                        System.out.println("6AM: You Win!");
                        timer.cancel();
                    }
                }
            }
        };

        // The run() method is called once every second.
        // This could be replaced by calling this once every 5 seconds, though
        // that might make it difficult to refactor the intervals for each animatronic.
        timer.scheduleAtFixedRate(task, 0, 1000); // (task, delay, period)
    }
}
