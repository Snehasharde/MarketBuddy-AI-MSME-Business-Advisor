package com.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.User;
import com.Entity.UserProfile;
import com.repository.UserRepository;
import com.repository.ProfileRepository;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public String showProfile(Model model, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email);

        UserProfile profile = profileRepository.findByUserId(user.getId())
                .orElseGet(() -> {
                    UserProfile p = new UserProfile();
                    p.setUser(user);
                    p.setProfileImageUrl("/uploads/default-profile.png"); 
                    return p;
                });

        model.addAttribute("user", user);
        model.addAttribute("profile", profile);

        return "profile"; // profile.html
    }


    @PostMapping("/update")
    public String updateProfile(@ModelAttribute("profile") UserProfile profile,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                Authentication authentication) throws IOException {

        String email = authentication.getName();
        User user = userRepository.findByEmail(email);

        // Fetch existing profile or create new one
        UserProfile existingProfile = profileRepository.findByUserId(user.getId()).orElse(new UserProfile());

        // Set/Update fields from form
        existingProfile.setUser(user);
        existingProfile.setBio(profile.getBio());
        existingProfile.setDateOfBirth(profile.getDateOfBirth());

        // Handle image upload
        if (!imageFile.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            String uploadDir = System.getProperty("user.dir") + "/uploads/";

            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, imageFile.getBytes());

            existingProfile.setProfileImageUrl("/uploads/" + fileName);
        }

        // Save updated profile
        profileRepository.save(existingProfile);

        // Redirect so updated data is shown
        return "redirect:/profile";
    }

}
