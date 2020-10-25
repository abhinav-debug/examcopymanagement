package com.stock.ExamCopyManagement.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.stock.ExamCopyManagement.Domain.UnallotedCopies;

public interface UnallotedCopiesRepository extends JpaRepository<UnallotedCopies, Integer> {
	
	@Query(value="SELECT COUNT(u_id) FROM unalloted_copies;",nativeQuery = true)
	int getCount();
	
	@Transactional
	@Modifying
	@Query(value="insert into unalloted_copies select * from serial_copies;",nativeQuery = true)
	void addRowsToUnalloted();
	
	@Transactional
	@Modifying
	@Query(value="delete from unalloted_copies where serial_no=?1 and id =?2",nativeQuery = true)
	void deleteUnallotedCopy(int serialNo);

	@Transactional
	@Query(value="select * from unalloted_copies where serial_no=?1",nativeQuery = true)
	UnallotedCopies findBySerialNo(int serialCopies);

}
