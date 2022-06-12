/**
 * 
 */
package section11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jonathan Vinh
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView showPage() {
	System.out.println("showPage called");

	String message = "Welcome to Spring MVC!";
	
	ModelAndView mv = new ModelAndView("main-menu");
	mv.addObject("message", message);
	return mv;
    }
}