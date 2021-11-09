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
public class TennisCoach_ConstructorInjection implements Coach {

    private FortuneService fortuneService;

    // Autowired annotation for constructors
    @Autowired
    public TennisCoach_ConstructorInjection(@Qualifier("happyFortuneService") FortuneService theFortuneService) {
	System.out.println(" >> TennisCoach_ConstructorInjection : inside default constructor");
	fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
