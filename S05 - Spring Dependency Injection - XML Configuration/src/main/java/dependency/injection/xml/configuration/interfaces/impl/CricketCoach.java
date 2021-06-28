/**
 * 
 */
package dependency.injection.xml.configuration.interfaces.impl;

import dependency.injection.xml.configuration.interfaces.ICoach;
import dependency.injection.xml.configuration.interfaces.IFortuneService;

/**
 * @author Jonathan Vinh
 *
 */
public class CricketCoach implements ICoach {

    private IFortuneService fortuneService;
    
    // Add new fields for emailAddress and Team name
    private String emailAddress;
    private String team;
    
    // Create a no-args constructor
    public CricketCoach() {
	System.out.println("CricketCoach : Inside the no-args constructor");
    }
    
    @Override
    public String getDailyWorkout() {
	return "Practice fast bowling for 15mins a day";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

    // Setter method : will be called by Spring when about to inject your dependency (cf. xml file)
    public void setFortuneService(IFortuneService fortuneService) {
	System.out.println("CricketCoach : Inside the setFortuneService method");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
	return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
	System.out.println("CricketCoach : Inside the setEmailAddress method (#" + emailAddress + ")");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
	return team;
    }
    public void setTeam(String team) {
	System.out.println("CricketCoach : Inside the setTeam method (#" + team + ")");
        this.team = team;
    }
}
