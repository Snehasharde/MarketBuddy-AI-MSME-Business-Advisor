package com.Entity;

import java.io.Serializable;

//import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Data
@Table(name = "users")
public class User {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String fullName;

  @Column(unique = true)
  private String email;

  private String password;
  
  private long phone;
  
//  private String role; // ROLE_USER or ROLE_ADVISOR
  
//One-to-One relationship with UserDetails
//  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//  private UserDetails userDetails;

//public String getRole() {
//	return role;
//}
//
//public void setRole(String role) {
//	this.role = role;
//}

	public long getPhone() {
	return phone;
}

public void setPhone(long phone) {
	this.phone = phone;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
  
}
