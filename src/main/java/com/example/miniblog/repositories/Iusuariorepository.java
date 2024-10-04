package com.example.miniblog.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.miniblog.models.usuario;

public interface Iusuariorepository extends JpaRepository<usuario, Long>{

}
