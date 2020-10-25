package com.stock.ExamCopyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.MissingCopies;

@Repository
public interface MissingCopiesRepository extends JpaRepository<MissingCopies, Integer> {

	
	@Query(value = "select count(u_id) from missing_copies",nativeQuery = true)
	int getCount();
	
	@Query(value = "select u_id from missing_copies where u_id = (select max(u_id) from missing_copies)",nativeQuery = true)
	int getLastValue();

	@Query(value="insert into missing_copies values(?1,?2)",nativeQuery = true)
	void saveMissingCopies(int uId, int serialNo);
	
	
}
