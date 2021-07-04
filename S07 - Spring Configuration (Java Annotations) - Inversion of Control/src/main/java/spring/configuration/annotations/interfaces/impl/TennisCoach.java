/**
 * 
 */
package spring.configuration.annotations.interfaces.impl;

import org.springframework.stereotype.Component;

import spring.configuration.annotations.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 *
 */
@Component("thatTennisCoach")
public class TennisCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
	// TODO Auto-generated method stub
	return "TENNIS : DailyWorkout from TennisCoach";
    }

}
