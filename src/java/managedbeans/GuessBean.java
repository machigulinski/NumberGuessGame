/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import java.io.Serializable;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.GuessingService;


/**
 *
 * @author Machi
 */
@Named("guessBean")
@SessionScoped
public class GuessBean implements Serializable {    
    private String result;
    private int playerNumber;
    private int randomNumber;
    private int numOfGuesses = 0;
    private int maxNumOfGuesses= 0;
    private int minNumOfGuesses = 0;
    private boolean gameOn = false;
    
    
    @Inject
    private GuessingService gns;
    /**
     * Creates a new instance of GuessBean
     */
    public GuessBean() {}
    
    public String checkGuess(){
	if(!gameOn){
            randomNumber = this.generateRandomNumber();
            gameOn = true;
            gns.setGameOn(gameOn);
        }
	
	gns.guessNumber(randomNumber, playerNumber);
	this.result = gns.getResult();
	this.gameOn = gns.isGameOn();
	this.numOfGuesses = gns.getNumOfGuesses();
	
	if (gameOn) {	    
	    result = "Your guess is too " + result.toUpperCase() + ". Try again.";
	    
	} else {
	    result = "Yey, YOU  DID IT!";
	    this.setMinMaxGuesses();
	}		
	return null;    
    }
    
    private void setMinMaxGuesses(){
	
    
    }
  
    
    
    public String startGame() {	
	randomNumber = this.generateRandomNumber();
	this.setPlayerNumber(0);
	this.setNumOfGuesses(0);
	this.setResult(null);
	return null;
    }

    private int generateRandomNumber() {	
	Random rand = new Random();
	return rand.nextInt(10)+1;	
	
    }

    public int getPlayerNumber() {
	return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
	this.playerNumber = playerNumber;
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public int getRandomNumber() {
	return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
	this.randomNumber = randomNumber;
    }

    public int getNumOfGuesses() {
	return numOfGuesses;
    }

    public void setNumOfGuesses(int numOfGuesses) {
	this.numOfGuesses = numOfGuesses;
    }

    public int getMaxNumOfGuesses() {
	return maxNumOfGuesses;
    }

    public void setMaxNumOfGuesses(int maxNumOfGuesses) {
	this.maxNumOfGuesses = maxNumOfGuesses;
    }

    public int getMinNumOfGuesses() {
	return minNumOfGuesses;
    }

    public void setMinNumOfGuesses(int minNumOfGuesses) {
	this.minNumOfGuesses = minNumOfGuesses;
    }

    public boolean isGameOn() {
	return gameOn;
    }

    public void setGameOn(boolean gameOn) {
	this.gameOn = gameOn;
    }
    
    
    public static void main(String[] args) {
	GuessBean gb = new GuessBean();
	System.out.println(gb.generateRandomNumber());
    }
}
