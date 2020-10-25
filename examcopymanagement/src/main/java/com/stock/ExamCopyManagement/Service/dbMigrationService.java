package com.stock.ExamCopyManagement.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class dbMigrationService {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Modifying
	public void migrateME() {
		Session session = entityManager.unwrap(Session.class);
		String hql = "use me_records";
		Query q = session.createSQLQuery(hql);
		Query my = session.createSQLQuery("CALL migrateME()");

		q.executeUpdate();
		my.executeUpdate();
		Query s = session.createSQLQuery("use examcopymanagement");

		s.executeUpdate();

		

	}
	
	@Modifying
	public void migrateCS() {
		

		Session session = entityManager.unwrap(Session.class);
		
		String hql = "use cs_records";
		Query q = session.createSQLQuery(hql);
		Query my = session.createSQLQuery("CALL migrateCS()");
		q.executeUpdate();
		my.executeUpdate();
		Query s = session.createSQLQuery("use examcopymanagement");

		s.executeUpdate();
		
	}

	public void setDefaultDB() {
		
		
		Session session = entityManager.unwrap(Session.class);
		Query s = session.createSQLQuery("use examcopymanagement");
		s.executeUpdate();

		
		
	}

	public void revertME() {
		// TODO Auto-generated method stub
		
	}

}
