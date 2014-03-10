/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import java.io.Serializable;
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
    private int maxNumOfGuesses = 0;
    private int minNumOfGuesses = 0;
    private boolean gameOn = false;
    private boolean showStartBtn = false;
    
    @Inject
    private GuessingService gns;
    /**
     * Creates a new instance of GuessBean
     */
    public GuessBean() {}
    
    public void checkGuess(){
	if(!gameOn){
            randomNumber = gns.generateRandomNumber();
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
	    this.setShowStartBtn(true);
	       
	}		
	//return null;    
    }
    
    private void setMinMaxGuesses(){
		
	if(minNumOfGuesses == 0 || minNumOfGuesses > numOfGuesses ) {
	    setMinNumOfGuesses(numOfGuesses);	
	}
	    
	if(maxNumOfGuesses == 0 || maxNumOfGuesses < numOfGuesses ) {
	    setMaxNumOfGuesses(numOfGuesses);		
	}
    }  
    
    
    public String startGame() {	
	randomNumber = gns.generateRandomNumber();
	this.setPlayerNumber(0);
	this.setNumOfGuesses(0);
	this.gns.setNumOfGuesses(0);
	this.setResult(null);
	return null;
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

    public boolean isShowStartBtn() {
	return showStartBtn;
    }

    public void setShowStartBtn(boolean showStartBtn) {
	this.showStartBtn = showStartBtn;
    }

    public GuessingService getGns() {
	return gns;
    }

    public void setGns(GuessingService gns) {
	this.gns = gns;
    }
       
}
