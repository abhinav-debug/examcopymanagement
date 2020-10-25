package com.stock.ExamCopyManagement.AOP;

import java.time.LocalDate;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.ExamCopyManagement.Domain.StockCS;
import com.stock.ExamCopyManagement.Repository.AllotedCopiesRepository;
import com.stock.ExamCopyManagement.Repository.MissingCopiesRepository;
import com.stock.ExamCopyManagement.Repository.SerialCopiesRepository;
import com.stock.ExamCopyManagement.Repository.StockCSRepository;
import com.stock.ExamCopyManagement.Repository.StudentCSRepository;
import com.stock.ExamCopyManagement.Repository.UFMCopiesRepository;
import com.stock.ExamCopyManagement.Repository.UnallotedCopiesRepository;
import com.stock.ExamCopyManagement.Service.UserService;

@Aspect
@Component
public class BeforeStatusInfo {

	@Autowired
	private SerialCopiesRepository serialCopiesRepository;

	@Autowired
	private MissingCopiesRepository missingCopiesRepository;

	@Autowired
	private UFMCopiesRepository ufmCopiesRepository;

	@Autowired
	private StockCSRepository stockCSRepository;

	@Autowired
	private AllotedCopiesRepository allotedCopiesRepository;

	@Autowired
	private UnallotedCopiesRepository unallotedCopiesRepository;

	@Autowired
	private UserService userService;

	@Before("execution(* com.stock.ExamCopyManagement.Controller.InsideController.reallotCopies(..))")
	public void beforeinfo() {

		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("I   N   T   E   R  C   P   T   E   R");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");

		int scsCount = 0;

		int missingCount = 0;

		int ufmCount = 0;

		int allotedCount = 0;

		int unallotedCount = 0;

		int serialCount = 0;

		LocalDate date = LocalDate.now();

		try {
			String x = String.valueOf(serialCopiesRepository.getCount());
			String y = String.valueOf(missingCopiesRepository.getCount());
			String z = String.valueOf(stockCSRepository.getLastCount());
			String p = String.valueOf(ufmCopiesRepository.getCount());
			String q = String.valueOf(allotedCopiesRepository.getCount());
			String r = String.valueOf(unallotedCopiesRepository.getCount());

			if (x == null) {
				serialCount = 0;
			} else {
				serialCount = serialCopiesRepository.getCount();
			}
			if (y == null) {
				missingCount = 0;
			} else {
				missingCount = missingCopiesRepository.getCount();
			}
			if (z == null) {
				scsCount = 0;
			} else {
				scsCount = stockCSRepository.getLastCount();
			}
			if (p == null) {
				ufmCount = 0;
			} else {
				ufmCount = ufmCopiesRepository.getCount();
			}
			if (q == null) {
				allotedCount = 0;
			} else {
				allotedCount = allotedCopiesRepository.getCount();
			}
			if (r == null) {
				unallotedCount = 0;
			} else {
				unallotedCount = unallotedCopiesRepository.getCount();
			}

		} catch (Exception e) {

		}

		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("I   N   T   E   R  C   P   T   E   R");
		System.out.println();
		System.out.println(scsCount + "  " + missingCount + "  " + ufmCount + "  " + allotedCount + "   "
				+ unallotedCount + "  " + serialCount + "  " + date);
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");

		System.out.println(serialCount);

		StockCS stock = new StockCS();

		stock.setDatetime(date);
		stock.setId(scsCount + 1);
		stock.setTotalAlloted(allotedCount);
		stock.setTotalMissing(missingCount);
		stock.setTotalUnAlloted(unallotedCount);
		stock.setTotalUFM(ufmCount);
		stock.setTotalSerialCopies(serialCount);
		userService.saveStock(stock);
		System.out.println(stock);

	}

}
