package com.firstporject.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Map<Long, User> userMap = new HashMap<>();
    private Long nextId = 1L;

    // GET /api/users
    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userMap.get(id);
    }

    // POST /api/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(nextId++);
        userMap.put(user.getId(), user);
        return user;
    }

    // PUT /api/users/{id}
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        if (!userMap.containsKey(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        user.setId(id);
        userMap.put(id, user);
        return user;
    }

    // DELETE /api/users/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userMap.remove(id);
    }
}
