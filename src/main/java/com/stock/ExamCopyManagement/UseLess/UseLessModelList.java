package com.stock.ExamCopyManagement.UseLess;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseLessModelList {

	private List<UseLessModel> useLessModels;
	
}