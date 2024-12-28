package com.ForoHub.APIRest.repository;

import com.ForoHub.APIRest.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
