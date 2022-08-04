package com.security;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService implements UserDetailsService
{
	@Autowired
    private AccountRepository accountRepository;

	 @Autowired
	    private PasswordEncoder encoder;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<Account> account = this.accountRepository.findByUsername(username);
	        System.out.println(account.get());
	        return account.map(
	                acc -> {
	                   User user =  new User(acc.getUsername(),
	                           encoder.encode(acc.getPassword()),
	                            true, true,
	                            true, true,
	                            Arrays.stream(acc.getRole().split(","))
	                                    .map(SimpleGrantedAuthority::new)
	                                    .collect(Collectors.toList()));
	                    System.out.println(user);
	                    return user;
	                }
	        ).orElseThrow(()->new UsernameNotFoundException("Username not found"));
	    }
	
}
