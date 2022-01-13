/**
 * 
 */
package spring.configuration.javacode.interfaces.impl;

import org.springframework.beans.factory.annotation.Value;

import spring.configuration.javacode.interfaces.Coach;
import spring.configuration.javacode.interfaces.FortuneService;

/**
 * @author Jonathan Vinh
 */
public class SwimCoach implements Coach {

    private FortuneService fortuneService;
    
    // Field Level Injection
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

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

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

}
