package com.stock.ExamCopyManagement.Intercepter;

import java.io.Serializable;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.HandlerInterceptor;

import com.stock.ExamCopyManagement.Domain.StockCS;
import com.stock.ExamCopyManagement.Repository.AllotedCopiesRepository;
import com.stock.ExamCopyManagement.Repository.MissingCopiesRepository;
import com.stock.ExamCopyManagement.Repository.SerialCopiesRepository;
import com.stock.ExamCopyManagement.Repository.StockCSRepository;
import com.stock.ExamCopyManagement.Repository.UFMCopiesRepository;
import com.stock.ExamCopyManagement.Repository.UnallotedCopiesRepository;
import com.stock.ExamCopyManagement.Service.UserService;


@ComponentScan
public class StatusInfoIntercept extends EmptyInterceptor {

	

	private static org.slf4j.Logger log = LoggerFactory.getLogger(StatusInfoIntercept.class);


		
	
		
			@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		return false;
		
				
			}

		}
				
				
	




