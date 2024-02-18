package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;

	@ModelAttribute
	public void commanDataForModel(Model model) {
		model.addAttribute("Header", "Learn with Joy");
		model.addAttribute("Desc", "Home For Programmers");
		System.out.println("Adding common data to model");

	}

	@RequestMapping("/contact")
	public String showForm(Model model) {

		return "contact";
	}

//	old way
//	@RequestMapping(path = "/processForm",method = RequestMethod.POST)
//	public String handleForm(HttpServletRequest request) {
//		String email = request.getParameter("email");
//		System.out.println(email);
//		return "";

//	}

	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user, Model model) {
		System.out.println(user);
		// process
		
		if(user.getUserName().isBlank()) {
			return "redirect:/contact";
		}
		
		int creadedUser = this.userService.createUser(user);
		model.addAttribute("msg", "User created with ID: " + creadedUser);
		
//		model.addAttribute("user", user);
		return "success";
	}

}

/*
 * @RequestMapping(path = "/processForm", method = RequestMethod.POST) public
 * String handleForm( //default -> true
 * 
 * @RequestParam(name = "email",required = false) String userEmail,
 * 
 * @RequestParam("userName") String userName,
 * 
 * @RequestParam("password") String userPassword,Model model) {
 * 
 * // System.out.println(userEmail); // System.out.println(userName); //
 * System.out.println(userPassword);
 * 
 * User user = new User();
 * 
 *  user.setEmail(userEmail); 
 *  user.setUserName(userName);
 *  user.setPassword(userPassword);
 * 
 * // process
 * 
 * // model.addAttribute("name", userName); 
 * // model.addAttribute("email",userEmail);
 * // model.addAttribute("password", userPassword);
 * 
 *  model.addAttribute("user", user);
 * 
 * System.out.println(user);
 * 
 * return "success"; 
 * }
 */
