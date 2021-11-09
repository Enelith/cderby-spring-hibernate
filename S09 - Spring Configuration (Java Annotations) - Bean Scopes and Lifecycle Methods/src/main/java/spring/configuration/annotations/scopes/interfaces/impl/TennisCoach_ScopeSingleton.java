/*
 * 
 */
package spring.configuration.annotations.scopes.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.configuration.annotations.scopes.interfaces.Coach;
import spring.configuration.annotations.scopes.interfaces.FortuneService;

/**
 * DEFAULT Scope = SINGLETON
 * 
 * @author Jonathan Vinh
 *
 */
@Component
public class TennisCoach_ScopeSingleton implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // Define a default constructor
    public TennisCoach_ScopeSingleton() {
	System.out.println(" >> TennisCoach_ScopeSingleton : inside default constructor");
    }
    
    @Override
    public String getDailyWorkout() {
	return "Practice your backhand volley with TennisCoach_ScopeSingleton";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
