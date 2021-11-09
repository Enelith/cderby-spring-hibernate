/*
 * 
 */
package spring.configuration.annotations.di.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.configuration.annotations.di.interfaces.Coach;
import spring.configuration.annotations.di.interfaces.FortuneService;

@Component
public class TennisCoach_MethodInjection implements Coach {

    private FortuneService fortuneService;

    // Define a default constructor
    public TennisCoach_MethodInjection() {
	System.out.println(" >> TennisCoach_MethodInjection : inside default constructor");
    }
    
    // Define a method
    @Autowired
    public void doSomethingRandom(FortuneService fortuneService) {
	System.out.println(" >> TennisCoach_MethodInjection : inside doSomethingRandom");
	this.fortuneService = fortuneService;
    }
    
    @Override
    public String getDailyWorkout() {
	return "Practice your backhand volley with TennisCoach_MethodInjection";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
