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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="missing_copies")
public class MissingCopies {

	
	@Id
	@Column(name="u_id")
	private int uId;
	
	@Column(name="serial_no")
	private int serialNo;
}
