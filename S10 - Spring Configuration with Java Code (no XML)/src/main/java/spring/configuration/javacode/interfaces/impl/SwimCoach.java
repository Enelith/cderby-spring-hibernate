/**
 * 
 */
package spring.configuration.javacode.interfaces.impl;

import spring.configuration.javacode.interfaces.Coach;
import spring.configuration.javacode.interfaces.FortuneService;

/**
 * @author Jonathan Vinh
 */
public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    /**
     * 
     */
    public SwimCoach(FortuneService theFortuneService) {
	this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Swim 1000 meters as a warm up.";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
