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
	ICoach alphaCoach = context.getBean("myCoach", ICoach.class);

	ICoach betaCoach = context.getBean("myCoach", ICoach.class);

	// close the context
	context.close();
    }

}
