package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */
    private PigGameState ourGameState;

    public PigLocalGame() {
        //TODO  You will implement this constructor
        ourGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (ourGameState.getPlayerId() == playerIdx){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (action instanceof PigHoldAction){
            if(ourGameState.getPlayerId() == 0) {
                ourGameState.setPlayer0Score(ourGameState.getPlayer0Score() + ourGameState.getRunningScore());
                ourGameState.setPlayerId(1);
            }
            else if(ourGameState.getPlayerId() == 1){
                ourGameState.setPlayer1Score(ourGameState.getPlayer1Score() + ourGameState.getRunningScore());
                ourGameState.setPlayerId(0);
            }
            ourGameState.setRunningScore(0);
            return true;
        }
        if (action instanceof PigRollAction){
            int randNum = (int) (Math.random() * 6) + 1;
            if (randNum != 1){
                ourGameState.setRunningScore(ourGameState.getRunningScore() + randNum);
            }
            else {
                ourGameState.setRunningScore(0);
                if(ourGameState.getPlayerId() == 0){
                    ourGameState.setPlayerId(1);
                }
                else{
                    ourGameState.setPlayerId(0);
                }
                return true;
            }
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState pigCopy = new PigGameState(ourGameState);
        p.sendInfo(pigCopy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(ourGameState.getPlayer0Score() >= 50){
            return "Player 0 won with a score of" + ourGameState.getPlayer0Score();
        }
        else if (ourGameState.getPlayer1Score() >= 50){
            return "Player 1 won with a score of" + ourGameState.getPlayer1Score();
        }
        return null;
    }



}// class PigLocalGame
