/*
 * 
 */
package spring.configuration.annotations.scopes.interfaces.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spring.configuration.annotations.scopes.interfaces.Coach;
import spring.configuration.annotations.scopes.interfaces.FortuneService;

/**
 * PROTOTYPE Scope = Create a new instance every time
 * 
 * @author Jonathan Vinh
 */
@Component
@Scope("prototype")
public class TennisCoach_ScopePrototype implements Coach, DisposableBean {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // Define a default constructor
    public TennisCoach_ScopePrototype() {
	System.out.println(" >> TennisCoach_ScopePrototype : inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
	return "Practice your backhand volley with TennisCoach_ScopePrototype";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

    @PostConstruct
    public void doMyStartupStuff() {
	System.out.println(" >> TennisCoach_ScopePrototype: inside doMyStartupStuff()");
    }

    // Rappel : For "prototype" scoped beans, Spring does not call the @PreDestroy method. 
    @Override
    public void destroy() throws Exception {
	System.out.println(" >> TennisCoach_ScopePrototype: inside destroy()");

    }

}
