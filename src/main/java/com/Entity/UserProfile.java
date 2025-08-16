package com.Entity;

import jakarta.persistence.*;
//import lombok.*;

import java.time.LocalDate;

@Entity
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "user_profiles")
public class UserProfile {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String bio;
 private String profileImageUrl;
 private LocalDate dateOfBirth;

 @OneToOne
 @JoinColumn(name = "user_id", nullable = false)
 private User user;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getBio() {
	return bio;
}

public void setBio(String bio) {
	this.bio = bio;
}

public String getProfileImageUrl() {
	return profileImageUrl;
}

public void setProfileImageUrl(String profileImageUrl) {
	this.profileImageUrl = profileImageUrl;
}

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
 
 
}
