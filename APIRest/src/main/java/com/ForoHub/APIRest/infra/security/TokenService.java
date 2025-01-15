package com.ForoHub.APIRest.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generarToken(Authentication authToken){
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("foro alura")
                    .withSubject("ana")
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("no se genero token");
        }
    }
    }

