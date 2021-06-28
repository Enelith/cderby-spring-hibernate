/**
 * 
 */
package bean.scopes.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.scopes.lifecycle.interfaces.ICoach;

/**
 * @author Jonathan Vinh
 */
public class BeanScopeDemoApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// load the spring configuration file
	ClassPathXmlApplicationContext context =
		    new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

	// retrieve bean from spring container
	ICoach alphaCoach = context.getBean("mySingletonCoach", ICoach.class);
	ICoach betaCoach = context.getBean("mySingletonCoach", ICoach.class);

	// check if they're the same (Singleton by default)
	boolean isEqual = (alphaCoach == betaCoach);
	System.out.println("====== SINGLETON SCOPE ======");
	System.out.println("\nPointing to the same object ? " + isEqual);
	System.out.println("Memory location for alphaCoach : " + alphaCoach);
	System.out.println("Memory location for betaCoach : " + betaCoach);

	// retrieve bean from spring container
	ICoach gammaCoach = context.getBean("myPrototypeCoach", ICoach.class);
	ICoach zetaCoach = context.getBean("myPrototypeCoach", ICoach.class);

	// check if they're the same (Defined as Prototype)
	isEqual = (gammaCoach == zetaCoach);
	System.out.println("\n====== PROTOTYPE SCOPE ======");
	System.out.println("\nPointing to the same object ? " + isEqual);
	System.out.println("Memory location for gammaCoach : " + gammaCoach);
	System.out.println("Memory location for zetaCoach : " + zetaCoach);
	
	// close the context
	context.close();
    }

}
