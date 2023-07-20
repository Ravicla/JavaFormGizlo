package com.form.persistence.crud;

import com.form.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository <Usuario,Integer> {
}
