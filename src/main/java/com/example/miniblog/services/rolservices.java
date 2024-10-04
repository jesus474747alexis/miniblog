package com.example.miniblog.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniblog.models.rol;
import com.example.miniblog.repositories.Irolrepository;
@Service
public class rolservices {

	private Irolrepository rolrepo;
	@Autowired
	public rolservices(Irolrepository rolrepo) {
		this.rolrepo=rolrepo;
	}
	
	  public rol crearrol(rol rol){
	        return rolrepo.save(rol);
	    }
	    
	    public List<rol> listarrol(){
	        return rolrepo.findAll();
	    }
	  
	    
	    public void eliminarrolPorId(Long id){
	        rolrepo.deleteById(id);
	    }
	    

	    
	    public void actualizarproducto(rol rol){
	        rolrepo.save(rol);
	    }
	    
	  
	    public Optional<rol> buscarPorId(Long id){
	        return rolrepo.findById(id);
	    }
	
	
}
