package com.demo_park_api.service;

import com.demo_park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor // Injeção de depêndencia via lombok
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
}
