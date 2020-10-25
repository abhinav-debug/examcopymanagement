package com.stock.ExamCopyManagement.Domain;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ObjectStudentSerial {

	private String  enrollementNo;
	
	private int serialCopies;
	
	
	
	
	
}
