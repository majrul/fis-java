package com.security;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityPracticeApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityPracticeApplication.class, args);
		
	}
	
	@Autowired
	private AccountRepository repo;
	
	@PostConstruct
	public void initialize() {
		System.out.println("initialize");
		List<Account> accs = Stream.of(
				new Account(1, "abc", "abc", "ROLE_USER", true),
				new Account(2, "abc1", "abc", "ROLE_USER", true),
				new Account(3, "abc2", "abc", "ROLE_USER", true),
				new Account(4, "abc3", "abc", "ROLE_USER", true),
				new Account(5, "admin", "admin", "ROLE_ADMIN", true)).collect(Collectors.toList());
		
		repo.saveAll(accs);
		System.out.println(repo.count());
		for(Account acc:repo.findAll())
			System.out.println(acc);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
			http.authorizeRequests()
			.antMatchers("/all").permitAll()
			.antMatchers("/user").hasAnyRole("USER", "ADMIN")
			.antMatchers("/admin").hasAnyRole("ADMIN")
			
			.anyRequest()
			.authenticated()
			.and().formLogin().and().logout()
			.and().csrf().disable();
	}
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager manager() throws Exception
	{
		return  super.authenticationManager();
	}
	
	@Autowired
	private AccountDetailsService userDetailsService;
	
	@Override
   protected void configure(AuthenticationManagerBuilder auth)
     throws Exception {
       auth.userDetailsService(userDetailsService);
   }

}
