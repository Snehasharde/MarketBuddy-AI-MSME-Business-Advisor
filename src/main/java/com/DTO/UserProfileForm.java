package com.DTO;

//import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

//@Data
public class UserProfileForm {
    private String bio;                // editable
    private MultipartFile profileImage; // optional
    
    
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public MultipartFile getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}
    
    
}
