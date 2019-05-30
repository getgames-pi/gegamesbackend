package com.getgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getgames.model.Jogos;

public interface jogoRepository extends JpaRepository<Jogos, Long> {

}
