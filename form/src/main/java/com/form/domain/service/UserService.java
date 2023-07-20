package com.form.domain.service;

import com.form.domain.User;
import com.form.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAll(){
    List<User> userGetAll = userRepository.getAll();
    return (List<User>) userGetAll;
  }

  public Optional<User> getUser(int userId){
    Optional<User> userIdOut = userRepository.getUser(userId);
    return (Optional<User>) userIdOut;
  }

  public User save(User user){
    User userSaveOut = userRepository.save(user);
    return userSaveOut;
  }

  public boolean delete(int userId){
    return getUser(userId).map(user -> {
      userRepository.delete(userId);
      return true;
    }).orElse(false);
  }

}
