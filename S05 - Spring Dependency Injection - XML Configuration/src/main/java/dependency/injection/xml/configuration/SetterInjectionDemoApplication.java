/**
 * 
 */
package dependency.injection.xml.configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependency.injection.xml.configuration.interfaces.ICoach;

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
	ICoach theCoach = context.getBean("myCricketCoach", ICoach.class);
	// CricketCoach theCoach = context.getBean("myCricketCoach",
	// CricketCoach.class); // This also works fine

	// call methods on the bean
	System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());

	// close the context
	context.close();
    }

}
