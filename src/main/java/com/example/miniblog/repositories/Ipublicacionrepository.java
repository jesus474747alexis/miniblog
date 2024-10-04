package com.example.miniblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.miniblog.models.publicacion;

public interface Ipublicacionrepository extends JpaRepository<publicacion, Long>{

}
