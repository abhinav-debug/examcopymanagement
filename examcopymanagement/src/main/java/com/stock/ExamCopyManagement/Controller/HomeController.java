package com.stock.ExamCopyManagement.Controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stock.ExamCopyManagement.Domain.Role;
import com.stock.ExamCopyManagement.Domain.User;
import com.stock.ExamCopyManagement.Service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/", "/loginPage" })
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("thymeleaf/login");
		return modelAndView;
	}

	@GetMapping("/home")
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView();

		int count;
		int count1;
		try {
			count = userService.getCopiesCount();

		} catch (Exception e) {
			count = 0;
		}
		try {
			count1 = userService.getUnAllotedCopiesCount();

		} catch (Exception e) {
			count1 = 0;
		}

		System.out.println("................................" + count + "" + count1);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		User user = userService.findUserByUserName(auth.getName());

		if (hasRoleCS) {

			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("ROLE_CS");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
		}

		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " !");
		modelAndView.addObject("copiesLeft", "Serial Copies In Database : " + count);
		modelAndView.addObject("copiesNotAlloted", "Copies Not Yet Alloted : " + count1);
		modelAndView.setViewName("thymeleaf/home");
		return modelAndView;

	}

	@GetMapping("/in")
	public String in() {
		return "jsp/index";
	}

}
