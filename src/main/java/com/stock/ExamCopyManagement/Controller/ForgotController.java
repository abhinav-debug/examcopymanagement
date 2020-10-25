package com.stock.ExamCopyManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stock.ExamCopyManagement.Domain.User;
import com.stock.ExamCopyManagement.Repository.UserRepository;

@Controller
public class ForgotController {

	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping("/forgot")
	public @ResponseBody String forgot(@RequestParam(value="username",required = true) String username){
		
		User u = userRepository.findByUserName(username);
		System.out.println(u);
		String msg = "";
		
		
		
		if(u!=null) {
			msg = "true";
			
		}else {
			msg = "false";
		}
		
		return msg;
	}
}
