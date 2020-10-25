package com.stock.ExamCopyManagement.Domain;


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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_me")
public class StudentME {
	
	@Id
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "enrollment_no")
	private String enrollmentNo;

}
