package com.ForoHub.APIRest.modelo;

import com.ForoHub.APIRest.dto.DatosAutenticacionUsuario;
import com.ForoHub.APIRest.dto.DatosRespuestaActualizar;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name = "usuarios")
@Entity(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String clave;

    public void actualizarDatos(DatosAutenticacionUsuario datosAutenticacionUsuario) {
        if (datosAutenticacionUsuario.login() != null) {
            this.login = datosAutenticacionUsuario.login();
        }
        if (datosAutenticacionUsuario.clave() != null) {
            this.clave = datosAutenticacionUsuario.clave();
        }
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getClave() {
        return clave;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return login;
    }




    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
