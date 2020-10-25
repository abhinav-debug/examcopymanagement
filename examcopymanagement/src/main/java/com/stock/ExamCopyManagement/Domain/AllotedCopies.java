package com.stock.ExamCopyManagement.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "alloted_copies")
public class AllotedCopies {
	@Id
	@Column(name = "enrollment_no")
	private int enrollmentNo;
	
	@Column(name = "serial_no")
	private int serialNo;
}
