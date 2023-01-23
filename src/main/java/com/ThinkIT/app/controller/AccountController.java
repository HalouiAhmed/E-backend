package com.ThinkIT.app.controller;

import java.util.List;

import javax.validation.Valid;

import com.ThinkIT.app.entity.Account;
import com.ThinkIT.app.service.AccountService;
import com.ThinkIT.app.dto.AccountDTO;
import com.ThinkIT.app.dto.AuthenticationDTO;
import com.ThinkIT.app.dto.JwtDTO;
import com.ThinkIT.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@RestController
@RequestMapping("/thinkIT/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRepository rep;

	@PostMapping("/login")
	public JwtDTO authenticate(@RequestBody AuthenticationDTO authenticationDTO) throws Exception {
		return this.accountService.authenticateUser(authenticationDTO);
	}

	@PutMapping("/{id}")
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public Account updateAccount(@PathVariable Long id, @Valid @RequestBody Account authenticationDTO)
			throws Exception {
		authenticationDTO.setId(id);
		return this.rep.save(authenticationDTO);
	}

	@GetMapping()
	@Operation(security = { @SecurityRequirement(name = "Bearer Token") })
	public List<AccountDTO> getAccounts() {
		return this.accountService.getAccounts();
	}
}
