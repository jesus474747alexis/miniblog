package com.example.miniblog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniblog.models.usuario;
import com.example.miniblog.repositories.Irolrepository;
import com.example.miniblog.repositories.Iusuariorepository;

@Service
public class usuarioservices {

	private Iusuariorepository usuariorepo;
	@Autowired
	public usuarioservices(Iusuariorepository usuariorepo) {
		this.usuariorepo=usuariorepo;
	}
	
	  public usuario crearusuario(usuario usuario){
	        return usuariorepo.save(usuario);  
	    }
	    
	    public List<usuario> listarusuario(){
	        return usuariorepo.findAll();
	    }
	  
	    
	    public void eliminarrolPorId(Long id){
	        usuariorepo.deleteById(id);
	    }
	    

	    
	    public void actualizarusuario(usuario usuario){
	        usuariorepo.save(usuario);
	    }
	    
	  
	    public Optional<usuario> buscarPorId(Long id){
	        return usuariorepo.findById(id);
	    }
}
