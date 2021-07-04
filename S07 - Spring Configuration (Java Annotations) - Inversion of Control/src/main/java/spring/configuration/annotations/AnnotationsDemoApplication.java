/**
 * 
 */
package spring.configuration.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.configuration.annotations.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 */
public class AnnotationsDemoApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// Read Spring config file
	ClassPathXmlApplicationContext context =
		    new ClassPathXmlApplicationContext("applicationContext.xml");

	// Get the bean from the Spring container
	ICoach coach = context.getBean("thatTennisCoach", ICoach.class);

	// Call method on the bean
	System.out.println(coach.getDailyWorkout());

	// Close context
	context.close();
    }
}
