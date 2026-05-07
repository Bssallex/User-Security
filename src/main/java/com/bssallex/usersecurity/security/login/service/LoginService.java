package com.bssallex.usersecurity.security.login.service;

import com.bssallex.usersecurity.entity.Scopes;
import com.bssallex.usersecurity.entity.Users;
import com.bssallex.usersecurity.exceptions.EmailOrPassword;
import com.bssallex.usersecurity.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    public LoginResponse login(LoginRequest request){

        Optional<Users> verificar = usersRepository.findByEmail(request.getEmail());

        if(verificar.isEmpty() || !passwordVerify(request.getPassword(), verificar.get().getPassword())){
            throw new EmailOrPassword("Email ou senha inválidos");
        }

        Users pegarUsuario = verificar.get();

        List<String> scopes = pegarUsuario.getScopes()
                .stream()
                .map(Scopes::getName)
                .toList();

        long tempoExpiracaoToken = 600L;

        JwtClaimsSet tokenJWT = JwtClaimsSet.builder()
                .issuer("user-security-api")
                .subject(pegarUsuario.getEmail())
                .expiresAt(Instant.now().plusSeconds(tempoExpiracaoToken))
                .issuedAt(Instant.now())
                .claim("email", pegarUsuario.getEmail())
                .claim("scope", scopes)
                .build();

        String assinarToken = jwtEncoder.encode(JwtEncoderParameters.from(tokenJWT)).getTokenValue();

        return LoginResponse.builder()
                .accessToken(assinarToken)
                .expiresIn(tempoExpiracaoToken)
                .build();
    }

    private boolean passwordVerify(String password, String savedPassword){
        return passwordEncoder.matches(password, savedPassword);
    }
}
