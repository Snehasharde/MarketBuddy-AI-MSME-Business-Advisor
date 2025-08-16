package com.service;


import org.springframework.stereotype.Service;

import com.Entity.User;
import com.Entity.UserProfile;
import com.repository.UserProfileRepository;
import com.repository.UserRepository;

import java.util.Optional;

@Service
public class ProfileService {
    private final UserRepository userRepository;
    private final UserProfileRepository profileRepository;
    String uploadDir = "src/main/resources/static/uploads/";


    public ProfileService(UserRepository userRepository, UserProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        return user;
    }

    public UserProfile getProfile(Long userId) {
        UserProfile profile = profileRepository.findByUserId(userId);

        if (profile == null) {
            profile = new UserProfile();
            profile.setProfileImageUrl("/uploads/default-profile.png"); // default image path
        } else if (profile.getProfileImageUrl() == null) {
            profile.setProfileImageUrl("/uploads/default-profile.png");
        }

        return profile;
    }


    public UserProfile saveOrUpdateProfile(Long userId, UserProfile profileData) {
        User user = userRepository.findById(userId).orElseThrow();
        UserProfile profile = profileRepository.findByUserId(userId);

        if (profile == null) {
            profile = new UserProfile();
            profile.setUser(user);
        }

        profile.setBio(profileData.getBio());
        profile.setDateOfBirth(profileData.getDateOfBirth());
        profile.setProfileImageUrl(profileData.getProfileImageUrl());

        return profileRepository.save(profile);
    }
}

