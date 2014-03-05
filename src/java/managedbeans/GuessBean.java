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
@Named
@SessionScoped
public class GuessBean implements Serializable {
    
    
    private int playerNumber;
    private boolean success = false;
    
    @Inject
    private GuessingService guessingService;
    /**
     * Creates a new instance of GuessBean
     */
    public GuessBean() {}
    
    public String checkGuess(){
	
	
	
		
	return "result";
    
    }

    public static int generateRandomNumber() {	
	Random rand = new Random();
	return rand.nextInt((10 - 1) + 1) + 1;	
    }

    public int getPlayerNumber() {
	return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
	this.playerNumber = playerNumber;
    }
    
    
    public static void main(String[] args) {
	System.out.println(generateRandomNumber());
    }
}
