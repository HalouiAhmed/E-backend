package com.ThinkIT.app.service;



import com.ThinkIT.app.entity.Account;
import com.ThinkIT.app.dto.AccountDTO;
import com.ThinkIT.app.dto.AuthenticationDTO;
import com.ThinkIT.app.dto.JwtDTO;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public interface AccountService {

	Optional<Account> findByLogin(String login);

	JwtDTO authenticateUser(AuthenticationDTO authenticationDTO) throws Exception;

	List<AccountDTO> getAccounts();

	String getConnectedUser();

}
