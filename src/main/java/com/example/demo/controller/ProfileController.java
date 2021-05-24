package com.example.demo.controller;


import com.example.demo.entity.Profile;
import com.example.demo.service.ProfileService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@JsonAutoDetect
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping(value = "/profiles")
    public ResponseEntity<?> create(@RequestBody Profile profile) {
        profileService.save(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/profiles")
    public ResponseEntity<?> update(@RequestBody Profile newProfile) {
        Profile profile = profileService.find(newProfile.getId());
        profile.setName(newProfile.getName());
        profile.setSurname(newProfile.getSurname());
        profile.setAddress(newProfile.getAddress());
        profile.setPhone(newProfile.getPhone());
        profile.setUser(newProfile.getUser());
        profileService.save(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/profiles/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Profile profile = profileService.find(id);
        profileService.delete(profile);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/profiles")
    public ResponseEntity<List<Profile>> findAll() {
        final List<Profile> profileList = profileService.findAll();

        return profileList != null && !profileList.isEmpty()
                ? new ResponseEntity<>(profileList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/profiles/{id}")
    public ResponseEntity<Profile> find(@PathVariable(name = "id") Long id) {
        final Profile profile = profileService.find(id);

        return profile != null
                ? new ResponseEntity<>(profile, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
