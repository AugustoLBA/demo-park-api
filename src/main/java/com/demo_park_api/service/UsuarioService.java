package com.demo_park_api.service;

import com.demo_park_api.dto.UsuarioCreateDTO;
import com.demo_park_api.entity.Usuario;
import com.demo_park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // Injeção de depêndencia via lombok
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado.")
        );
    }
    @Transactional
    public Usuario editarSenha(Long id, String novaSenha){
        Usuario user = buscarPorId(id);
        user.setPassword(novaSenha);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario toUsuario(UsuarioCreateDTO dto){
        Usuario user = new Usuario();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
}
