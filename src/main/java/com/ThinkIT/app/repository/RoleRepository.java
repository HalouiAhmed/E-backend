package com.ThinkIT.app.repository;


import com.ThinkIT.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRole(String role);
}
