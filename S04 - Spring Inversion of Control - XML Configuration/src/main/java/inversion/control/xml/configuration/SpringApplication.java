/**
 * 
 */
package inversion.control.xml.configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jonathan Vinh
 */
public class SpringApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// load the spring configuration file
	ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
			
	// retrieve bean from spring container
	ICoach theCoach = context.getBean("myGolfCoach", ICoach.class);
	
	// call methods on the bean
	System.out.println(theCoach.getDailyWorkout());

	theCoach = context.getBean("myBasketCoach", ICoach.class);
	// call methods on the bean
	System.out.println(theCoach.getDailyWorkout());
	
	// close the context
	context.close();
    }

}
