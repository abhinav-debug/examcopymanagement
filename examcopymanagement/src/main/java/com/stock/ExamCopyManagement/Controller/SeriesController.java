package com.stock.ExamCopyManagement.Controller;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.stock.ExamCopyManagement.Domain.DetailedInfoCS;
import com.stock.ExamCopyManagement.Domain.DetailedInfoME;
import com.stock.ExamCopyManagement.Domain.MissingCopies;
import com.stock.ExamCopyManagement.Domain.ObjectStudentSerial;
import com.stock.ExamCopyManagement.Domain.SerialCopies;
import com.stock.ExamCopyManagement.Domain.UFMCopies;
import com.stock.ExamCopyManagement.Domain.User;
import com.stock.ExamCopyManagement.Repository.AllotedCopiesRepository;
import com.stock.ExamCopyManagement.Repository.DetailedInfoRepositoryCS;
import com.stock.ExamCopyManagement.Repository.DetailedInfoRepositoryME;
import com.stock.ExamCopyManagement.Repository.MissingCopiesRepository;
import com.stock.ExamCopyManagement.Repository.SerialCopiesRepository;
import com.stock.ExamCopyManagement.Repository.StockCSRepository;
import com.stock.ExamCopyManagement.Repository.StudentCSRepository;
import com.stock.ExamCopyManagement.Repository.UFMCopiesRepository;
import com.stock.ExamCopyManagement.Repository.UnallotedCopiesRepository;
import com.stock.ExamCopyManagement.Service.UserService;

@Controller
@RequestMapping("Series")
public class SeriesController {

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

	@PersistenceContext
	private EntityManager em;

	@RequestMapping("/deleteSeries")
	public String deleteSeries() {

		serialCopiesRepository.deleteAll();

		return "redirect:/home";
	}

	@RequestMapping("/deleteUnAllotedSeries")
	public String deleteUnAllotedSeries() {

		unallotedCopiesRepository.deleteAll();

		return "redirect:/home";
	}

	@RequestMapping("/deleteAll")
	public String deleteAll() {

		serialCopiesRepository.deleteAll();

		unallotedCopiesRepository.deleteAll();

		allotedCopiesRepository.deleteAll();

		return "redirect:/home";
	}

	@PostMapping("/addSeries")
	public RedirectView addSeries(@RequestParam("seriesNo") int seriesNo, @RequestParam("copiesNo") int copiesNo,
			RedirectAttributes redir) {
		int i;
		int lastCopy;
		int count = 0;

		LinkedHashSet<SerialCopies> serialCopies = new LinkedHashSet<SerialCopies>();

		try {

			lastCopy = serialCopiesRepository.getLastValue();
		} catch (Exception e) {
			lastCopy = 0;
		}

		if (copiesNo == 0) {
			redir.addFlashAttribute("error", true);
			RedirectView redirectView = new RedirectView("/home", true);
			redirectView.setExposePathVariables(false);
			return redirectView;
		}

		try {
			System.out.println(lastCopy);
			for (i = 0; i < copiesNo; i++) {
				SerialCopies sc = new SerialCopies();
				sc.setSerialNo(seriesNo + i);
				sc.setSId(i + lastCopy + 1);
				System.out.println("adding .............." + sc + "............" + copiesNo + "..........." + seriesNo);
				serialCopies.add(sc);

			}
			userService.saveSeries(serialCopies);
			System.out.println("adding .............." + seriesNo + "............" + copiesNo);
		} catch (Exception e) {

		}
		RedirectView redirectView = new RedirectView("/home", true);
		redir.addFlashAttribute("seriesAdded", true);

		return redirectView;

	}

