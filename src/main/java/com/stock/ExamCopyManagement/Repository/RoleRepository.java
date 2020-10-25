package com.stock.ExamCopyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.ExamCopyManagement.Domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	 Role findByRole(String role);
}
