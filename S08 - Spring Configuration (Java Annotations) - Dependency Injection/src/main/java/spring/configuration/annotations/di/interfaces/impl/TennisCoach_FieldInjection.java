/*
 * 
 */
package spring.configuration.annotations.di.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.configuration.annotations.di.interfaces.Coach;
import spring.configuration.annotations.di.interfaces.FortuneService;

/**
 * Inject dependencies by setting field values on your class directly (even private fields).
 * Accomplished by using Java Reflection.
 * 
 * 1 - Configure the DI with Autowired Annotation (applied directly on the field, no need for Setter methods)
 * 
 * @author Jonathan Vinh
 *
 */
@Component
public class TennisCoach_FieldInjection implements Coach {

    @Autowired
    @Qualifier("databaseFortuneService")
    private FortuneService fortuneService;

    // Define a default constructor
    public TennisCoach_FieldInjection() {
	System.out.println(" >> TennisCoach_FieldInjection : inside default constructor");
    }
    
    @Override
    public String getDailyWorkout() {
	return "Practice your backhand volley with TennisCoach_FieldInjection";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
