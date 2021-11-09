/*
 * 
 */
package spring.configuration.annotations.di.interfaces.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.configuration.annotations.di.interfaces.FortuneService;

@Component
@Qualifier("lambdaService")
public class RESTFortuneService implements FortuneService {

    @Override
    public String getFortune() {
	return "Today is your lucky day! ~ RESTFortuneService";
    }

}
