/*
 * 
 */
package spring.configuration.javacode.interfaces.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import spring.configuration.javacode.interfaces.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {

    // Create an array of Strings
    private String[] data = {
	    "Beware of the wolf in sheep's clothing",
	    "Diligence is the mother of Good Luck",
	    "The journey is the reward"
    };
    
    // Create a random number generator
    private Random myRandom = new Random();

    public String getFortune() {
	int index = myRandom.nextInt(data.length);
	
	return data[index];
    }
}