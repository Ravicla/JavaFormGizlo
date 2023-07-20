package com.form.persistence.mapper;

import com.form.domain.User;
import com.form.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mappings({
    @Mapping(source = "idUsuario", target = "userId"),
    @Mapping(source = "nombre", target = "name"),
    @Mapping(source = "apellido", target = "lastName"),
    @Mapping(source = "telefono", target = "phoneNumber"),
    @Mapping(source = "correo", target = "email"),
    @Mapping(source = "direccion", target = "address")
  })
  User toUser(Usuario usuario);
  List<User> toUsers(List<Usuario>usuarios);
  @InheritInverseConfiguration
  Usuario toUsuario(User user);
}
