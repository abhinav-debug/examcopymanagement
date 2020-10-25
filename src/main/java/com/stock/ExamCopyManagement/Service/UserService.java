package com.stock.ExamCopyManagement.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stock.ExamCopyManagement.Domain.AllotedCopies;
import com.stock.ExamCopyManagement.Domain.DetailedInfoCS;
import com.stock.ExamCopyManagement.Domain.DetailedInfoME;
import com.stock.ExamCopyManagement.Domain.Role;
import com.stock.ExamCopyManagement.Domain.SerialCopies;
import com.stock.ExamCopyManagement.Domain.StockCS;
import com.stock.ExamCopyManagement.Domain.StudentCS;
import com.stock.ExamCopyManagement.Domain.StudentME;
import com.stock.ExamCopyManagement.Domain.UFMCopies;
import com.stock.ExamCopyManagement.Domain.UnallotedCopies;
import com.stock.ExamCopyManagement.Domain.User;
import com.stock.ExamCopyManagement.Repository.AllotedCopiesRepository;
import com.stock.ExamCopyManagement.Repository.DetailedInfoRepositoryCS;
import com.stock.ExamCopyManagement.Repository.MissingCopiesRepository;
import com.stock.ExamCopyManagement.Repository.RoleRepository;
import com.stock.ExamCopyManagement.Repository.SerialCopiesRepository;
import com.stock.ExamCopyManagement.Repository.StockCSRepository;
import com.stock.ExamCopyManagement.Repository.StudentCSRepository;
import com.stock.ExamCopyManagement.Repository.StudentMERepository;
import com.stock.ExamCopyManagement.Repository.UFMCopiesRepository;
import com.stock.ExamCopyManagement.Repository.UnallotedCopiesRepository;
import com.stock.ExamCopyManagement.Repository.UserRepository;

