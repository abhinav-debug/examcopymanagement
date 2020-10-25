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

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="unalloted_copies")
public class UnallotedCopies {

	@Id
	@Column(name="u_id")
	private int uId;
	
	@Column(name="serial_no")
	private int serialNo;
}
