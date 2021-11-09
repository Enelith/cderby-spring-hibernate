/**
 * 
 */
package spring.configuration.annotations.scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.configuration.annotations.scopes.interfaces.Coach;

/**
 * Note : the DEFAULT Scope = SINGLETON
 * 
 * @author Jonathan Vinh
 */
public class AnnotationBeanScopeDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// read spring config file
	ClassPathXmlApplicationContext context = 
		    new ClassPathXmlApplicationContext("applicationContext.xml");
	
	initBeans(context, "tennisCoach_ScopeSingleton");
	
	initBeans(context, "tennisCoach_ScopePrototype");

	// close the context
	context.close();
    }
    
    private static void initBeans(ClassPathXmlApplicationContext context, String beanType) {
	// Retrieve bean from Spring Container
	Coach theCoach = context.getBean(beanType, Coach.class);
	Coach otherCoach = context.getBean(beanType, Coach.class);
	
	displayResult(theCoach, otherCoach);
    }
    
    private static void displayResult(Coach theCoach, Coach otherCoach) {
	// Check if they are the same
	boolean result = (theCoach == otherCoach);
	
	System.out.println();
	System.out.println("Pointing to the same object : " + result);
	System.out.println("Memory location for theCoach : " + theCoach);
	System.out.println("Memory location for otherCoach : " + otherCoach);
	System.out.println();
    }

}
