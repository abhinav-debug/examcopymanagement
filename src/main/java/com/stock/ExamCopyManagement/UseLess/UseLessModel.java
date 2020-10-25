package com.stock.ExamCopyManagement.UseLess;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UseLessModel {

	private int serialNo;
	
	private String enrollementNo;
	
	private Boolean absentPresent;
	
	private Boolean check;
	

	
}
