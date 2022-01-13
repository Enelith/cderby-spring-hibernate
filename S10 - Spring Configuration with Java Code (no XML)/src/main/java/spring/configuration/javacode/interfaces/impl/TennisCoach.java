/*
 * 
 */
package spring.configuration.javacode.interfaces.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.configuration.javacode.interfaces.Coach;
import spring.configuration.javacode.interfaces.FortuneService;

/**
 * DEFAULT Scope = SINGLETON
 * 
 * @author Jonathan Vinh
 *
 */
@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // Define a default constructor
    public TennisCoach() {
	System.out.println(" >> TennisCoach : inside default constructor");
    }
    
    @Override
    public String getDailyWorkout() {
	return "Practice your backhand volley with TennisCoach";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }
    
    // Define init method
    // Rappel : Code will execute after constructor and after injection of dependencies
    @PostConstruct
    public void doInitStuffs() {
	System.out.println(" >> TennisCoach : inside doInitStuffs() method [@PostConstruct]");
    }
    
    // Define destroy method
    // Rappel : Code will execute before the bean is destroyed
    @PreDestroy
    public void doCleanupStuffs() {
	System.out.println(" >> TennisCoach : inside doCleanupStuffs() method [@PreDestroy]");
    }
}
