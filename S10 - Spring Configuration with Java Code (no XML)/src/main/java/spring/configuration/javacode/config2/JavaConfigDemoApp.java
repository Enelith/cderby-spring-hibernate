/*
 * 
 */
package spring.configuration.javacode.config2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.configuration.javacode.interfaces.Coach;
import spring.configuration.javacode.interfaces.impl.SwimCoach;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
	System.out.println(" --- JavaConfigDemoApp --- ");
	
	// read spring config Java class
	AnnotationConfigApplicationContext context =
		    new AnnotationConfigApplicationContext(SportConfig.class);

	// get the bean from spring container
	SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
	call(theCoach);
	
	// Call the injected props values for SwimCoach
	System.out.println("SwimCoach EMAIL : " + theCoach.getEmail());
	System.out.println("SwimCoach TEAM : " + theCoach.getTeam());
	
	// close the context
	context.close();
    }
    
    public static void call(Coach theCoach) {
	System.out.println();
	// call a method on the bean
	System.out.println(theCoach.getDailyWorkout());
	// call method to get daily fortune
	System.out.println(theCoach.getDailyFortune());
    }

}
