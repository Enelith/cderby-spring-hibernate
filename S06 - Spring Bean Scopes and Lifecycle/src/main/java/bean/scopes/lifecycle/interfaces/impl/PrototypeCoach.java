/**
 * 
 */
package bean.scopes.lifecycle.interfaces.impl;

import org.springframework.beans.factory.DisposableBean;

import bean.scopes.lifecycle.interfaces.ICoach;
import bean.scopes.lifecycle.interfaces.IFortuneService;

/**
 * @author Jonathan Vinh
 */
public class PrototypeCoach implements ICoach, DisposableBean {

    // Define a private field for the dependency
    private IFortuneService fortuneService;
    
    public PrototypeCoach() {
	
    }

    // Define a constructor for dependency injection
    public PrototypeCoach(IFortuneService theFortuneService) {
	fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "PrototypeCoach : getDailyWorkout";
    }

    @Override
    public String getDailyFortune() {
	// Use fortuneService to get a fortune
	return "PrototypeCoach : " + fortuneService.getFortune();
    }
    
    // Add an init method
    public void doStartup() {
	System.out.println("PrototypeCoach : inside method doStartup");
    }

    @Override
    public void destroy() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("PrototypeCoach: inside method destroy@DisposableBean");		
    }
}
