/**
 * 
 */
package bean.scopes.lifecycle.interfaces.impl;

import bean.scopes.lifecycle.interfaces.IFortuneService;

/**
 * @author Jonathan Vinh
 */
public class HappyFortuneService implements IFortuneService {

    @Override
    public String getFortune() {
	return "Today is your lucky day";
    }
}
