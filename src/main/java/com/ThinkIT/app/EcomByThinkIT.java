package com.ThinkIT.app;

import com.ThinkIT.app.entity.Account;
import com.ThinkIT.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author AHMED HALOUI
 *
 */
@SpringBootApplication
public class EcomByThinkIT implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(EcomByThinkIT.class, args);
	}

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Override
	public void run(String... args) throws Exception {
		Account account = new Account();
		account.setLogin("Ahmed");
		account.setPassword(this.bcrypt.encode("password"));
		this.accountRepository.save(account);
	}
}
