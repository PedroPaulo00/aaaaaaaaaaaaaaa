package com.example.time.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.time.domain.model.Dono;
import com.example.time.domain.repository.DonoRepository;

@Component
public class UserDetailsSecurityServer implements UserDetailsService {

    @Autowired
    private DonoRepository donoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Dono> optTreinador = donoRepository.findByEmail(username);
       if(optTreinador.isEmpty()){
        throw new UsernameNotFoundException("Usuário ou senha Inválidos.");
       }
       return optTreinador.get();
    }
    
}

