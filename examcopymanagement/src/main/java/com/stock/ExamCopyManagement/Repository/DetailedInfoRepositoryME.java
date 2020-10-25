package com.stock.ExamCopyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.DetailedInfoCS;
import com.stock.ExamCopyManagement.Domain.DetailedInfoME;

@Repository
public interface DetailedInfoRepositoryME extends JpaRepository<DetailedInfoME,Integer> {
	
	@Query(value = "select count(id) from detailed_info_me", nativeQuery = true)
	int getCount();
	
	@Query(value = "select count(foo) from detailed_info_me", nativeQuery = true)
	int getCountFoo();

	@Query(value = "select count(foo1) from detailed_info_me", nativeQuery = true)
	int getCountFoo1();

	@Query(value = "select count(foo2) from detailed_info_me", nativeQuery = true)
	int getCountFoo2();

	@Query(value = "select count(foo3) from detailed_info_me", nativeQuery = true)
	int getCountFoo3();

	@Query(value = "select count(foo4) from detailed_info_me", nativeQuery = true)
	int getCountFoo4();

	@Query(value = "select count(foo5) from detailed_info_me", nativeQuery = true)
	int getCountFoo5();

	@Query(value = "select count(foo6) from detailed_info_me", nativeQuery = true)
	int getCountFoo6();

	@Query(value="select * from detailed_info_me where id = 0",nativeQuery = true)
	DetailedInfoCS findByDate(String name, String date);
	
	
	@Query(value = "select foo from detailed_info_me where foo = ?1 ", nativeQuery = true)
	String findbySerialNofoo(String string);

	@Query(value = "select foo1 from detailed_info_me where foo1 = ?1 ", nativeQuery = true)
	String findbySerialNofoo1(String string);

	@Query(value = "select foo2 from detailed_info_me where foo2 = ?1 ", nativeQuery = true)
	String findbySerialNofoo2(String string);

	@Query(value = "select foo3 from detailed_info_me where foo3 = ?1 ", nativeQuery = true)
	String findbySerialNofoo3(String string);

	@Query(value = "select foo4 from detailed_info_me where foo4 = ?1 ", nativeQuery = true)
	String findbySerialNofoo4(String string);

	@Query(value = "select foo5 from detailed_info_me where foo5 = ?1 ", nativeQuery = true)
	String findbySerialNofoo5(String string);

	@Query(value = "select foo6 from detailed_info_me where foo6 = ?1 ", nativeQuery = true)
	String findbySerialNofoo6(String string);
	

}
