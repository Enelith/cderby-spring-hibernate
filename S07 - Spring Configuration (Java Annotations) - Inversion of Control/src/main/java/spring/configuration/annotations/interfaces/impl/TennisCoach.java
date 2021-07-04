/**
 * 
 */
package spring.configuration.annotations.interfaces.impl;

import org.springframework.stereotype.Component;

import spring.configuration.annotations.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 */
// @Component("thatTennisCoach") // Explicit Bean ID
@Component // Default Bean ID = Class name with first letter in lowercase (ie :
	   // tennisCoach)
public class TennisCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
	// TODO Auto-generated method stub
	return "TENNIS : DailyWorkout from TennisCoach";
    }

}
