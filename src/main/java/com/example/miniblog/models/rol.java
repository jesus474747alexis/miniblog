package com.example.miniblog.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table
public class rol {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String tipo;
@OneToMany( targetEntity=usuariorol.class )
private List usuariorollist;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}


}
