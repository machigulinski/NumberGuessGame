package service;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Machi
 */
public class GuessingService implements Serializable {

    private String result;
    private int numOfGuesses = 0;
    private boolean gameOn = true;

    public void guessNumber(int randomNumber, int playerNumber) {
	String msg;
	if (playerNumber < randomNumber) {
	    msg = "low";
	} else if (playerNumber > randomNumber) {
	    msg = "high";
	} else {
	    msg = "match";
	    gameOn = false;
	}
	numOfGuesses++;
	this.result = msg;
    }
    
     public int generateRandomNumber() {	
	Random rand = new Random();
	return rand.nextInt(10)+1;	
	
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public int getNumOfGuesses() {
	return numOfGuesses;
    }

    public void setNumOfGuesses(int numOfGuesses) {
	this.numOfGuesses = numOfGuesses;
    }

    public boolean isGameOn() {
	return gameOn;
    }

    public void setGameOn(boolean gameOn) {
	this.gameOn = gameOn;
    }

}
