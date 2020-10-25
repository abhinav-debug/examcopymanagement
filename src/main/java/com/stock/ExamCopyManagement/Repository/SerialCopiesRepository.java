package com.stock.ExamCopyManagement.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.SerialCopies;


@Repository
public interface SerialCopiesRepository extends JpaRepository<SerialCopies, Integer> {

	@Query(value="SELECT count(s_id) from serial_copies",nativeQuery = true)
	int getCount();
 
	@Query(value="SELECT s_id FROM serial_copies where s_id =(select max(s_id) from serial_copies)",nativeQuery = true)
	int getLastValue();


	@Transactional
	@Modifying
	@Query(value="delete from serial_copies where serial_no=?1",nativeQuery = true)
	void deleteSerialCopy(int serialNo);

	@Transactional
	@Query(value="select * from serial_copies where serial_no=?1",nativeQuery = true)
	SerialCopies findBySerialNo(int serialNo);
	
	@Transactional
	@Query(value="select serial_no from serial_copies where serial_no=?1",nativeQuery = true)
	int findBySerial(int serialNo);
}

