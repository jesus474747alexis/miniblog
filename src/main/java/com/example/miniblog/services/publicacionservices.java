package com.example.miniblog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniblog.models.publicacion;
import com.example.miniblog.models.rol;
import com.example.miniblog.repositories.Ipublicacionrepository;


@Service
public class publicacionservices {
	private Ipublicacionrepository publicacionrepo;
	@Autowired
	public publicacionservices(Ipublicacionrepository publicacionrepo) {
		this.publicacionrepo=publicacionrepo;
	}
	
	  public publicacion crearpublicacion(publicacion publicacion){
	        return publicacionrepo.save(publicacion);
	    }
	    
	    public List<publicacion> listarpublicacion(){
	        return publicacionrepo.findAll();
	    }
	  
	    
	    public void eliminarrolPorId(Long id){
	        publicacionrepo.deleteById(id);
	    }
	    

	    
	    public void actualizarproducto(publicacion publicacion){
	        publicacionrepo.save(publicacion);
	    }
	    
	  
	    public Optional<publicacion> buscarPorId(Long id){
	        return publicacionrepo.findById(id);
	    }
	
}
