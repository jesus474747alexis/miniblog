package com.example.miniblog.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class publicacion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private int idpersona;
private String cuerpo;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getIdpersona() {
	return idpersona;
}
public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}
public String getCuerpo() {
	return cuerpo;
}
public void setCuerpo(String cuerpo) {
	this.cuerpo = cuerpo;
}

}

