package com.form.persistence;

import com.form.domain.User;
import com.form.domain.repository.UserRepository;
import com.form.persistence.crud.UsuarioCrudRepository;
import com.form.persistence.entity.Usuario;
import com.form.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
  @Autowired
  private UsuarioCrudRepository usuarioCrudRepository;
  @Autowired
  private UserMapper userMapper;
  @Override
  public List<User> getAll() {
    List<Usuario>usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
    return userMapper.toUsers(usuarios);
  }

  @Override
  public Optional<User> getUser(int userId) {
    return usuarioCrudRepository.findById(userId).map(usuario -> userMapper.toUser(usuario));
  }

  @Override
  public User save(User user) {
    Usuario usuario = userMapper.toUsuario(user);
    return userMapper.toUser(usuarioCrudRepository.save(usuario));
  }

  @Override
  public void delete(int usuarioId) {
    usuarioCrudRepository.deleteById(usuarioId);
  }
}
