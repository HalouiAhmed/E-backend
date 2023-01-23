package com.ThinkIT.app.repository;

import com.ThinkIT.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByLogin(String login);
}
