/*
 * 
 */
package spring.configuration.javacode.config1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.configuration.javacode.interfaces.Coach;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
	System.out.println(" --- JavaConfigDemoApp --- ");
	
	// read spring config Java class
	AnnotationConfigApplicationContext context =
		    new AnnotationConfigApplicationContext(SportConfig.class);

	// get the bean from spring container
	Coach theCoach = context.getBean("tennisCoach", Coach.class);
	call(theCoach);
	
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
