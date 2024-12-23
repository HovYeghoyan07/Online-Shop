package am.itspace.onlineshop.service;

import am.itspace.onlineshop.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface UserService {
    public User register(User user, MultipartFile multipartFile);
    Optional<User>findByEmail(String email);
}