	@GetMapping("/addUFMCopies")
	public String addUFMPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findUserByUserName(auth.getName());
		model.addAttribute("userName", "Welcome " + user.getUserName() + " !");
		return "thymeleaf/addUFMCopies";
	}

	@PostMapping("/addUFMCopies")
	public String addUFMCopies(@RequestParam("seriesNo") int seriesNo, @RequestParam("copiesNo") int copiesNo,
			Model model) {

		int i;
		int lastCopy;

		LinkedHashSet<UFMCopies> uf = new LinkedHashSet<UFMCopies>();

		try {

			lastCopy = ufmCopiesRepository.getLastValue();
		} catch (Exception e) {
			lastCopy = 0;
		}

		if (copiesNo == 0) {
			model.addAttribute("error", true);
			return "thymeleaf/addUFMCopies";
		}

		System.out.println(lastCopy);

		for (i = 0; i < copiesNo; i++) {
			try {
				UFMCopies sc = new UFMCopies();
				sc.setSerialNo(seriesNo + i);
				sc.setUId(i + lastCopy + 1);
				System.out.println("adding .............." + sc + "............" + copiesNo + "..........." + seriesNo);
				uf.add(sc);

			} catch (Exception e) {

				model.addAttribute("error", true);
				return "redirect:/Series/addUFMCopies";

			}

		}

		userService.saveUFMCopies(uf);
		System.out.println("adding .............." + seriesNo + "............" + copiesNo);

		return "redirect:/Series/addUFMCopies?seriesadded";
	}

	@GetMapping("/addMissingCopies")
	public String addMissingPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findUserByUserName(auth.getName());

		model.addAttribute("userName", "Welcome " + user.getUserName() + " !");

		return "thymeleaf/addMissingCopies";
	}

	@PostMapping("/addMissingCopies")
	public ModelAndView addMissingCopies(@RequestParam("seriesNo") int seriesNo, @RequestParam("copiesNo") int copiesNo,
			Model model) {

		int i;
		int lastCopy;
		int x = 0;
		ModelAndView modelAndView = new ModelAndView();

		LinkedHashSet<MissingCopies> Missing = new LinkedHashSet<MissingCopies>();

		try {

			lastCopy = missingCopiesRepository.getLastValue();
		} catch (Exception e) {
			lastCopy = 0;
		}

		if (copiesNo == 0) {
			modelAndView.addObject("error", true);
			modelAndView.setViewName("thymeleaf/addMissingCopies");
			return modelAndView;
		}

		for (i = 0; i < copiesNo; i++) {

			try {
				if (String.valueOf(seriesNo + i).equals(detailedInfoRepositoryCS
						.findbySerialNofoo(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryCS
								.findbySerialNofoo1(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryCS
								.findbySerialNofoo2(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryCS
								.findbySerialNofoo3(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryCS
								.findbySerialNofoo4(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryCS
								.findbySerialNofoo5(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).contentEquals(detailedInfoRepositoryCS
								.findbySerialNofoo6(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryME
								.findbySerialNofoo(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryME
								.findbySerialNofoo1(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryME
								.findbySerialNofoo2(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryME
								.findbySerialNofoo3(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryME
								.findbySerialNofoo4(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryME
								.findbySerialNofoo5(String.valueOf(seriesNo + i)))
						|| String.valueOf(seriesNo + i).equals(detailedInfoRepositoryME
								.findbySerialNofoo6(String.valueOf(seriesNo + i)))

				) {

					x = x + 1;
					System.out.println("already in alloted copiessssssssss ");

				}
				
				else {
					
				}

			} catch (Exception e) {
				if((seriesNo + i) == serialCopiesRepository.findBySerial(seriesNo + i)){
					serialCopiesRepository.delete(serialCopiesRepository.findBySerialNo(seriesNo+i));
					modelAndView.addObject("inSeries"+true);
				}else {
				MissingCopies m = new MissingCopies();
				m.setUId(i + lastCopy + 1);
				m.setSerialNo(seriesNo + i);

				System.out.println(m);
				Missing.add(m);
				}
				
			}
			System.out.println(Missing);
			
			

		}

		try {
			System.out.println(lastCopy);
			for (MissingCopies mc : Missing) {

				missingCopiesRepository.save(mc);

			}

			System.out.println("adding .............." + seriesNo + "............" + copiesNo);
		} catch (Exception e) {

		}
		System.out.println(String.valueOf(x));

		if (x == 0) {

			modelAndView.setViewName("redirect:/Series/addMissingCopies?seriesadded");

		} else if (x == copiesNo) {

			modelAndView.setViewName("redirect:/Series/addMissingCopies?allalloted");

		} else {
			modelAndView.setViewName("redirect:/Series/addMissingCopies?missing");
		}

		return modelAndView;
	}

}
