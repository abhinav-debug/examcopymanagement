package com.stock.ExamCopyManagement.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.StudentCS;

@Repository
public interface StudentCSRepository extends JpaRepository<StudentCS, Integer> {

	@Query(value="SELECT COUNT(student_id) FROM student_cs;",nativeQuery = true)
	int getCount();
	
	
	@Query(value="SELECT student_id FROM student_cs WHERE student_id = (SELECT MIN(student_id)  FROM student_cs)",nativeQuery = true)
	int getInitialValue();


	@Modifying
	@Transactional
	@Query(value="insert into student_cs values(?1,?2)",nativeQuery = true)
	void saveStudent(int studentId, String enrollmentNo);
	
	
}
