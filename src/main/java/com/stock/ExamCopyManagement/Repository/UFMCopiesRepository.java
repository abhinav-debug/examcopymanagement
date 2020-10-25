package com.stock.ExamCopyManagement.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.UFMCopies;

@Repository
public interface UFMCopiesRepository extends JpaRepository<UFMCopies,Integer> {

	@Query(value = "select count(u_id) from ufm_copies",nativeQuery = true)
	int getCount();
	
	@Query(value = "select u_id from ufm_copies where u_id = (select max(u_id) from ufm_copies)",nativeQuery = true)
	int getLastValue();

	@Modifying
	@Transactional
	@Query(value="insert into ufm_copies values (?1,?2)",nativeQuery = true)
	void saveUFMCopies(int uId, int serialNo);

	@Transactional
	@Query(value="select * from ufm_copies where serial_no=?1",nativeQuery = true)
	UFMCopies findBySerialNo(int serialNo);
}
