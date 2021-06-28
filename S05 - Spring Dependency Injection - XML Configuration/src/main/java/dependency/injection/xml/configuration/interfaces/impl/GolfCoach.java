/**
 * 
 */
package dependency.injection.xml.configuration.interfaces.impl;

import dependency.injection.xml.configuration.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 *
 */
public class GolfCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
	return "GOLF : Practice your putting skills for 2 hours today";
    }

    @Override
    public String getDailyFortune() {
	// TODO Auto-generated method stub
	return null;
    }

}
