package com.stock.ExamCopyManagement.Controller;

import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.stock.ExamCopyManagement.Domain.AllotedCopies;
import com.stock.ExamCopyManagement.Domain.DetailedInfoCS;
import com.stock.ExamCopyManagement.Domain.DetailedInfoME;
import com.stock.ExamCopyManagement.Domain.MissingCopies;
import com.stock.ExamCopyManagement.Domain.ObjectStudentSerial;
import com.stock.ExamCopyManagement.Domain.SerialCopies;
import com.stock.ExamCopyManagement.Domain.StockCS;
import com.stock.ExamCopyManagement.Domain.StudentCS;
import com.stock.ExamCopyManagement.Domain.StudentME;
import com.stock.ExamCopyManagement.Domain.UFMCopies;
import com.stock.ExamCopyManagement.Domain.UnallotedCopies;
import com.stock.ExamCopyManagement.Domain.User;
import com.stock.ExamCopyManagement.Repository.AllotedCopiesRepository;
import com.stock.ExamCopyManagement.Repository.DetailedInfoRepositoryCS;
import com.stock.ExamCopyManagement.Repository.DetailedInfoRepositoryME;
import com.stock.ExamCopyManagement.Repository.MissingCopiesRepository;
import com.stock.ExamCopyManagement.Repository.SerialCopiesRepository;
import com.stock.ExamCopyManagement.Repository.StockCSRepository;
import com.stock.ExamCopyManagement.Repository.StudentCSRepository;
import com.stock.ExamCopyManagement.Repository.StudentMERepository;
import com.stock.ExamCopyManagement.Repository.UFMCopiesRepository;
import com.stock.ExamCopyManagement.Repository.UnallotedCopiesRepository;
import com.stock.ExamCopyManagement.Service.UserService;
import com.stock.ExamCopyManagement.UseLess.UseLessMissing;
import com.stock.ExamCopyManagement.UseLess.UseLessModel;
import com.stock.ExamCopyManagement.UseLess.UseLessModelList;

@Controller
@RequestMapping("home")
public class InsideController {

	@Autowired
	private UserService userService;

	@Autowired
	private SerialCopiesRepository serialCopiesRepository;

	@Autowired
	private StudentCSRepository studentCSRepository;

	@Autowired
	private ObjectStudentSerial objectStudentSerial;

	@Autowired
	private AllotedCopiesRepository allotedCopiesRepository;

	@Autowired
	private UnallotedCopiesRepository unallotedCopiesRepository;

	@Autowired
	private StockCSRepository stockCSRepository;

	@Autowired
	private MissingCopiesRepository missingCopiesRepository;

	@Autowired
	private UFMCopiesRepository ufmCopiesRepository;

	@Autowired
	private DetailedInfoRepositoryCS detailedInfoRepositoryCS;

	@Autowired
	private DetailedInfoRepositoryME detailedInfoRepositoryME;

	@Autowired
	private StudentMERepository studentMERepository;

