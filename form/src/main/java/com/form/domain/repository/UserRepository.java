package com.form.domain.repository;

import com.form.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  List<User> getAll();
  Optional<User> getUser(int userId);
  User save(User user);
  void delete(int userId);
}