@Component
@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private SerialCopiesRepository serialCopiesRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private StudentCSRepository studentCSRepository;
	private AllotedCopiesRepository allotedCopiesRepository;
	private UnallotedCopiesRepository unallotedCopiesRepository;
	private UFMCopiesRepository ufmCopiesRepository;
	private StockCSRepository stockCSRepository;
	private MissingCopiesRepository missingCopiesRepository;
	private DetailedInfoRepositoryCS detailedInfoRepositoryCS;
	private StudentMERepository studentMERepository;

	@PersistenceContext
	private EntityManager entityManager;

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder, SerialCopiesRepository serialCopiesRepository,
			StudentCSRepository studentCSRepository, AllotedCopiesRepository allotedCopiesRepository,
			MissingCopiesRepository missingCopiesRepository, UFMCopiesRepository ufmCopiesRepository,
			UnallotedCopiesRepository unallotedCopiesRepository, DetailedInfoRepositoryCS detailedInfoRepositoryCS,
			StockCSRepository stockCSRepository, StudentMERepository studentMERepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.serialCopiesRepository = serialCopiesRepository;
		this.studentCSRepository = studentCSRepository;
		this.allotedCopiesRepository = allotedCopiesRepository;
		this.unallotedCopiesRepository = unallotedCopiesRepository;
		this.ufmCopiesRepository = ufmCopiesRepository;
		this.missingCopiesRepository = missingCopiesRepository;
		this.detailedInfoRepositoryCS = detailedInfoRepositoryCS;
		this.stockCSRepository = stockCSRepository;
		this.studentMERepository = studentMERepository;
	}

	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User saveUser(User user) {
		User localUser = userRepository.findByUserName(user.getUserName());

		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUserName());

		} else {

			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(true);
		
			return userRepository.save(user);
		}
		return localUser;
	}

	@Transactional
	public void saveAll(Set<SerialCopies> set) {

		Session session = entityManager.unwrap(Session.class);

		for (SerialCopies sc : set) {

			session.save(sc);
		}

	}

	public List<StudentCS> findAllStudent() {

		return studentCSRepository.findAll();
	}

	public List<SerialCopies> findAllSerialNo() {
		return serialCopiesRepository.findAll();
	}

	public int getCountStudent() {

		return studentCSRepository.getCount();
	}

	@Transactional
	public void saveAllotedCopies(AllotedCopies ac) {

		allotedCopiesRepository.save(ac);
	}

	public void saveUnallotedCopies(UnallotedCopies un) {
		unallotedCopiesRepository.save(un);
	}

	public void deleteSerialCopy(int i) {

		serialCopiesRepository.deleteSerialCopy(i);
	}

	public List<UnallotedCopies> findAllUASerialNo() {

		return unallotedCopiesRepository.findAll();
	}

	public void deleteUnallotedCopy(int serialNo) {

		unallotedCopiesRepository.deleteUnallotedCopy(serialNo);
	}

	public int getCopiesCount() {

		return serialCopiesRepository.getCount();
	}

	public int getUnAllotedCopiesCount() {

		return unallotedCopiesRepository.getCount();
	}

	public int getAllotedCopiesCount() {

		return allotedCopiesRepository.getCount();
	}

	@Transactional
	public void saveUFMCopies(LinkedHashSet<UFMCopies> uf) {

		Session session = entityManager.unwrap(Session.class);
		int count = 0;
		for (UFMCopies sc : uf) {
			session.save(sc);
			count++;
			if (count % 50 == 0) { // 50, same as the JDBC batch size
				// flush a batch of inserts and release memory:
				session.flush();
				session.clear();
				count = 0;
			}
		}
		session.close();

	}

	@Transactional
	@Modifying
	public void updateAddColumn(String name, DetailedInfoCS d) {

		LocalDate date1 = LocalDate.now();

		String date = String.valueOf(date1);

		Session session = entityManager.unwrap(Session.class);

		String hqll = "SELECT count(" + date + ") FROM detailed_info_cs WHERE `" + name + "` = '" + date + "'; ";
		Query my1 = session.createSQLQuery(hqll);
		int i = my1.getFirstResult();

		if (i == 1) {

			System.out.println("=======================already in===========================");

		} else {

			String hql = "UPDATE `examcopymanagement`.`detailed_info_cs` SET `" + name + "`='" + date
					+ "' WHERE `id`='0';";
			Query my = session.createSQLQuery(hql);
			my.executeUpdate();

		}

	}

	@Transactional
	@Modifying
	public void updateAddCustomDate(String name, DetailedInfoCS d) {

		Session session = entityManager.unwrap(Session.class);

		String hqll = "SELECT count(" + d.getFoo() + ") FROM detailed_info_cs WHERE `" + name + "` = '" + d.getFoo()
				+ "'; ";
		Query my1 = session.createSQLQuery(hqll);
		int i = my1.getFirstResult();

		if (i == 1) {

			System.out.println("=======================already in===========================");

		} else {

			String hql = "UPDATE `examcopymanagement`.`detailed_info_cs` SET `" + name + "`='" + d.getFoo()
					+ "' WHERE `id`='0';";
			Query my = session.createSQLQuery(hql);
			my.executeUpdate();

			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
		}

	}

	@Modifying
	@Transactional
	public void updateAlterColumn() {

		LocalDate date1 = LocalDate.now();

		String date = String.valueOf(date1);

		Session session = entityManager.unwrap(Session.class);

		String hql = "ALTER TABLE `examcopymanagement`.`detailed_info_cs` \r\n" + "ADD COLUMN `" + date
				+ "` INT(45) NULL";
		Query my = session.createSQLQuery(hql);
		my.executeUpdate();

	}

	public void saveStock(StockCS stock) {
		// TODO Auto-generated method stub

		stockCSRepository.save(stock);

	}

	@Modifying
	@Transactional
	public void saveAllotedToDetailedInfo(String enrollementNo, String i, DetailedInfoCS d) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaUpdate<DetailedInfoCS> update = cb.createCriteriaUpdate(DetailedInfoCS.class);
		Root e = update.from(DetailedInfoCS.class);

		update.set(d.getFoo(), i);
		update.where(cb.equal(e.get("enrollmentNo"), enrollementNo));

		entityManager.createQuery(update).executeUpdate();
		

		/*
		 * d.setEnrollmentNo(enrollementNo);
		 * 
		 * 
		 * Session session = entityManager.unwrap(Session.class);
		 * 
		 * String hql = "UPDATE `examcopymanagement`.`detailed_info_cs` SET `" +
		 * d.getFoo() + "`='" + i + "' WHERE `enrollment_no`='" + enrollementNo + "';";
		 * Query my = session.createSQLQuery(hql); my.executeUpdate();
		 */

	}

	@Transactional
	@Modifying
	public void updateDate(DetailedInfoCS c) {
		c.setEnrollmentNo("ENROLLMENT NO");

		Session session = entityManager.unwrap(Session.class);
		session.clear();
		session.update(c);

	}

	@Transactional
	public void saveSeries(LinkedHashSet<SerialCopies> serialCopies) {
		Session session = entityManager.unwrap(Session.class);
		int count = 0;
		for (SerialCopies sc : serialCopies) {
			session.save(sc);
			count++;
			if (count % 50 == 0) { // 50, same as the JDBC batch size
				// flush a batch of inserts and release memory:
				session.flush();
				session.clear();
				count = 0;
			}
		}
		session.close();

	}

	@Transactional
	@Modifying
	public void updateAddColumnME(String name, DetailedInfoME d) {
		LocalDate date1 = LocalDate.now();

		String date = String.valueOf(date1);

		Session session = entityManager.unwrap(Session.class);

		String hqll = "SELECT count(" + date + ") FROM detailed_info_me WHERE `" + name + "` = '" + date + "'; ";
		Query my1 = session.createSQLQuery(hqll);
		int i = my1.getFirstResult();

		if (i == 1) {

			System.out.println("=======================already in===========================");

		} else {

			String hql = "UPDATE `examcopymanagement`.`detailed_info_me` SET `" + name + "`='" + date
					+ "' WHERE `id`='0';";
			Query my = session.createSQLQuery(hql);
			my.executeUpdate();

		}

	}

	@Transactional
	@Modifying
	public void updateAddCustomDate(String name, DetailedInfoME d) {

		Session session = entityManager.unwrap(Session.class);

		String hqll = "SELECT count(" + d.getFoo() + ") FROM detailed_info_me WHERE `" + name + "` = '" + d.getFoo()
				+ "'; ";
		Query my1 = session.createSQLQuery(hqll);
		int i = my1.getFirstResult();

		if (i == 1) {

			System.out.println("=======================already in===========================");

		} else {

			String hql = "UPDATE `examcopymanagement`.`detailed_info_me` SET `" + name + "`='" + d.getFoo()
					+ "' WHERE `id`='0';";
			Query my = session.createSQLQuery(hql);
			my.executeUpdate();

			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
			System.out.println("=======================date added===========================");
		}

	}

	@Transactional
	@Modifying
	public void updateDateME(DetailedInfoME c) {
		c.setEnrollmentNo("ENROLLMENT NO");

		Session session = entityManager.unwrap(Session.class);
		session.clear();
		session.update(c);

	}

	@Transactional
	@Modifying
	public void saveAllotedToDetailedInfo(String enrollementNo, String i, DetailedInfoME d) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaUpdate<DetailedInfoME> update = cb.createCriteriaUpdate(DetailedInfoME.class);
		Root e = update.from(DetailedInfoME.class);

		update.set(d.getFoo(), i);
		update.where(cb.equal(e.get("enrollmentNo"), enrollementNo));

		entityManager.createQuery(update).executeUpdate();
		
		/*
		 * d.setEnrollmentNo(enrollementNo);
		 * 
		 * 
		 * Session session = entityManager.unwrap(Session.class);
		 * 
		 * String hql = "UPDATE `examcopymanagement`.`detailed_info_me` SET `" +
		 * d.getFoo() + "`='" + i + "' WHERE `enrollment_no`='" + enrollementNo + "';";
		 * Query my = session.createSQLQuery(hql); my.executeUpdate();
		 */

	}

	public List<StudentME> findAllStudentME() {
		return studentMERepository.findAll();
	}

	@Transactional
	@Modifying
	public void saveUnallotedCopies(LinkedHashSet<UnallotedCopies> unall) {
		Session session = entityManager.unwrap(Session.class);
		session.clear();
		int count = 0;
		for (UnallotedCopies sc : unall) {
			session.save(sc);
			count++;
			if (count % 50 == 0) { // 50, same as the JDBC batch size
				// flush a batch of inserts and release memory:
				session.flush();
				session.clear();
				count = 0;
			}

		}

	}

	@Transactional
	public void deleteSeries(LinkedHashSet<SerialCopies> serialDelete) {

		Session session = entityManager.unwrap(Session.class);
		int count = 0;
		try {
			for (SerialCopies sc : serialDelete) {
				session.remove(session.find(SerialCopies.class, sc.getSId()));
				count++;
				if (count % 50 == 0) { // 50, same as the JDBC batch size
					// flush a batch of inserts and release memory:
					session.flush();
					session.clear();
					count = 0;
				}
			}

		} catch (Exception e) {

		}

	}

	@Transactional
	public void deleteUnallotedSeries(LinkedHashSet<UnallotedCopies> unalldelete) {
		Session session = entityManager.unwrap(Session.class);
		session.clear();

		
		int count = 0;
		try {
			for (UnallotedCopies sc : unalldelete) {
				session.remove(session.find(UnallotedCopies.class, sc.getUId()));
				count++;
				if (count % 50 == 0) { // 50, same as the JDBC batch size
					// flush a batch of inserts and release memory:
					session.flush();
					session.clear();
					count = 0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
