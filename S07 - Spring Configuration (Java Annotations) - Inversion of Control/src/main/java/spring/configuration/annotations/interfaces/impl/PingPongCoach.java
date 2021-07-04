/**
 * 
 */
package spring.configuration.annotations.interfaces.impl;

import org.springframework.stereotype.Component;

import spring.configuration.annotations.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 */
@Component
public class PingPongCoach implements ICoach {

    // define a default constructor
    public PingPongCoach() {
	System.out.println(" >> PingPongCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
	return "PINGPONG : Practice your pingpong drop shot";
    }
}
