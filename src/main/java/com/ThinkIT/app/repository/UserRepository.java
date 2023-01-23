package com.ThinkIT.app.repository;

import com.ThinkIT.app.entity.Account;
import com.ThinkIT.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByAccount(Account account);
   Optional<User> findByAccountLogin(String login);
}
