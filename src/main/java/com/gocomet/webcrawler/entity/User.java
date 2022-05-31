package com.gocomet.webcrawler.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@NonNull
	@Setter(AccessLevel.NONE)
	@Column(name = "user_username", unique = true)
	private String username;

	@NonNull
	@Setter(AccessLevel.NONE)
	@Column(name = "user_password")
	private String password;

	@NonNull
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> userRoles;

	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	private static PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public void setPassword(String password) {
		this.password = bCryptPasswordEncoder.encode(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public static PasswordEncoder getbCryptPasswordEncoder() {
		return bCryptPasswordEncoder;
	}

	public static void setbCryptPasswordEncoder(PasswordEncoder bCryptPasswordEncoder) {
		User.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public User(int id, @NonNull String username, @NonNull String password, @NonNull Set<Role> userRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = bCryptPasswordEncoder.encode(password);
		this.userRoles = userRoles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
