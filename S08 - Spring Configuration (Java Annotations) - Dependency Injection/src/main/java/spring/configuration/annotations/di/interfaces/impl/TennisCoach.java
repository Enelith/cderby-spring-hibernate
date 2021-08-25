/*
 * 
 */
package spring.configuration.annotations.di.interfaces.impl;

import org.springframework.stereotype.Component;

import spring.configuration.annotations.di.interfaces.Coach;
import spring.configuration.annotations.di.interfaces.FortuneService;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
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
