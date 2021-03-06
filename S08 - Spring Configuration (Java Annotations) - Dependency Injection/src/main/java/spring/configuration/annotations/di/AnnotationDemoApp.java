/*
 * 
 */
package spring.configuration.annotations.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.configuration.annotations.di.interfaces.Coach;

public class AnnotationDemoApp {

    public static void main(String[] args) {
	// read spring config file
	ClassPathXmlApplicationContext context =
		    new ClassPathXmlApplicationContext("applicationContext.xml");

	// get the bean from spring container
	Coach theCoach = context.getBean("tennisCoach_ConstructorInjection", Coach.class);
	call(theCoach);
	
	theCoach = context.getBean("tennisCoach_SetterInjection", Coach.class);
	call(theCoach);
	
	theCoach = context.getBean("tennisCoach_MethodInjection", Coach.class);
	call(theCoach);
	
	theCoach = context.getBean("tennisCoach_FieldInjection", Coach.class);
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
