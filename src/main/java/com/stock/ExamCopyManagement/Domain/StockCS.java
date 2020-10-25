package com.stock.ExamCopyManagement.Domain;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="stock_cs")
public class StockCS {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="total_alloted",nullable = true)
	private int totalAlloted;
	
	@Column(name="total_serialCopies",nullable = true)
	private int totalSerialCopies;
	
	@Column(name="total_missing",nullable = true)
	private int totalMissing;
	
	@Column(name="total_UFM",nullable = true)
	private int totalUFM;
	
	@Column(name="total_unalloted",nullable = 
			true)
	private int totalUnAlloted;
	
	@Column(name="date_time",nullable = 
			true)
	private LocalDate datetime;
	
	
	
}
