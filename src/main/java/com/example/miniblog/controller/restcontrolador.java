package com.example.miniblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.miniblog.services.rolservices;
import com.example.miniblog.services.usuarioservices;
import com.example.miniblog.services.personaservices;
import com.example.miniblog.services.publicacionservices;
import com.example.miniblog.exception.BadRequestException;
import com.example.miniblog.exception.ResourceNotFoundException;
import com.example.miniblog.models.MensajeResponse;
import com.example.miniblog.models.persona;
import com.example.miniblog.models.publicacion;
import com.example.miniblog.models.rol;
import com.example.miniblog.models.usuario;
@RestController
@RequestMapping("/miniblog/")
public class restcontrolador {
	
	private rolservices rolservices;
	
	private usuarioservices usuarioservices;
	
	private personaservices personaservices;
	
	private publicacionservices publicacionservices;
	
	@Autowired
	public restcontrolador(rolservices rolservices) {
		this.rolservices=rolservices;
	}
	
	
	  MensajeResponse mensajeresponse= new MensajeResponse();  
		
	    rol rol2=null;
	    
	    usuario usuario2=null;
	    
	    persona persona2=null;
	    
	    publicacion publicacion2=null;
	    
	    @PostMapping(value = "crearrol", headers = "Accept=application/json")
	    public ResponseEntity<?> crearrol(@RequestBody rol rol1) {
	    	rol rol =new rol();
	    	try {
	    	rol.setId(rol1.getId());
	    	rol.setTipo(rol1.getTipo());
	        this.rol2=rolservices.crearrol(rol);
	    	mensajeresponse.setMnesaje("Guardado correctamente");
	    	mensajeresponse.setObject(rol);
	    	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	    	 } catch (DataAccessException exDt) {
	             throw  new BadRequestException(exDt.getMessage());
	         }
	    }
	    
	    @GetMapping(value = "rol", headers = "Accept=application/json")
	    public ResponseEntity<?> listarproductos() {
	    	 try{
	    	        List<rol> getList = rolservices.listarrol();
	    	        if (getList == null || getList.isEmpty()) {
	    	            throw new ResourceNotFoundException("productos");
	    	        }
	    	        mensajeresponse.setMnesaje("Lista de roles");
	    	    	mensajeresponse.setObject(getList);
	    	        return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
	    	        } catch (DataAccessException exDt) {
	    	            throw  new BadRequestException(exDt.getMessage());
	    	        }    
	    	
	    	
	    }
	    
	    @PutMapping(value = "actualizarrol/{id}", headers = "Accept=application/json")
	    public ResponseEntity<?> actualizarrol(@RequestBody rol rol1,@PathVariable Long id) {
	    	Optional<rol> rol = rolservices.buscarPorId(id);
	    	rol rolActualizar =new rol();
	    	try {
	    		 if (rol1 == null || rol1.getId()!=id ) {
	    			 throw new ResourceNotFoundException("rol", "id", id);
	    		 } else {
	    			 rolActualizar.setId(rol1.getId());
	    			 rolActualizar.setTipo(rol1.getTipo());
	    			 this.rol2=rolservices.crearrol(rolActualizar);
	             	mensajeresponse.setMnesaje("Guardado correctamente");
	             	mensajeresponse.setObject(rolActualizar);
	             	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	             }
	        	 } catch (DataAccessException exDt) {
	                 throw  new BadRequestException(exDt.getMessage());
	             }
	    }
	    
	    @DeleteMapping(value = "eliminarrol/{id}", headers = "Accept=application/json")
        public ResponseEntity<?>  eliminarrol(@PathVariable Long id) {
           Optional<rol> rol = rolservices.buscarPorId(id);
        	rol rolActualizar =new rol();
          try {  
   	   rolservices.eliminarrolPorId(id);
   	   mensajeresponse.setMnesaje("rol con id : "+id+ "eliminado correctamente");
   	   mensajeresponse.setObject(rol);
	    	 return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
           }catch (DataAccessException exDt) {
           throw  new BadRequestException(exDt.getMessage());
           }    
          }
	    
	    @PostMapping(value = "crearusuario", headers = "Accept=application/json")
	    public ResponseEntity<?> crearusuario(@RequestBody usuario usuario3) {
	    	usuario usuario =new usuario();
	    	try {
	    	usuario.setId(usuario3.getId());
	    	usuario.setContraseña(usuario3.getContraseña());
	    	usuario.setEstado(usuario3.getEstado());
	    	usuario.setUsuario(usuario3.getUsuario());
	    	this.usuario2=usuarioservices.crearusuario(usuario);
	    	mensajeresponse.setMnesaje("Guardado correctamente");
	    	mensajeresponse.setObject(usuario);
	    	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	    	 } catch (DataAccessException exDt) {
	             throw  new BadRequestException(exDt.getMessage());
	         }
	    }

