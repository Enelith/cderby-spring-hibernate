/**
 * 
 */
package bean.scopes.lifecycle.interfaces.impl;

import bean.scopes.lifecycle.interfaces.ICoach;
import bean.scopes.lifecycle.interfaces.IFortuneService;

/**
 * @author Jonathan Vinh
 */
public class TrackCoach implements ICoach {

    // Define a private field for the dependency
    private IFortuneService fortuneService;
    
    public TrackCoach() {
	
    }

    // Define a constructor for dependency injection
    public TrackCoach(IFortuneService theFortuneService) {
	fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "TRACK : Run a hard 5km";
    }

    @Override
    public String getDailyFortune() {
	// Use fortuneService to get a fortune
	return "Run : " + fortuneService.getFortune();
    }
    
    // Add an init method
    public void doStartup() {
	System.out.println("TrackCoach : inside method doStartup");
    }
    
    // Add a destroy method
    public void doDestroy() {
	System.out.println("TrackCoach : inside method doDestroy");
    }
}
