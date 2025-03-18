package com.seuusuario.portalvagas.security;

import com.seuusuario.portalvagas.model.Candidato;
import com.seuusuario.portalvagas.model.Empresa;
import com.seuusuario.portalvagas.repository.CandidatoRepository;
import com.seuusuario.portalvagas.repository.EmpresaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final CandidatoRepository candidatoRepository;
    private final EmpresaRepository empresaRepository;

    public UserDetailsServiceImpl(CandidatoRepository candidatoRepository, EmpresaRepository empresaRepository) {
        this.candidatoRepository = candidatoRepository;
        this.empresaRepository = empresaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Candidato candidato = candidatoRepository.findByEmail(username);
        if (candidato != null) {
            return new User(candidato.getEmail(), candidato.getSenha(), new ArrayList<>());
        }

        Empresa empresa = empresaRepository.findByEmail(username);
        if (empresa != null) {
            return new User(empresa.getEmail(), empresa.getSenha(), new ArrayList<>());
        }

        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}

