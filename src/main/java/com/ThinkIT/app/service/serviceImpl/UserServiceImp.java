package com.ThinkIT.app.service.serviceImpl;


import com.ThinkIT.app.configuration.exception.CustomAuthenticationException;
import com.ThinkIT.app.dto.UserDTO;
import com.ThinkIT.app.entity.Account;
import com.ThinkIT.app.entity.User;
import com.ThinkIT.app.repository.AccountRepository;
import com.ThinkIT.app.repository.RoleRepository;
import com.ThinkIT.app.repository.UserRepository;
import com.ThinkIT.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
	UserRepository userRepository;
    @Autowired
	AccountRepository accountRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
	RoleRepository roleRepository;
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		if(userDTO.isAgreeToTermes()!=true) {
            throw new CustomAuthenticationException("Please agree to the terms and conditions");
		}
		ModelMapper modelMapper = new ModelMapper();
		User user=modelMapper.map(userDTO,User.class);
		Account account =new Account(userDTO.getEmail(),bCryptPasswordEncoder.encode(userDTO.getPassword()));
		user.setAccount(account);
		account.setRole(null);
		User newUser=userRepository.save(user);
		UserDTO userToShow=modelMapper.map(newUser, UserDTO.class);
		return userToShow;
	}


}
