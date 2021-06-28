/**
 * 
 */
package dependency.injection.xml.configuration.interfaces.impl;

import dependency.injection.xml.configuration.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 */
public class BasketCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
	return "BASKET : 10.000 hours training to become a real master";
    }

    @Override
    public String getDailyFortune() {
	// TODO Auto-generated method stub
	return null;
    }

}
