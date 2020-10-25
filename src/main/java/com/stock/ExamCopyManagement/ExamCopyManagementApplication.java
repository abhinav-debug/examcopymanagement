package com.stock.ExamCopyManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.stock.ExamCopyManagement.Domain.Role;
import com.stock.ExamCopyManagement.Domain.User;
import com.stock.ExamCopyManagement.Service.UserService;
import com.stock.ExamCopyManagement.Service.dbMigrationService;

@SpringBootApplication(scanBasePackages = "com.stock.ExamCopyManagement")
public class ExamCopyManagementApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	

	@PostConstruct
	void setUTCTimezone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(ExamCopyManagementApplication.class, args);

	}

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(ExamCopyManagementApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User();
		user1.setId(2);
		user1.setUserName("anay");
		user1.setPassword("anay");
		Role userRole = new Role();
		userRole.setId(2);
		userRole.setRole("ROLE_ME");
		user1.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userService.saveUser(user1);
		
		
		


System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");
System.out.println("==================================================================================");

DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
System.out.println(dateFormat.format(new Date())); // will print like 2014-02-20


	}
	/*
	 * @Value("${spring.view.prefix}") private String prefix = "";
	 * 
	 * @Value("${spring.view.suffix}") private String suffix = "";
	 * 
	 * @Value("${spring.view.view-names}") private String viewNames = "";
	 * 
	 * @Bean InternalResourceViewResolver jspViewResolver() { final
	 * InternalResourceViewResolver vr = new InternalResourceViewResolver();
	 * vr.setPrefix(prefix); vr.setSuffix(suffix); vr.setViewClass(JstlView.class);
	 * vr.setViewNames(viewNames); return vr; }
	 */

}