	    @GetMapping(value = "usuario", headers = "Accept=application/json")
	    public ResponseEntity<?> listarusuario() {
	    	 try{
	    	        List<usuario> getList = usuarioservices.listarusuario();
	    	        if (getList == null || getList.isEmpty()) {
	    	            throw new ResourceNotFoundException("productos");
	    	        }
	    	        mensajeresponse.setMnesaje("Lista de usuarios");
	    	    	mensajeresponse.setObject(getList);
	    	        return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
	    	        } catch (DataAccessException exDt) {
	    	            throw  new BadRequestException(exDt.getMessage());
	    	        }    
	    	
	    	
	    }
	    
	    @PutMapping(value = "actualizarusuario/{id}", headers = "Accept=application/json")
	    public ResponseEntity<?> actualizarusuario(@RequestBody usuario usuario1,@PathVariable Long id) {
	    	Optional<usuario> usuario = usuarioservices.buscarPorId(id);
	    	usuario usuarioActualizar =new usuario();
	    	try {
	    		 if (usuario1 == null || usuario1.getId()!=id ) {
	    			 throw new ResourceNotFoundException("usuario", "id", id);
	    		 } else {
	    			 usuarioActualizar.setId(usuario1.getId());
	    		    	usuarioActualizar.setContraseña(usuario1.getContraseña());
	    		    	usuarioActualizar.setEstado(usuario1.getEstado());
	    		    	usuarioActualizar.setUsuario(usuario1.getUsuario());
	    			 this.usuario2=usuarioservices.crearusuario(usuarioActualizar);
	             	mensajeresponse.setMnesaje("Guardado correctamente");
	             	mensajeresponse.setObject(usuarioActualizar);
	             	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	             }
	        	 } catch (DataAccessException exDt) {
	                 throw  new BadRequestException(exDt.getMessage());
	             }
	    }
	    
	    @DeleteMapping(value = "eliminarusuario/{id}", headers = "Accept=application/json")
        public ResponseEntity<?>  eliminarusuario(@PathVariable Long id) {
           Optional<usuario> usuario = usuarioservices.buscarPorId(id);
        	rol rolActualizar =new rol();
          try {  
   	   rolservices.eliminarrolPorId(id);
   	   mensajeresponse.setMnesaje("usuario con id : "+id+ "eliminado correctamente");
   	   mensajeresponse.setObject(usuario);
	    	 return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
           }catch (DataAccessException exDt) {
           throw  new BadRequestException(exDt.getMessage());
           }    
          }
	    
	    @PostMapping(value = "crearpersona", headers = "Accept=application/json")
	    public ResponseEntity<?> crearpersona(@RequestBody persona persona1) {
	    	persona persona =new persona();
	    	try {
	    	persona.setId(persona1.getId());
	    	persona.setApellidos(persona1.getApellidos());
	    	persona.setDireccion(persona1.getDireccion());
	    	persona.setIdusuario(persona1.getIdusuario());
	    	persona.setNombres(persona1.getNombres());
	    	persona.setPais(persona1.getPais());
	    	persona.setSexo(persona1.getSexo());
	    	persona.setUsuario(persona1.getUsuario());
	        this.persona2=personaservices.crearpersona(persona);
	    	mensajeresponse.setMnesaje("Guardado correctamente");
	    	mensajeresponse.setObject(persona);
	    	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	    	 } catch (DataAccessException exDt) {
	             throw  new BadRequestException(exDt.getMessage());
	         }
	    }
	    
	    @GetMapping(value = "persona", headers = "Accept=application/json")
	    public ResponseEntity<?> listarpersona() {
	    	 try{
	    	        List<persona> getList = personaservices.listarpersona();
	    	        if (getList == null || getList.isEmpty()) {
	    	            throw new ResourceNotFoundException("personas");
	    	        }
	    	        mensajeresponse.setMnesaje("Lista de personas");
	    	    	mensajeresponse.setObject(getList);
	    	        return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
	    	        } catch (DataAccessException exDt) {
	    	            throw  new BadRequestException(exDt.getMessage());
	    	        }    
	    	
	    	
	    }
	    
