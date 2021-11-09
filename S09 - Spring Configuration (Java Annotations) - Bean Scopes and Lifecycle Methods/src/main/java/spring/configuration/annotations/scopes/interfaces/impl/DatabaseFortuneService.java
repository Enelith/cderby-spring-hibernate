/*
 * 
 */
package spring.configuration.annotations.scopes.interfaces.impl;

import org.springframework.stereotype.Component;

import spring.configuration.annotations.scopes.interfaces.FortuneService;

@Component
public class DatabaseFortuneService implements FortuneService {

    @Override
    public String getFortune() {
	return "Today is your lucky day! ~ DatabaseFortuneService";
    }

}
