/**
 * 
 */
package dependency.injection.xml.configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependency.injection.xml.configuration.interfaces.impl.CricketCoach;

/**
 * @author Jonathan Vinh
 */
public class SetterInjectionDemoApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// load the spring configuration file
	ClassPathXmlApplicationContext context =
		    new ClassPathXmlApplicationContext("applicationContext.xml");

	// retrieve bean from spring container
	CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class); // This also works fine

	// call methods on the bean
	System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());
	
	// call the new methods for literal values
	System.out.println("Email address : " + theCoach.getEmailAddress());
	System.out.println("Team : " + theCoach.getTeam());
	
	// close the context
	context.close();
    }

}
