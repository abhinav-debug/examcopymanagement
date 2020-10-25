package com.stock.ExamCopyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.StudentME;

@Repository
public interface StudentMERepository extends JpaRepository<StudentME,Integer> {
	
	@Query(value="SELECT COUNT(student_id) FROM student_me;",nativeQuery = true)
	int getCount();
	
	
	@Query(value="SELECT student_id FROM student_me WHERE student_id = (SELECT MIN(student_id)  FROM student_me)",nativeQuery = true)
	int getInitialValue();

}
