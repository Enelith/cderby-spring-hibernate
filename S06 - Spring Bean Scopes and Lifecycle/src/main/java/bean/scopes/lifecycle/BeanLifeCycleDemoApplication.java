/**
 * 
 */
package bean.scopes.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.scopes.lifecycle.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 */
public class BeanLifeCycleDemoApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// load the spring configuration file
	ClassPathXmlApplicationContext context =
		    new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

	// retrieve bean from spring container
	ICoach theCoach = context.getBean("myTrackCoach", ICoach.class);

	System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());
	
	// PROTOTYPE DESTROY HANDLER TEST
	theCoach = context.getBean("myPrototypeCoach", ICoach.class);
	System.out.println(theCoach.getDailyWorkout());
	
	// close the context
	context.close();
    }

}