	@PostMapping("/allotCopies")
	public String allotCopiesSubmit(@ModelAttribute("useLessModelList") UseLessModelList useLessModelList, Model model,
			BindingResult bindingResult, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));

		System.out.println(useLessModelList);

		if (useLessModelList.getUseLessModels().get(0).getCheck() == null) {
			model.addAttribute("noRecordSelected", true);
			return "redirect:/home/allotCopies?noRecordSelected";
		}

		int count1=1;
		int count2;
		DetailedInfoCS d = new DetailedInfoCS();
		DetailedInfoME dme = new DetailedInfoME();

		if (hasRoleCS) {

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

			}
		} else if (hasRoleME) {

			if (detailedInfoRepositoryME.getCountFoo() == 1) {
				dme.setFoo("foo");

			} else if (detailedInfoRepositoryME.getCountFoo1() == 1) {
				dme.setFoo("foo1");

			} else if (detailedInfoRepositoryME.getCountFoo2() == 1) {
				dme.setFoo("foo2");

			} else if (detailedInfoRepositoryME.getCountFoo3() == 1) {

				dme.setFoo("foo3");
			} else if (detailedInfoRepositoryME.getCountFoo4() == 1) {
				dme.setFoo("foo4");

			} else if (detailedInfoRepositoryME.getCountFoo5() == 1) {

				dme.setFoo("foo5");
			} else if (detailedInfoRepositoryME.getCountFoo6() == 1) {
				dme.setFoo("foo6");

			}

		}

		System.out.println(
				".................................................................................................................");

		System.out.println(useLessModelList);
		System.out.println(useLessModelList.getUseLessModels().size());
		System.out.println(useLessModelList.getUseLessModels().get(4));
		System.out.println();
		System.out.println(
				".................................................................................................................");
		LinkedHashSet<SerialCopies> serialDelete = new LinkedHashSet<SerialCopies>();
		LinkedHashSet<UnallotedCopies> unalldelete = new LinkedHashSet<UnallotedCopies>();
		LinkedHashSet<UnallotedCopies> unalladd = new LinkedHashSet<UnallotedCopies>();


		for (UseLessModel um : useLessModelList.getUseLessModels()) {

			try {
				count2 = unallotedCopiesRepository.getCount();
			} catch (Exception e) {
				count2 = 0;
			}

			

			if (um.getCheck() == true) {

				if (um.getAbsentPresent() == true) {
					System.out.println("Preseeeeeeeeeeeeeeeeeeeent");

					try {
						UFMCopies uac = ufmCopiesRepository.findBySerialNo(um.getSerialNo());
						ufmCopiesRepository.delete(uac);

					} catch (Exception e) {
						serialDelete.add(serialCopiesRepository.findBySerialNo(um.getSerialNo()));
					}

					try {
						unalldelete.add(unallotedCopiesRepository.findBySerialNo(um.getSerialNo()));
					} catch (Exception e) {
						serialDelete.add(serialCopiesRepository.findBySerialNo(um.getSerialNo()));

					}

					if (hasRoleCS) {

						userService.saveAllotedToDetailedInfo(um.getEnrollementNo(), String.valueOf(um.getSerialNo()),
								d);
					} else if (hasRoleME) {
						userService.saveAllotedToDetailedInfo(um.getEnrollementNo(), String.valueOf(um.getSerialNo()),
								dme);

					}

				} else {

					if (unallotedCopiesRepository.findBySerialNo(um.getSerialNo()) != null) {
						System.out.println("INN UNALLOTED COPIES");
						System.out.println(unallotedCopiesRepository.findBySerialNo(um.getSerialNo()));
						
						UnallotedCopies un = new UnallotedCopies();
						
						System.out.println("abseeeeeeeeeeeeeeeeeeeeeeeeent");
						System.out.println(um.getEnrollementNo());
						System.out.println(um.getSerialNo());

						un.setUId(count1);
						un.setSerialNo(um.getSerialNo());
						System.out.println(un);
						unalldelete.add(unallotedCopiesRepository.findBySerialNo(um.getSerialNo()));
						
						unalladd.add(un);
						count1++;
						
						
					}else {
						UnallotedCopies un = new UnallotedCopies();
						
						System.out.println("abseeeeeeeeeeeeeeeeeeeeeeeeent");
						System.out.println(um.getEnrollementNo());
						System.out.println(um.getSerialNo());

						un.setUId(count1);
						un.setSerialNo(um.getSerialNo());
						System.out.println(un);
						unalladd.add(un);
						
						serialDelete.add(serialCopiesRepository.findBySerialNo(um.getSerialNo()));

						count1++;
						
					}

					if (count2 == 0) {
						count2 = 0;
					} else if (count2 == 180) {
						count2 = count2 - 180;
					}
					
					


					if (hasRoleCS) {

						userService.saveAllotedToDetailedInfo(um.getEnrollementNo(), "ABSENT", d);
					} else if (hasRoleME) {
						userService.saveAllotedToDetailedInfo(um.getEnrollementNo(), "ABSENT", dme);

					}

				}

			}

			else {
				return "redirect:/home/allotCopies";
			}
		}
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);
		System.out.println(serialDelete);

		userService.deleteUnallotedSeries(unalldelete);
		userService.saveUnallotedCopies(unalladd);
		userService.deleteSeries(serialDelete);

		return "redirect:/home";
	}

	@GetMapping("/allotCopies")
	public String allotCopies(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));

		int reallocateCopies = unallotedCopiesRepository.getCount();
		System.out.println(
				"............................................................................+" + reallocateCopies);

		if (reallocateCopies > 0) {

			model.addAttribute("CopiesUnalloted", true);
		}

		int i;

		User user = userService.findUserByUserName(auth.getName());

		LinkedHashSet<ObjectStudentSerial> objectStudentSerials = new LinkedHashSet<ObjectStudentSerial>();
		LinkedHashSet<ObjectStudentSerial> one = new LinkedHashSet<ObjectStudentSerial>();
		LinkedHashSet<ObjectStudentSerial> two = new LinkedHashSet<ObjectStudentSerial>();
		LinkedHashSet<ObjectStudentSerial> three = new LinkedHashSet<ObjectStudentSerial>();

		if (hasRoleCS) {
			int count = studentCSRepository.getCount();

			System.out.println(userService.findAllStudent());
			System.out.println(userService.findAllSerialNo());

			List<StudentCS> scs = userService.findAllStudent();

			List<SerialCopies> sc = userService.findAllSerialNo();

			if (scs.size() <= sc.size()) {

				int start = studentCSRepository.getInitialValue();

				System.out.println("........................" + start + "............................" + count);

				System.out.println(scs.get(1).getEnrollmentNo());
				System.out.println(sc.get(1).getSerialNo());

				for (i = 0; i < 60; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					one.add(oss);

				}
				for (i = 60; i < 120; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					two.add(oss);

				}
				for (i = 120; i < 180; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					three.add(oss);

				}

				System.out.println(objectStudentSerials);

			} else {

				model.addAttribute("NoRecord", true);
			}
			System.out.println(one.size() + "    " + two.size() + "      " + three.size());
			System.out.println(three.size() + one.size() + two.size());
			model.addAttribute("useLessModelList", new UseLessModelList());
			model.addAttribute("objectStudentSerials", objectStudentSerials);
			model.addAttribute("three", three);
			model.addAttribute("one", one);
			model.addAttribute("two", two);

		} else if (hasRoleME) {

			int count = studentMERepository.getCount();

			System.out.println(userService.findAllStudentME());
			System.out.println(userService.findAllSerialNo());

			List<StudentME> scs = userService.findAllStudentME();

			List<SerialCopies> sc = userService.findAllSerialNo();

			if (scs.size() <= sc.size()) {

				int start = studentMERepository.getInitialValue();

				System.out.println("........................" + start + "............................" + count);

				System.out.println(scs.get(1).getEnrollmentNo());
				System.out.println(sc.get(1).getSerialNo());

				for (i = 0; i < (count / 3); i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					one.add(oss);

				}
				for (i = (count / 3); i < ((count / 3) + (count / 3)); i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					two.add(oss);

				}
				for (i = ((count / 3) + (count / 3)); i < count; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					three.add(oss);

				}

				System.out.println(objectStudentSerials);

			} else {

				model.addAttribute("NoRecord", true);
			}
			System.out.println(one.size() + "    " + two.size() + "      " + three.size());
			System.out.println(three.size() + one.size() + two.size());
			model.addAttribute("useLessModelList", new UseLessModelList());
			model.addAttribute("objectStudentSerials", objectStudentSerials);
			model.addAttribute("three", three);
			model.addAttribute("one", one);
			model.addAttribute("two", two);

		}
		model.addAttribute("userName", "Welcome " + user.getUserName() + " !");

		return "thymeleaf/allotCopies";
	}

	@RequestMapping("/reAllotCopies")
	public String reallotCopies(Model model) {

		int i;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));

		LinkedHashSet<ObjectStudentSerial> objectStudentSerials = new LinkedHashSet<ObjectStudentSerial>();
		LinkedHashSet<ObjectStudentSerial> one = new LinkedHashSet<ObjectStudentSerial>();
		LinkedHashSet<ObjectStudentSerial> two = new LinkedHashSet<ObjectStudentSerial>();
		LinkedHashSet<ObjectStudentSerial> three = new LinkedHashSet<ObjectStudentSerial>();
		LinkedHashSet<UnallotedCopies> unall = new LinkedHashSet<UnallotedCopies>();
		LinkedHashSet<SerialCopies> s = new LinkedHashSet<SerialCopies>();
		if (hasRoleCS) {
			int count = studentCSRepository.getCount();
			int count1 = unallotedCopiesRepository.getCount();

			if (count1 == 0) {

				model.addAttribute("NoRecord", true);
				return "thymeleaf/allotCopies";
			} else {

				List<SerialCopies> ser = userService.findAllSerialNo();
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(count1);
				System.out.println(count);
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(".............................................................");

				if ((count > count1)) {

					for (i = 1; i < (count - count1 + 1); i++) {
						UnallotedCopies unallotedCopies = new UnallotedCopies();

						unallotedCopies.setUId(i + count1);
						unallotedCopies.setSerialNo(ser.get(i - 1).getSerialNo());

						System.out.println(unallotedCopies);
						unall.add(unallotedCopies);
						s.add(serialCopiesRepository.findBySerialNo(unallotedCopies.getSerialNo()));

					}

					userService.saveUnallotedCopies(unall);
					userService.deleteSeries(s);
					System.out.println(userService.findAllStudent());
					System.out.println(userService.findAllUASerialNo());
				}

			}

			List<StudentCS> scs = userService.findAllStudent();

			List<UnallotedCopies> sc = userService.findAllUASerialNo();

			if (scs.size() <= sc.size()) {

				int start = studentCSRepository.getInitialValue();

				System.out.println("........................" + start + "............................" + count);

				System.out.println(scs.get(1).getEnrollmentNo());
				System.out.println(sc.get(1).getSerialNo());

				for (i = 0; i < 60; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					one.add(oss);

				}
				for (i = 60; i < 120; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					two.add(oss);

				}
				for (i = 120; i < 180; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					three.add(oss);

				}

				System.out.println(objectStudentSerials);

			} else {

				model.addAttribute("NoRecord", true);

			}
			System.out.println(one.size() + "    " + two.size() + "      " + three.size());
			System.out.println(three.size() + one.size() + two.size());
			model.addAttribute("useLessModelList", new UseLessModelList());
			model.addAttribute("objectStudentSerials", objectStudentSerials);
			model.addAttribute("three", three);
			model.addAttribute("one", one);
			model.addAttribute("two", two);

		} else if (hasRoleME) {
			int count = studentMERepository.getCount();
			int count1 = unallotedCopiesRepository.getCount();

			if (count1 == 0) {

				model.addAttribute("NoRecord", true);
				return "thymeleaf/allotCopies";
			} else {

				List<SerialCopies> ser = userService.findAllSerialNo();
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(count1);
				System.out.println(count);
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(".............................................................");
				System.out.println(".............................................................");

				if ((count > count1)) {

					for (i = 1; i < (count - count1 + 1); i++) {
						UnallotedCopies unallotedCopies = new UnallotedCopies();

						unallotedCopies.setUId(i + count1);
						unallotedCopies.setSerialNo(ser.get(i - 1).getSerialNo());

						System.out.println(unallotedCopies);
						unall.add(unallotedCopies);
						s.add(serialCopiesRepository.findBySerialNo(unallotedCopies.getSerialNo()));

					}

					userService.saveUnallotedCopies(unall);
					userService.deleteSeries(s);
					System.out.println(userService.findAllStudent());
					System.out.println(userService.findAllUASerialNo());
				}

			}

			List<StudentME> scs = userService.findAllStudentME();

			List<UnallotedCopies> sc = userService.findAllUASerialNo();

			if (scs.size() <= sc.size()) {

				int start = studentMERepository.getInitialValue();

				System.out.println("........................" + start + "............................" + count);

				System.out.println(scs.get(1).getEnrollmentNo());
				System.out.println(sc.get(1).getSerialNo());
				for (i = 0; i < (count / 3); i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					one.add(oss);

				}
				for (i = (count / 3); i < ((count / 3) + (count / 3)); i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					two.add(oss);

				}
				for (i = ((count / 3) + (count / 3)); i < count; i++) {
					ObjectStudentSerial oss = new ObjectStudentSerial();
					oss.setEnrollementNo(scs.get(i).getEnrollmentNo());
					oss.setSerialCopies(sc.get(i).getSerialNo());

					three.add(oss);

				}
			} else {

				model.addAttribute("NoRecord", true);

			}

			System.out.println(one.size() + "    " + two.size() + "      " + three.size());
			System.out.println(three.size() + one.size() + two.size());
			model.addAttribute("useLessModelList", new UseLessModelList());
			model.addAttribute("objectStudentSerials", objectStudentSerials);
			model.addAttribute("three", three);
			model.addAttribute("one", one);
			model.addAttribute("two", two);

		}

		model.addAttribute("userName", "Welcome " + user.getUserName() + " !");

		return "thymeleaf/allotCopies";
	}

	@RequestMapping("/showInfo")
	public String info(Model model) {

		List<StockCS> st = stockCSRepository.findAll();

		System.out.println(st);

		model.addAttribute("status", st);

		return "thymeleaf/statusInfo";

	}

	@RequestMapping("/saveExamDate")
	public String addExamDate(@RequestParam("date") String date) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));

		if (hasRoleCS) {

			DetailedInfoCS d = new DetailedInfoCS();
			d.setFoo(date);
			String name = null;

			if (detailedInfoRepositoryCS.getCountFoo() == 0) {
				name = "foo";

			} else if (detailedInfoRepositoryCS.getCountFoo1() == 0) {
				name = "foo1";

			} else if (detailedInfoRepositoryCS.getCountFoo2() == 0) {
				name = "foo2";

			} else if (detailedInfoRepositoryCS.getCountFoo3() == 0) {

				name = "foo3";
			} else if (detailedInfoRepositoryCS.getCountFoo4() == 0) {
				name = "foo4";

			} else if (detailedInfoRepositoryCS.getCountFoo5() == 0) {

				name = "foo5";
			} else if (detailedInfoRepositoryCS.getCountFoo6() == 0) {
				name = "foo6";

			}
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("======================= ===========================" + name + d.getFoo());
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");

			userService.updateAddCustomDate(name, d);
		} else if (hasRoleME) {

			DetailedInfoME d = new DetailedInfoME();
			d.setFoo(date);
			String name = null;

			if (detailedInfoRepositoryME.getCountFoo() == 0) {
				name = "foo";

			} else if (detailedInfoRepositoryME.getCountFoo1() == 0) {
				name = "foo1";

			} else if (detailedInfoRepositoryME.getCountFoo2() == 0) {
				name = "foo2";

			} else if (detailedInfoRepositoryME.getCountFoo3() == 0) {

				name = "foo3";
			} else if (detailedInfoRepositoryME.getCountFoo4() == 0) {
				name = "foo4";

			} else if (detailedInfoRepositoryME.getCountFoo5() == 0) {

				name = "foo5";
			} else if (detailedInfoRepositoryME.getCountFoo6() == 0) {
				name = "foo6";

			}
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("======================= ===========================" + name + d.getFoo());
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");

			userService.updateAddCustomDate(name, d);
		}

		return "redirect:/home";

	}

	@GetMapping("/detailedInfo")
	public String detailedInfo(Model model) {

		int count;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));

		if (hasRoleCS) {

			count = detailedInfoRepositoryCS.getCount();
			List<DetailedInfoCS> detailedInfoCSs = detailedInfoRepositoryCS.findAll();

			DetailedInfoCS date = detailedInfoCSs.get(0);

			LinkedHashSet<DetailedInfoCS> d = new LinkedHashSet<DetailedInfoCS>();

			for (int i = 1; i < count; i++) {

				DetailedInfoCS c = detailedInfoCSs.get(i);
				d.add(c);
				System.out.println(c);

			}
			model.addAttribute("detailed", d);
			model.addAttribute("date", date);
		} else if (hasRoleME) {
			count = detailedInfoRepositoryME.getCount();
			List<DetailedInfoME> detailedInfoCSs = detailedInfoRepositoryME.findAll();

			DetailedInfoME date = detailedInfoCSs.get(0);

			LinkedHashSet<DetailedInfoME> d = new LinkedHashSet<DetailedInfoME>();

			for (int i = 1; i < count; i++) {

				DetailedInfoME c = detailedInfoCSs.get(i);
				d.add(c);
				System.out.println(c);

			}
			model.addAttribute("detailed", d);
			model.addAttribute("date", date);
		}

		return "thymeleaf/detailedInfo";
	}

	@PostMapping("/updateDate")
	public String updateDate(@RequestParam(value = "foo", required = false) String foo,
			@RequestParam(value = "foo1", required = false) String foo1,
			@RequestParam(value = "foo2", required = false) String foo2,
			@RequestParam(value = "foo3", required = false) String foo3,
			@RequestParam(value = "foo4", required = false) String foo4,
			@RequestParam(value = "foo5", required = false) String foo5,
			@RequestParam(value = "foo6", required = false) String foo6, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));

		if (hasRoleCS) {

			int count = detailedInfoRepositoryCS.getCount();
			List<DetailedInfoCS> detailedInfoCSs = detailedInfoRepositoryCS.findAll();

			DetailedInfoCS date = detailedInfoCSs.get(0);

			LinkedHashSet<DetailedInfoCS> d = new LinkedHashSet<DetailedInfoCS>();
			for (int i = 1; i < count; i++) {

				DetailedInfoCS c = detailedInfoCSs.get(i);
				d.add(c);
				System.out.println(c);

			}

			model.addAttribute("detailed", d);
			model.addAttribute("date", date);

			DetailedInfoCS c = new DetailedInfoCS();

			if (foo != null) {
				c.setFoo(foo);
			} else {
				c.setFoo(null);
			}
			if (foo1 != null) {
				c.setFoo1(foo1);
			} else {
				c.setFoo1(null);
			}
			if (foo2 != null) {
				c.setFoo2(foo2);
			}
			if (foo3 != null) {
				c.setFoo3(foo3);
			} else {
				c.setFoo3(null);
			}
			if (foo4 != null) {
				c.setFoo4(foo4);
			} else {
				c.setFoo4(null);

			}
			if (foo5 != null) {
				c.setFoo5(foo5);
			} else {
				c.setFoo5(null);

			}
			if (foo6 != null) {
				c.setFoo6(foo6);
			} else {
				c.setFoo6(null);
			}

			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("                UPDATE DATE             ");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");

			userService.updateDate(c);

		} else if (hasRoleME) {

			int count = detailedInfoRepositoryME.getCount();
			List<DetailedInfoME> detailedInfoCSs = detailedInfoRepositoryME.findAll();

			DetailedInfoME date = detailedInfoCSs.get(0);

			LinkedHashSet<DetailedInfoME> d = new LinkedHashSet<DetailedInfoME>();
			for (int i = 1; i < count; i++) {

				DetailedInfoME c = detailedInfoCSs.get(i);
				d.add(c);
				System.out.println(c);

			}

			model.addAttribute("detailed", d);
			model.addAttribute("date", date);

			DetailedInfoME c = new DetailedInfoME();

			if (foo != null) {
				c.setFoo(foo);
			} else {
				c.setFoo(null);
			}
			if (foo1 != null) {
				c.setFoo1(foo1);
			} else {
				c.setFoo1(null);
			}
			if (foo2 != null) {
				c.setFoo2(foo2);
			}
			if (foo3 != null) {
				c.setFoo3(foo3);
			} else {
				c.setFoo3(null);
			}
			if (foo4 != null) {
				c.setFoo4(foo4);
			} else {
				c.setFoo4(null);

			}
			if (foo5 != null) {
				c.setFoo5(foo5);
			} else {
				c.setFoo5(null);

			}
			if (foo6 != null) {
				c.setFoo6(foo6);
			} else {
				c.setFoo6(null);
			}

			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("                UPDATE DATE             ");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");
			System.out.println("====================================================================================");

			userService.updateDateME(c);

		}

		return "redirect:/home/detailedInfo";
	}

	@RequestMapping("/missingUFMCopies")
	public String missingUFMCopiesDetail(Model model) {

		LinkedHashSet<UseLessMissing> m = new LinkedHashSet<UseLessMissing>();
		int count;
		int count1;
		try {
			count = missingCopiesRepository.getCount();
		} catch (Exception e) {
			count = 0;
		}
		try {
			count1 = ufmCopiesRepository.getCount();
		} catch (Exception e) {
			count1 = 0;
		}

		List<MissingCopies> missing = missingCopiesRepository.findAll();
		List<UFMCopies> u = ufmCopiesRepository.findAll();

		if (count > count1 || count == count1) {

			for (int i = 1; i <= count - 1; i++) {
				UseLessMissing use = new UseLessMissing();
				try {
					use.setMissing(missing.get(i).getSerialNo());
				} catch (Exception e) {
					use.setMissing(0);
				}

				try {
					use.setUfm(u.get(i).getSerialNo());
				} catch (Exception e) {
					use.setUfm(0);
				}
				m.add(use);
			}
		} else {
			for (int i = 0; i < count1 - 1; i++) {
				UseLessMissing use = new UseLessMissing();
				try {
					use.setMissing(missing.get(i).getSerialNo());
				} catch (Exception e) {
					use.setMissing(0);
				}

				try {
					use.setUfm(u.get(i).getSerialNo());
				} catch (Exception e) {
					use.setUfm(0);
				}
				m.add(use);
			}
		}

		model.addAttribute("m", m);

		return "thymeleaf/missingUFMCopies";
	}

	@RequestMapping("/columnFilled")
	public RedirectView columnFilled(RedirectAttributes redir) {

		RedirectView r = new RedirectView("/home", true);
		r.setExposeModelAttributes(false);

		redir.addFlashAttribute("columnFilled", true);

		return r;
	}

}