	    @PutMapping(value = "actualizarpersona/{id}", headers = "Accept=application/json")
	    public ResponseEntity<?> actualizarpersona(@RequestBody persona persona1,@PathVariable Long id) {
	    	Optional<persona> persona = personaservices.buscarPorId(id);
	    	persona personaActualizar =new persona();
	    	try {
	    		 if (persona1 == null || persona1.getId()!=id ) {
	    			 throw new ResourceNotFoundException("usuario", "id", id);
	    		 } else {
	    			 personaActualizar.setId(persona1.getId());
	    		    	personaActualizar.setApellidos(persona1.getApellidos());
	    		    	personaActualizar.setDireccion(persona1.getDireccion());
	    		    	personaActualizar.setIdusuario(persona1.getIdusuario());
	    		    	personaActualizar.setNombres(persona1.getNombres());
	    		    	personaActualizar.setPais(persona1.getPais());
	    		    	personaActualizar.setSexo(persona1.getSexo());
	    		    	personaActualizar.setUsuario(persona1.getUsuario());
	    			  this.persona2=personaservices.crearpersona(personaActualizar);
	             	mensajeresponse.setMnesaje("Guardado correctamente");
	             	mensajeresponse.setObject(personaActualizar);
	             	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	             }
	        	 } catch (DataAccessException exDt) {
	                 throw  new BadRequestException(exDt.getMessage());
	             }
	    }
	    @DeleteMapping(value = "eliminarpersona/{id}", headers = "Accept=application/json")
        public ResponseEntity<?>  eliminarpersona(@PathVariable Long id) {
           Optional<persona> persona = personaservices.buscarPorId(id);
        	persona personaActualizar =new persona();
          try {  
   	   rolservices.eliminarrolPorId(id);
   	   mensajeresponse.setMnesaje("persona con id : "+id+ "eliminado correctamente");
   	   mensajeresponse.setObject(persona);
	    	 return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
           }catch (DataAccessException exDt) {
           throw  new BadRequestException(exDt.getMessage());
           }    
          }
	    
	    
	    @PostMapping(value = "crearpublicacion", headers = "Accept=application/json")
	    public ResponseEntity<?> crearpublicacion(@RequestBody publicacion publicacion1) {
	    	publicacion publicacion =new publicacion();
	    	try {
	    	publicacion.setId(publicacion1.getId());
	    	publicacion.setIdpersona(publicacion1.getIdpersona());
	    	publicacion.setCuerpo(publicacion1.getCuerpo());
	    	this.publicacion2=publicacionservices.crearpublicacion(publicacion);
	    	mensajeresponse.setMnesaje("Guardado correctamente");
	    	mensajeresponse.setObject(publicacion);
	    	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	    	 } catch (DataAccessException exDt) {
	             throw  new BadRequestException(exDt.getMessage());
	         }
	    }
	    
	    @GetMapping(value = "publicacion", headers = "Accept=application/json")
	    public ResponseEntity<?> listarpublicacion() {
	    	 try{
	    	        List<publicacion> getList = publicacionservices.listarpublicacion();
	    	        if (getList == null || getList.isEmpty()) {
	    	            throw new ResourceNotFoundException("publicacion");
	    	        }
	    	        mensajeresponse.setMnesaje("Lista de publicaciones");
	    	    	mensajeresponse.setObject(getList);
	    	        return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
	    	        } catch (DataAccessException exDt) {
	    	            throw  new BadRequestException(exDt.getMessage());
	    	        }    
	    	
	    	
	    }
	    
	    @PutMapping(value = "actualizarpublicacion/{id}", headers = "Accept=application/json")
	    public ResponseEntity<?> actualizarpublicacion(@RequestBody publicacion publicacion1,@PathVariable Long id) {
	    	Optional<publicacion> persona = publicacionservices.buscarPorId(id);
	    	publicacion publicacionActualizar =new publicacion();
	    	try {
	    		 if (publicacion1 == null || publicacion1.getId()!=id ) {
	    			 throw new ResourceNotFoundException("usuario", "id", id);
	    		 } else {
	    			 publicacionActualizar.setId(publicacion1.getId());
	    		    	publicacionActualizar.setIdpersona(publicacion1.getIdpersona());
	    		    	publicacionActualizar.setCuerpo(publicacion1.getCuerpo());
	    			   this.publicacion2=publicacionservices.crearpublicacion(publicacionActualizar);
	             	mensajeresponse.setMnesaje("Guardado correctamente");
	             	mensajeresponse.setObject(publicacionActualizar);
	             	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
	             }
	        	 } catch (DataAccessException exDt) {
	                 throw  new BadRequestException(exDt.getMessage());
	             }
	    }
	    
	    @DeleteMapping(value = "eliminarpublicacion/{id}", headers = "Accept=application/json")
        public ResponseEntity<?>  eliminarpublicacion(@PathVariable Long id) {
           Optional<publicacion> publicacion = publicacionservices.buscarPorId(id);
        	persona personaActualizar =new persona();
          try {  
   	   rolservices.eliminarrolPorId(id);
   	   mensajeresponse.setMnesaje("publicacion con id : "+id+ "eliminado correctamente");
   	   mensajeresponse.setObject(publicacion);
	    	 return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
           }catch (DataAccessException exDt) {
           throw  new BadRequestException(exDt.getMessage());
           }    
          }
	    
	    
	    
}
