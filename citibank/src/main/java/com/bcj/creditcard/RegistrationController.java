package com.bcj.creditcard;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcj.creditcard.model.Customer;
import com.bcj.creditcard.model.Register;
import com.bcj.creditcard.service.RegistrationService;

/**
 * @author sridhar
 *
 */
/**
 * @author sridhar
 *
 */
/**
 * @author sridhar
 *
 */
@Controller
public class RegistrationController {

	@Autowired
	RegistrationService rs;

	public void setRegistrationService(RegistrationService rs) {
		this.rs = rs;
	}

	@RequestMapping("/")
	public String login() {
		System.out.println("customer0");
		return "index";
	}

	@RequestMapping("/registration")
	public String saveCustomer() {
		// System.out.println(customer);
		// rs.saveCustomer(customer);
		return "registration";
	}

	@RequestMapping(value = ("/activatecard"))
	public String activatecard() {

		return "activatecard";
	}


	@RequestMapping(value = ("/activateform"))
	public String activateform(@ModelAttribute Register register, ModelMap model) {
		System.out.println(register.getCreditcard());
		System.out.println(register.getCreditcard().getCardNumber());
		String message = "";
		int result = rs.activateCard(register);
		if (result == 1) {
			message = "registersucessful";
			model.addAttribute("message", message);

			return "registersucessful";
		} else if (result == 2) {

			message = "alreadyactivated";
			model.addAttribute("message", message);

			return "registersucessful";
		} else {
			message = "invalidcard";
			model.addAttribute("message", message);
			return "registersucessful";

		}

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	

	@RequestMapping(value = ("/login"), method = RequestMethod.POST)
	public String login(@ModelAttribute Register register, ModelMap model) {
		String message1 = "";
		if (rs.authenticate(register)) {
			message1 = "Invalid Username or Password";
			model.addAttribute("message1", message1);
			return "profile";
		} else {
			message1 = "Invalid Username or Password";
			model.addAttribute("message1", message1);
			return "index";
		}

	}

	@RequestMapping(value = ("/signup"), method = RequestMethod.POST)
	public ModelAndView saveCustomer1(@ModelAttribute Customer customer) {
		System.out.println(customer);
		rs.saveCustomer(customer);

		return new ModelAndView("sucess");
	}

}