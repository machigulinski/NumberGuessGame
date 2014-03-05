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
    private boolean gameOn = true;
    
    
    @Inject
    private GuessingService gns;
    /**
     * Creates a new instance of GuessBean
     */
    public GuessBean() {}
    
    public String checkGuess(){
	if(gameOn == false){
            randomNumber = this.generateRandomNumber();
            gameOn = true;
            gns.setGameOn(gameOn);
        }
	
	gns.guessNumber(randomNumber, playerNumber);
	result = gns.getResult();
	gameOn = gns.isGameOn();
	
	if (gameOn) {	    
	    result = "Your guess is too " + result + "Try again.";	
	} else {
	    result = "YEY, YOU  DID IT!";
	    
	}
	
	
	
	
		
	return null;
    
    }
    
    
    public String startGame() {	
	randomNumber = this.generateRandomNumber();
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
    
    
    public static void main(String[] args) {
	GuessBean gb = new GuessBean();
	System.out.println(gb.generateRandomNumber());
    }
}
