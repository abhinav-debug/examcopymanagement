package com.stock.ExamCopyManagement.AOP;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.stock.ExamCopyManagement.Domain.AllotedCopies;
import com.stock.ExamCopyManagement.Domain.DetailedInfoCS;
import com.stock.ExamCopyManagement.Domain.DetailedInfoME;
import com.stock.ExamCopyManagement.Repository.AllotedCopiesRepository;
import com.stock.ExamCopyManagement.Repository.DetailedInfoRepositoryCS;
import com.stock.ExamCopyManagement.Repository.DetailedInfoRepositoryME;
import com.stock.ExamCopyManagement.Repository.StudentCSRepository;
import com.stock.ExamCopyManagement.Repository.UnallotedCopiesRepository;
import com.stock.ExamCopyManagement.Service.UserService;

@Component
@Aspect
public class BeforeAllotCopies {

	@Autowired
	private UnallotedCopiesRepository unallotedCopiesRepository;

	@Autowired
	private StudentCSRepository studentCSRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AllotedCopiesRepository allotedCopiesRepository;

	@Autowired
	private DetailedInfoRepositoryCS detailedInfoRepositoryCS;
	
	@Autowired
	private DetailedInfoRepositoryME detailedInfoRepositoryME;

	@Before("execution(* com.stock.ExamCopyManagement.Controller.InsideController.allotCopies(..))")
	public int BeforeAllotement() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));
		
		System.out.println(hasRoleCS + "       "+ hasRoleME);
		
		if(hasRoleCS) {
		if(detailedInfoRepositoryCS.getCountFoo6() > 1) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getResponse();

			RequestDispatcher rd = request.getRequestDispatcher("/home/columnFilled");
			try {
				System.out.println("==========================");
				rd.forward(request, response);
				System.out.println("==========================");
				return 0;

			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
			
		}
		}else if(hasRoleME) {
		
		if(detailedInfoRepositoryME.getCountFoo6() > 1) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getResponse();

			RequestDispatcher rd = request.getRequestDispatcher("/home/columnFilled");
			try {
				rd.forward(request, response);
				return 0;
			
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
			
		}}

		System.out.println(".....................................................");
		System.out.println(".....................................................");
		System.out.println(".....................................................");
		System.out.println(unallotedCopiesRepository.getCount());
		System.out.println(".....................................................");
		System.out.println(".....................................................");
		System.out.println(".....................................................");

		int countUn;

		try {
			countUn = unallotedCopiesRepository.getCount();
		} catch (Exception e) {
			countUn = 0;
		}

		if (countUn > 0) {
			System.out.println("==========================");


			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getRequest();
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getResponse();

			RequestDispatcher rd = request.getRequestDispatcher("/home/reAllotCopies");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Before("execution(* com.stock.ExamCopyManagement.Controller.InsideController.allotCopies(..))")
	public void AddColumnAllotCopies() {

		LocalDate date1 = LocalDate.now();

		String date = String.valueOf(date1);
		String name = null;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));
		
		if(hasRoleCS) {

			
			
		DetailedInfoCS d = new DetailedInfoCS();
		d.setId(0);
		if (detailedInfoRepositoryCS.getCountFoo() == 0) {
			name="foo";

		} else if (detailedInfoRepositoryCS.getCountFoo1() == 0) {
			name="foo1";

		} else if (detailedInfoRepositoryCS.getCountFoo2() == 0) {
			name="foo2";

		} else if (detailedInfoRepositoryCS.getCountFoo3() == 0) {

			name="foo3";
		} else if (detailedInfoRepositoryCS.getCountFoo4() == 0) {
			name="foo4";

		} else if (detailedInfoRepositoryCS.getCountFoo5() == 0) {

			name="foo5";
		} else if (detailedInfoRepositoryCS.getCountFoo6() == 0) {
			name="foo6";
		}

		System.out.println(
				"============================================================================================date");
		System.out.println(
				"============================================================================================date");
		System.out.println(
				"============================================================================================date");
		System.out.println(
				"============================================================================================date");
		if (detailedInfoRepositoryCS.getCountFoo() == 1) {
			d.setFoo("foo");

		} else if (detailedInfoRepositoryCS.getCountFoo1() == 1) {
			d.setFoo("foo1");

		} else if (detailedInfoRepositoryCS.getCountFoo2() == 1) {
			d.setFoo("foo2");

		} else if (detailedInfoRepositoryCS.getCountFoo3() == 1) {

			d.setFoo("foo3");
		} else if (detailedInfoRepositoryCS.getCountFoo4() == 1) {
			d.setFoo("foo4");

		} else if (detailedInfoRepositoryCS.getCountFoo5() == 1) {

			d.setFoo("foo5");
		} else if (detailedInfoRepositoryCS.getCountFoo6() == 1) {
			d.setFoo("foo6");

		}else {
			userService.updateAddColumn(name, d);
		}

		}else if(hasRoleME) {
			
			
			
			DetailedInfoME d = new DetailedInfoME();
			d.setId(0);
			if (detailedInfoRepositoryME.getCountFoo() == 0) {
				name="foo";

			} else if (detailedInfoRepositoryME.getCountFoo1() == 0) {
				name="foo1";

			} else if (detailedInfoRepositoryME.getCountFoo2() == 0) {
				name="foo2";

			} else if (detailedInfoRepositoryME.getCountFoo3() == 0) {

				name="foo3";
			} else if (detailedInfoRepositoryME.getCountFoo4() == 0) {
				name="foo4";

			} else if (detailedInfoRepositoryME.getCountFoo5() == 0) {

				name="foo5";
			} else if (detailedInfoRepositoryME.getCountFoo6() == 0) {
				name="foo6";
			}

			if (detailedInfoRepositoryME.getCountFoo() == 1) {
				d.setFoo("foo");

			} else if (detailedInfoRepositoryME.getCountFoo1() == 1) {
				d.setFoo("foo1");

			} else if (detailedInfoRepositoryME.getCountFoo2() == 1) {
				d.setFoo("foo2");

			} else if (detailedInfoRepositoryME.getCountFoo3() == 1) {

				d.setFoo("foo3");
			} else if (detailedInfoRepositoryME.getCountFoo4() == 1) {
				d.setFoo("foo4");

			} else if (detailedInfoRepositoryME.getCountFoo5() == 1) {

				d.setFoo("foo5");
			} else if (detailedInfoRepositoryME.getCountFoo6() == 1) {
				d.setFoo("foo6");

			}else {
				userService.updateAddColumnME(name, d);
			}
		}

		
		

	}
	
	
	@After("execution(* com.stock.ExamCopyManagement.Controller.InsideController.allotCopies(..))")
	public void addCopiesToDetailedInfo() {
		
		List<AllotedCopies> allotedCopies = allotedCopiesRepository.findAll();
		
		
		
	}

}
