/**
 * 
 */
package dependency.injection.xml.configuration.interfaces.impl;

import dependency.injection.xml.configuration.interfaces.IFortuneService;

/**
 * @author Jonathan Vinh
 */
public class HappyFortuneService implements IFortuneService {

    @Override
    public String getFortune() {
	return "Today is your lucky day";
    }
}
