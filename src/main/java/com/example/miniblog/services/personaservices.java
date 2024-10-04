package com.example.miniblog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniblog.models.persona;
import com.example.miniblog.repositories.Ipersonarepository;
@Service
public class personaservices {

	private Ipersonarepository personarepo;
	@Autowired
	public personaservices(Ipersonarepository personarepo) {
		this.personarepo=personarepo;
	}
	
	  public persona crearpersona(persona persona){
	        return personarepo.save(persona);
	    }
	    
	    public List<persona> listarpersona(){
	        return personarepo.findAll();
	    }
	  
	    
	    public void eliminarrolPorId(Long id){
	        personarepo.deleteById(id);
	    }
	    

	    
	    public void actualizarpersona(persona persona){
	        personarepo.save(persona);
	    }
	    
	  
	    public Optional<persona> buscarPorId(Long id){
	        return personarepo.findById(id);
	    }
}
