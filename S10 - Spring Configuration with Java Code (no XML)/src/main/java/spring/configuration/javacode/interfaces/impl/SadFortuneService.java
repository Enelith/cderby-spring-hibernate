/**
 * 
 */
package spring.configuration.javacode.interfaces.impl;

import spring.configuration.javacode.interfaces.FortuneService;

/**
 * @author Jonathan Vinh
 *
 */
public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
	return "Today is a sad day";
    }

}
