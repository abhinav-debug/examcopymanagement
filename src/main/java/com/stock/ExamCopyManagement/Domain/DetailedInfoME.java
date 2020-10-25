package com.stock.ExamCopyManagement.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="detailed_info_me")
public class DetailedInfoME {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="enrollment_no")
	private String enrollmentNo;
	
	@Column(name="foo")
	private String foo;
	
	@Column(name="foo1")
	private String foo1;
	
	@Column(name="foo2")
	private String foo2;
	
	@Column(name="foo3")
	private String foo3;
	
	@Column(name="foo4")
	private String foo4;
	
	@Column(name="foo5")
	private String foo5;
	
	@Column(name="foo6")
	private String foo6;
}
