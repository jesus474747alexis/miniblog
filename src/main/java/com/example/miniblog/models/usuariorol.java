package com.example.miniblog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class usuariorol {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int id_rol;
private int id_usuario;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_rol() {
	return id_rol;
}
public void setId_rol(int id_rol) {
	this.id_rol = id_rol;
}
public int getId_usuario() {
	return id_usuario;
}
public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
}

}


