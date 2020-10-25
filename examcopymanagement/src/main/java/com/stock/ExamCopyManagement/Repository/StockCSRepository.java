package com.stock.ExamCopyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.StockCS;

@Repository
public interface StockCSRepository extends JpaRepository<StockCS, Integer> {

	@Query(value = "select count(id) from stock_cs where id =(select max(id) from stock_cs)", nativeQuery = true)
	int getLastCount();


}
