package com.example.demo.service;


import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    public void delete(Profile profile) { profileRepository.delete(profile);}

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile find(Long id) {
        return profileRepository.findById(id).get();
    }
}
