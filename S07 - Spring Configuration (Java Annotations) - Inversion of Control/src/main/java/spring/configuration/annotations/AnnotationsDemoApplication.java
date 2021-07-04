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
	// ICoach coach = context.getBean("thatTennisCoach", ICoach.class); // Call Bean with specific Bean ID
	ICoach coach = context.getBean("tennisCoach", ICoach.class); // Use the Defautl Bean ID of the TennisCoach class = tennisCoach

	// Call method on the bean
	System.out.println(coach.getDailyWorkout());

	// Close context
	context.close();
    }
}
