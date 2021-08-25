/*
 * 
 */
package spring.configuration.annotations.di.interfaces.impl;

import org.springframework.stereotype.Component;

import spring.configuration.annotations.di.interfaces.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
	return "Today is your lucky day!";
    }

}
