/*
 * 
 */
package spring.configuration.annotations.di.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.configuration.annotations.di.interfaces.Coach;
import spring.configuration.annotations.di.interfaces.FortuneService;

@Component
public class TennisCoach_SetterInjection implements Coach {

    private FortuneService fortuneService;

    // Define a default constructor
    public TennisCoach_SetterInjection() {
	System.out.println(" >> TennisCoach_SetterInjection : inside default constructor");
    }
    
    // Define a setter method
    @Autowired
    @Qualifier("lambdaService")
    public void setFortuneService(FortuneService fortuneService) {
	System.out.println(" >> TennisCoach_SetterInjection : inside setFortuneService");
	this.fortuneService = fortuneService;
    }
    
    @Override
    public String getDailyWorkout() {
	return "Practice your backhand volley with TennisCoach_SetterInjection";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
