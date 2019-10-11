package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int playerId;
    private int player0Score;
    private int player1Score;
    private int runningScore;
    private int dieValue;

    public PigGameState(){
        playerId = 0;
        player0Score = 0;
        player1Score = 0;
        runningScore = 0;
        dieValue = 0;
    }

    public PigGameState(PigGameState ourPig){
        this.playerId = ourPig.playerId;
        this.player0Score = ourPig.player0Score;
        this.player1Score = ourPig.player1Score;
        this.runningScore = ourPig.runningScore;
        this.dieValue = ourPig.dieValue;
    }


    public int getPlayerId(){return playerId;}
    public int getPlayer0Score(){return player0Score;}
    public int getPlayer1Score(){return player1Score;}
    public int getRunningScore(){return runningScore;}
    public int getDieValue(){return dieValue;}


    public void setPlayerId(int newId){
        this.playerId = newId;
    }
    public void setPlayer0Score(int newScore){
        this.player0Score = newScore;
    }
    public void setPlayer1Score(int newScore1){
        this.player1Score = newScore1;
    }
    public void setRunningScore(int newRunningScore){
        this.runningScore = newRunningScore;
    }
    public void setDieValue(int newDieValue){
        this.dieValue = newDieValue;
    }

}
