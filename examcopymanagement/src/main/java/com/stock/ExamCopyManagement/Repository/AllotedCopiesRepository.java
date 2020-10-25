package com.stock.ExamCopyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.AllotedCopies;

@Repository
public interface AllotedCopiesRepository extends JpaRepository<AllotedCopies, Integer> {

	@Query(value="SELECT COUNT(u_id) FROM alloted_copies;",nativeQuery = true)
	int getCount();

	@Query(value="select serial_no from alloted_copies where serial_no = ?1",nativeQuery = true)
	int findbySerialNo(int seriaNo);
}
