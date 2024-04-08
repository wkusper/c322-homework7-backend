package edu.iu.habahram.DinerPancakeHouseMerge.controllers;


import edu.iu.habahram.DinerPancakeHouseMerge.model.User;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.FileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {
    private FileRepository fileRepository;

    public RegisterController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @PostMapping
    public boolean add(@RequestBody User user) {
        try {
            System.out.println("Adding user to register: " + user.username());
            return fileRepository.add(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public List<User> findAll() {
        try {
            return fileRepository.findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}


