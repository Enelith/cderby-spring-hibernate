/**
 * 
 */
package bean.scopes.lifecycle.interfaces.impl;

import bean.scopes.lifecycle.interfaces.ICoach;
import bean.scopes.lifecycle.interfaces.IFortuneService;

/**
 * @author Jonathan Vinh
 */
public class BasketCoach implements ICoach {

    // Define a private field for the dependency
    private IFortuneService fortuneService;

    // Define a constructor for dependency injection
    public BasketCoach(IFortuneService theFortuneService) {
	fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "BASKET : 10.000 hours training to become a real master";
    }

    @Override
    public String getDailyFortune() {
	// Use fortuneService to get a fortune
	return fortuneService.getFortune();
    }
}
