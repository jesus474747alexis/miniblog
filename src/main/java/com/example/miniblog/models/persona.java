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
public class persona {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombres;
private String apellidos;
private String sexo;
private String pais;
private String direccion;
@OneToMany( targetEntity=publicacion.class )
private List publicacionlist;
private int idusuario;
@OneToOne(targetEntity=usuario.class)
private usuario usuario;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public List getPublicacionlist() {
	return publicacionlist;
}
public void setPublicacionlist(List publicacionlist) {
	this.publicacionlist = publicacionlist;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public usuario getUsuario() {
	return usuario;
}
public void setUsuario(usuario usuario) {
	this.usuario = usuario;
}

}


