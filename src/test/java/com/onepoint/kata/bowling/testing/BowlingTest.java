package com.onepoint.kata.bowling.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.onepoint.kata.bowling.Bowling;

class BowlingTest {


	  private Bowling partie;

	    @BeforeEach
	    public void setUp() {
	    	// initialisation d'une instance
	        partie = new Bowling();
	    }

	    @Test
	    public void scoreZero() {
	    	// basic 
	    	jouer(20, 0);
	        assertEquals(partie.getScore(), 0);
	    }
	    
	    @Test
	    public void scoreMax() {
	    	//partie ideal 
	    	jouer(12, 10);
	        assertEquals(partie.getScore(), 300);
	    }

	    @Test
	    public void scoreTousHuit() {
	    	//exemple si le joueur fait tomber la somme de 8 dans chaque couple de lancee
	    	jouer(20, 4);
	        assertEquals(partie.getScore(), 80);
	    }
	    
	    @Test
	    public void scoreDeuxiemeExemple() {
	    	//exemple 2 de l'exercice ... 
	    	jouer(10, 9);
	        assertEquals(partie.getScore(), 90);
	    }
	    
	    @Test
	    public void scoreTroisiemeExemple() {
	    	//exemple 3 de l'exercice ... 
	    	for(int i =0 ;i<10; i++) { 
	    		// spare 
	    		 partie.knock(5);
	 	         partie.knock(5);
	    	}
	    	partie.knock(5);
	        assertEquals(partie.getScore(), 150);
	    }
	    
	    @Test
	    public void scoreOnlySpare() {
	    	// spare 
	    	partie.knock(5);
		    partie.knock(5);
		   
	        jouer(18, 0);
	        assertEquals(partie.getScore(), 10);
	    }
	    
	    @Test
	    public void scoreSpare() {
	    	// spare 
	    	partie.knock(5);
		    partie.knock(5);
		    
		    
		    partie.knock(2);
	        jouer(17, 0);
	        assertEquals(partie.getScore(), 14);
	    }
	    
	    @Test
	    public void scoreOnlyStrike() {
	    	partie.knock(10); // Strike
	    	
	    	jouer(18, 0);
	        assertEquals(partie.getScore(), 10);
	    }
	    
	    @Test
	    public void scoreStrike() {
	    	partie.knock(10); // Strike
	    	
	        partie.knock(2);
	        partie.knock(5);
	        jouer(16, 0);

	        assertEquals(partie.getScore(), 24);
	    }
	  
	  
	    
	    private void jouer(int times, int pins) {
	        for (int i = 0; i < times; i++)
	            partie.knock(pins);
	    }



}
