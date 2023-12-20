package kswelder.com.github.task.services;

import kswelder.com.github.task.dto.UserDTO;
import kswelder.com.github.task.models.User;
import kswelder.com.github.task.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserDTO> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
    public User getUserById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
    public User getUserByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
    public User getUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not Found"));
    }
    public void saveUser(User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setCreatedAt(localDateTime);
        user.setUpdatedAt(localDateTime);
        repository.save(user);
    }
    public void updateUser(String id, User user) {
        User register = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        if (user.getUsername() != "") register.setUsername(user.getUsername());
        if (user.getEmail() != "") register.setEmail(user.getEmail());
        if (user.getPassword() != "") register.setPassword(user.getPassword());

        register.setUpdatedAt(LocalDateTime.now());

        repository.save(register);
    }
    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
