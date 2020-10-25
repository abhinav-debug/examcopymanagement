package com.stock.ExamCopyManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.stock.ExamCopyManagement.Service.dbMigrationService;

@Controller
public class MigrationController {

	@Autowired
	private dbMigrationService dbMigrationService;

	@RequestMapping("/migrate")
	public RedirectView migrate(Model model, RedirectAttributes redir) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean hasRoleCS = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CS"));
		boolean hasRoleME = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ME"));
		ModelAndView modelAndView = new ModelAndView();
		if (hasRoleCS) {
			try {
				dbMigrationService.migrateCS();
			} catch (Exception e) {
				dbMigrationService.setDefaultDB();
				redir.addFlashAttribute("errorMigrate", true);
				dbMigrationService.setDefaultDB();
			}
		} else if (hasRoleME) {
			try {
				dbMigrationService.migrateME();
			} catch (Exception e) {
				dbMigrationService.setDefaultDB();
				redir.addFlashAttribute("errorMigrate", true);
				dbMigrationService.setDefaultDB();
			}
		}

		RedirectView redirectView = new RedirectView("/home", true);
		redirectView.setExposePathVariables(false);

		return redirectView;
	}
}
