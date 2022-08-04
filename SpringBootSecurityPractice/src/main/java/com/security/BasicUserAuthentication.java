package com.security;

import java.security.Principal;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicUserAuthentication {

	@RequestMapping("/hi")
	public String greet(Principal p)
	{
		System.out.println("hi");
		return "Hello "+p.getName(); 
	}
	@RequestMapping("/user")
	public String messsage()
	{
		System.out.println("user");
		return "User"; 
	}
	@RequestMapping("/all")
	public String messsageAl()
	{
		System.out.println("guests");
		return "All Guests"; 
	}
	@RequestMapping("/admin")
	public String messsageAdmin()
	{
		System.out.println("admin");
		return "Admin"; 
	}
	@RequestMapping("/admin1")
	public String messsageAdmin1()
	{
		System.out.println("admin1");
		return "Admin ONE"; 
	}
}


interface AccountRepository extends CrudRepository<Account, Long>{
	public Optional<Account> findByUsername(String username);
}

@Entity
class Account {
	@Id
	private long id;
	private String username, password, role;
	private boolean active;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(long id, String username, String password, String role, boolean active) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", active=" + active + "]";
	}
	
	
	
}