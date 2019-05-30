package com.getgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.getgames.model.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Long>{

}
