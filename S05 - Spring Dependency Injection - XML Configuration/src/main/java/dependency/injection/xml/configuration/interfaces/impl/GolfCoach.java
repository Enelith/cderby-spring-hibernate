/**
 * 
 */
package dependency.injection.xml.configuration.interfaces.impl;

import dependency.injection.xml.configuration.interfaces.ICoach;
import dependency.injection.xml.configuration.interfaces.IFortuneService;

/**
 * @author Jonathan Vinh
 */
public class GolfCoach implements ICoach {

    // Define a private field for the dependency
    private IFortuneService fortuneService;

    // Define a constructor for dependency injection
    public GolfCoach(IFortuneService theFortuneService) {
	fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "GOLF : Practice your putting skills for 2 hours today";
    }

    @Override
    public String getDailyFortune() {
	// Use fortuneService to get a fortune
	return fortuneService.getFortune();
    }
}
