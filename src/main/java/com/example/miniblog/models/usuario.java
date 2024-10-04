package com.example.miniblog.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String usuario;
private String contraseña;
private String estado;

@OneToMany( targetEntity=usuariorol.class )
private List usuariorollist;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public List getUsuariorollist() {
	return usuariorollist;
}

public void setUsuariorollist(List usuariorollist) {
	this.usuariorollist = usuariorollist;
}

}

